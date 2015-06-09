package ict4315.unit10;

import static org.junit.Assert.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.junit.Test;

public class ContactListViewPanel_Test {
    
    @Test (expected = IllegalArgumentException.class)
    public void testConstructorWithNullMediator() {
        ContactListViewPanel test = new ContactListViewPanel(null);
    }
    @Test (expected = NullPointerException.class)
    public void testConstructorWithValidArgument() {
    
        ViewMediator tester = new ViewMediator();
        ContactListViewPanel test = new ContactListViewPanel(tester);
    }
}
