package ict4315.unit10;

import java.awt.Desktop;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class for handling file creation
 * and saving the Address Book contact list
 * @author Jeff Carmichael
 *
 */
public class XmlFileHandler {
    
    /**
     * Writes contact list to file "contactList.xml"
     * @param contacts the contact list to be saved to file
     * @throws FileNotFoundException
     */
    public void saveContactListToXmlFile(ArrayList<Contact> contacts) throws FileNotFoundException {
        File f = new File("contactList.xml");
        FileOutputStream fos = new FileOutputStream(f);
        XMLEncoder xmle = new XMLEncoder(fos);
        xmle.writeObject(contacts);
        xmle.close();
    }
    
    /**
     * Retrieves saved Contact list from file "contactList.xml"
     * @return contact list for address book.
     * @throws FileNotFoundException
     */
    @SuppressWarnings("unchecked")
    public ArrayList<Contact> getContactListFileIfExists() throws FileNotFoundException {
        Object savedContactList;
        XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("contactList.xml")));
        savedContactList = decoder.readObject();
        decoder.close();
        return (ArrayList<Contact>) savedContactList;
    }
}
