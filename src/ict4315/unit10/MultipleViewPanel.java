package ict4315.unit10;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * GUI container that holds the 3 views
 * @author Jeff Carmichael
 *
 */
public class MultipleViewPanel extends JPanel {
    /**
     */
    private static final long serialVersionUID = 1L;
    
    private ViewMediator mediator;
    private CardLayout contactMultiViewLayout;
    
    /**
     * constructs the container with dimensions
     * and background color then builds the views
     * and adds them to the container.
     * Order of Views:
     * ContactDetails
     * EditContact
     * AddContact
     * @param mediator
     */
    public MultipleViewPanel(ViewMediator mediator) {
        
        super.setBackground(Color.WHITE);
        super.setPreferredSize(new Dimension(500,400));
        contactMultiViewLayout = new CardLayout();
        super.setLayout(contactMultiViewLayout);
        super.setBorder(new EmptyBorder(20,20,20,20));
        
        this.mediator = mediator;
        mediator.registerMultiViewPanel(this);
        
        AddContactViewPanel addContactView = new AddContactViewPanel(mediator);
        ContactDetailsViewPanel contactDetailsView = new ContactDetailsViewPanel(mediator.getFirstContact(), mediator);
        EditContactViewPanel editContactView = new EditContactViewPanel(mediator, mediator.getFirstContact());
        
        add(contactDetailsView);
        add(editContactView);
        add(addContactView);
        
    }
    
    /**
     * Changes the visible view to the next one
     * in the sequence.
     */
    public void nextContactViewPanel() {
        contactMultiViewLayout.next(this);
    }
    
    /**
     * Changes the visible view to the previous on
     * in the sequence.
     */
    public void previousContactViewPanel() {
        contactMultiViewLayout.previous(this);
    }
}
