package com.home.custom;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import com.home.Cities;
import com.home.Client;

public class ClientsModel extends AbstractTableModel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Vector<Vector<Object>> data;
    private String columnNames[] = {"N\u00B0Client", "Nom", "Prenom", "Mobile", 
    								"Adresse", "Wilaya", "Commune", "Solde"};
    
    public static final int TAG = 8;
    
    public ClientsModel() {
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
    	
    	Client c = (Client) data.get(row).get(TAG);
    	
    	if (c == null) {
    		c = new Client();
    		data.get(row).set(TAG, c);
    	}
    		
		switch (col) {
		case 0:
			c.setId(Integer.parseInt((String)value));
			break;
		case 1:
			c.setLastname((String)value);
			break;
		case 2:
			c.setFirstname((String)value);
			break;
		case 3:
			c.setMobile((String)value);
			break;
		case 4:
			c.setAddress((String)value);
			break;
		case 7:
			c.setCredit(Double.parseDouble((String)value));
			break;
		}
		c.update();
    	
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
    
    public Client getClient(int row) {
    	return (Client)data.get(row).get(TAG);
    }
    
    public void delete(int row) {
    	Client f = (Client)data.get(row).get(TAG);
    	f.delete();
    	data.remove(row);
    	fireTableDataChanged();
    }
    
    public void addRow(Client client) {
        
        if (client == null) {
            throw new IllegalArgumentException("rowData cannot be null");
        }
        
        Vector<Object> v = new Vector<Object>();
        v.add(client.getId());
        v.add(client.getLastname());
        v.add(client.getFirstname());
        v.add(client.getMobile());
        v.add(client.getAddress());
        v.add(client.getWilaya());
        v.add(client.getCity());
        v.add(client.getCredit());
        v.add(client);
        data.add(v);
        fireTableDataChanged();
    }
}
