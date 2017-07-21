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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Matrix_Create {
	ArrayList<ArrayList<String>> matrix = new ArrayList<ArrayList<String>>();

	// Einlesen der Datei und erstellen einer Matrix als Objekt

	/**
	 * reads text file and files the values in the Arraylist matrix
	 * 
	 * @param Input
	 *            - File you want to read (f.e. MAS_tmt_median)
	 * @throws IOException
	 *             - reading
	 */
	public void read(String Input) throws IOException {

		BufferedReader text = new BufferedReader(new InputStreamReader(new FileInputStream(Input), "UTF-8"));

		for (String line = text.readLine(); line != null; line = text.readLine()) {

			int i = 0;
			String d = "";
			ArrayList<String> x = new ArrayList<String>();
			String datavalue[] = line.split("	");
			/*
			 * ignoring the AFFX-probesets and the first line with information
			 */
			if (!datavalue[0].startsWith("AFFX") && !line.startsWith("#")) {

				while (i < datavalue.length) {
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
	 * Goes through the whole Matrix and prints out the row with the ATnr you
	 * want
	 * 
	 * @param search
	 *            - the first Element of the you searching for (could be AT
	 *            number or ATG number if already parsed)
	 * @return - ArrayList of the Row you search
	 */
	public ArrayList<String> SucheZeile(String search) {
		int zahl = 0;
		for (int r = 0; r < this.matrix.size(); r++) {
			if (this.matrix.get(r).get(0).equals(search)) {
				zahl++;
				return this.matrix.get(r);
			}
		}
		// if(zahl == 0)System.out.println("Nichts gefunden");
		return null;

	}

	/**
	 * Exports your matrix in a txt file
	 * 
	 * @param filename
	 *            - Path with filename where you want to export the matrix to
	 * @throws IOException
	 */
	public void exportMatrix(String filename) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(filename));

		for (int r = 0; r < this.matrix.size(); r++) {
			// bw.write(this.matrix.get(r).get(index) );
			for (int c = 0; c < this.matrix.get(r).size(); c++) {
				bw.write(this.matrix.get(r).get(c) + "\t");
			}
			bw.newLine();
		}
		bw.flush();
	}

	/**
	 * Calculates the relative Value of each cell to the row it's in
	 * 
	 * 
	 * 1.step: Parse all Strings beginning at Index(1,1) to Floats to Calculate
	 * the Sum of all values of a row Save the result into a variable named sum.
	 * 2.step: Parse every String cell to float to calculate the relative value
	 * of every cell to his row 3.step: Parse it back to string to set it as
	 * cell value
	 * 
	 * 
	 */
	public void zscore() {
		for (int r = 1; r < this.matrix.size(); r++) {
			float sum = 0;
			for (int c = 1; c < this.matrix.get(r).size(); c++) {
				sum += Float.parseFloat(this.matrix.get(r).get(c));
			}
			for (int c = 1; c < this.matrix.get(r).size(); c++) {
				float zahl = 0;
				zahl = Float.parseFloat(this.matrix.get(r).get(c));
				zahl = zahl / sum;
				String s = Float.toString(zahl);
				this.matrix.get(r).set(c, s);

			}
		}
	}
}
