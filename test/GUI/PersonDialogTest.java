package GUI;

import AddressBook.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class PersonDialogTest {
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
        testPersonDialog = new PersonDialog(testJFrame, TestPersonFullInfo);
        testEmptyPersonDialog = new PersonDialog(testJFrame, EmptyPerson);
    }

    @Test
    void fullPerson_showDialog_OKResult() {
        PersonDialog.Result result = PersonDialog.Result.OK;
        assertEquals(result, testPersonDialog.showDialog());
    }

    @Test
    void fullPerson_getPerson_equals() {
        assertEquals(TestPersonFullInfo.toString(), testPersonDialog.getPerson().toString());
    }

    @Test
    void EmptyPerson_getPerson_null() {
        assertNull(testEmptyPersonDialog.getPerson());
    }
}