package AddressBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    void open() {
        assertThrows(NullPointerException.class, () -> {
            testAddressBookController.open(null);
        });
    }

    @Test
    void save() {
    }
}