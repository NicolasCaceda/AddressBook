package AddressBook;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private Person TestPersonFullInfo;
    private Person EmptyPerson;
    private Exception illegalArgumentException = new IllegalArgumentException();

    @BeforeEach
    void setUp() {
        TestPersonFullInfo = new Person("F", "L", "A", "C", "S",
                "Z", "P");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void getFirstName_nameExists_returnsF() {
        assertEquals("F", TestPersonFullInfo.getFirstName());
    }

    @Test
    public void Person_firstNameDNE_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> new Person("", "L", "A", "C", "S",
                "Z", "P"));
    }

    @Test
    public void getLastName_nameExists_returnsL() {
        assertEquals("L", TestPersonFullInfo.getLastName());
    }

    @Test
    public void Person_lastNameDNE_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> new Person("F", "", "A", "C", "S",
                "Z", "P"));
    }

    @Test
    public void getAddress() {
        assertEquals("A", TestPersonFullInfo.getAddress());
    }

    @Test
    public void getCity() {
        assertEquals("C", TestPersonFullInfo.getCity());
    }

    @Test
    public void getState() {
        assertEquals("S", TestPersonFullInfo.getState());
    }

    @Test
    public void getZip() {
        assertEquals("Z", TestPersonFullInfo.getZip());
    }

    @Test
    public void getPhone() {
        assertEquals("P", TestPersonFullInfo.getPhone());
    }

    @Test
    public void toString1() {
        assertEquals("L"+", "+"F", TestPersonFullInfo.toString());
    }

    @Test
    public void containsString() {
        assertTrue(TestPersonFullInfo.containsString("F"));
        assertTrue(TestPersonFullInfo.containsString("L"));
        assertTrue(TestPersonFullInfo.containsString("A"));
        assertTrue(TestPersonFullInfo.containsString("C"));
        assertTrue(TestPersonFullInfo.containsString("S"));
        assertTrue(TestPersonFullInfo.containsString("Z"));
        assertTrue(TestPersonFullInfo.containsString("P"));
        assertFalse(TestPersonFullInfo.containsString("Y"));

    }

    @ParameterizedTest
    @ValueSource(ints={0,1,2,3,4,5,6,7})
    public void getField_(int field) {
        if (field == 0)
            assertEquals("L", TestPersonFullInfo.getField(field));
        if (field == 1)
            assertEquals("F", TestPersonFullInfo.getField(field));
        if (field == 2)
            assertEquals("A", TestPersonFullInfo.getField(field));
        if (field == 3)
            assertEquals("C", TestPersonFullInfo.getField(field));
        if (field == 4)
            assertEquals("S", TestPersonFullInfo.getField(field));
        if (field == 5)
            assertEquals("Z", TestPersonFullInfo.getField(field));
        if (field == 6)
            assertEquals("P", TestPersonFullInfo.getField(field));
        if (field == 7)
            assertThrows(IllegalArgumentException.class, () -> TestPersonFullInfo.getField(field));

    }
}