import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

/**
   A simple user-interface for computing the area of
   a triangle.   We have places to input the base and height,
   and a place to read out the area.

   We'll use the grid layout with two columns and three rows,
   laid out something like this:
   <pre>
   base             _(field to enter base)___
   height           _(field to enter height)_
   compute button   _(field that gets area)__
   </pre>

   @author P. Conrad
   @version 2011-01-01

 */

public class MyJFrame extends JFrame implements ActionListener {

	public static void main(String [] args) {
		System.out.println("This is the main of MyJFrame");
		MyJFrame j = new MyJFrame();
		MyJFrame jn = null;
		MyHandler mh1 = null; // compiles, and runs
		// MyHandler mh2 = new MyHandler(); // does not compile
	    MyHandler mh3 = j.new MyHandler(); // compiles and runs
	    // MyHandler mh4 = jn.new MyHandler(); // compiles, but will not run
	}

	public void foo() {
		MyHandler handler = new MyHandler();		
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("I am my own ActionListener");
	}
	
    private JLabel  baseLabel;
    private JLabel  heightLabel;
    private JButton computeAreaButton;

    private JTextField baseTextField;
    private JTextField heightTextField;
    private JTextField areaTextField;

    public MyJFrame() {
		super("Compute Area Of Triangle, My Friends"); // superclass constructor sets the title

		setLayout(new GridLayout(4,2)); // rows, columns
		
		FontUIResource fbold = new FontUIResource(Font.SANS_SERIF,Font.BOLD,24);
		FontUIResource fplain = new FontUIResource(Font.SANS_SERIF,Font.PLAIN,24);
		UIManager.put("Label.font", fbold);
		UIManager.put("Button.font", fbold);
		UIManager.put("TextField.font", fplain);
		
		baseLabel = new JLabel("base");
		baseTextField = new JTextField(10); // 10 wide, and initially empty
		baseTextField.setToolTipText("enter a floating point number for triangle base");
		
		heightLabel = new JLabel("height");
		heightTextField = new JTextField(10); // 10 wide, and initially empty
		heightTextField.setToolTipText("enter a floating point number for triangle height");
		
		computeAreaButton = new JButton("Compute Area");
		computeAreaButton.setToolTipText("click when data has been entered");
		areaTextField = new JTextField(10);
		areaTextField.setEditable(false); // not an editable field
		
		// add everything to the panel
		// note how the code is formatted to resemble the grid layout!
		
		
		add(baseLabel);         add(baseTextField);
		add(heightLabel);       add(heightTextField);
		add(computeAreaButton); add(areaTextField);
		
		
		// this is here for demoing the way GridLayout
		// deals with extra stuff...
		JLabel extraStupidField = new JLabel("This is dumb");
		add(extraStupidField);
		
		JButton extraButton = new JButton("This is a dumb button");
		add(extraButton);
		extraButton.addActionListener( this );
		
		
		
		// The only thing we want to wait for is a click on the button
		
		MyHandler handler = new MyHandler();
		computeAreaButton.addActionListener(handler);
		

    } // MyJFrame

    // inner class 

    private class MyHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
			// the only thing we are expecting is a button press
			if (event.getSource()!=computeAreaButton) 
				return;
			
			// So the button was pressed.  Let's validate
			// that the contents of baseTextField and 
			// heightTextField can be converted to double.
			// For each one, if its not valid, set it to zero.
			
			double base = getDoubleValue(baseTextField);
			double height = getDoubleValue(heightTextField);
			
			// Here is where in a true MVC app we'd
			// separate out the computation.  For now,
			// just hard code it.
			
			double area=0.5 * base * height;
			
			// format answer as string, and put back into field
			String areaAsString = String.format("%f",area);
			areaTextField.setText(areaAsString);
			
		} // actionPerformed
		
		/** Get a double value from a JTextField.  As a
			side-effect, if the value is not valid as a double,
			force the field's value to "0.0", and return 0.0 
			
			@param the JTextField to operate on 
		*/
		
		public double getDoubleValue(JTextField jtf) {
			String currValue = jtf.getText();
			double value = 0.0;
			try {
				value = Double.parseDouble(currValue);
			} catch (NumberFormatException nfe) {
				jtf.setText("0.0");
				value = 0.0;
			}
			return value;
		}
		
    }// innerclass MyHandler
} // outerclass MyJFrame
