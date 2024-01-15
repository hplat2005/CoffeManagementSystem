package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import view.ShowProductsPanel;
public class ShowProductsController implements MouseListener {
	ShowProductsPanel showProductsPanel;
	public ShowProductsController(ShowProductsPanel showProductsPanel) {
		this.showProductsPanel = showProductsPanel;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Object src = e.getSource();
		if(src == showProductsPanel.closeButton) {
			showProductsPanel.pressCloseButton();
		} 
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
