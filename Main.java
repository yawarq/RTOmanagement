
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		int check = 1;
		
		while(check !=2)
		{
			System.out.println();
			System.out.println("========================================");
			System.out.println("Welcome RTO MANAGEMENT SYSTEM");
			System.out.println("========================================");
			
			Scanner sc = new Scanner(System.in);

			LicenseDao dao = new LicenseDaoImpl();
			
			
			System.out.println();
			System.out.println("1. ADMIN");
			System.out.println("2. USER");
			System.out.println();
			
			System.out.println("Enter your choice:");
			int choice = sc.nextInt();
			
			if(choice==1)
			{
				System.out.println();
				System.out.println("Enter username: ");
				String username = sc.next();
				
				System.out.println("Enter Password: ");
				String password = sc.next();
				
				
				String login = dao.adminLogin(username, password);
				
				System.out.println(login);
				
				if(login.equals("Wrong Credentials!"))
				{
					check = 1;
					continue;
				}
                       
				System.out.println("1. Insert LICENSE Details");
				System.out.println("2. Go back");
				System.out.println("3. Exit");
				
				System.out.println();
				System.out.println("Enter your choice:");
				int insertorNot = sc.nextInt();
				
				if(insertorNot==1)
					
				{
					System.out.println("Enter License holder name ");
					String user_name = sc.next();
					
					System.out.println("Enter license id ");
					String license_id = sc.next();
					
					System.out.println("enter DOB ");
					int DOB = sc.nextInt();
					
					System.out.println("Enter Vehicle type ");
					String Vehicle_type = sc.next();
					
					System.out.println("Enter address ");
					String address = sc.next();
					
					System.out.println("Enter issued date ");
					String issued_date = sc.next();
					
					System.out.println("Enter  valid date ");
					String valid_date = sc.next();
					
					
					String result = dao.insertLicenseDetails(user_name, license_id, DOB, Vehicle_type , address, issued_date, valid_date);


					
					System.out.println(result);
					
				}
				else if(insertorNot==2)
				{
					check = 1;
				}
				else if(insertorNot==3)
				{
					check = 2;
				}
				else
				{
					System.out.println("Please Enter Correction Information Next Time!");
				}
			}
			else if(choice ==2)
			{
				System.out.println();
				System.out.println("1.  apply for license");
				System.out.println("2.  license details");
				System.out.println("3. Go back");
				System.out.println("4. Exit");
				
				
				System.out.println();
				System.out.println("Enter your choice: ");
				int option = sc.nextInt();
				
				if(option==1)
					
				{
					System.out.println("Enter License holder name ");
					String user name = sc.next();
					
	
					
					System.out.println("enter DOB ");
					int DOB = sc.next();
                                        System.out.println("enter aadhar number ");
					int aadhar no = sc.next();
					
					System.out.println("Enter Vehicle type ");
					String Vehicle type = sc.next();
					
					System.out.println("Enter address ");
					string address = sc.nextInt();
				
					
					
				        String result = dao.insertUserDetails(user name, DOB,aadhar no, Vehicle type , address);
					
					System.out.println(result);
					
					
				}
				else if(option==2)
				{
					System.out.println("Enter aadhar number ");
					int aadhar no = sc.nextInt();
					
					System.out.println("Enter user name: ");
					String name = sc.next();
					
					
					String result = dao.licenseStatus(aadhar no, name);
					
					
					System.out.println();
					
					System.out.println(result);
					
				}
				else if(option==3)
				{
					check = 1;
				}
				else if(option ==4)
				{
					check = 2;
				}
				else
				{
					System.out.println("Please Enter Correction Information Next Time!");
				}
				
			}
			else
			{
				System.out.println("Please Enter Correction Information Next Time!");
			}
			
		}
		
	    System.out.println("============================");
	    System.out.println("Thank you for visiting us !");
	    System.out.println("============================");
		
		
	}
}