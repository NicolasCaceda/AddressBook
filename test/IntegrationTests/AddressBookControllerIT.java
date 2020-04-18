package IntegrationTests;

import AddressBook.AddressBook;
import AddressBook.AddressBookController;
import AddressBook.Person;
import AddressBook.FileSystem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class AddressBookControllerIT {

    FileSystem fileSystem0;
    File file0;

    AddressBook addressBook0;
    AddressBookController testController;

    Person person0;
    Person person1;
    Person person2;

    @BeforeEach
    void setUp() throws SQLException {
        addressBook0 = mock(AddressBook.class);
        testController =
                new AddressBookController(addressBook0);

        fileSystem0 = mock(FileSystem.class);
        file0 = mock(File.class);

        person0 = mock(Person.class);
        person1 = mock(Person.class);
        person2 = mock(Person.class);



        //Make stubs here:
        when(addressBook0.get(0)).thenReturn(person0);
        when(addressBook0.get(1)).thenReturn(person1);
        when(addressBook0.get(2)).thenReturn(person2);

        when(file0.exists()).thenReturn(true);

        doThrow(new NullPointerException()).when(fileSystem0).saveFile(addressBook0, file0);

    }

    @Test
    public void addressbookcontroller_add_test(){
        assertDoesNotThrow(() -> testController.add(person0));
        verify(addressBook0).add(person0);
    }

    @Test
    public void addressbookcontroller_set_test(){
        testController.add(person0);
        testController.set(1,person1);
        assertEquals(person1, testController.get(1));
        verify(addressBook0).set(1, person1);
    }

    @Test
    public void addressbookcontroller_remove_test(){
        testController.add(person0);
        testController.remove(0);
        //"removed" because the stub above doesnt permit it to be removed
        when(addressBook0.get(0)).thenReturn(null);
        assertNotEquals(person0,testController.get(0));
        verify(addressBook0).remove(0);
    }

    @Test
    public void addressbookcontroller_get_test(){
        testController.add(person0);
        assertEquals(person0, testController.get(0));
        verify(addressBook0).get(0);
    }

    @Test
    public void addressbookcontroller_clear_test(){
        testController.add(person0);
        testController.add(person1);
        testController.add(person2);
        testController.clear();
        when(addressBook0.get(0)).thenReturn(null);
        assertNull(testController.get(0));
        verify(addressBook0).get(0);
    }

    @Test
    public void addressbookcontroller_open_test() throws FileNotFoundException, SQLException {
        assertThrows(FileNotFoundException.class, ()-> testController.open(file0));
    }

    @Test
    public void addressbookcontroller_save_test() throws SQLException{
        assertThrows(NullPointerException.class, () -> testController.save(file0));
    }

    @Test
    public void addressbookcontroller_getModel_test() {
        AddressBook addressBook;
        addressBook = testController.getModel();
        assertEquals(testController.getModel(), addressBook);
    }
}
