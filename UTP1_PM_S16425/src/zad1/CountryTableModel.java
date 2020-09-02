package zad1;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class CountryTableModel extends AbstractTableModel {
	
	/**
	 * 
	 */
	ArrayList<Country> list = new ArrayList<Country>();
	String [] kolumny;
	
	public CountryTableModel(String [] kolumny) {
		this.kolumny = kolumny;
	}
	
	public String getColumnName(int columns) {
		return kolumny[columns];
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return kolumny.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		switch(columnIndex) {
		case 0:
			return list.get(rowIndex).getName();
		case 1:
			return list.get(rowIndex).getCapital();
		case 2:
			return list.get(rowIndex).getPopulation();
		default:
				return null;
		}
	}
	
	public void setList(ArrayList<Country> list) {
		this.list = list;
	}


	
}


