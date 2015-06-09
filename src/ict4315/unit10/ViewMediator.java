package ict4315.unit10;

import ict4315.unit10.ContactListViewPanel.ListViewLabel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Mediator for the Address Book.
 * @author Jeff Carmichael
 *
 */
public class ViewMediator implements MouseListener, ActionListener, FocusListener {
    
    ViewMediator mediator = this;
    
    ContactList contacts;
    
    /**
     * references to GUI views and components
     */
    ContactListViewPanel listView;
    ContactDetailsViewPanel detailsView;
    AddContactViewPanel addContactView;
    EditContactViewPanel editView;
    MultipleViewPanel multiView;
    ButtonViewPanel buttonView;
    JFrame mainWindow;
    
    JButton goToAddContactButton;
    JButton addContactButton;
    JButton editContactButton;
    JButton confirmContactButton;
    JButton cancelEditButton;
    JButton cancelNewContactButton;
    JButton removeContactButton;
    JTextField lastNameTextField;
    JTextField editLastNameTextField;
    JPanel editContactPanel;
    JPanel viewContactPanel;
    JPanel newContactPanel;
    
    /**
     * Reference to the last name selected in
     * the list view of the GUI
     */
    ContactListViewPanel.ListViewLabel lastSelected = null;
    
    /**
     * Saves the current list of contacts to a preset
     * file and closes the program.
     */
    public final void saveListAndClose() {
        XmlFileHandler save = new XmlFileHandler();
        try {
            save.saveContactListToXmlFile(contacts.getListOfContacts());
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        }
    }
    
    /**
     * Accesses preset file that holds the saved contact
     * list and retrieves the list for use in the program.
     * @return the list of contacts that was saved
     * @throws FileNotFoundException
     */
    public final ArrayList<Contact> openSavedListAndSet() throws FileNotFoundException {
        ArrayList<Contact> list;
        File f = new File("contactList.xml");
        if (f.exists()) {
            XmlFileHandler open = new XmlFileHandler();
            list = open.getContactListFileIfExists();
        } else {
            list = new ArrayList<Contact>();
        }
        return list;
    }
    
    /**
     * Retrieves the first contact in the AddressBook.
     * @return first contact in list.
     */
    public final Contact getFirstContact() {
        return contacts.getFirstContactInList();
    }
    
    /**
     * Registers reference to the contact list.
     */
    public final void registerContactList(ContactList contacts) {
        this.contacts = contacts;
    }
    
    /**
     * The next set of methods register references to
     * the GUI buttons and text fields that require communication.
     */
    public final void registerGoToContactButton(JButton goToContactButton) {
        this.goToAddContactButton = goToContactButton;
    }
    public final void registerAddContactButton(JButton addContactButton) {
        this.addContactButton = addContactButton;
    }
    public final void registerEditContactButton(JButton editContactButton) {
        this.editContactButton = editContactButton;
    }
    public final void registerConfirmContactButton(JButton confirmContactButton) {
        this.confirmContactButton = confirmContactButton;
    }
    public final void registerCancelEditButton(JButton cancelEditButton) {
        this.cancelEditButton = cancelEditButton;
    }
    public final void registerCancelNewContactButton(JButton cancelNewContactButton) {
        this.cancelNewContactButton = cancelNewContactButton;
    }
    public final void registerRemoveContactButton(JButton removeContactButton) {
        this.removeContactButton = removeContactButton;
    }
    public final void registerContactLastNameTextField(JTextField contactLastNameTextField) {
        this.lastNameTextField = contactLastNameTextField;
    }
    public final void registerEditLastNameTextField(JTextField editLastNameTextField) {
        this.editLastNameTextField = editLastNameTextField;
    }
    /**
     * Registers the reference to the listViewPanel
     * Adds a sample contact to the list if empty
     * populates the list view with names of contacts
     * in the Address book
     * @param listView
     */
    public final void registerListView(ContactListViewPanel listView) {
        this.listView = listView;
        if(contacts.getList().size() == 0) {
            contacts.addSampleContact();
        }
        this.listView.fillPanelWithContactListNames(contacts, this);
    }
    /**
     * the following set of methods register the GUI views of
     * the Address Book.
     */
    public final void registerDetailsViewPanel(ContactDetailsViewPanel detailsView) {
        this.detailsView = detailsView;
    }
    public final void registerAddContactView(AddContactViewPanel addContactView) {
        this.addContactView = addContactView;
    }
    public final void registerEditContactView(EditContactViewPanel editView) {
        this.editView = editView;
    }
    public final void registerMultiViewPanel(MultipleViewPanel multiView) {
        this.multiView = multiView;
    }
    public final void registerButtonView(ButtonViewPanel buttonView) {
        this.buttonView = buttonView;
    }
    
    /**
     * Registers the reference to the container window of the 
     * Address Book GUI
     */
    public final void registerWindow(JFrame mainWindow) {
        this.mainWindow = mainWindow;
    }
    
    /**
     * Controls program actions when a contact name is
     * clicked in the list view. Sets appropriate other views
     * with details of selected contact.
     */
    @Override
    public final void mouseClicked(MouseEvent e) {
        Object source = (ContactListViewPanel.ListViewLabel) e.getSource();
        if (lastSelected == null) {
            lastSelected = (ListViewLabel) source;
            ((JComponent) source).setForeground(Color.GREEN);
            System.out.println("ID: " + lastSelected.getRelevantContactID());
            System.out.println(contacts.getContactWithTargetId(lastSelected.getRelevantContactID()).formatContactFullName());
            detailsView.updateView(contacts.getContactWithTargetId(lastSelected.getRelevantContactID()));
            editView.setContactUnderEdit(detailsView.getCurrentContact());
        }else {
            lastSelected.setForeground(Color.DARK_GRAY);
            lastSelected = (ListViewLabel) source;
            ((JComponent) source).setForeground(Color.GREEN);
            detailsView.updateView(contacts.getContactWithTargetId(lastSelected.getRelevantContactID()));
            editView.setContactUnderEdit(detailsView.getCurrentContact());
        }
    }
    /**
     * Empty mouse listener methods
     */
    @Override
    public void mousePressed(MouseEvent e) {
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    /**
     * Controls Program actions when a button is
     * clicked in one of the views.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == editContactButton) {
            multiView.nextContactViewPanel();
            buttonView.nextButtonPanel();
        }else if (e.getSource() == addContactButton) {
            Contact newContact = new Contact(addContactView.collectContactData());
            contacts.addContact(newContact);
            detailsView.updateView(newContact);
            listView.updateListView(contacts, mediator);
            editView.setContactUnderEdit(newContact);
            addContactView.resetTextFields();
            multiView.nextContactViewPanel();
            buttonView.nextButtonPanel();
        }else if (e.getSource() == confirmContactButton) {
            editView.confirmContactChanges();
            detailsView.updateView(editView.getContactUnderEdit());
            multiView.previousContactViewPanel();
            buttonView.previousButtonPanel();
        }else if (e.getSource() == goToAddContactButton) {
            multiView.previousContactViewPanel();
            buttonView.previousButtonPanel();
        }else if (e.getSource() == cancelEditButton) {
            multiView.previousContactViewPanel();
            buttonView.previousButtonPanel();
        }else if (e.getSource() == removeContactButton) {
            contacts.removeContact(editView.getContactUnderEdit());
            listView.updateListView(contacts, mediator);
            detailsView.updateView(contacts.getFirstContactInList());
            multiView.previousContactViewPanel();
            buttonView.previousButtonPanel();
        }else if (e.getSource() == cancelNewContactButton) {
            addContactView.resetTextFields();
            multiView.nextContactViewPanel();
            buttonView.nextButtonPanel();
        }
    }
    
    /**
     * Empty focus listener method
     */
    @Override
    public void focusGained(FocusEvent e) {
    }
    
    /**
     * Tracks the required text fields that have been filled.
     */
    @Override
    public final void focusLost(FocusEvent e) {
        if (e.getSource() == lastNameTextField) {
            if (lastNameTextField.getText().equals("")) {
                addContactButton.setEnabled(false);
            }else {
                addContactButton.setEnabled(true);
            }
        }else if (e.getSource() == editLastNameTextField) {
            if (editLastNameTextField.getText().equals("")) {
                confirmContactButton.setEnabled(false);
            } else {
                confirmContactButton.setEnabled(true);
            }
        }
    }
}
