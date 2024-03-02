package Test;

import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class BaseD {
	
	public void ajouterMed(String c,String n,String p,String d,String q){
		
		String username="root";
		String password="";
		String DatabaseName="ihm";
		String url = "jdbc:mysql://localhost:3306/"+DatabaseName;
		
		try{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection(url, username, password);

		PreparedStatement pst=con.prepareStatement("insert into medicament(code,nom,prix,date,quantite)values(?,?,?,?,?)");
		pst.setString(1, c);
		pst.setString(2, n);
		pst.setString(3, p);
		pst.setString(4, d);
		pst.setString(5, q);
		pst.executeUpdate();
		
		con.close();
		}catch(Exception e){ System.out.println(e);}
	}
	
	
	public void tableLoad(JTable t){ //table form
		
			String username="root";
			String password="";
			String DatabaseName="ihm";
			String url = "jdbc:mysql://localhost:3306/"+DatabaseName;
			
			try{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection(url, username, password);

			PreparedStatement pst=con.prepareStatement("select * from medicament");
			ResultSet rs=pst.executeQuery();
			t.setModel(DbUtils.resultSetToTableModel(rs));
			

			con.close();
			}catch(Exception e){ System.out.println(e);}
	}
	

	public void searchMed(JTable t,String c){//search
		
			String username="root";
			String password="";
			String DatabaseName="ihm";
			String url = "jdbc:mysql://localhost:3306/"+DatabaseName;
			
			try{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection(url, username, password);

			PreparedStatement pst=con.prepareStatement("select * from medicament where code =?");
			pst.setString(1, c);
			ResultSet rs=pst.executeQuery();
			t.setModel(DbUtils.resultSetToTableModel(rs));
			

			con.close();
			}catch(Exception e){ System.out.println(e);}
	}
	
	
	public void supprimerMed(String c){
		
			String username="root";
			String password="";
			String DatabaseName="ihm";
			String url = "jdbc:mysql://localhost:3306/"+DatabaseName;
			
			try{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection(url, username, password);

			PreparedStatement pst=con.prepareStatement("delete from medicament where code=?");
			pst.setString(1, c);
			pst.executeUpdate();
			
			con.close();
			}catch(Exception e){ System.out.println(e);}
	}
	
	
	public void modifierMed(String c,String n,String p,String d,String q,String cr){
		
			String username="root";
			String password="";
			String DatabaseName="ihm";
			String url = "jdbc:mysql://localhost:3306/"+DatabaseName;
			
			try{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection(url, username, password);

			PreparedStatement pst=con.prepareStatement("update medicament set code=?,nom=?,prix=?,date=?,quantite=? where code=?");
			
			pst.setString(1, c);
			pst.setString(2, n);
			pst.setString(3, p);
			pst.setString(4, d);
			pst.setString(5, q);
			pst.setString(6, cr);
			pst.executeUpdate();
			
			con.close();
			}catch(Exception e){ System.out.println(e);}
	}

	
	public void searchMedDash(JTable t,String q){//search quantite
		
			String username="root";
			String password="";
			String DatabaseName="ihm";
			String url = "jdbc:mysql://localhost:3306/"+DatabaseName;
			
			try{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection(url, username, password);

			PreparedStatement pst=con.prepareStatement("select * from medicament where quantite <=?");
			pst.setString(1, q);
			ResultSet rs=pst.executeQuery();
			t.setModel(DbUtils.resultSetToTableModel(rs));
			

			con.close();
			}catch(Exception e){ System.out.println(e);}
	}
}
