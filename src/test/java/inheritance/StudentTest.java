package inheritance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest extends UniversityMemberTest {

        @Override
        UniversityMember createUniversityMember() {
            return new Student();
        }

        @Override
        @Test
        void getIdentification() {
            Student student = new Student();
            assertEquals("Student_Identification", student.getIdentification());
        }

        @Override
        @Test
        void getUniversityName() {
            Student student = new Student();
            assertEquals("University of Applied Sciences of Northwestern Switzerland", student.getUniversityName());
        }

        @Test
        void getSemester() {
            Student student = new Student();
            assertEquals(3, student.getSemester());
        }
}