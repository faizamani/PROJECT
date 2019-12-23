/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 *
 * @author My HP
 */


public class Login extends JFrame {
    JButton blogin = new JButton("Login");
    JPanel panel = new JPanel();
    JTextField txuser = new JTextField(15);
    JPasswordField pass = new JPasswordField(15);

    Login() {
        super("Login");
        setSize(300, 200);
        setLocation(500, 280);
        panel.setLayout(null);

        JLabel textuser = new JLabel("name :");
        textuser.setBounds(45, 28, 85, 20);
        panel.add(textuser);
        
        JLabel password = new JLabel("password :");
        password.setBounds(20, 63, 70, 20);
        panel.add(password);
        
        txuser.setBounds(100, 30, 150, 20);
        pass.setBounds(100, 65, 150, 20);
        blogin.setBounds(110, 100, 80, 20);

        panel.add(blogin);
        panel.add(txuser);
        panel.add(pass);

        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        actionlogin();
    }

    public void actionlogin() {
        blogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String puname = txuser.getText();
                String ppaswd = pass.getText();
                if (puname.equals("faiz") && ppaswd.equals("254484")) {
                    
                    
                    dispose();
                } else {

                    JOptionPane.showMessageDialog(null, "Wrong Password / Username");
                    txuser.setText("");
                    pass.setText("");
                    txuser.requestFocus();
                }

            }
        });
    }

    
}
