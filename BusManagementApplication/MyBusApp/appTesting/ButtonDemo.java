package appTesting;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
 
public class ButtonDemo extends JPanel
                        implements ActionListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JButton b1, b2, b3;
 
    public ButtonDemo() {
        ImageIcon leftButtonIcon = createImageIcon("/images/ForRentBus.gif"); //$NON-NLS-1$
        ImageIcon middleButtonIcon = createImageIcon("/images/InternalBusPecs.gif"); //$NON-NLS-1$
        ImageIcon rightButtonIcon = createImageIcon("/images/longRangeBus.gif"); //$NON-NLS-1$
 
        this.b1 = new JButton("Buses For Rent", leftButtonIcon); //$NON-NLS-1$
        this.b1.setVerticalTextPosition(SwingConstants.CENTER);
        this.b1.setHorizontalTextPosition(SwingConstants.LEADING); //
        this.b1.setActionCommand("b1Clicked"); //$NON-NLS-1$
       
        this.b2 = new JButton("Internal Buses", middleButtonIcon); //$NON-NLS-1$
        this.b2.setVerticalTextPosition(SwingConstants.BOTTOM);
        this.b2.setHorizontalTextPosition(SwingConstants.CENTER);
     
      
        this.b2.setActionCommand("b2Clicked"); //$NON-NLS-1$
        this.b3 = new JButton("Long Range Buses", rightButtonIcon); //$NON-NLS-1$
        this.b3.setActionCommand("b3Clicked"); //$NON-NLS-1$
   
       
 
        //Listen for actions on buttons 1, 2 and 3.
        this.b1.addActionListener(this);
        this.b2.addActionListener(this);
        this.b3.addActionListener(this);
        
 
        this.b1.setToolTipText("Click this button to view available Buses For Rent"); //$NON-NLS-1$
        this.b2.setToolTipText("Click this button to view available Internal Buses"); //$NON-NLS-1$
        this.b3.setToolTipText("Click this button to view available Long Range Buses"); //$NON-NLS-1$
 
        //Add Components to this container, using the default FlowLayout.
        add(this.b1);
        add(this.b2);
        add(this.b3);
      
    }
 
 
    public void actionPerformed(ActionEvent e) {
        if ("b1Clicked".equals(e.getActionCommand())) { //$NON-NLS-1$
        	  //Create and set up the window.
            JFrame frame1 = new JFrame("BUSES FOR RENT"); //$NON-NLS-1$
            
            //Create and set up the content pane.
            JComponent newContentPane = new Main();
            newContentPane.setOpaque(true);
            frame1.getContentPane().add(new BusesForRentTable(),
                    BorderLayout.CENTER);
            
            //Display the window.
            frame1.pack();
            frame1.setLocationRelativeTo(null);
            frame1.setVisible(true);
            
        }
        else if("b2Clicked".equals(e.getActionCommand())) {
        	
        	  //Create and set up the window.
            JFrame frame2 = new JFrame("INTERNAL BUSES LIST"); //$NON-NLS-1$
         
            //Create and set up the content pane.
            JComponent newContentPane1 = new Main();
            newContentPane1.setOpaque(true); 
            frame2.getContentPane().add(new InternalBusTabel(),
                    BorderLayout.CENTER);
            
            //Display the window.
            frame2.pack();
            frame2.setLocationRelativeTo(null);
            frame2.setVisible(true);
            }
         else {if("b3Clicked".equals(e.getActionCommand())) {
        	  //Create and set up the window.
            JFrame frame3 = new JFrame("LONG RANGE BUSES"); //$NON-NLS-1$
         
            //Create and set up the content pane.
            JComponent newContentPane3 = new Main();
            newContentPane3.setOpaque(true); 
            frame3.getContentPane().add(new LongRangeBusTable(),
                    BorderLayout.CENTER);
            
            //Display the window.
            frame3.pack();
            frame3.setLocationRelativeTo(null);
            frame3.setVisible(true);
        }
    }
 }
 
    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = ButtonDemo.class.getResource(path);
        if (imgURL != null) 
            return new ImageIcon(imgURL);
        
        System.err.println("Couldn't find file: " + path); //$NON-NLS-1$
        return null;
    }
 
}