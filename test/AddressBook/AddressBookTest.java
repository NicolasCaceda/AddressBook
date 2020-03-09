package AddressBook;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressBookTest {

    private AddressBook book;
    private Person fullPerson;
    private Person EmptyPerson;
    private Person[] personArray;

    @BeforeEach
    void setUp() {
        book = new AddressBook();
        fullPerson = new Person("F", "L", "A", "C", "S",
            "Z", "P");
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
    void getPersons_twoPersons_Array() {
        book.add(fullPerson);
        book.add(fullPerson);
        Person[] array = {fullPerson, fullPerson};
        assertArrayEquals(array , book.getPersons());
    }


    @Test
    void add_emptyPerson_doesNotThrowsException() {
        assertDoesNotThrow(() -> book.add(EmptyPerson));
    }

    @Test
    void add_fullPerson_throwsException() {
        assertDoesNotThrow(() -> book.add(fullPerson));
    }

    @Test
    void set_indexOutOfBoundsPersonArray_throwsException() {
        assertThrows(IndexOutOfBoundsException.class,() -> book.set(2,EmptyPerson));
    }

    @Test
    void set_indexExistsReplaceWithEmpty_throwsException() {
        book.add(fullPerson);
        assertDoesNotThrow(() -> book.set(0,EmptyPerson));
    }

    @Test
    void set_setPerson_throwsException() {
        book.add(EmptyPerson);
        assertDoesNotThrow(() -> book.set(0,fullPerson));
    }

    @Test
    void remove_indexDoesNotExist_throwsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> book.remove(41));
    }

    @Test
    void remove_indexExists_throwsException() {
        book.add(fullPerson);
        assertDoesNotThrow(() -> book.remove(0));
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