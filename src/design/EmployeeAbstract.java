package design;

public abstract class EmployeeAbstract implements Employee {
    final String empName = "Smith";
    static String resignationDate = "08/14/2009";

    public void farewell () {
        System.out.println(empName+ "last day was " +resignationDate);
    }
    public abstract void farewell (int date);
}
