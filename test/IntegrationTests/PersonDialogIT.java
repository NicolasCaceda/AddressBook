package IntegrationTests;

import AddressBook.Person;
import GUI.PersonDialog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PersonDialogIT {
    PersonDialog testPersonDialog;
    PersonDialog testEmptyPersonDialog;
    Person TestPersonFullInfo;
    Person EmptyPerson;
    JFrame testJFrame;

    @BeforeEach
    public void setUp() {
        testJFrame = new JFrame();
        TestPersonFullInfo = new Person("F", "L", "A", "C", "S",
                "Z", "P");
        testPersonDialog = mock(PersonDialog.class);
        testEmptyPersonDialog = mock(PersonDialog.class);
    }

    @Test
    void fullPerson_showDialog_OKResult() {
        PersonDialog.Result result = PersonDialog.Result.OK;
        when(testPersonDialog.showDialog()).thenReturn(PersonDialog.Result.OK);

        assertEquals(result, testPersonDialog.showDialog());
    }
    @Test
    void fullPerson_showDialog_CANCELResult() {
        PersonDialog.Result result = PersonDialog.Result.CANCEL;
        when(testPersonDialog.showDialog()).thenReturn(PersonDialog.Result.CANCEL);

        assertEquals(result, testPersonDialog.showDialog());
    }

    @Test
    void EmptyPerson_showDialog_OKResult() {
        PersonDialog.Result result = PersonDialog.Result.OK;
        when(testEmptyPersonDialog.showDialog()).thenReturn(PersonDialog.Result.OK);

        assertEquals(result, testEmptyPersonDialog.showDialog());
    }
    @Test
    void EmptyPerson_showDialog_CANCELResult() {
        PersonDialog.Result result = PersonDialog.Result.CANCEL;
        when(testEmptyPersonDialog.showDialog()).thenReturn(PersonDialog.Result.CANCEL);

        assertEquals(result, testEmptyPersonDialog.showDialog());
    }
}
