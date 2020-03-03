package AddressBook;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    Person TestPersonFullInfo;

    @BeforeEach
    void setUp() {
        TestPersonFullInfo = new Person("F", "L", "A", "C", "S",
                "Z", "P");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void getFirstName() {
        assertEquals("F", TestPersonFullInfo.getFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals("L", TestPersonFullInfo.getLastName());
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

    @Test
    public void getField() {
        assertEquals("L", TestPersonFullInfo.getField(0));
        assertEquals("F", TestPersonFullInfo.getField(1));
        assertEquals("A", TestPersonFullInfo.getField(2));
        assertEquals("C", TestPersonFullInfo.getField(3));
        assertEquals("S", TestPersonFullInfo.getField(4));
        assertEquals("Z", TestPersonFullInfo.getField(5));
        assertEquals("P", TestPersonFullInfo.getField(6));
    }
}