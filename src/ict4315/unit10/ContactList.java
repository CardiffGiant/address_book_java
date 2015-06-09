package ict4315.unit10;

import java.util.ArrayList;
import java.util.List;
/**
 * List of Contacts for the address book.
 * @author Jeff Carmichael
 *
 */
public class ContactList {
    
    /**
     * Internal representation of the list of contacts.
     */
    private List<Contact> listOfContacts;
    private ViewMediator mediator;
    
    /**
     * total contacts that have ever been added
     * used for id purposes.
     */
    private int totalContacts;
    
    /**
     * Empty constructor.
     */
    public ContactList() {
    }
    
    /**
     * Constructor with mediator argument.
     * Checks if mediator argument is null.
     * throws IllegalArgumentException
     * @param mediator the mediator for the address book.
     */
    public ContactList(ViewMediator mediator) throws IllegalArgumentException {
        if (mediator != null) {
            listOfContacts = new ArrayList<Contact>();
            this.setMediator(mediator);
            mediator.registerContactList(this);
            
            totalContacts = 0;
        }else {
            throw new IllegalArgumentException("Attempted to pass null mediator argument");
        }
    }
    
    /**
     * Returns the underlying list of contacts.
     */
    public List<Contact> getList() {
        return listOfContacts;
    }
    
    /**
     * Sets the list of contacts to the argument.
     * @param listOfContacts
     */
    public void setListOfContacts(ArrayList<Contact> listOfContacts) throws IllegalArgumentException {
        if (listOfContacts != null) {
            this.listOfContacts = listOfContacts;
            totalContacts = getTotalContactsNumber();
        }else {
            throw new IllegalArgumentException("the list that was passed is null");
        }
    }
    
    /**
     * 
     * @return
     */
    public ArrayList<Contact> getListOfContacts() {
        return (ArrayList<Contact>) listOfContacts;
    }
    
    /**
     * Gets the total number of contacts in the list.
     */
    private final int getTotalContactsNumber() {
        int temp = 0;
        for (int i = 0; i< listOfContacts.size();++i) {
            if (listOfContacts.get(i).getContactID() > temp) {
                temp = listOfContacts.get(i).getContactID();
            }
        }
        return temp;
    }
    /**
     * Returns first contact in the list.
     */
    public Contact getFirstContactInList() {
        Contact target;
        if (listOfContacts.size() == 0) {
            target = new Contact();
        }else {
            target = listOfContacts.get(0);
        }
        return target;
    }
    
    /**
     * Returns the Contact with the corresponding ID.
     */
    public Contact getContactWithTargetId(int targetID) {
        Contact target = null;
        for (int i = 0; i<listOfContacts.size();++i) {
            if (listOfContacts.get(i).getContactID()==targetID) {
                target = listOfContacts.get(i);
            }
        }
        return target;
    }
    
    /**
     * Adds a Contact to the list.
     */
    public final Contact addContact(Contact contactToAdd) throws IllegalArgumentException {
        if (contactToAdd != null) {
            if (listOfContacts.size() == 0) {
                ++totalContacts;
                contactToAdd.setContactID(totalContacts);
                listOfContacts.add(contactToAdd);
            }else {
                addAlphabetical(contactToAdd);
            }
        }else {
            throw new IllegalArgumentException("Attempted to add a null Contact");
        }
        return contactToAdd;
    }
    
    /**
     * Adds contact to list alphabetically
     * @param contactToAdd
     */
    private final void addAlphabetical(Contact contactToAdd) throws IllegalArgumentException {
        for (int i = 0; i<listOfContacts.size(); ++i) {
            if (listOfContacts.get(i).getLastName().compareTo(contactToAdd.getLastName()) > 0) {
                ++totalContacts;
                contactToAdd.setContactID(totalContacts);
                listOfContacts.add(i, contactToAdd);
                break;
            }else if (listOfContacts.get(i).getLastName().compareTo(contactToAdd.getLastName()) == 0) {
                if (listOfContacts.get(i).getFirstName().compareTo(contactToAdd.getFirstName()) > 0) {
                    ++totalContacts;
                    contactToAdd.setContactID(totalContacts);
                   listOfContacts.add(i,contactToAdd);
                   break;
                }
            }else if (i == listOfContacts.size()-1) {
                ++totalContacts;
                contactToAdd.setContactID(totalContacts);
                listOfContacts.add(contactToAdd);
            }
        }
    }
    
    /**
     * Removes the specified contact from the list.
     */
    public void removeContact(Contact target) {
        listOfContacts.remove(target);
    }
    
    /**
     * Returns the Contact at the target position.
     */
    public Contact getContactAtPosition(int targetPosition) {
        return listOfContacts.get(targetPosition);
    }
    
    /**
     * Outputs list of contacts to console for testing.
     */
    public void printList() {
        for (int i = 0; i<listOfContacts.size(); ++i) {
            System.out.println(listOfContacts.get(i).formatAllContactFieldsWithLabels());
        }
    }
    
    /**
     * Adds a sample contact when the Address Book is first used.
     */
    public void addSampleContact() {
        this.addContact(new Contact("ExampleOf","AContact","5555555555","7777777777","123 Example Street",
                "Sample Town","CO","12345","example@example.com"));
    }

    public ViewMediator getMediator() {
        return mediator;
    }

    public void setMediator(ViewMediator mediator) {
        this.mediator = mediator;
    }
}
