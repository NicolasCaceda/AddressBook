package AddressBook;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressBookTest {

    private AddressBook book;
    private AddressBook brokenBook;
    private Person fullPerson;
    private Person EmptyPerson;
    private Person[] personArray;

    //Before each test make a new addressbook and person
    @BeforeEach
    void setUp() {
        book = new AddressBook();
        fullPerson = new Person("F", "L", "A", "C", "S",
            "1", "2");
    }

    //After each test run this empty method
    @AfterEach
    void tearDown() {
    }

    //tests that if no person has been added to the address book
    //the result will be an empty array.
    @Test
    void getPersons_noPersons_emptyArray() {
        Person[] array={};
        assertArrayEquals(array , book.getPersons());
    }

    //Adds two people to the address book then requests all the people
    //returns an array of 2 persons
    @Test
  void getPersons_twoPersons_returnsArray() {
    book.add(fullPerson);
    book.add(fullPerson);
    Person[] array = {fullPerson, fullPerson};
    assertArrayEquals(array , book.getPersons());
  }

    //Tests what happens when you add an empty person
    //Nothing happens. Not even an exception.
    @Test
    void add_emptyPerson_doesNotThrowsException() {
        assertDoesNotThrow(() -> book.add(EmptyPerson));
    }

    //Adds a full person to the addressbook.
    //should not fail
    @Test
    void add_fullPerson_throwsException() {
        assertDoesNotThrow(() -> book.add(fullPerson));
    }

    //tests what happens when you try to set an index that does not exist
    //with a person that has not been initialized.
    //throws an exception.
    @Test
    void set_indexOutOfBoundsPersonArray_throwsException() {
        assertThrows(IndexOutOfBoundsException.class,() -> book.set(2,EmptyPerson));
    }

    //tests what happens when you try to set an index that does exist
    //with a person that has not been initialized.
    //Nothing breaks
    @Test
    void set_indexExistsReplaceWithEmpty_throwsException() {
        book.add(fullPerson);
        assertDoesNotThrow(() -> book.set(0,EmptyPerson));
    }

    //tests what happens when you try to set an index that exists
    //with a person that exists.
    //Nothing breaks.
    @Test
    void set_setPerson_throwsException() {
        book.add(EmptyPerson);
        assertDoesNotThrow(() -> book.set(0,fullPerson));
    }

    //tests what happens when you try to remove from an index that does not exist
    //throws an exception.
    @Test
    void remove_indexDoesNotExist_throwsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> book.remove(41));
    }

    //tests what happens when you try to remove from an index that does exist
    //Nothing breaks.
    @Test
    void remove_indexExists_throwsException() {
        book.add(fullPerson);
        assertDoesNotThrow(() -> book.remove(0));
    }

    //tests what happens when you try to get from an index that does not exist
    //throws an exception.
    @Test
    void get_indexDoesNotExist_throwsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> book.get(41));
    }

    //tests what happens when you try to get from an index that does exist
    //Nothing breaks.
    @Test
    void get_getAPerson_returnsPerson() {
        book.add(fullPerson);
        assertEquals(fullPerson, book.get(0));
    }

    //tests what happens when you try to clear and empty book
    //Should'nt break
    @Test
    void clear_bookPersonEmpty_throwsNothing() {
        assertDoesNotThrow(() -> book.clear());
    }

    //If the book isn't initialized and you try to clear the book it should break.
    @Test
    void clear_bookNotInit_throwsException() {
        assertThrows(NullPointerException.class, () -> brokenBook.clear());
    }

    //If the book is cleared prior and then cleared again, nothing breaks.
    @Test
    void clear_bookPersonCleared_throwsNothing() {
        book.clear();
        assertDoesNotThrow(() -> book.clear());
    }

    //if you add something
    //then remove it
    //then clear it shouldn't break.
    @Test
    void clear_bookPersonZero_throwsNothing() {
        book.add(fullPerson);
        book.remove(0);
        assertDoesNotThrow(() -> book.clear());
    }

    //Clearing as normal shouldn't break this.
    //Normal being adding people then clearing to restart
    @Test
    void clear_bookNotEmpty_throwsNothing() {
        book.add(fullPerson);
        book.add(fullPerson);
        book.add(fullPerson);
        assertDoesNotThrow(() -> book.clear());
    }

    //not initialized
    //try to get row count
    //it breaks.
    @Test
    void getRowCount_notInit_throwsException() {
        assertThrows(NullPointerException.class, () -> brokenBook.getRowCount());
    }

    //if you add nothing to a book and get the row count you're still at the start
    @Test
    void getRowCount_nothingAdded_returnsZero() {
        assertEquals(0, book.getRowCount());
    }

    //add a person and then get row count
    //works as intended
    @Test
    void getRowCount_oneItemAdded_returnsOne() {
        book.add(fullPerson);
        assertEquals(1, book.getRowCount());
    }

    //if you get a col count on an uninitialized book. it will break.
    @Test
    void getColumnCount_notInit_throwsException() {
        assertThrows(NullPointerException.class, () -> brokenBook.getColumnCount());
    }

    //there should be 7 column if not uh oh...
    @Test
    void getColumnCount_nothingAdded_returnsNull() {
        assertEquals(7, book.getColumnCount());
    }

    //add a person
    //see if that effected the column count
    //it really shouldnt have
    @Test
    void getColumnCount_oneItemAdded_returnsOne() {
        book.add(fullPerson);
        assertEquals(7, book.getColumnCount());
    }

    //add a person and get a value from the book at column row.
    @Test
    void getValueAt_validValid_returnsValidObject() {
        book.add(fullPerson);
        assertEquals("2",book.getValueAt(0,6));
    }

    //add a person and fail to target them.
    @Test
    void getValueAt_validNotValid_throwsException() {
        book.add(fullPerson);
        assertThrows(IllegalArgumentException.class,() -> book.getValueAt(0,9));
    }

    //add a person and fail to target them again
    @Test
    void getValueAt_notValidValid_throwsException() {
        book.add(fullPerson);
        assertThrows(IndexOutOfBoundsException.class,() -> book.getValueAt(1,6));
    }

    //add a person and fail to target them again
    @Test
    void getValueAt_notValidNotValid_throwsException() {
        book.add(fullPerson);
        assertThrows(IndexOutOfBoundsException.class,() -> book.getValueAt(1,9));
    }

    //there is no person and you failed to get a nonexistent person.
    @Test
    void getValueAt_notInit_throwsException() {
        assertThrows(NullPointerException.class,() -> brokenBook.getValueAt(0,0));
    }

    //get the column name
    //works as expected
    @Test
    void getColumnName_validCol_returnString() {
        assertEquals("Phone", book.getColumnName(6));
    }

    //get the column name
    //it doesnt exist
    //throw exception
    @Test
    void getColumnName_invalidCol_throwsException() {
        assertThrows(IndexOutOfBoundsException.class,() -> book.getColumnName(9));
    }

    //get column name
    //it doesnt exist because not initialized
    //it breaks.
    @Test
    void getColumnName_notInit_throwsException() {
        assertThrows(NullPointerException.class,() -> brokenBook.getColumnName(6));
    }

    //adds 19 persons to the address book
    //adds 1 more to make 20 to ensure the book can hold at least 20 persons
    @Test
    void addXAmountOfPersons() {
      for (int i = 0; i < 19; i++) {
       book.add(fullPerson);
      }
      assertDoesNotThrow(() -> book.add(fullPerson));
  }
}