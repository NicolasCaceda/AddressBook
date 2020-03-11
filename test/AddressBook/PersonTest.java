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

    //Before each test create new person
    @BeforeEach
    void setUp() {
        TestPersonFullInfo = new Person("F", "L", "A", "C", "S",
                "Z", "P");
    }

    //After each test run this empty method
    @AfterEach
    void tearDown() {
    }

    //Test method name: methodName_whatYouAreTesting_expectedBehavior()

    //Testing if we initialize a person with nothing but null values.
    // Should throw an exception
    @Test
    public void Person_emptyPerson_throwsException(){
        assertThrows(IllegalArgumentException.class, () -> new Person(null, null, null, null, null,
                null, null));
    }

    //Testing if we initialize a person but the name is an empty string.
    // Should throw an exception
    @Test
    public void Person_firstNameEmpty_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> new Person("", "L", "A", "C", "S",
                "Z", "P"));
    }

    //Testing if we initialize a person with the first name being null.
    // Should throw an exception
    @Test
    public void Person_firstNameNull_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> new Person(null, "L", "A", "C", "S",
                "Z", "P"));
    }

    //Testing if we initialize a person with the last name being null.
    // Should throw an exception
    @Test
    public void Person_lastNameEmpty_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> new Person("F", null, "A", "C", "S",
                "Z", "P"));
    }

    //Testing if we initialize a person but the last name is an empty string.
    // Should throw an exception
    @Test
    public void Person_lastNameNull_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> new Person("F", "", "A", "C", "S",
                "Z", "P"));
    }

    //Testing if a person with the first name F will return F.
    @Test
    public void getFirstName_personExists_returnsFName() {
        assertEquals("F", TestPersonFullInfo.getFirstName());
    }

    //Testing if a person not initialized will throw an exception if the first name is requested.
    @Test
    public void getFirstName_personDNE_throwsException() {
        assertThrows(NullPointerException.class,() -> EmptyPerson.getFirstName());
    }

    //Testing if a person with the last name L will return L.
    @Test
    public void getLastName_personExists_returnsLName() {
        assertEquals("L", TestPersonFullInfo.getLastName());
    }

    //Testing if a person not initialized will throw an exception if the last name is requested.
    @Test
    public void getLastName_personDNE_throwsException() {
        assertThrows(NullPointerException.class,() -> EmptyPerson.getLastName());
    }

    //Testing if a person with the address A will return A.
    @Test
    public void getAddress_personExists_returnsAddress() {
        assertEquals("A", TestPersonFullInfo.getAddress());
    }

    //Testing if a person not initialized will throw an exception if the address is requested.
    @Test
    public void getAddress_personDNE_throwsException() {
        assertThrows(NullPointerException.class,() -> EmptyPerson.getAddress());
    }

    //Testing if a person with the city name C will return C.
    @Test
    public void getCity_personExists_returnsCity() {
        assertEquals("C", TestPersonFullInfo.getCity());
    }

    //Testing if a person not initialized will throw an exception if the city is requested.
    @Test
    public void getCity_personDNE_throwsException() {
        assertThrows(NullPointerException.class,() -> EmptyPerson.getCity());
    }

    //Testing if a person with the state name S will return S.
    @Test
    public void getState_personExists_returnsState() {
        assertEquals("S", TestPersonFullInfo.getState());
    }

    //Testing if a person not initialized will throw an exception if the state name is requested.
    @Test
    public void getState_personDNE_throwsException() {
        assertThrows(NullPointerException.class,() -> EmptyPerson.getState());
    }

    //Testing if a person with the zip code Z will return Z.
    @Test
    public void getZip_personExists_returnsZip() {
        assertEquals("Z", TestPersonFullInfo.getZip());
    }

    //Testing if a person not initialized will throw an exception if the zip is requested.
    @Test
    public void getZip_personDNE_throwsException() {
        assertThrows(NullPointerException.class,() -> EmptyPerson.getZip());
    }

    //Testing if a person with the phone number P will return P.
    @Test
    public void getPhone_personExists_returnsPhone() {
        assertEquals("P", TestPersonFullInfo.getPhone());
    }

    //Testing if a person not initialized will throw an exception if the phone number is requested.
    @Test
    public void getPhone_personDNE_throwsException() {
        assertThrows(NullPointerException.class,() -> EmptyPerson.getPhone());
    }

    //Testing if a person with the full name LF will return LF.
    @Test
    public void toString_personExists_returnsLFName() {
        assertEquals("L"+", "+"F", TestPersonFullInfo.toString());
    }

    //Testing if a person not initialized will throw an exception if the full name is requested.
    @Test
    public void toString_personDNE_throwsException() {
        assertThrows(NullPointerException.class,() -> EmptyPerson.toString());
    }

    //Testing if each column in a person can be reached
    //Most of these were done for code coverage.
    //Not all are needed.
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

    //Tests each output for each field possible.
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

    //tests what happens if the field requested is not within the range of valid fields.
    //Throws exception.
    @Test
    public void getField_indexOutOfBounds_throwException(){
        assertThrows(IllegalArgumentException.class, () -> TestPersonFullInfo.getField(7));
    }
}