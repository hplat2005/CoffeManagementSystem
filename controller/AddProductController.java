package controller;
import  view.AddProductPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class AddProductController implements MouseListener {
	
	AddProductPanel addProductPanel;
	public AddProductController(AddProductPanel addProductPanel) {
		this.addProductPanel = addProductPanel;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Object src = e.getSource();
		if(addProductPanel.addButton == src) {
			addProductPanel.pressAddButton();
		}else if(addProductPanel.closeButton == src) {
			addProductPanel.pressCloseButton();
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
	public void productIdTextField() {
		
	}

}
