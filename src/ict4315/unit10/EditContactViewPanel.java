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
 * GUI view for editing an existing contact from
 * the Address Book
 * @author Jeff Carmichael
 *
 */
public class EditContactViewPanel extends JPanel {
    /**
     */
    private static final long serialVersionUID = 1L;
    
    private ViewMediator mediator;
    
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
    
    private Contact contactUnderEdit;
    
    /**
     * constructor for the view
     * Builds the entire view with all labels and text fields.
     * @param mediator the view's mediator
     * @param contactUnderEdit the contact whose details should be displayed
     */
    public EditContactViewPanel(ViewMediator mediator, Contact contactUnderEdit) throws IllegalArgumentException {
        if (mediator == null) {
            throw new IllegalArgumentException("the mediator argument was null");
        }
        if (contactUnderEdit == null) {
            throw new IllegalArgumentException("the contact argument that was passed is null");
        }
        super.setBackground(Color.WHITE);
        super.setPreferredSize(new Dimension(400,300));
        super.setLayout(new GridLayout(0,3));
        super.setBorder(new EmptyBorder(20,20,20,20));
        
        this.mediator = mediator;
        mediator.registerEditContactView(this);
        this.contactUnderEdit = contactUnderEdit;
        createInfoLabels();
        createTextFields();
        addLabelsAndTextFields();
    }
    
    /**
     * Creates the labels which includes setting dimensions
     * and adding borders. Also sets text justification.
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
     * Creates text fields and sets width in pixels.
     * Adds focus listener to appropriate field.
     */
    private final void createTextFields() {
        contactFirstName = new JTextField(contactUnderEdit.getFirstName(),20);
        contactLastName = new JTextField(contactUnderEdit.getLastName(),20);
        contactLastName.addFocusListener(mediator);
        mediator.registerEditLastNameTextField(contactLastName);
        contactEmail = new JTextField(contactUnderEdit.getEmail(),20);
        contactMobile = new JTextField(contactUnderEdit.getMobilePhone(),10);
        contactHomePhone = new JTextField(contactUnderEdit.getHomePhone(),10);
        contactStreet = new JTextField(contactUnderEdit.getStreet(),30);
        contactCity = new JTextField(contactUnderEdit.getCity(),20);
        contactState = new JTextField(contactUnderEdit.getState(),2);
        contactZip = new JTextField(contactUnderEdit.getZipCode(),5);
    }
    
    /**
     * Adds GUI elements to the view.
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
     * Sets fields of contact under edit to
     * text field values.
     */
    public final void confirmContactChanges() {
        contactUnderEdit.setFirstName(contactFirstName.getText());
        contactUnderEdit.setLastName(contactLastName.getText());
        contactUnderEdit.setEmail(contactEmail.getText());
        contactUnderEdit.setMobilePhone(contactMobile.getText());
        contactUnderEdit.setHomePhone(contactHomePhone.getText());
        contactUnderEdit.setStreet(contactStreet.getText());
        contactUnderEdit.setCity(contactCity.getText());
        contactUnderEdit.setState(contactState.getText());
        contactUnderEdit.setZipCode(contactZip.getText());
    }
    
    /**
     * Accessor for the contact under edit
     * @return the contact that is being edited.
     */
    public final Contact getContactUnderEdit() {
        return contactUnderEdit;
    }
    
    /**
     * Sets contact under edit to passed argument
     * then populates text fields with appropriate data.
     * @param newContact
     */
    public final void setContactUnderEdit(Contact newContact) {
        contactUnderEdit = newContact;
        
        contactFirstName.setText(contactUnderEdit.getFirstName());
        contactLastName.setText(contactUnderEdit.getLastName());
        contactEmail.setText(contactUnderEdit.getEmail());
        contactMobile.setText(contactUnderEdit.getMobilePhone());
        contactHomePhone.setText(contactUnderEdit.getHomePhone());
        contactStreet.setText(contactUnderEdit.getStreet());
        contactCity.setText(contactUnderEdit.getCity());
        contactState.setText(contactUnderEdit.getState());
        contactZip.setText(contactUnderEdit.getZipCode());
    }
    
    
}
