package ict4315.unit10;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.FileNotFoundException;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public final class AddressBookDriver {

    public static void main(String[] args) throws FileNotFoundException {
        
        /**
         * Initial setup for the Address Book
         */
        ViewMediator mediator = new ViewMediator();
        WindowObserver windowListener = new WindowObserver(mediator);
        ContactList testList = new ContactList(mediator);
        testList.setListOfContacts(mediator.openSavedListAndSet());
        
        /**
         * Build the container window of GUI
         */
        JFrame window = new JFrame("test of text pane");
        mediator.registerWindow(window);
        window.addWindowListener(windowListener);
        window.setMinimumSize(new Dimension(720,600));
        window.setPreferredSize(new Dimension(720, 600));
        window.setLayout(new BorderLayout());
        
        /**
         * Build the inner container panel and the views.
         */
        JPanel rightPane = new JPanel();
        rightPane.setLayout(new BoxLayout(rightPane,BoxLayout.Y_AXIS));
        rightPane.setSize(new Dimension(400,600));
        rightPane.setBackground(Color.WHITE);
        ContactListViewPanel listView = new ContactListViewPanel(mediator);
        MultipleViewPanel multiView = new MultipleViewPanel(mediator);
        ButtonViewPanel buttonView = new ButtonViewPanel(mediator);
        
        /**
         * Add views to right panel of GUI.
         */
        rightPane.add(multiView);
        rightPane.add(buttonView);
        
        /**
         * Add elements to the program window and make it visible
         */
        window.add(new JScrollPane(listView, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
                                    JScrollPane.HORIZONTAL_SCROLLBAR_NEVER),BorderLayout.WEST);
        window.add(rightPane,BorderLayout.EAST);
        window.pack();
        window.setVisible(true);
        
    }

}
