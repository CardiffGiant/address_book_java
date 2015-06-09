package ict4315.unit10;

import org.junit.Test;

public class AddContactViewPanel_Test {
        
    @Test (expected = IllegalArgumentException.class)
    public void testContstructorWithNullArgument() {
        AddContactViewPanel nullTest = new AddContactViewPanel(null);
    }
}
