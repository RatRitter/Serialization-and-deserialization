import java.io.Serializable;

@SuppressWarnings("serial")
class Employee implements Serializable{
	int id;
	String name;
	int contact;
	String desiganation;
	String department;
	double salary;
public Employee(int id,String name,int contact,String desiganation,String department,double salary) {
	this.id = id;
	this.name = name;
	this.contact = contact;
	this.desiganation = desiganation;
	this.department = department;
	this.salary = salary;
}
public String toString() {
	return  "Employee [id = " + this.id + ", name = " + this.name + ", contact = " + this.contact +
			", desiganation = " + desiganation
			+ ", department = " + this.department + ", salary = " + this.salary + "]";
}
}
