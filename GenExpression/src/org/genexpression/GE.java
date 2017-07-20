package org.genexpression;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;




public class GE {
	
	public static void main(String[] args) throws Exception {
	
	//Lesen test = new Lesen("C:/Users/denis/Desktop/testSet.txt");
	//ArrayList<ATG> ATGListeTest = test.read();
	//ausgabe(ATGListeTest); 
	//System.out.println(test.read().get(3).getATnr());
	
	/*
	 * Test the searchAT and search ATG Functions. First with a existing 
	 * String and then with a non-existing. Should first print out the right
	 * ATG-/AT-Number and then the String "Keine passende ATG-Nummer gefunden"
	 */
	//System.out.println(searchAT("267639_at", ATGListeTest));
	//System.out.println(searchAT("12345678", ATGListeTest));

	//System.out.println(searchATG("At2g32950", ATGListeTest));
	//System.out.println(searchATG("987654321", ATGListeTest));
	
	
	Matrix_Create matrixexp = new Matrix_Create();
	matrixexp.read("C:/Users/denis/Desktop/matrixTestSetRMA.txt");
	matrixexp.ausgabe();
	//System.out.println(matrixexp.matrix.get(1).get(3));
	//System.out.println(matrixexp.matrix.get(0).get(0) + "\n");
	//matrixexp.SucheATnr("267608_at");
	
	}
	
	/**
	 * 
	 * @param atgnr - The ATG-Number to which you want to find the prober AT-Number
	 * @param h - ArrayList of ATG-Objects (ATGnr, ATnr, pfam)
	 * @return  a proper AT-Number as String to the given ATG-Number
	 */
	public static String searchATG(String atgnr, ArrayList<ATG> h) {
		String zielseq = "Keine passende AT-Nummer gefunden";
		for (int i = 0; i < h.size(); i++) {
			if(h.get(i).getATGnr().equals(atgnr)) {
				zielseq = h.get(i).getATnr();
				return zielseq;
			}
		}
		return zielseq;
	}
	
	/**
	 * 
	 * @param atnr - The AT-Number to which you want to find the prober ATG-Number
	 * @param h - ArrayList of ATG-Object (ATGnr, ATnr, pfam)
	 * @return  a prober ATG-Number as String to the given AT-Number
	 */
	public static String searchAT(String atnr, ArrayList<ATG> h) {
		String zielseq = "Keine passende ATG-Nummer gefunden";
		for(int i = 0; i < h.size(); i++) {
			if(h.get(i).getATnr().equals(atnr)) {
				zielseq = h.get(i).getATGnr();
				return zielseq;
			}
		}
		return zielseq;
	}
	
	/**
	 * Prints all Elements of a certain ArrayList out
	 * 
	 * @param h - ArrayList of ATG-Objects (ATGnr, ATnr, pfam)
	 */
	public static void ausgabe(ArrayList<ATG> h) {
		for (int i = 0; i < h.size(); i++) {
			System.out.println(h.get(i).getATGnr()+
					", "+h.get(i).getATnr()+", "+h.get(i).getPfam());
		}
	}
	
	public static void ATGzuExprParser(String atgfile, String atfile) {
		
	}
}


