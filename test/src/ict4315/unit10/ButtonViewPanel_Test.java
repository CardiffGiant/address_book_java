package ict4315.unit10;

import org.junit.Test;

public class ButtonViewPanel_Test {

    @Test (expected = IllegalArgumentException.class)
    public void testConstructorWithNullMediator() {
        ButtonViewPanel test = new ButtonViewPanel(null);
    }
    @Test
    public void testConstructorWithValidArgument() {
        try {
            ViewMediator mediator = new ViewMediator();
            ButtonViewPanel test = new ButtonViewPanel(mediator);
        }catch (IllegalArgumentException e) {
            throw new IllegalArgumentException ("the argument passed was null");
        }
    }
}
