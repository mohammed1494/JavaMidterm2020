package design;

public class FortuneEmployee {
	/**
	 * FortuneEmployee class has a main methods where you will be able to create Object from
	 * EmployeeInfo class to use fields and attributes.Demonstrate as many methods as possible 
	 * to use with proper business work flow.Think as a Software Architect, Product Designer and 
	 * as a Software Developer.(employee.info.system) package is given as an outline,you need to elaborate
	 * more to design an application that will meet for fortune 500 Employee Information
	 * Services.
	 *
	 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
	 *
	 **/
	public static void main(String[] args) {
		EmployeeInfo e1 = new EmployeeInfo("name", 101);
		e1.getDept("IT");
		e1.farewell(01/31/2019);
		e1.setSalary(50000.00);
		e1.setEmployeeId(101);
		e1.setGender('M');
		e1.setName("Ali");

		System.out.println(e1 );

		EmployeeInfo e2 = new EmployeeInfo("Lebron", 102, "IT", 65000.00, 'M');
		e2.farewell();
		e2.annualSalary();
		e2.employeeName();
		e2.assignDepartment();
		e2.calculateSalary();
		e2.getGender();

		EmployeeInfo.calculateEmployeePension();
		EmployeeInfo.calculateEmployeeBonus(10, 50000.00);
		EmployeeInfo.setCompanyName("Google");
	}
}
