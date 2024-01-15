package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.Dashboard;

public class StaffListener implements MouseListener{
    Dashboard dashboard;
    public StaffListener(Dashboard dashboard) {
    	this.dashboard = dashboard;
    }
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Object source = e.getSource();
		if(source == dashboard.addStaffButton) {
			dashboard.pressAddStaffButton();
		}else if(source == dashboard.deleteStaffButton) {
			dashboard.pressDeleteStaffButton();
		}else if(source == dashboard.showStaffsButton) {
			dashboard.pressShowStaffButton();
		}else if(source == dashboard.updateStaffButton) {
			dashboard.pressUpdateStaffButton();
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
