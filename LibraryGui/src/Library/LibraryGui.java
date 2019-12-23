/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class LibraryGui {

    ArrayList<Library> librarylist = new ArrayList<Library>();
    String header[] = new String[]{"Book Id", "Title ", "Type","Dateloan ","DateReturn","Matric Num"};
    DefaultTableModel dtm = new DefaultTableModel(header, 1);
                                                                                                                                                                                             
    LibraryGui() {

        JFrame frame = new JFrame("Library Book Loan  System");
        frame.setSize(828, 400);

        JLabel jlabel = new JLabel("Book Id");
        jlabel.setBounds(20, 10, 70, 20);
        frame.add(jlabel);

        JLabel jlabela = new JLabel("Title");
        jlabela.setBounds(20, 30, 70, 20);
        frame.add(jlabela);

        JLabel jlabelb = new JLabel("Type");
        jlabelb.setBounds(20, 50, 70, 20);
        frame.add(jlabelb);
        
        JLabel jlabelc= new JLabel("Date Loan");
        jlabelc.setBounds(20, 70, 70, 20);
        frame.add(jlabelc);
        
        
        JLabel jlabeld= new JLabel("Date Return");
        jlabeld.setBounds(20, 90, 70, 20);
        frame.add(jlabeld);
        
         JLabel jlabele= new JLabel("Matric Num");
        jlabele.setBounds(310, 10, 70, 20);
        frame.add(jlabele);
        
       /** The object of JLabel class is a component for placing text in a container. It is used to display a single line of read only text. The text can be changed by an application but a user cannot edit it directly. It inherits JComponent class.*/
        
        
   
        JTextField jtfbookid = new JTextField();
        jtfbookid.setBounds(90, 10, 200, 20);
        frame.add(jtfbookid);

        JTextField jtftitle = new JTextField();
        jtftitle.setBounds(90, 32, 200, 20);
        frame.add(jtftitle);

        JTextField jtftype = new JTextField();
        jtftype.setBounds(90, 54, 200, 20);
        frame.add(jtftype);
        
        JTextField jtfdateloan = new JTextField();
        jtfdateloan.setBounds(90, 76, 200, 20);
        frame.add(jtfdateloan);
        
        JTextField jtfdatereturn = new JTextField();
        jtfdatereturn.setBounds(90, 98, 200, 20);
        frame.add(jtfdatereturn);
        
        JTextField jtfmatricnum = new JTextField();
        jtfmatricnum.setBounds(380, 10, 200, 20);
        frame.add(jtfmatricnum);
        // The object of a JTextField class is a text component that allows the editing of a single line text. It inherits JTextComponent class.
        

        JButton jbuttoninsert = new JButton("INSERT");
        jbuttoninsert.setBounds(20, 130, 90, 20);
        frame.add(jbuttoninsert);

        JButton jbuttondelete = new JButton("DELETE");
        jbuttondelete.setBounds(130, 130, 90, 20);
        frame.add(jbuttondelete);

        JButton jbuttonsearch = new JButton("SEARCH");
        jbuttonsearch.setBounds(240, 130, 90, 20);
        frame.add(jbuttonsearch);

        JButton jbuttonupdate = new JButton("UPDATE");
        jbuttonupdate.setBounds(350, 130, 90, 20);
        frame.add(jbuttonupdate);

        JButton jbuttonexit = new JButton("EXIT");
        jbuttonexit.setBounds(10, 330, 90, 20);
        frame.add(jbuttonexit);
        //The JButton class is used to create a labeled button that has platform independent implementation. The application result in some action when the button is pushed
       

        //table creation
        JTable jtable = new JTable();
        jtable.setBounds(10, 166, 800, 150);
        frame.add(jtable);
        jtable.setModel(dtm);
        JScrollPane scrollPane = new JScrollPane(jtable);
        scrollPane.setBounds(10, 166, 800, 150);
        frame.add(scrollPane);
        jtable.getColumnModel().getColumn(0).setPreferredWidth(100);
        jtable.getColumnModel().getColumn(1).setPreferredWidth(200);
        jtable.getColumnModel().getColumn(2).setPreferredWidth(100);
        jtable.getColumnModel().getColumn(3).setPreferredWidth(100);
        jtable.getColumnModel().getColumn(4).setPreferredWidth(100);
        jtable.getColumnModel().getColumn(5).setPreferredWidth(100);
        //The JTable class is used to display data in tabular form. It is composed of rows and columns
        jbuttoninsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                
                
                String bookid = jtfbookid.getText();
                String title = jtftitle.getText().toUpperCase();
                String type = jtftype.getText();
                String dateloan=jtfdateloan.getText();
                String datereturn=jtfdatereturn.getText();
                String matricnum=jtfmatricnum.getText();
                
                if (matricnum.length() < 6) {
                    JOptionPane.showMessageDialog(frame, "Please Insert 6 Digit!!!");
                    return;
                }
                if (!isInteger(bookid)) {
                    JOptionPane.showMessageDialog(frame, "Please Insert Number Only");
                    return;
                }

                Library library = new Library(bookid,title,type,dateloan, datereturn,matricnum);
                librarylist.add(library);//create object list array
                writeData();
            }
        });
//Write data is use to key in data into specific location
        jbuttondelete.addActionListener(new ActionListener() {
            private String ic;
            @Override
            public void actionPerformed(ActionEvent ae) {
                String bookid = JOptionPane.showInputDialog("Book Id to delete?");
                if (bookid != null) {
                    System.out.println("not null");
                    for (int i = 0; i <librarylist.size(); i++) {
                        if (librarylist.get(i).getBookid().equalsIgnoreCase(bookid)) {
                            librarylist.remove(i);
                        }
                    }
                    writeData();
                }
            }
        });

        jbuttonsearch.addActionListener(new ActionListener() {
            private String bookid;
            @Override
            public void actionPerformed(ActionEvent ae) {
                String bookid = JOptionPane.showInputDialog("Enter Book ID?");
                if ( bookid!= null) {
                    for (int i = 0; i < librarylist.size(); i++) {
                        if (librarylist.get(i).getBookid().equalsIgnoreCase(bookid)) {
                            JOptionPane.showMessageDialog(frame, "Found!!!");
                            jtftitle.setText(librarylist.get(i).getTitle());
                            jtftype.setText(librarylist.get(i).getType());
                            jtfmatricnum.setText(librarylist.get(i).getMatricnum());
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(frame, "Not Found!!!");
                }
            }
        });

        jbuttonupdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String bookid = jtfbookid.getText();
                String title = jtftitle.getText();
                String type = jtftype.getText();
                String dateloan =jtfdateloan.getText();
                String datereturn=jtfdatereturn.getText();
                String matricnum =jtfmatricnum.getText();

                if (bookid != null) {
                    for (int i = 0; i < librarylist.size(); i++) {
                        if (librarylist.get(i).getBookid().equalsIgnoreCase(bookid)) {
                            librarylist.get(i).setTitle(title);
                            librarylist.get(i).setType(type);
                            librarylist.get(i).setDateloan(dateloan);
                            librarylist.get(i).setDatereturn(datereturn);
                            librarylist.get(i).SetMatricnum(matricnum);
                            JOptionPane.showMessageDialog(frame, "Updated!!!");
                        }
                    }
                }
                writeData();
            }
        });
        jbuttonexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.setVisible(false); //you can't see me!
                frame.dispose();
            }
        });

        readData();
        jtable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = jtable.getSelectedRow();
                jtfbookid.setText(dtm.getValueAt(row, 0).toString());
                jtftitle.setText(dtm.getValueAt(row, 1).toString());
                jtftype.setText(dtm.getValueAt(row, 2).toString());
                jtfdateloan.setText(dtm.getValueAt(row, 3).toString());
                jtfdatereturn.setText(dtm.getValueAt(row, 4).toString());
                jtfmatricnum.setText(dtm.getValueAt(row, 5).toString());
            
            
            }
        });

        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LibraryGui librarygui = new LibraryGui();
        new Login();
    }

    void readData() { //read data from "data.txt" and display on table
        try {
            File file = new File("data.txt"); //create file
            file.createNewFile();//if not exit
            FileReader f = new FileReader("data.txt");
            StringBuffer sb = new StringBuffer();
            while (f.ready()) {
                char c = (char) f.read();
                if (c == '-') {
                    System.out.println(sb);
                    String libraryarray[] = sb.toString().split(",");
                    Library library = new Library(libraryarray[0], libraryarray[1], libraryarray[2],libraryarray[3],libraryarray[4],libraryarray[5]);
                    librarylist.add(library);
                    sb = new StringBuffer();
                } else {
                    sb.append(c);
                }
            }
            dtm.setRowCount(0); //update table
            for (int i = 0; i < librarylist.size(); i++) {//populate table using object list
                Object[] objs = {librarylist.get(i).getBookid(), librarylist.get(i).getTitle(), librarylist.get(i).getType(),librarylist.get(i).getDateloan(),librarylist.get(i).getDatereturn(),librarylist.get(i).getMatricnum()  };
                dtm.addRow(objs);
            }
        } catch (IOException e) {
        }
    }

    private void writeData() { //write data to file "data.txt"
        try (FileWriter f = new FileWriter("data.txt")) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < librarylist.size(); i++) {
           sb.append(librarylist.get(i).getBookid() + "," + librarylist.get(i).getTitle() + "," + librarylist.get(i).getType() + "-"+ librarylist.get(i).getDateloan()+ "-"+ librarylist.get(i).getDatereturn()+ "-"+ librarylist.get(i).getMatricnum());
            }
            f.write(sb.toString());
            f.close();
        } catch (IOException e) {
            return;
        }
        dtm.setRowCount(0); //update table content
        for (int i = 0; i < librarylist.size(); i++) {//populate table using object list
           Object[] objs = {librarylist.get(i).getBookid(), librarylist.get(i).getTitle(), librarylist.get(i).getType(),librarylist.get(i).getDateloan(),librarylist.get(i).getDatereturn(),librarylist.get(i).getMatricnum()  }; 
            dtm.addRow(objs);
        }
    }

    public boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}
