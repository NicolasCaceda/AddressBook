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

    //Test method name: methodName_whatYouAreTesting_expectedBehavior()

    @Test
    public void Person_emptyPerson_throwsException(){
        assertThrows(IllegalArgumentException.class, () -> new Person(null, null, null, null, null,
                null, null));
    }

    @Test
    public void Person_firstNameEmpty_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> new Person("", "L", "A", "C", "S",
                "Z", "P"));
    }

    @Test
    public void Person_firstNameNull_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> new Person(null, "L", "A", "C", "S",
                "Z", "P"));
    }

    @Test
    public void Person_lastNameEmpty_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> new Person("F", null, "A", "C", "S",
                "Z", "P"));
    }

    @Test
    public void Person_lastNameNull_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> new Person("F", "", "A", "C", "S",
                "Z", "P"));
    }

    @Test
    public void getFirstName_personExists_returnsFName() {
        assertEquals("F", TestPersonFullInfo.getFirstName());
    }

    @Test
    public void getFirstName_personDNE_throwsException() {
        assertThrows(NullPointerException.class,() -> EmptyPerson.getFirstName());
    }

    @Test
    public void getLastName_personExists_returnsLName() {
        assertEquals("L", TestPersonFullInfo.getLastName());
    }

    @Test
    public void getLastName_personDNE_throwsException() {
        assertThrows(NullPointerException.class,() -> EmptyPerson.getLastName());
    }

    @Test
    public void getAddress_personExists_returnsAddress() {
        assertEquals("A", TestPersonFullInfo.getAddress());
    }

    @Test
    public void getAddress_personDNE_throwsException() {
        assertThrows(NullPointerException.class,() -> EmptyPerson.getAddress());
    }

    @Test
    public void getCity_personExists_returnsCity() {
        assertEquals("C", TestPersonFullInfo.getCity());
    }

    @Test
    public void getCity_personDNE_throwsException() {
        assertThrows(NullPointerException.class,() -> EmptyPerson.getCity());
    }

    @Test
    public void getState_personExists_returnsState() {
        assertEquals("S", TestPersonFullInfo.getState());
    }

    @Test
    public void getState_personDNE_throwsException() {
        assertThrows(NullPointerException.class,() -> EmptyPerson.getState());
    }

    @Test
    public void getZip_personExists_returnsZip() {
        assertEquals("Z", TestPersonFullInfo.getZip());
    }

    @Test
    public void getZip_personDNE_throwsException() {
        assertThrows(NullPointerException.class,() -> EmptyPerson.getZip());
    }

    @Test
    public void getPhone_personExists_returnsPhone() {
        assertEquals("P", TestPersonFullInfo.getPhone());
    }

    @Test
    public void getPhone_personDNE_throwsException() {
        assertThrows(NullPointerException.class,() -> EmptyPerson.getPhone());
    }

    @Test
    public void toString_personExists_returnsLFName() {
        assertEquals("L"+", "+"F", TestPersonFullInfo.toString());
    }

    @Test
    public void toString_personDNE_throwsException() {
        assertThrows(NullPointerException.class,() -> EmptyPerson.toString());
    }

    @Test
    public void containsString_PersonFullInfo_Returns() {
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
    @ValueSource(ints={0,1,2,3,4,5,6})
    public void getField_personExists_ReturnInfo(int field) {
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
    }

    @Test
    public void getField_indexOutOfBounds_throwException(){
        assertThrows(IllegalArgumentException.class, () -> TestPersonFullInfo.getField(7));
    }
}