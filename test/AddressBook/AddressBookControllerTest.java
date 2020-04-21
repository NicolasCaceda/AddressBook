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

    //set up before running the tests
    @BeforeEach
    void setup() {
        dummyPerson = new Person("F", "L", "A", "C", "S",
                "1", "2");
        testAddressBook = new AddressBook();
        testAddressBookController = new AddressBookController(testAddressBook);

    }

    //open something that doesnt exist
    //it break.
    @Test
    void nothing_open_exception() {
        //there is no file so it should break
        assertThrows(NullPointerException.class, () -> {
            testAddressBookController.open(null);
        });
    }

    //depends on save and clear
    @Test
    void stuffExists_open_DoesNotThrow() throws SQLException, FileNotFoundException {
        //setup for opening a good file
        File testFile = new File("openTest.txt");
        //setup some more stuff required for this test
        testAddressBook.add(dummyPerson);
        testAddressBookController.save(testFile);
        testAddressBook.clear();
        //The assertion
        assertDoesNotThrow(() -> testAddressBookController.open(testFile));
        //get rid of that file i dont want it anymore.
        testFile.delete();
    }

}