package GUI;

import AddressBook.AddressBook;
import AddressBook.AddressBookController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressBookGUITest {

    AddressBook testAddressBook;
    AddressBookController testAddresBookController;
    AddressBookGUI testGui;

    @Test
    void objectBuildsCorrectly_NotNull() {
        testAddressBook = new AddressBook();
        testAddresBookController = new AddressBookController(testAddressBook);
        testGui = new AddressBookGUI(testAddresBookController, testAddressBook);
        assertNotNull(testGui);
    }
}