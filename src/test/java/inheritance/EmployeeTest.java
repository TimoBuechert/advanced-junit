package inheritance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest extends UniversityMemberTest {

    @Override
    UniversityMember createUniversityMember() {
        return new Employee();
    }

    @Override
    @Test
    void getIdentification() {
        Employee employee = new Employee();
        assertEquals("Employee_Identification", employee.getIdentification());
    }

    @Test
    void getSalary() {
        Employee employee = new Employee();
        assertEquals(5000, employee.getSalary());
    }
}