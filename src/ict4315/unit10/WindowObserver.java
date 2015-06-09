package ict4315.unit10;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Handles operations when user exits the program.
 * @author Jeff Carmichael
 *
 */
public class WindowObserver implements WindowListener {
    
    private ViewMediator mediator;
    
    /**
     * @param mediator view mediator for address book
     */
    public WindowObserver(ViewMediator mediator) {
        this.mediator = mediator;
    }
    
    /**
     * Handles program operations for saving
     * contact list and exiting.
     */
    @Override
    public final void windowClosing(WindowEvent e) {
        mediator.saveListAndClose();
        System.exit(0);
    }
    
    /**
     * All methods below are empty methods.
     */
    @Override
    public void windowOpened(WindowEvent e) { 
    }
    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

}
