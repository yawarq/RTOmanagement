package com.masai.usecases.layers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.masai.usecases.db.DButil;

public class LicenseDaoImpl implements LicenseDao {
	
	@Override
	public String insertLicenseDetails(String user name,String License id,INT DOB,
			String Vehicle Type,String Address, String issue date, String valid date)
	{
		String message = "Not inserted !";
		
		try (Connection conn = DButil.provideConnection()) {
			
			PreparedStatement ps =  conn.prepareStatement("insert into Licensedetails(user name,DOB,address, "
					+ "Vehicle Type,License id,issue date,valid date ) values (?,?,?,?,?,?,?) ");
			
			ps.setString(1, user name);
			ps.setString(2, DOB);
			ps.setString(3, address);
			ps.setString(4, Vehicle Type);
			ps.setInt(5,License id);
			ps.setString(6, issue date);
			ps.setString(7, valid date);
			
			int x = ps.executeUpdate();
			
			if(x>0)
			{
				message = "License Details Inserted Sucessfully !";
			}
			
			
			
		} catch (Exception e) {
			message = e.getMessage();
		}
		
		
		
		
		return message;
	}

	@Override
	public String LicenseStatus( String user name, int aadhar no) {
		
		String message = "License id not available !";
		
		try (Connection conn = DButil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select License id from Licensedetails "
					+ "where aadhar no = ? and user name = ?");
			
			ps.setString(1, aadhar no);
			ps.setString(2, user name);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				int x = rs.getInt("License id");
				
				if(x>0)
				{
					
					PreparedStatement ps3 = conn.prepareStatement("insert into userdetails values(?,?,?)");
					
					ps3.setInt(1, rs.getInt("License id"));
					ps3.setString(2,user name);
					ps3.setInt(3, DOB);
					
					
					ps3.executeUpdate();
					
					PreparedStatement ps4  = conn.prepareStatement("select * from userdetails where name = ?");
					
					ps4.setString(1, name);
					
					ResultSet rs2 = ps4.executeQuery();
					
					if(rs2.next())
					{
						System.out.println();
						System.out.println("License id: "+ rs2.getInt("License id"));
						System.out.println("user Name: "+rs2.getString("Name"));
						System.out.println("user DOB: "+rs2.getInt("DOB"));						
					}
					message = "License Approved !";
				}
				
			}
			else 
			{
				message = "Please Enter Valid details !";
			}
			
			
		} catch (Exception e) {
			message = e.getMessage();
		}
		
		
		
		
		
		
		
		return message;
	}


	@Override
	public String adminLogin(String username, String password) {
		
		String message = "Wrong Credentials!";
		
		try (Connection conn = DButil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("Select * from adminlogin where username = ? and password = ?");
			
			ps.setString(1, username);
			ps.setString(2,password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				System.out.println();
				System.out.println("Welcome "+rs.getString("username")+"!");
				message = "";
			}
			
			
		} catch (Exception e) {
			message = e.getMessage();
		}
		
		return message;
	}

}