import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeService {
static void displayMenu(ArrayList<Employee> array) {
	System.out.println("----------Employee System----------");

}
@SuppressWarnings("unchecked")
public static void main(String[] args) throws IOException {
	String username = "pip";
	String password = "123";
	Scanner sc = new Scanner(System.in); 
	System.out.println("Enter name: ");
	String name1 = sc.next();
	System.out.println("Enter password: ");
	String pas = sc.next();
	if (name1.equals(username) && pas.equals(password)) {
		System.out.println("Login and password are correct");
	} else {
		System.out.println("Try again");
	}
	int id;
	String name;
	double salary;
	int contact;
	String desiganation;
	String department;
	
	ArrayList<Employee> array = new ArrayList<Employee>();
	File file = null;
	FileInputStream fis = null;
	ObjectInputStream ois = null;
	FileOutputStream fos = null;
	ObjectOutputStream oos = null;
	try {
		
		 file = new File("file.txt");
		 fis = new FileInputStream(file);
		ois = new ObjectInputStream(fis);
		if(file.exists()) {
			
			 fis = new FileInputStream(file);
			 ois = new ObjectInputStream(fis);
			array = (ArrayList<Employee>)ois.readObject();
		}}
	catch (EOFException e) {
		e.printStackTrace();
		}
			
		
	
	catch(Exception e) {
		System.err.println(e);
	}
	do {
		System.out.println("----------Employee System----------" 
				+ "\n1.Add employee "
				+ "\n2.View employee "
				+ "\n3.Edit employee "
				+ "\n4.Delete employee "
				+ "\n5.View all employee "
				+ "\n6.Exit "); 
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			
			System.out.println("Enter id: ");
			id = sc.nextInt();
			System.out.println("Enter name: ");
			name = sc.next();
			System.out.println("Enter contact: ");
			contact = sc.nextInt();
			System.out.println("Enter desiganation: ");
			desiganation = sc.next();
			System.out.println("Enter department: ");
			department = sc.next();
			System.out.println("Enter salary: ");
			salary = sc.nextDouble();
			array.add(new Employee(id,name,contact,department,desiganation,salary));
			displayMenu(array);
			break;
			
		case 2:
			
			System.out.println("Enter id to search: ");
			id = sc.nextInt();
			int i = 0;
			for(Employee emp: array) {
				if(id == emp.id) {
					System.out.println(emp + "\n");
					i++;
				}
			}
			if(i == 0) {
				System.out.println("Not found");
			}
			break;
		case 3:
			System.out.println("Enter id to edit the details: ");
			id = sc.nextInt();
			int j = 0;
			for(Employee emp: array) {
				if(id == emp.id) {
					j++;
					do {
						int choice1 = 0;
						System.out.println("\n1.id employee "
						+ "\n2.name employee "
						+ "\n3.contact employee "		
						+ "\n4.department employee "
						+ "\n5.desiganation employee "
						+ "\n6.salary employee "
						+ "\n7.Exit ");
						choice1 = sc.nextInt();
						switch(choice1) {
						case 1:
						System.out.println("Enter new id: ");
						emp.id = sc.nextInt();
						System.out.println(emp + "\n");
						break;
						case 2:
						System.out.println("Enter new name: ");
						emp.name = sc.nextLine();
						System.out.println(emp + "\n");
						break;
						case 3:
						System.out.println("Enter new contact: ");
						emp.contact = sc.nextInt();
						System.out.println(emp + "\n");
						break;
						case 4:
						System.out.println("Enter new desiganation: ");
						emp.desiganation = sc.nextLine();
						System.out.println(emp + "\n");
						break;
						case 5:
						System.out.println("Enter new department: ");
						emp.department = sc.next();
						System.out.println(emp + "\n");
						break;
						case 6:
						System.out.println("Enter new salary: ");
						emp.salary = sc.nextDouble();
						System.out.println(emp + "\n");
						break;
						case 7:
							j++;
							break;
						default:
							System.out.println("Not found");
							break;
						}
					}
					while(j == 1);
				}
			}
			if(j == 0) {
				System.out.println("Not found");
			}
			break;
		case 4:
			System.out.println("Enter id to delete: ");
			id = sc.nextInt();
			int n = 0;
			try {
				for(Employee emp: array) {
					if(id == emp.id) {
						array.remove(emp);
						displayMenu(array);
						n++;
					}
				}
				if(n == 0) {
					System.out.println("Not found");
				}
			}
			catch(Exception ex) {
				System.out.println(ex);
			}
			break;
		case 5:
			try {
				array = (ArrayList<Employee>)ois.readObject();
			}
		catch (EOFException e) {
			e.printStackTrace();}
			catch(ClassNotFoundException e2) {
				System.out.println(e2);
			}
			catch(Exception e2) {
				System.out.println(e2);
			}
			
			
			displayMenu(array);
			break;
		case 6:
			try {
				fos = new FileOutputStream(file);
				oos = new ObjectOutputStream(fos);
				oos.writeObject(array);
			}
			catch(IOException e1) {
				e1.printStackTrace();
			}
			catch(Exception e2) {
				e2.printStackTrace();
			}
			finally {
				try {
					fis.close();
					ois.close();
					fos.close();
					oos.close();
					
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
			}
			System.out.println("Exit");
			sc.close();
			System.exit(0);
			break;
		default:
			System.out.println("Enter a correct choice");
			break;
	}
}
	while(true);
}}
