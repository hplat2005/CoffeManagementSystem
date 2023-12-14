package controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.Dashboard;

public class MouseMenuListener implements MouseListener {
	Dashboard dashboard;
	
	public MouseMenuListener(Dashboard dashboard) {
		this.dashboard = dashboard;
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Object source = e.getSource();
		
		if(dashboard.homeLabel == source) {
			dashboard.pressHomeLabel();
		}else if(dashboard.productsLabel == source) {
			dashboard.pressProductsLabel();
		}else if(dashboard.staffLabel == source) {
			dashboard.pressStaffLabel();
		}else if(dashboard.orderLabel == source) {
			dashboard.pressOrderLabel();
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
