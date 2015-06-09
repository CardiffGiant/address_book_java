package ict4315.unit10;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
/**
 * GUI view for the buttons.
 * @author Jeff Carmichael
 *
 */
public final class ButtonViewPanel extends JPanel {
    /**
     */
    private static final long serialVersionUID = 1L;
    ViewMediator mediator;
    
    JButton goToAddContact;
    JButton addContact;
    JButton editContact;
    JButton confirmContact;
    JButton cancelEdit;
    JButton cancelNewContact;
    JButton remove;
    JPanel editContactPanel;
    JPanel viewContactPanel;
    JPanel newContactPanel;
    CardLayout buttonLayout;
    
    /**
     * Builds the button view of the GUI
     * and sets reference to the controller(mediator)
     * Button view sequence is:
     * view contact panel
     * edit contact panel
     * new contact panel
     * @param mediator
     */
    public ButtonViewPanel(ViewMediator mediator) throws IllegalArgumentException {
        if (mediator != null) {
            this.mediator = mediator;
            mediator.registerButtonView(this);
            super.setPreferredSize(new Dimension(300,100));
            super.setBorder(new EmptyBorder(10,10,10,10));
            super.setBackground(Color.WHITE);
            buttonLayout = new CardLayout();
            super.setLayout(buttonLayout);
            createButtons();
            createCardPanels();
            addButtonsToPanels();
            add(viewContactPanel);
            add(editContactPanel);
            add(newContactPanel);
        }else {
            throw new IllegalArgumentException("The mediator that was passed is null");
        }
    }
    
    /**
     * Builds the buttons for the GUI
     */
    private final void createButtons() {
        goToAddContact = new JButton("+");
        mediator.registerGoToContactButton(goToAddContact);
        goToAddContact.addActionListener(mediator);
        
        addContact = new JButton("Add Contact");
        mediator.registerAddContactButton(addContact);
        addContact.addActionListener(mediator);
        addContact.setEnabled(false);
        
        editContact = new JButton("Edit");
        mediator.registerEditContactButton(editContact);
        editContact.addActionListener(mediator);
        
        confirmContact = new JButton("Confirm");
        mediator.registerConfirmContactButton(confirmContact);
        confirmContact.addActionListener(mediator);
        
        cancelEdit = new JButton("Cancel");
        mediator.registerCancelEditButton(cancelEdit);
        cancelEdit.addActionListener(mediator);
        
        remove = new JButton("Remove");
        mediator.registerRemoveContactButton(remove);
        remove.addActionListener(mediator);
        
        cancelNewContact = new JButton("Cancel");
        mediator.registerCancelNewContactButton(cancelNewContact);
        cancelNewContact.addActionListener(mediator);
    }
    
    /**
     * Builds the panels for the button views in the GUI
     */
    private final void createCardPanels() {
        editContactPanel = new JPanel();
        editContactPanel.setPreferredSize(new Dimension(400,100));
        editContactPanel.setLayout(new BoxLayout(editContactPanel, BoxLayout.X_AXIS));
        viewContactPanel = new JPanel();
        viewContactPanel.setPreferredSize(new Dimension(400,100));
        viewContactPanel.setLayout(new BoxLayout(viewContactPanel, BoxLayout.X_AXIS));
        newContactPanel = new JPanel();
        newContactPanel.setPreferredSize(new Dimension(400,100));
        newContactPanel.setLayout(new BoxLayout(newContactPanel, BoxLayout.X_AXIS));
    }
    
    /**
     * Adds the buttons to the panels
     */
    private final void addButtonsToPanels() {
        editContactPanel.add(Box.createHorizontalStrut(30));
        editContactPanel.add(confirmContact);
        editContactPanel.add(Box.createHorizontalStrut(80));
        editContactPanel.add(remove);
        editContactPanel.add(cancelEdit);
        
        viewContactPanel.add(Box.createHorizontalStrut(30));
        viewContactPanel.add(goToAddContact);
        viewContactPanel.add(Box.createHorizontalStrut(100));
        viewContactPanel.add(editContact);
        
        newContactPanel.add(Box.createHorizontalStrut(30));
        newContactPanel.add(addContact);
        newContactPanel.add(Box.createHorizontalStrut(100));
        newContactPanel.add(cancelNewContact);
    }
    
    /**
     * Displays the next button view in the sequence.
     */
    public void nextButtonPanel() {
        buttonLayout.next(this);
    }
    
    /**
     * Displays the previous button view in the sequence.
     */
    public void previousButtonPanel() {
        buttonLayout.previous(this);
    }
}
