package appTesting;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;


public class PasswordDemo extends JPanel
                          implements ActionListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String OK = "ok"; //$NON-NLS-1$
    private static String HELP = "help"; //$NON-NLS-1$

    private JPasswordField passwordField;

    public PasswordDemo() {
        //Use the default FlowLayout.

        //Create everything.
        this.passwordField = new JPasswordField(10);
        this.passwordField.setEchoChar('*');
        this.passwordField.setActionCommand(OK);
        this.passwordField.addActionListener(this);

        JLabel label = new JLabel("Please Enter Your Password: "); //$NON-NLS-1$
        label.setLabelFor(this.passwordField);
       
        JComponent buttonPane = createButtonPanel();

        //Lay out everything.
        add(label);
        add(this.passwordField);

        add(buttonPane);
    }
    ImageIcon icon = createImageIcon("/images/welcome.jpg"); //$NON-NLS-1$
    private ImageIcon createImageIcon(String path) {
    	 java.net.URL imgURL = Main.class.getResource(path);
         if (imgURL != null) 
             return new ImageIcon(imgURL);
         
         System.err.println("Couldn't find file: " + path); //$NON-NLS-1$
         return null;
	}

	protected JComponent createButtonPanel() {
        JPanel p = new JPanel(new GridLayout(0,1));
        JButton okButton = new JButton("OK"); //$NON-NLS-1$
        JButton helpButton = new JButton("Help"); //$NON-NLS-1$

        okButton.setActionCommand(OK);
        helpButton.setActionCommand(HELP);
        okButton.addActionListener(this);
        helpButton.addActionListener(this);

        p.add(okButton);
        p.add(helpButton);

        return p;
    }

    
	public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (OK.equals(cmd)) { //Process the password.
            char[] input = this.passwordField.getPassword();
            if (isPasswordCorrect(input)) {
            	  //Create and set up the window.
                JFrame frame = new JFrame("BUS SELECTION"); //$NON-NLS-1$
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //Create and set up the content pane.
                JComponent newContentPane = new Main();
                newContentPane.setOpaque(true); //content panes must be opaque
                frame.getContentPane().add(new ButtonDemo(),
                        BorderLayout.CENTER);
               
                
                //Display the window.
                frame.pack();
                frame.setVisible(true);
            	 
            } else {
                JOptionPane.showMessageDialog(null,
                    "Invalid password. Try again.", //$NON-NLS-1$
                    "Error Message", //$NON-NLS-1$
                    JOptionPane.ERROR_MESSAGE);
            }

            //Zero out the possible password, for security.
            for (int i = 0; i < input.length; i++) {
                input[i] = 0;
            }

            this.passwordField.selectAll();
            resetFocus();
        } else { 
        	//The user has asked for help.
            JOptionPane.showMessageDialog(null,
                "Please contact our Customer Care Office for help\n" //$NON-NLS-1$
              + "Call us at +36 70 551 3745.\n" //$NON-NLS-1$
              + "Thank you for Understanding\n" );//$NON-NLS-1$
           
        }
    }
	/**
     * Checks the passed-in array against the correct password.
     * After this method returns, you should invoke eraseArray
     * on the passed-in array.
     */
    private static boolean isPasswordCorrect(char[] input) {
        boolean isCorrect = true;
        char[] correctPassword = { 'J', 'O', 'S', 'H', 'U', 'A'};

        if (input.length != correctPassword.length) {
            isCorrect = false;
        } else {
            for (int i = 0; i < input.length; i++) {
                if (input[i] != correctPassword[i]) {
                    isCorrect = false;
                }
            }
        }

        //Zero out the password.
        for (int i = 0; i < correctPassword.length; i++) {
            correctPassword[i] = 0;
        }

        return isCorrect;
    }

    //Must be called from the event-dispatching thread.
    protected void resetFocus() {
        this.passwordField.requestFocusInWindow();
    }

}
