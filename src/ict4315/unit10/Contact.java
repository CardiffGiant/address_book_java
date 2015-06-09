package ict4315.unit10;

/**
 * Holds contact information for use in
 * address book
 * @author Jeff Carmichael
 *
 */
public class Contact {
    
    private String firstName;
    private String lastName;
    private String mobilePhone;
    private String homePhone;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String email;
    private String letterIndex;
    private int contactID;

    
    /**
     * Formats contact's full name
     * @return contact's formatted full name
     */
    public String formatContactFullName() {
        return (firstName + " " + lastName);
    }
    
    /**
     * Format all contact fields for output.
     */
    public String formatAllContactFieldsWithLabels() {
        return("Name:   " + firstName + " " + lastName + "\n" + "Mobile: " + mobilePhone + "\n"
                + "Home:   " + homePhone + "\n" + "Address: " + street + "\n" +
                "\t" + city + ", " + state + " " + zipCode);
    }
    /**
     * No argument constructor.
     */
    public Contact() {
        /**
        firstName = "";
        lastName = "";
        mobilePhone = "";
        homePhone = "";
        street = "";
        city = "";
        state = "";
        zipCode = "";
        email = "";
        */
     }
    
    /**
     * All argument constructor.
     * @param firstName   contact first name
     * @param lastName    contact last name
     * @param mobilePhone contact mobile number
     * @param homePhone   contact home number
     * @param street      contact street address
     * @param city        contact city location
     * @param state       contact state address
     * @param zipCode     contact zip code
     * @param email       contact email address
     */
    public Contact (String firstName, String lastName, String mobilePhone, String homePhone,
            String street, String city, String state, String zipCode, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobilePhone = mobilePhone;
        this.homePhone = homePhone;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.email = email;
        setLetterIndex();
    }
    
    /**
     * constructor with array argument
     */
    public Contact(final String[] contactData) {
        firstName = ensureIsUpperCase(contactData[0]);
        lastName = ensureIsUpperCase(contactData[1]);
        mobilePhone = contactData[2];
        homePhone = contactData[3];
        street = contactData[4];
        city = contactData[5];
        state = contactData[6];
        zipCode = contactData[7];
        email = contactData[8];
        setLetterIndex();
    }
    
    /**
     * Sets letter index for alphabetical arrangement
     * this setter is for XMLDecoder but is functional.
     */
    public final void setLetterIndex(String letterIndex) {
        this.letterIndex = letterIndex;
    }
    
    /**
     * sets the letter index for alphabetizing the 
     * contact list.
     */
    public final void setLetterIndex() {
        letterIndex = lastName.substring(0,1);
    }
    /**
     * Gets letter index for contact for
     * alphabetical arrangement
     * @return first letter of last name
     */
    public final String getLetterIndex() {
       return letterIndex;
    }
    
    /**
     * Sets first letter of String to upper case.
     */
    private final String ensureIsUpperCase(String targetData) {
        return targetData.substring(0,1).toUpperCase() + targetData.substring(1);
    }
    /**
     * Getters and Setters for all class fields
     */
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getContactID() {
        return contactID;
    }

    public void setContactID(int contactID) {
        this.contactID = contactID;
    }
}
