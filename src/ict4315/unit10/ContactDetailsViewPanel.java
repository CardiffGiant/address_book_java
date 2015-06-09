package ict4315.unit10;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * GUI view that displays contact information.
 * Data cannot be edited in this view.
 * @author Jeff Carmichael
 *
 */
public class ContactDetailsViewPanel extends JPanel {
    /**
     */
    private static final long serialVersionUID = 1L;
    
    private JLabel nameTitle;
    private JLabel contactFullName;
    private JLabel emailTitle;
    private JLabel contactEmail;
    private JLabel mobilePhoneTitle;
    private JLabel contactMobile;
    private JLabel homePhoneTitle;
    private JLabel contactHomePhone;
    private JLabel streetTitle;
    private JLabel contactStreet;
    private JLabel blank;
    private JLabel contactCityStateZip;
    
    private Contact currentContact; //contact that is currently visible in the GUI view
    
    private ViewMediator mediator;
    
    /**
     * Builds the GUI view for contact details
     * data is not editable in this view.
     * @param firstInList first contact in the Address Book
     * @param obs mediator for this view
     * @throws IllegalArgumentException if arguments are null
     */
    public ContactDetailsViewPanel(Contact firstInList, ViewMediator obs) throws IllegalArgumentException{
        if (firstInList == null) {
            throw new IllegalArgumentException("The contact passed is null");
        }
        if (obs == null) {
            throw new IllegalArgumentException("The mediator passed is null");
        }
        super.setBackground(Color.WHITE);
        super.setPreferredSize(new Dimension(500,400));
        super.setLayout(new GridLayout(0,2));
        super.setBorder(new EmptyBorder(80,20,20,20));
       
        currentContact = firstInList;
        mediator = obs;
        mediator.registerDetailsViewPanel(this);
       
        createInfoLabels();
        addInfoLabels();
    }
    
    /**
     * Updates the label text values when a new contact is
     * selected.
     * @param newView the source contact of data.
     */
    public final void updateView(Contact newView) throws IllegalArgumentException {
        if (newView != null) {
            contactFullName.setText(newView.getFirstName() + " " + newView.getLastName());
            contactEmail.setText(newView.getEmail());
            contactMobile.setText(newView.getMobilePhone());
            contactHomePhone.setText(newView.getHomePhone());
            contactStreet.setText(newView.getStreet());
            contactCityStateZip.setText(newView.getCity() +" " + newView.getState() + " " + newView.getZipCode());
            currentContact = newView;
        }else {
            throw new IllegalArgumentException("The new contact to display is null");
        }
    }
     
    /**
     * Returns the contact that is currently visible in view.
     * @return
     */
    public Contact getCurrentContact() {
         return currentContact;
    }
     
    /**
     * Builds all necessary labels with dimensions,
     * border and text justification.
     */
    private final void createInfoLabels() {
       nameTitle = new JLabel("Name: ", SwingConstants.RIGHT);
       nameTitle.setPreferredSize(new Dimension(80,20));
       nameTitle.setBorder(new EmptyBorder(0,0,0,10));
       
       emailTitle = new JLabel("Email: ", SwingConstants.RIGHT);
       emailTitle.setPreferredSize(new Dimension(80,20));
       emailTitle.setBorder(new EmptyBorder(0,0,0,10));
       mobilePhoneTitle = new JLabel("Mobile: ", SwingConstants.RIGHT);
       mobilePhoneTitle.setPreferredSize(new Dimension(80,20));
       mobilePhoneTitle.setBorder(new EmptyBorder(0,0,0,10));
       homePhoneTitle = new JLabel("Home: ", SwingConstants.RIGHT);
       homePhoneTitle.setPreferredSize(new Dimension(80,20));
       homePhoneTitle.setBorder(new EmptyBorder(0,0,0,10));
       streetTitle = new JLabel("Address: ", SwingConstants.RIGHT);
       streetTitle.setPreferredSize(new Dimension(80,20));
       streetTitle.setBorder(new EmptyBorder(0,0,0,10));
       blank = new JLabel("", SwingConstants.RIGHT);
       blank.setPreferredSize(new Dimension(80,20));
       
       contactFullName = new JLabel(currentContact.getFirstName() + " " + currentContact.getLastName(), SwingConstants.LEFT);
       contactEmail = new JLabel(currentContact.getEmail(), SwingConstants.LEFT);
       contactMobile = new JLabel(currentContact.getMobilePhone(), SwingConstants.LEFT);
       contactHomePhone = new JLabel(currentContact.getHomePhone(), SwingConstants.LEFT);
       contactStreet = new JLabel(currentContact.getStreet(), SwingConstants.LEFT);
       contactCityStateZip = new JLabel(currentContact.getCity() + " " + currentContact.getState()
                                          + " " + currentContact.getZipCode(), SwingConstants.LEFT);
    }
    
    /**
     * Adds labels to the view.
     */
    private final void addInfoLabels() {
       add(nameTitle);
       add(contactFullName);
       
       add(emailTitle);
       add(contactEmail);
       
       add(mobilePhoneTitle);
       add(contactMobile);
       
       add(homePhoneTitle);
       add(contactHomePhone);
       
       add(streetTitle);
       add(contactStreet);
       
       add(blank);
       add(contactCityStateZip);
       
    }
}
