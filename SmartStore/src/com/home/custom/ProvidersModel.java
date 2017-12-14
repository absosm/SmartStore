package com.home.custom;

import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import com.home.Cities;
import com.home.Provider;

public class ProvidersModel extends AbstractTableModel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Vector<Vector<Object>> data;
    private String columnNames[] = {"N\u00B0Fournisseur", "Nom", "Prenom", "Mobile", 
    								"Adresse", "Wilaya", "Commune", "Solde"};
    
    public static final int TAG = 8;
    
    public ProvidersModel() {
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
    	if (col == 0 || col == 5 || col == 6)
    		return false;
    	else
    		return true; 
    }
    
    public void setValueAt(Object value, int row, int col) {
    	
    	Provider p = (Provider) data.get(row).get(TAG);
    	
    	if (p == null) {
    		p = new Provider();
    		data.get(row).set(TAG, p);
    	}
    		
		switch (col) {
		case 0:
			p.setId(Integer.parseInt((String)value));
			break;
		case 1:
			p.setLastname((String)value);
			break;
		case 2:
			p.setFirstname((String)value);
			break;
		case 3:
			p.setMobile((String)value);
			break;
		case 4:
			p.setAddress((String)value);
			break;
		case 7:
			p.setCredit(Double.parseDouble((String)value));
			break;
		}
		p.update();
    	
        data.get(row).set(col, value);
        fireTableCellUpdated(row, col);
      }

    public Object getValueAt(int row, int column) {
    	
    	if (column == 5) {
    		int codew = (Integer) data.get(row).get(5);
    		return Cities.getWilaya(codew+1);
    	}
    	
    	if (column == 6) {
    		int codew = (Integer) data.get(row).get(5);
    		int codec = (Integer) data.get(row).get(6);
    		return Cities.getCity(codew+1, codec+1);
    	}
    		
    	return data.get(row).get(column);
    }
    
    public Provider getProvider(int row) {
    	return (Provider)data.get(row).get(TAG);
    }
    
    public void delete(int row) {
    	
    	Provider p = (Provider)data.get(row).get(TAG);
    	int confirm = JOptionPane.showConfirmDialog(null, String.format(
    			"Voulez vous supprimer cette client \"%s %s\"", p.getLastname(), p.getFirstname()), 
    			"Confirmation", JOptionPane.YES_NO_OPTION);
    	
		if (confirm == JOptionPane.YES_OPTION) {
			p.delete();
			data.remove(row);
		}
    	
    	fireTableDataChanged();
    }
    
    public void addRow(Provider provider) {
        
        if (provider == null) {
            throw new IllegalArgumentException("rowData cannot be null");
        }
        
        Vector<Object> v = new Vector<Object>();
        v.add(provider.getId());
        v.add(provider.getLastname());
        v.add(provider.getFirstname());
        v.add(provider.getMobile());
        v.add(provider.getAddress());
        v.add(provider.getWilaya());
        v.add(provider.getCity());
        v.add(provider.getCredit());
        v.add(provider);
        data.add(v);
        fireTableDataChanged();
    }
}
