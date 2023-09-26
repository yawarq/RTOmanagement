package com.masai.usecases.layers;

public interface LicenseDao {
	
	public String insertLicenseDetails(String user_name,String License_id,int DOB,
			String vehicle_type,String address, String issue_date, String valid_date);

	public String insertUserDetails(String user_name,int DOB,int aadhar_no,String vehicle_type,String address);
	
	public String adminLogin(String user_name, String password);
         
        public String LicenseStatus(int aadhar_no, String user_name);


	
}