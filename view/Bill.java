package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Bill extends JPanel {

	
	/**
	 * Create the panel.
	 */
	public Bill() {
		setLayout(null);
		this.setBounds(170,1,908,704);
		
		JLabel lblNewLabel = new JLabel("Order");
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 21));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 908, 130);
		add(lblNewLabel);


	}
}
