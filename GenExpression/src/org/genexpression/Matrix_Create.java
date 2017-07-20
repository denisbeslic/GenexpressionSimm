package org.genexpression;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

public class Matrix_Create {
	ArrayList<ArrayList<String>> matrix = new ArrayList<ArrayList<String>>();
	
	//int row, column = 0;
	
	
	
	
	
	//Einlesen der Datei und erstellen einer Matrix als Objekt
	public void read(String Input) throws IOException {
	
		BufferedReader text = new BufferedReader(new InputStreamReader(
				new FileInputStream(Input), "UTF-8"));
		
	
		for (String line = text.readLine(); line != null; line = text.readLine()) {
			
			int i = 0;
			String d = "";
			ArrayList<String> x = new ArrayList<String>();
			String datavalue[] = line.split("	");
			if(!datavalue[0].startsWith("AFFX")) {
			
			while(i < datavalue.length) {
				d = datavalue[i];
				x.add(d);
				i++;
			}
			
			matrix.add(x);
			
			}

		}
	
		
	}
	
	// Ausgabe der Matrix in Form
	public void ausgabe() {
		for (int r = 0; r < this.matrix.size(); r++) {
			for (int c = 0; c < this.matrix.get(r).size(); c++) {
				System.out.print(this.matrix.get(r).get(c) + "\t| ");
			}
			System.out.print("\n");
		}
	}

	//Input ATnr; Output Expressionsdaten von mehreren Hybrid. Also eine Matrix Zeile
	public void SucheATnr(String atnr) {
		for (int r = 0; r < this.matrix.size(); r++) {
			if(this.matrix.get(r).get(0).equals(atnr)) {
				System.out.println(this.matrix.get(r));
			}
		}
		
	}
	
	//Input ATnr + HybID; Output einzelne Int Zelle;
	public void SucheATnrUndHyb() {
		
	}
	
	
}
