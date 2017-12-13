package com.home.custom;

import java.util.Vector;
import javax.swing.table.AbstractTableModel;

import com.home.Family;

public class FamiliesModel extends AbstractTableModel {

    private Vector<Vector> data;
    private String columnNames[] = {"Désignation", "Remarque", "Nombre"};
    public static final int TAG = 3;
    
    public FamiliesModel() {
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
    	
    	Family f = (Family) data.get(row).get(TAG);
    	
    	if (f == null) {
    		f = new Family();
    		data.get(row).set(TAG, f);
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
    
    public Family getFamille(int row) {
    	return (Family)data.get(row).get(TAG);
    }
    
    public void delete(int row) {
    	Family f = (Family)data.get(row).get(TAG);
    	f.delete();
    	data.remove(row);
    	fireTableDataChanged();
    }
    
    public void addRow(Family famille) {
        
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
