package GUI;

import AddressBook.AddressBook;
import AddressBook.AddressBookController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressBookGUITest {

    AddressBook testAddressBook;
    AddressBookController testAddresBookController;
    AddressBookGUI testGui;

    //test isnt really used as the class is excluded
    //if it builds it doesnt break
    @Test
    void objectBuildsCorrectly_NotNull() {
        testAddressBook = new AddressBook();
        testAddresBookController = new AddressBookController(testAddressBook);
        testGui = new AddressBookGUI(testAddresBookController, testAddressBook);
        assertNotNull(testGui);
    }
}