package org.genexpression;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

public class Matrix_Create {
	ArrayList<ArrayList<String>> matrix = new ArrayList<ArrayList<String>>();
	
	
	//Einlesen der Datei und erstellen einer Matrix als Objekt
	
	/**
	 * reads text file and files the values in the Arraylist matrix
	 * 
	 * @param Input - File you want to read (f.e. MAS_tmt_median)
	 * @throws IOException - reading 
	 */
	public void read(String Input) throws IOException {
	
		BufferedReader text = new BufferedReader(new InputStreamReader(
				new FileInputStream(Input), "UTF-8"));
		
	
		for (String line = text.readLine(); line != null; line = text.readLine()) {
			
			int i = 0;
			String d = "";
			ArrayList<String> x = new ArrayList<String>();
			String datavalue[] = line.split("	");
			/*
			 * ignoring the AFFX-probesets and the first line with information
			 */
			if(!datavalue[0].startsWith("AFFX") && !line.startsWith("#")) {
			
			while(i < datavalue.length) {
				d = datavalue[i];
				x.add(d);
				i++;
			}
			
			matrix.add(x);
			}
		}
	}
	
	/**
	 * prints matrix out
	 */
	public void ausgabe() {
		for (int r = 0; r < this.matrix.size(); r++) {
			for (int c = 0; c < this.matrix.get(r).size(); c++) {
				System.out.print(this.matrix.get(r).get(c) + "\t| ");
			}
			System.out.print("\n");
		}
	}

	/**
	 * Goes through the whole Matrix and prints out the row with the ATnr
	 * you want
	 * 
	 * @param search - the first Element of the you searching for (could be
	 * 					AT number or ATG number if already parsed)
	 * @return - ArrayList of the Row you search
	 */
	public ArrayList<String> SucheZeile(String search) {
		int zahl = 0;
		for (int r = 0; r < this.matrix.size(); r++) {
			if(this.matrix.get(r).get(0).equals(search)) {
				zahl ++;
				return this.matrix.get(r);
			}
		}
		//if(zahl == 0)System.out.println("Nichts gefunden");
		return null;
		
	}
	
	
	public void exportMatrix(String filename) throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
		
		for(int r = 0; r < this.matrix.size(); r++) {
			//bw.write(this.matrix.get(r).get(index) );
			for(int c = 0; c < this.matrix.get(r).size(); c++) {
				bw.write(this.matrix.get(r).get(c) + "\t");
			}
			bw.newLine();
		}
		bw.flush();
	}
	

/*	
	@Override
	public String toString() {
		return "Matrix_Create [matrix=" + matrix + "]";
	}
*/	
	
	
}
