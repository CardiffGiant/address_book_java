package ict4315.unit10;

import org.junit.Test;

public class EditContactViewPanel_Test {

    @Test (expected = IllegalArgumentException.class)
    public void testConstructorWithNullMediator() {
        Contact tester = new Contact();
        EditContactViewPanel test = new EditContactViewPanel(null, tester);
    }
    @Test (expected = IllegalArgumentException.class)
    public void testConstructorWithNullContactArgument() {
        ViewMediator tester = new ViewMediator();
        EditContactViewPanel test = new EditContactViewPanel(tester, null);
    }
    @Test
    public void testConstructorWithValidArguments() {
        try {
            ViewMediator mediator = new ViewMediator();
            Contact tester = new Contact();
            EditContactViewPanel test = new EditContactViewPanel(mediator, tester);
        }catch (IllegalArgumentException e) {
            throw new IllegalArgumentException ("the argument passed was null");
        }
    }
}


