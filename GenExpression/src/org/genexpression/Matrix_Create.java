package org.genexpression;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class Matrix_Create {

	ArrayList<ArrayList<String>> matrix = new ArrayList<ArrayList<String>>();
	int row, column = 0;
	
	//Einlesen der Datei und erstellen einer Matrix als Objekt
	public void read(String Input) throws IOException {
		
		BufferedReader text = new BufferedReader(new InputStreamReader(
				new FileInputStream(Input), "UTF-8"));
		
		//Matrix erstellen?
		
	
		for (String line = text.readLine(); line != null; line = text.readLine()) {
			
			String datavalue[] = line.split("/t");
			
			if(!datavalue[0].startsWith("AFFX")) {
				
				//Scanner colReader = new Scanner()
			}
			
		
		}
	
		
	}
	
	// Ausgabe der Matrix in Form
	public void ausgabe() {
		
	}
	
	//Input ATnr; Output Expressionsdaten von mehreren Hybrid. Also eine Matrix Zeile
	public void SucheATnr() {
		
	}
	
	//Input ATnr + HybID; Output einzelne Int Zelle;
	public void SucheATnrUndHyb() {
		
	}
	
	
}
