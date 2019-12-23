/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

/**
 *
 * @author user
 */
public class Library {
    private String title ,type ,dateloan,datereturn,matricnum;
    final private String bookid;
    
    Library(String bookid,String title,String type,String dateloan,String datereturn ,String matricnum){
        this.bookid = bookid;
        this.title = title;
        this.type = type;
        this.dateloan=dateloan;
        this.datereturn=datereturn;
        this.matricnum= matricnum;
    }
    void setTitle(String title){
        this.title = title;
    }
    void setType(String type){
        this.type = type;
    }
     void setDateloan(String dateloan){
        this.dateloan = dateloan;    
    }
    
    void setDatereturn(String datereturn){
        this.datereturn=datereturn;
        
    }
           
     void SetMatricnum(String matricnum) {
         this.matricnum=matricnum;
         
     }      
    
    
    String getBookid(){
        return bookid;
    }
    String getTitle(){
        return title;
    }
    String getType(){
        return type;
    }
    String getDateloan(){
        return dateloan;
    }
    String getDatereturn(){
        return datereturn;
    }
    String getMatricnum(){
        return matricnum;
    }



}
