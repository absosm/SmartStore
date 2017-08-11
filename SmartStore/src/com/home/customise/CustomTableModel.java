package com.home.customise;

import java.util.Vector;
import javax.swing.table.AbstractTableModel;

public class CustomTableModel extends AbstractTableModel {

    private Vector<Vector> data;
    private String columnNames[] = {"Désignation", "Remarque"};
    
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

    public Object getValueAt(int row, int column) {
        return data.get(row).get(column);
    }
    
    public void addRow(Field field) {
        
        if (field == null) {
            throw new IllegalArgumentException("rowData cannot be null");
        }
        
        Vector v = new Vector();
        v.add(field.getDesignation());
        v.add(field.getNote());
        data.add(v);
        fireTableDataChanged();
    }
}