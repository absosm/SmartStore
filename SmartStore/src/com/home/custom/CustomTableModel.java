package com.home.custom;

import java.util.Vector;
import javax.swing.table.AbstractTableModel;

import com.home.Famille;

public class CustomTableModel extends AbstractTableModel {

    private Vector<Vector> data;
    private String columnNames[] = {"Désignation", "Remarque", "Nombre"};
    
    public CustomTableModel() {
        data = new Vector<Vector>();
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
    	return true; 
    }
    
    public void setValueAt(Object value, int row, int col) {
    	
    	Famille f = (Famille) data.get(row).get(3);
    	
    	if (f == null) {
    		f = new Famille();
    		data.get(row).set(3, f);
    	}
    		
		switch (col) {
		case 0:
			f.setDesignation((String)value);
			break;
		case 1:
			f.setNote((String)value);
			break;
		case 2:
			f.setCount(Integer.parseInt((String)value));
			break;
		}
		f.update();
    	
        data.get(row).set(col, value);
        fireTableCellUpdated(row, col);
      }

    public Object getValueAt(int row, int column) {
        return data.get(row).get(column);
    }
    
    public Famille getFamille(int row) {
    	return (Famille)data.get(row).get(3);
    }
    
    public void delete(int row) {
    	Famille f = (Famille)data.get(row).get(3);
    	f.delete();
    	data.remove(row);
    	fireTableDataChanged();
    }
    
    public void addRow(Famille famille) {
        
        if (famille == null) {
            throw new IllegalArgumentException("rowData cannot be null");
        }
        
        Vector v = new Vector();
        v.add(famille.getDesignation());
        v.add(famille.getNote());
        v.add(famille.getCount());
        v.add(famille);
        data.add(v);
        fireTableDataChanged();
    }
}
