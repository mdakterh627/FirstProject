
package myproject;

import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;


public class GeneralClass {
    
    private static Connection con = null;
    
    public static void setImagetoLabel(String path , JLabel picShow){
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage();
        Image newImage = img.getScaledInstance(picShow.getWidth(), picShow.getHeight(), img.SCALE_SMOOTH);
        ImageIcon newImageIcon = new ImageIcon(newImage);
        picShow.setIcon(newImageIcon);
    }
    
    public static void showDataIntoTable(String dbTable, JTable table){
        
        con = DataBaseConnection.dataBaseConnection();
        
        try{
        Statement st = con.createStatement();
        String Queery = "select * from " + dbTable;//select 8 from table
        ResultSet rs = st.executeQuery(Queery);
        table.setModel(DbUtils.resultSetToTableModel(rs));
        
        }catch(Exception ex){
        
        
        
        }
        finally{
        
        try{
        
        con.close();
        }catch(Exception ex){
        
        
        
        }
        
        }
    
    
    }
}

