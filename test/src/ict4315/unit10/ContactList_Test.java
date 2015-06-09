package ict4315.unit10;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit tests for ContactList class
 * @author Jeff Carmichael
 *
 */
public class ContactList_Test {
    
    ViewMediator testMediator = new ViewMediator();
    ContactList testList = new ContactList(testMediator);
    /**
     * preconstructed test Contact objects.
     */
    Contact nullContact = null;
    
    Contact oneJ = new Contact("James", "Jones", "555-7658", "333-8769",
            "456 High Street", "Miami", "FL", "80567", "player@test.com");

    Contact twoJ = new Contact("Harry", "Jones", "444-7685", "333-8769",
            "456 High Street", "Miami", "FL", "80567", "joker@test.com");

    Contact oneB = new Contact("Beth", "Barrington", "444-7685", "333-8769",
            "456 High Street", "Miami", "FL", "80567", "joker@test.com");

    Contact oneC = new Contact("Alex", "Cupertino", "444-7685", "333-8769",
            "456 High Street", "Miami", "FL", "80567", "joker@test.com");

    Contact twoC = new Contact("Micha", "Carter", "444-7685", "333-8769",
            "456 High Street", "Miami", "FL", "80567", "joker@test.com");
    
    /**
     * Tests null argument in constructor
     */
    @Test (expected = IllegalArgumentException.class)
    public void testConstructorfWithNullMediatorArg() {
        ViewMediator nullMediator = null;
        ContactList nullArgTest = new ContactList(nullMediator);
    }
    
    /**
     * Tests constructor with valid argument.
     */
    @Test
    public void testConstructorWithValidArgument() {
        try {
            ContactList validList = new ContactList(testMediator);
        }catch (IllegalArgumentException invalid) {
            System.out.println("Constructor failed with valid argument");
        }
    }
    
    /**
     * Tests adding a null Contact to the list.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testAddContactWithNullArgument() {
        ContactList test = new ContactList(testMediator);
        test.addContact(nullContact);
    }
    
    /**
     * Tests adding a valid Contact to the list.
     */
    @Test
    public void testAddContactWithValidArgument() {
        try {
            ContactList validTest = new ContactList(testMediator);
            validTest.addContact(oneB);
        }catch (IllegalArgumentException invalid) {
            System.out.println("Adding a contact failed with valid argument");
        }
    }
    
    /**
     * Tests adding multiple contacts to check for
     * alphabetical order.
     */
    @Test
    public void testAlphabeticalAddContact() {
        ContactList alpha = new ContactList(testMediator);
        alpha.addContact(oneB);
        alpha.addContact(oneJ);
        alpha.addContact(oneC);
        assertTrue("There was an insertion error and contacts are out of order", oneJ.equals(alpha.getContactAtPosition(2)));
            
    }
    
    /**
     * Tests contactID functionality.
     */
    @Test
    public void testContactID() {
        ContactList alpha = new ContactList(testMediator);
        alpha.addContact(oneB);
        alpha.addContact(oneJ);
        alpha.addContact(oneC);
        System.out.println("Should be Beth ---> " + alpha.getContactWithTargetId(1).formatContactFullName());
    }
}
