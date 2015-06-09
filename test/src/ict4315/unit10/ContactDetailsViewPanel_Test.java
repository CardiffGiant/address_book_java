package ict4315.unit10;

import static org.junit.Assert.*;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.junit.Test;

/**
 * Tests for contactDetails GUI view
 * @author Jeff Carmichael
 *
 */
public class ContactDetailsViewPanel_Test {
    
    @Test (expected = IllegalArgumentException.class)
    public void testNullContactArg() {
        ViewMediator mediator = new ViewMediator();
        JPanel view = new ContactDetailsViewPanel(null, mediator);
    }
    @Test (expected = IllegalArgumentException.class)
    public void testNullMediatorArg() {
        Contact test = new Contact();
        JPanel view = new ContactDetailsViewPanel(test, null);
    }
    @Test (expected = IllegalArgumentException.class)
    public void testNullContactInUpdateView() {
        Contact test = new Contact();
        ViewMediator med = new ViewMediator();
        JPanel view = new ContactDetailsViewPanel(test,med);
        ((ContactDetailsViewPanel) view).updateView(null);
    }
}
