package appTesting;

/*
 * SimpleTableDemo.java requires no other files.
 */

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BusesForRentTable extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final static boolean DEBUG = true;

    public BusesForRentTable() {
        super(new GridLayout(1,0));
        String[] columnNames={"BusType","DriverName","BusColour","Maximum Passengers"};
        Object[][] data = {
            {"BusForRent", "Hana Akos", //$NON-NLS-1$ //$NON-NLS-2$
             "Maroon", new Integer(34)}, //$NON-NLS-1$
            {"BusForRent", "Akos Szandor", //$NON-NLS-1$ //$NON-NLS-2$
             "White", new Integer(30)} //$NON-NLS-1$
           
        };

        final JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));

        
        if (DEBUG) {
            table.addMouseListener(new MouseAdapter() {
          
                public void mouseClicked(MouseEvent e) {
                    printDebugData(table);
                }
            });
        }

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);
    }

    protected static void printDebugData(JTable table) {
        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();
        javax.swing.table.TableModel model = table.getModel();

        System.out.println("Value of data: "); //$NON-NLS-1$
        for (int i=0; i < numRows; i++) {
            System.out.print("    row " + i + ":"); //$NON-NLS-1$ //$NON-NLS-2$
            for (int j=0; j < numCols; j++) {
                System.out.print("  " + model.getValueAt(i, j)); //$NON-NLS-1$
            }
            System.out.println();
        }
        System.out.println("--------------------------"); //$NON-NLS-1$
    }
}
