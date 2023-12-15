package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Dashboard;

public class ProductListener implements ActionListener {
    Dashboard dashboard;
    public ProductListener(Dashboard dashboard) {
    	this.dashboard = dashboard;
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(dashboard.addProductButton == source) {
			dashboard.clickAddProductButton();
		}else if(dashboard.showProductsButton == source) {
			dashboard.clickShowProductsButton();
		}else if(dashboard.deleteProductButton == source) {
			dashboard.clickDeleteProductButton();
		}else if(dashboard.updateProductButton == source) {
			dashboard.clickUpdateProductButton();
		}
		
	}

}
