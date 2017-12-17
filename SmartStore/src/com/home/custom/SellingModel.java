package com.home.custom;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import com.home.Selling;

public class SellingModel extends AbstractTableModel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Vector<Vector<Object>> data;
    private String columnNames[] = {"Cat\u00E9gorie", "Prix", "Boni"};
    private Class<?> columnTypes[] = {String.class, Double.class, Double.class};

	public static final int TAG = 3;
    
    public SellingModel() {
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
    
    @Override
    public Class<?> getColumnClass(int column) {
    	return columnTypes[column];
    }
    
    public boolean isCellEditable(int row, int col) {
    	if (col == 2)
    		return false;
    	else
    		return true; 
    }
    
    public void setValueAt(Object value, int row, int col) {
    	
    	Selling s = (Selling) data.get(row).get(TAG);
    	
    	if (s == null)
    		throw new IllegalArgumentException("rowData cannot be null");
    		
		switch (col) {
		case 0:
			s.setCategory((String)value);
			break;
		case 1:
			s.setPrice((Double)value);
			data.get(row).set(2, s.getFees());
			fireTableCellUpdated(row, 2);
			break;
		}
    	
        data.get(row).set(col, value);
        fireTableCellUpdated(row, col);
      }

    public Object getValueAt(int row, int column) {   		
    	return data.get(row).get(column);
    }
    
    public Selling getSelling(int row) {
    	return (Selling)data.get(row).get(TAG);
    }
    
    public void delete(int row) {
    	
    	Selling s = (Selling)data.get(row).get(TAG);
    	s.delete();
    	data.remove(row); 	
    	fireTableDataChanged();
    }
    
    public void update() {
    	
    	Selling s;
    	for(Vector<Object> v:data) {
    		s = (Selling)v.get(TAG);
    		v.set(2, s.getFees());
    	}
		fireTableDataChanged();
    }
    
    public void addRow(Selling selling) {
        
        if (selling == null) {
            throw new IllegalArgumentException("rowData cannot be null");
        }
        
        Vector<Object> v = new Vector<Object>();
        v.add(selling.getCategory());
        v.add(selling.getPrice());
        v.add(selling.getFees());
        v.add(selling);
        data.add(v);
        fireTableDataChanged();
    }
}
