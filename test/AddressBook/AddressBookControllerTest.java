package AddressBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class AddressBookControllerTest {
    Person dummyPerson;
    AddressBook testAddressBook;
    AddressBookController testAddressBookController;

    @BeforeEach
    void setup() {
        dummyPerson = new Person("F", "L", "A", "C", "S",
                "Z", "P");
        testAddressBook = new AddressBook();
        testAddressBookController = new AddressBookController(testAddressBook);

    }

    @Test
    void nothing_open_exception() {
        assertThrows(NullPointerException.class, () -> {
            testAddressBookController.open(null);
        });
    }

    //depends on save and clear
    @Test
    void stuffExists_open_DoesNotThrow() throws SQLException, FileNotFoundException {
        //setup for opening a good file
        File testFile = new File("openTest.txt");
        testAddressBook.add(dummyPerson);
        testAddressBookController.save(testFile);
        testAddressBook.clear();
        //The assertion
        assertDoesNotThrow(() -> testAddressBookController.open(testFile));
    }

}