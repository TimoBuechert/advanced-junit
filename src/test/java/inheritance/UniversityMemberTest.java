package inheritance;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

abstract class UniversityMemberTest {

    abstract UniversityMember createUniversityMember();

    @BeforeAll
    static void setUp() {
        System.out.println("setUp");
    }

    @Test
    abstract void getIdentification();

    @Test
    void getUniversityName() {
        UniversityMember universityMember = createUniversityMember();
        assertEquals("University of Applied Sciences", universityMember.getUniversityName());
    }

    @AfterAll
    static void tearDown() {
        System.out.println("tearDown");
        System.out.println("#########################");
    }
}