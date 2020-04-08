package IntegrationTests;

import AddressBook.AddressBook;
import AddressBook.AddressBookController;
import AddressBook.Person;
import AddressBook.FileSystem;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;

import static org.mockito.Mockito.mock;

public class AddressBookControllerIT {

    FileSystem fileSystem0;
    File file0;

    AddressBook addressBook0;
    AddressBookController testController;

    Person person0;
    Person person1;
    Person person2;

    @BeforeEach
    void setUp() {
        addressBook0 = mock(AddressBook.class);
        AddressBookController testController =
                new AddressBookController(addressBook0);
        fileSystem0 = mock(FileSystem.class);
        file0 = mock(File.class);
        person0 = mock(Person.class);
        person1 = mock(Person.class);
        person2 = mock(Person.class);



        //Make stubs here:
        when(mock.method()).blah();
    }
}
