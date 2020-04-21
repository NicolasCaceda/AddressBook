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
    //setup before each test
    @BeforeEach
    public void setUp() {
        testJFrame = new JFrame();
        TestPersonFullInfo = new Person("F", "L", "A", "C", "S",
                "1", "2");
        testPersonDialog = new PersonDialog(testJFrame, TestPersonFullInfo);
        testEmptyPersonDialog = new PersonDialog(testJFrame, EmptyPerson);
    }
/*
    @Test
    void fullPerson_showDialog_OKResult() {
        PersonDialog.Result result = PersonDialog.Result.OK;
        assertEquals(result, testPersonDialog.showDialog());
    }
*/
    //get the person
    //turn it into a string because objects will have different addressees.
    @Test
    void fullPerson_getPerson_equals() {
        assertEquals(TestPersonFullInfo.toString(), testPersonDialog.getPerson().toString());
    }

    //person doesnt exist.
    @Test
    void EmptyPerson_getPerson_null() {
        assertNull(testEmptyPersonDialog.getPerson());
    }
}