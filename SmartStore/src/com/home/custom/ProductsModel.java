package com.home.custom;

import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import com.home.Cities;
import com.home.Product;

public class ProductsModel extends AbstractTableModel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Vector<Vector<Object>> data;
    private String columnNames[] = {"ID", "Barcode", "Name", "Family", 
    								"Selling_lim", "Stor_date", "Expiration_date", "Location"};
    
    public static final int TAG = 8;
    
    public ProductsModel() {
        data = new Vector<Vector<Object>>();
    }
  
    public int getRowCount() {
        return data.size();
    }

    public int getColumnCount() {
        return columnNames.length;
    }
  
    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }
    
    public boolean isCellEditable(int row, int col) { 
    	if (col == 0 || col >= 5)
    		return false;
    	else
    		return true; 
    }
    
    public void setValueAt(Object value, int row, int col) {
 
    	Product c = (Product) data.get(row).get(TAG);
    	
    	if (c == null) {
    		c = new Product();
    		data.get(row).set(TAG, c);
    	}
    		
		switch (col) {
		case 0:
			c.setId(Integer.parseInt((String)value));
			break;
		case 1:
			c.setBarcode((String)value);
			break;
		case 2:
			c.setName((String)value);
			break;
		case 3:
			c.setFamily((String)value);
			break;
		case 4:
			c.setSelling_limit(Double.parseDouble((String)value));
			break;
		case 7:
			c.setLocation((String)value);
			break;
		}
		c.update();
    	
        data.get(row).set(col, value);
        fireTableCellUpdated(row, col);
      }

    public Object getValueAt(int row, int column) {
    	
    	/*if (column == 5) {
    		int codew = (Integer) data.get(row).get(5);
    		return Cities.getWilaya(codew);
    	}
    	
    	if (column == 6) {
    		int codew = (Integer) data.get(row).get(5);
    		int codec = (Integer) data.get(row).get(6);
    		return Cities.getCity(codew, codec);
    	}*/
    		
    	return data.get(row).get(column);
    }
    
    public Product getProduct(int row) {
    	return (Product)data.get(row).get(TAG);
    }
    
    public void delete(int row) {
    	
    	Product c = (Product)data.get(row).get(TAG);
    	int confirm = JOptionPane.showConfirmDialog(null, String.format(
    			"Voulez vous supprimer cette client \"%s %s\"", c.getBarcode(), c.getName()), 
    			"Confirmation", JOptionPane.YES_NO_OPTION);
    	
		if (confirm == JOptionPane.YES_OPTION) {
			c.delete();
			data.remove(row);
		}
    	
    	fireTableDataChanged();
    }
    
    public void addRow(Product product) {
        
        if (product == null) {
            throw new IllegalArgumentException("rowData cannot be null");
        }
        
        Vector<Object> v = new Vector<Object>();
        v.add(product.getId());
       v.add(product.getBarcode());
        v.add(product.getName());
        v.add(product.getFamily());
        v.add(product.getSelling_limit());
        v.add(product.getStore_date());
        v.add(product.getExpiration());
        v.add(product.getLocation());
        v.add(product);
        data.add(v);
        fireTableDataChanged();
    }
}
