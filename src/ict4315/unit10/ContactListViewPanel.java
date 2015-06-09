package ict4315.unit10;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class ContactListViewPanel extends JPanel {
    /**
     */
    private static final long serialVersionUID = 1L;
    private ViewMediator mediator;
    
    /**
     * Constructor for the list view
     * @param mediator reference for control of communications.
     */
    public ContactListViewPanel(ViewMediator mediator) throws IllegalArgumentException {
        if (mediator == null) {
            throw new IllegalArgumentException("the mediator argument was null");
        }
        setPreferredSize(new Dimension(200, 610));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(0,10,0,0));
        this.mediator = mediator;
        mediator.registerListView(this);
    }
    
    /**
     * Updates the list view after addition or removal of a contact.
     * @param targetList the new list to use in building the view
     * @param mediator the mediator to reference
     */
    public final void updateListView(ContactList targetList, ViewMediator mediator) throws IllegalArgumentException {
        if (targetList == null) {
            throw new IllegalArgumentException ("the target list to update is null");
        }
        if (mediator == null) {
            throw new IllegalArgumentException("the mediator argument was null"); 
        }else {
            removeAll();
            fillPanelWithContactListNames(targetList,mediator);
            updateUI();
        }
    }
    
    /**
     * Populates the list view with letter indexes and the names of all
     * contacts in the address book.
     * @param targetList
     * @param mediator
     */
    public final void fillPanelWithContactListNames(ContactList targetList, ViewMediator mediator) {
        String currentLetterIndex = buildAndAddListIndexLabel("@");
        int indexInList = 0;
        while (indexInList<targetList.getList().size()) {
            while (!targetList.getList().get(indexInList).getLetterIndex().equals(currentLetterIndex)) {
                currentLetterIndex = buildAndAddListIndexLabel(currentLetterIndex);
            }
            for (; indexInList<targetList.getList().size();++indexInList) {
                if(targetList.getList().get(indexInList).getLetterIndex().equals(currentLetterIndex)) {
                    int id = targetList.getList().get(indexInList).getContactID();
                    add(new ListViewLabel(targetList.getList().get(indexInList).formatContactFullName(), mediator, id));
                }else {
                    break;
                }
            }
        }
        fillListToZWithLabels(currentLetterIndex);
    }
    
    /**
     * Creates the list index labels for the alphabet.
     * @param currentLetterIndex letter to use in index label
     * @return the letter that was used to create the label
     */
    private final String buildAndAddListIndexLabel(String currentLetterIndex) {
        char c = currentLetterIndex.charAt(0);
        int j = (int) c;
        String newLetterIndex = String.valueOf(Character.toChars(j+1));
        JLabel columnHead = new JLabel("  " + newLetterIndex);
        columnHead.setBorder(new MatteBorder(0,0,2,0,Color.LIGHT_GRAY));
        columnHead.setPreferredSize(new Dimension(160,20));
        add(columnHead);
        
        return newLetterIndex;
    }
    
    private final void fillListToZWithLabels(String currentLetterIndex) {
        if (currentLetterIndex.equals("Z")) {
            ;
        }else {
            while (!currentLetterIndex.equals("Z")) {
                currentLetterIndex = buildAndAddListIndexLabel(currentLetterIndex);
            }
        }
    }
    /**
     * Nested label class for use in list view of GUI
     * @author Jeff Carmichael
     *
     */
    public final class ListViewLabel extends JLabel {
        /**
         */
        private static final long serialVersionUID = 1L;
        private ViewMediator observer;
        private int connectedContactID;
        
        ListViewLabel(String name, ViewMediator observer, int contactID) throws IllegalArgumentException{
            if(name == null) {
                throw new IllegalArgumentException("the name argument was null");
            }
            if(observer == null) {
                throw new IllegalArgumentException("the mediator argument was null");
            }
           this.setText(name);
           this.setPreferredSize(new Dimension(200,30));
           this.observer = observer;
           connectedContactID = contactID;
           addMouseListener(observer);
           super.setBorder(new EmptyBorder(5,10,3,70));
           super.setForeground(Color.DARK_GRAY);
        }
        
        public int getRelevantContactID() {
           return connectedContactID;
        }
    }

}
