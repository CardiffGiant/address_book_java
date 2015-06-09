package ict4315.unit10;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit tests for the Contact class
 * @author Jeff Carmichael
 *
 */
public class Contact_Test {
    Contact testContact = new Contact("Jeff", "Carmichael", "4569875604", "720123456",
                                       "789 Low Street", "Boulder", "CO", "90210", "tester@test.com");
    @Test
    public void testFormatContactFullName() {
        System.out.println(testContact.formatContactFullName());
    }
    
    @Test
    public void testFormatFullContactFieldsAndLabels() {
        System.out.println(testContact.formatAllContactFieldsWithLabels());
    }

}
