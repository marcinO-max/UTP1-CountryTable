package zad1;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import java.awt.Color;
import java.awt.Component;
import java.io.*;
import java.util.ArrayList;

public class CountryTable {
	
	String [] kolumnyNazw;
	String line;
	ArrayList <Country> kraje= new ArrayList<Country>();

	public CountryTable(String countriesFileName) throws IOException {
			File file = new File(countriesFileName);
			FileReader fr = new FileReader(file);
			try(BufferedReader br = new BufferedReader(fr)){
			kolumnyNazw = br.readLine().split("\t");
			while((line=br.readLine()) != null) {
				String [] splits = line.split("\\t");
				Country country = new Country();
				country.setName(splits[0]);
				country.setCapital(splits[1]);
				country.setPopulation(Integer.parseInt(splits[2]));
				kraje.add(country);
			}
			}
		}

	public JTable create() {
		JTable table = new JTable();
		CountryTableModel model = new CountryTableModel(kolumnyNazw);
		model.setList(kraje);
		table.setModel(model);
		//Kolorowy renderer = new Kolorowy();
		//table.setDefaultRenderer(Object.class, renderer);
		return table;	
	}
}
class Kolorowy implements TableCellRenderer{
	
	private static final DefaultTableCellRenderer Renderer = new DefaultTableCellRenderer();

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// TODO Auto-generated method stub
		Component c = Renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		if(column ==2) {	
		Object result = table.getModel().getValueAt(row, column);
			int var = (int)result;
			if(var > 20000000) {
				c.setForeground(Color.RED);
		}
		}
		
		return c;
	}

	
}
	


 