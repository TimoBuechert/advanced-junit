package inheritance;

public class Student extends UniversityMember {

    @Override
    public String getIdentification() {
        return "Student_Identification";
    }

    @Override
    public String getUniversityName() {
        return "University of Applied Sciences of Northwestern Switzerland";
    }

    public int getSemester() {
        return 3;
    }
}
