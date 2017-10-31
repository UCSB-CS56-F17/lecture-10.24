import java.awt.event.ActionListener;

// This is technique 1

public class SeparateActionListener implements ActionListener {

	public void actionPerformed(java.awt.event.ActionEvent e)  {
		System.out.println("This is an instance of SeparateActionListener");
	}

}
