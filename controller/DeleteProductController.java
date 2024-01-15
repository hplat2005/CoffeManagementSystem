package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import view.DeleteProductPanel;
public class DeleteProductController implements MouseListener {
    DeleteProductPanel deleteProductPanel;
    public DeleteProductController(DeleteProductPanel deleteProductPanel) {
    	this.deleteProductPanel = deleteProductPanel;
    }
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Object src = e.getSource();
		if(src == deleteProductPanel.searchButton) {
			deleteProductPanel.pressSearchButton();
		}else if(src == deleteProductPanel.deleteButton) {
			deleteProductPanel.pressDeleteButton();
		}else if(src == deleteProductPanel.closeButton) {
			deleteProductPanel.pressCloseButton();
		}else if(src == deleteProductPanel.resetButton) {
			deleteProductPanel.pressResetButton();
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
