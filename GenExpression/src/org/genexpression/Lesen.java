package org.genexpression;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Lesen {
	String m_Input;

	/**
	 * Constructor with the Inputfilepath
	 * 
	 * @param chInput
	 *            - The path of the input File as String
	 */
	Lesen(String chInput) {
		m_Input = chInput;
	}

	/**
	 * Goes through a txtfile line for line. Parses every line into an object of
	 * the ATG-Class. All Objects are located in an ArrayList.
	 * 
	 * @return - a ArrayList of all ATG-Objects (ATGnr, ATnr, Pfam)
	 * @throws IOException
	 *             - if BufferedReader somehow fails
	 */
	public ArrayList<ATG> read() throws IOException {

		// File file = new File(m_Input);
		BufferedReader text = new BufferedReader(new InputStreamReader(new FileInputStream(m_Input), "UTF-8"));

		// create an ArrayList to save the ATG-Objects in
		ArrayList<ATG> ATGListe = new ArrayList<ATG>();

		/*
		 * go through the file. line for line. split the line into strings at
		 * every tab.
		 */
		for (String line = text.readLine(); line != null; line = text.readLine()) {
			String datavalue[] = line.split("\t");

			/*
			 * Only parse lines which first string end with "at" and don't start
			 * with "AFFX", so we can skip the introduction lines and
			 * unnecessary AT-Numbers
			 */
			if (datavalue[0].endsWith("at") && !datavalue[0].startsWith("AFFX")) {

				/*
				 * Check if there at least 3 Strings in the Line, so the
				 * programm doesn't crash Add the ATnr (1st string), the ATGnr
				 * (3th string) and Pfam (the 4th string in the line) to the
				 * Object Attribute.
				 * 
				 * Add the created Object tempATG to the ArrayList ATGListe
				 * 
				 */
				if (datavalue.length > 3) {
					ATG tempATG = new ATG(datavalue[0], datavalue[2], datavalue[3]);
					ATGListe.add(tempATG);
				}

				/*
				 * If there aren't 3 strings in the line, just to the same as
				 * above but use the other constructor of ATG, so the Pfam is an
				 * empty String
				 */
				else {
					ATG tempATG = new ATG(datavalue[0], datavalue[2]);
					ATGListe.add(tempATG);
				}
			}
		}
		return ATGListe;
	}
}
