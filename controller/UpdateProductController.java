package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import database.ConnectDatabase;
import view.UpdateProductPanel;

public class UpdateProductController implements MouseListener {
    UpdateProductPanel updateProductPanel;
    public UpdateProductController(UpdateProductPanel updateProductPanel) {
    	this.updateProductPanel = updateProductPanel;
    }
	
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
       Object src = e.getSource();
       if(src == updateProductPanel.searchButton) {
    	   updateProductPanel.pressSearchButton();
       }else if(src == updateProductPanel.updateButton) {
    	   updateProductPanel.pressUpdateButton();
       }else if(src == updateProductPanel.resetButton) {
    	   updateProductPanel.pressResetButton();
       }else if(src == updateProductPanel.closeButton) {
    	   updateProductPanel.pressCloseButton();
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
