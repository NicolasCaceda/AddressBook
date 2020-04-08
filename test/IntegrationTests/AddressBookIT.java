package IntegrationTests;

import AddressBook.AddressBook;
import AddressBook.Person;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AddressBookIT {

    AddressBook addressBookObj = new AddressBook();
    Person person0;
    Person person1;
    Person person2;

    @BeforeEach
    public void setup(){
        person0 = mock(Person.class);
        person1 = mock(Person.class);
        person2 = mock(Person.class);

    }

    @Test
    public void addressbook_add_test(){
        //add person and didnt break
        assertDoesNotThrow(() -> addressBookObj.add(person0));
    }

    @Test
    public void addressbook_get_test(){
        //add person to book
        addressBookObj.add(person0);
        addressBookObj.add(person1);
        addressBookObj.add(person2);
        //assert that the person can be retrieved.
        assertEquals(person2,addressBookObj.get(2));
    }

}
