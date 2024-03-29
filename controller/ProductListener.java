package controller;

import
 java.awt.event.ActionEvent;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.Dashboard;

public class ProductListener implements MouseListener {
    Dashboard dashboard;
    public ProductListener(Dashboard dashboard) {
    	this.dashboard = dashboard;
    }
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		Object source = e.getSource();
		if(source == dashboard.addProductButton) {
			dashboard.pressAddProductButton();
		}else if(source == dashboard.deleteProductButton) {
			dashboard.pressDeleteProductButton();
		}else if(source == dashboard.updateProductButton) {
			dashboard.pressUpdateProductButton();
		}else if(source == dashboard.showProductsButton) {
			dashboard.pressShowProductsButton();
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
