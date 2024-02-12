package in.ineuron.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import in.ineuron.controller.IStudentController;
import in.ineuron.dto.Student;
import in.ineuron.factory.StudentControllerFactory;

public class TestApp {

	public static void main(String[] args) {
		
		IStudentController studentController =null;
		String status = null,name= null, city = null, country = null, email=null;
		Integer sid = null;
		Student studentRecord= null;
		
		try {
			while(true) {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("--------------------------------------------------");
				System.out.println("1.CREATE A RECORD");
				System.out.println("2.READ A RECORD");
				System.out.println("3.UPDATE A RECORD(to update single attribute)");
				System.out.println("4.UPDATE A RECORD(to update multiple attribute)");
				System.out.println("5.DELETE A RECORD");
				System.out.println("6.EXIT");
				System.out.println("Your options :: [1,2,3,4,5,6]");
				
				Integer option = Integer.parseInt(br.readLine());
				studentController = StudentControllerFactory.getStudentController();

				switch (option) {
				case 1: {
					System.out.println("Enter the name :: ");
					name = br.readLine();
					System.out.println("Enter the city :: ");
					city = br.readLine();
					System.out.println("Enter the email :: ");
					email = br.readLine();
					System.out.println("Enter the country :: ");
					country = br.readLine();
					Student std  = new Student();
					std.setCity(city);
					std.setCountry(country);
					std.setEmail(email);
					std.setName(name);
					status  = studentController.save(std);
					if(status.equals("success")) {
						System.out.println("Record inserted successfully..");
					}
					else if(status.equals("failure")){
						System.out.println("Record insertion failed..");
					}
					else {
						System.out.println("some problem occured");
					}
					break;
				}
				case 2: {
					System.out.println("Enter the ID :: ");
					sid = Integer.parseInt(br.readLine());
					studentRecord  = studentController.findById(sid);
					if(studentRecord !=null)
						System.out.println(studentRecord);
					else
						System.out.println("Record not avaibale for the given id :: "+sid);
					break;
				}
				case 3: {
					System.out.println("Enter the ID of the record to be updated :: ");
					sid = Integer.parseInt(br.readLine());
					studentRecord  = studentController.findById(sid);
					if(studentRecord!=null) {
					
						System.out.println("Choose the attribute you want to update by choosing a number below :: ");
						System.out.println("1.Name");
						System.out.println("2.Email");
						System.out.println("3.City");
						System.out.println("4.Country");
						System.out.println("Your options :: [1,2,3,4]");
						
						Integer choice = Integer.parseInt(br.readLine());
						switch(choice) {
							case 1:{
								System.out.println("Enter The new name to be updated :: ");
								name = br.readLine();
								status  = studentController.updateById(sid,"name",name);
								break;
								
							}
							case 2:{
								System.out.println("Enter The new email to be updated :: ");
								email = br.readLine();
								status  = studentController.updateById(sid,"email",email);
								break;
							}
							case 3:{
								System.out.println("Enter The new city to be updated :: ");
								city = br.readLine();
								status  = studentController.updateById(sid,"city",city);
								break;
							}
							case 4:{
								System.out.println("Enter The new country to be updated :: ");
								country = br.readLine();
								status  = studentController.updateById(sid,"country",country);
								break;
							}
							
							default: {
								System.out.println("Wrong option choosen ...");
								break;
								//throw new IllegalArgumentException("Unexpected option value: " + option);
							}		
					    }
						if(status.equalsIgnoreCase("success")) {
							System.out.println("Record updated successfully..");
						}
						else if(status.equalsIgnoreCase("failure")){
							System.out.println("Record updation failed..");
						}
						else{
							System.out.println("some problem occured");
						}
					}
					else {
						System.out.println("Record not availbale for give ID");
					}
					break;					
				}
				case 4: {
					System.out.println("Enter the ID of the record to be updated :: ");
					sid = Integer.parseInt(br.readLine());
					studentRecord  = studentController.findById(sid);
					if(studentRecord!=null) {
						Student newStd = new Student();
						newStd.setSid(sid);
						
						System.out.println("Student's name ::[Old name is :: "+ studentRecord.getName() + " ]: ");
						String newName = br.readLine();
						if(newName == null || newName.equals(""))
							newStd.setName(studentRecord.getName());
						else
							newStd.setName(newName);
						
						System.out.println("Student's email ::[Old email is :: "+ studentRecord.getEmail() + " ]: ");
						String newEmail = br.readLine();
						if(newEmail == null || newEmail.equals(""))
							newStd.setEmail(studentRecord.getEmail());
						else
							newStd.setEmail(newEmail);
						
						System.out.println("Student's city ::[Old city is :: "+ studentRecord.getCity() + " ]: ");
						String newCity = br.readLine();
						if(newCity == null || newCity.equals(""))
							newStd.setCity(studentRecord.getCity());
						else
							newStd.setCity(newCity);
						
						System.out.println("Student's country ::[Old country is :: "+ studentRecord.getCountry() + " ]: ");
						String newCountry = br.readLine();
						if(newCountry == null || newCountry.equals(""))
							newStd.setCountry(studentRecord.getCountry());
						else
							newStd.setCountry(newCountry);
						
						status = studentController.updatesById(newStd);
						if (status.equalsIgnoreCase("success")) {
							System.out.println("Record updated succesfully...");
						} else if (status.equalsIgnoreCase("failure")) {
							System.out.println("Record updation failed...");
						} else {
							System.out.println("Some problem occured...");
						}
					}
					else {
						System.out.println("Record not available for the given id ::" + sid);
					}
					break;
					
				}
				case 5: {
					System.out.println("Enter the ID of the record you want to delete:: ");
					sid = Integer.parseInt(br.readLine());
					status  = studentController.deleteById(sid);
					if(status.equalsIgnoreCase("success")) {
						System.out.println("Record deleted successfully..");
					}
					else if(status.equalsIgnoreCase("failure")){
						System.out.println("Record deletion failed..");
					}
					else if(status.equalsIgnoreCase("not available")){
						System.out.println("Record not available for the given ID :: "+sid);
					}
					else {
						System.out.println("some problem occured");
					}
					
					break;
				}
				case 6: {
					System.out.println("Thanks for using the application");
					System.exit(0);
				}
				
				default:{
					System.out.println("Please enter the option between 1-6");
					break;
					//throw new IllegalArgumentException("Unexpected option value: " + option);
				}
			}
		}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		

	}
}
