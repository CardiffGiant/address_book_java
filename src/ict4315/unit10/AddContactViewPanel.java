package ict4315.unit10;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * GUI view for adding a contact to the Address Book
 * @author Jeff Carmichael
 *
 */
public class AddContactViewPanel extends JPanel {
    /**
     */
    private static final long serialVersionUID = 1L;
    
    ViewMediator mediator;
    private JLabel nameTitle;
    private JTextField contactFirstName;
    private JTextField contactLastName;
    private JLabel emailTitle;
    private JTextField contactEmail;
    private JLabel mobilePhoneTitle;
    private JTextField contactMobile;
    private JLabel homePhoneTitle;
    private JTextField contactHomePhone;
    private JLabel streetTitle;
    private JTextField contactStreet;
    private JLabel cityTitle;
    private JTextField contactCity;
    private JLabel stateTitle;
    private JTextField contactState;
    private JLabel zipTitle;
    private JTextField contactZip;
    
    /**
     * View constructor for the add contact view.
     * Builds the view with all labels and text fields
     * @param mediator the view's mediator
     * @throws IllegalArgumentException if mediator is null
     */
    public AddContactViewPanel(ViewMediator mediator) throws IllegalArgumentException {
        if (mediator != null) {
            super.setBackground(Color.WHITE);
            super.setPreferredSize(new Dimension(400,300));
            super.setLayout(new GridLayout(0,3));
            super.setBorder(new EmptyBorder(20,20,20,20));
            
            this.mediator = mediator;
            mediator.registerAddContactView(this);
            
            createInfoLabels();
            createTextFields();
            addLabelsAndTextFields();
        }else {
            throw new IllegalArgumentException("The mediator passed to add contact view was null");
        }
    }
    
    /**
     * Builds the labels for the view.
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
        
        cityTitle = new JLabel("City: ", SwingConstants.RIGHT);
        cityTitle.setPreferredSize(new Dimension(80,20));
        cityTitle.setBorder(new EmptyBorder(0,0,0,10));
        
        stateTitle = new JLabel("State: ", SwingConstants.RIGHT);
        stateTitle.setPreferredSize(new Dimension(80,20));
        stateTitle.setBorder(new EmptyBorder(0,0,0,10));
        
        zipTitle = new JLabel("Zip Code: ", SwingConstants.RIGHT);
        zipTitle.setPreferredSize(new Dimension(80,20));
        zipTitle.setBorder(new EmptyBorder(0,0,0,10));
     }
    
    /**
     * builds the text fields for the view.
     */
    private final void createTextFields() {
        contactFirstName = new JTextField("first",20);
        contactLastName = new JTextField("last",20);
        contactLastName.addFocusListener(mediator);
        mediator.registerContactLastNameTextField(contactLastName);
        contactEmail = new JTextField(20);
        contactMobile = new JTextField(10);
        contactHomePhone = new JTextField(10);
        contactStreet = new JTextField(30);
        contactCity = new JTextField(20);
        contactState = new JTextField(2);
        contactZip = new JTextField(5);
    }
    
    /**
     * Adds labels and text fields to the view.
     */
    private final void addLabelsAndTextFields() {
        add(nameTitle);
        add(contactFirstName);
        add(contactLastName);
        add(emailTitle);
        add(contactEmail);
        add(new JLabel(""));
        add(mobilePhoneTitle);
        add(contactMobile);
        add(new JLabel(""));
        add(homePhoneTitle);
        add(contactHomePhone);
        add(new JLabel(""));
        add(streetTitle);
        add(contactStreet);
        add(new JLabel(""));
        add(cityTitle);
        add(contactCity);
        add(new JLabel(""));
        add(stateTitle);
        add(contactState);
        add(new JLabel(""));
        add(zipTitle);
        add(contactZip);
        add(new JLabel(""));
    }
    
    /**
     * Collects textField values into an array of Strings.
     * @return collected text field values.
     */
    public final String[] collectContactData() {
        String[] contactData = {contactFirstName.getText(),contactLastName.getText(),contactEmail.getText(),contactMobile.getText(),
                    contactHomePhone.getText(),contactStreet.getText(),contactCity.getText(),contactState.getText(),
                    contactZip.getText()};
        return contactData;
    }
    
    /**
     * Clears contents of text fields for new addition.
     */
    public final void resetTextFields() {
        contactFirstName.setText("");
        contactLastName.setText("");
        contactEmail.setText("");
        contactMobile.setText("");
        contactHomePhone.setText("");
        contactStreet.setText("");
        contactCity.setText("");
        contactState.setText("");
        contactZip.setText("");
    }
}
