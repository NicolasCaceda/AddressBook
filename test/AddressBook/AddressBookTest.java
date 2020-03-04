package AddressBook;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressBookTest {

    AddressBook book;

    @BeforeEach
    void setUp() {
        book = new AddressBook();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getPersons_noPersons_emptyArray() {
        Person[] array={};
        assertArrayEquals(array , book.getPersons());
    }

    @Test
    void add() {

    }

    @Test
    void set() {
    }

    @Test
    void remove() {
    }

    @Test
    void get() {
    }

    @Test
    void clear() {
    }

    @Test
    void getRowCount() {
    }

    @Test
    void getColumnCount() {
    }

    @Test
    void getValueAt() {
    }

    @Test
    void getColumnName() {
    }
}