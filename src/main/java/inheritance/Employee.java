package inheritance;

public class Employee extends UniversityMember {

    @Override
    public String getIdentification() {
        return "Employee_Identification";
    }

    public int getSalary() {
        return 5000;
    }
}
