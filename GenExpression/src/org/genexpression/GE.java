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
		
	/*
	 * ATG zu AT Parser Tests
	 */
	
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
	
		
		
		
	/*
	 * AT zu Expr Parser Tests	
	 */
	
	
	//Matrix_Create matrixexp = new Matrix_Create();
	//matrixexp.read("C:/Users/denis/Desktop/AT40/AT40_MAS_tmt_median(2).txt");
	//matrixexp.ausgabe();

	//System.out.println(matrixexp.SucheATnr("244902_at"));
	//System.out.println(matrixexp.SucheATnr("AFFX-r2-At-Actin-3_s_at"));
	//System.out.println(matrixexp.matrix.get(0));
	
	
		
	/*
	 * ATG zu Expr Parser Tests
	 */
	
	String ATGfile = "C:/Users/denis/Desktop/A-AFFY-2.adf.txt";
	String AT_Expressionfile = "C:/Users/denis/Desktop/AT40/AT40_RMA_tmt_median.txt";
		
	Matrix_Create matrixATG = new Matrix_Create();
	matrixATG = ATGzuExprParser(ATGfile, 
			AT_Expressionfile);
	//matrixATG.ausgabe();
	System.out.println(matrixATG.SucheZeile("AtCg00080"));
	System.out.println(matrixATG.SucheZeile("AtCg00300"));
	System.out.println(matrixATG.SucheZeile("AtCg00710"));
	System.out.println(matrixATG.SucheZeile("AtCg00580"));
	System.out.println(matrixATG.SucheZeile("AtCg00570"));
	System.out.println(matrixATG.SucheZeile("AtCg00070"));
	System.out.println(matrixATG.SucheZeile("AtCg00560"));
	System.out.println(matrixATG.SucheZeile("AtCg00550"));
	System.out.println(matrixATG.SucheZeile("AtCg00690"));
	System.out.println(matrixATG.SucheZeile("AtCg00220"));
	System.out.println(matrixATG.SucheZeile("At2g30570"));
	System.out.println(matrixATG.SucheZeile("At2g06520"));
	
	System.out.println(matrixATG.SucheZeile("At3g10350"));
	System.out.println(matrixATG.SucheZeile("At3g01480"));
	System.out.println(matrixATG.SucheZeile("At1g02910"));
	
	System.out.println(matrixATG.SucheZeile("At2g28800"));
	System.out.println(matrixATG.SucheZeile("At1g24490"));
	System.out.println(matrixATG.SucheZeile("At3g15095"));
	System.out.println(matrixATG.SucheZeile("At4g19100"));
	System.out.println(matrixATG.SucheZeile("At1g29310"));
	System.out.println(matrixATG.SucheZeile("At1g78720"));
	System.out.println(matrixATG.SucheZeile("At3g48570"));
	System.out.println(matrixATG.SucheZeile("At4g14870"));
	
	
	//System.out.println(matrixATG.SucheZeile("At2g32830"));
	//System.out.println(matrixATG.matrix.get(0));
	//System.out.println(matrixATG.matrix.get(1));
	//System.out.println(matrixATG.matrix.get(2));
	//System.out.println(matrixATG.SucheZeile("AFFX-r2-At-Actin-5_s_at"));
	
	
	
	/*
	 * ATG zu Express File Matrix exportieren in eine Text Datei
	 */
	
	/*
	matrixATG.exportMatrix("C:/Users/denis/Desktop/matrixausgabevon " 
	+AT_Expressionfile.substring(AT_Expressionfile.lastIndexOf("/") + 1));
	*/
	
	
	}
	
	/**
	 * Search for a certain AT-Number with the input of the ATG-Number
	 * 
	 * @param atgnr - The ATG-Number to which you want to find the prober AT-Number
	 * @param h - ArrayList of ATG-Objects (ATGnr, ATnr, pfam)
	 * @return  a proper AT-Number as String to the given ATG-Number
	 */
	public static String searchATwithATG(String atgnr, ArrayList<ATG> h) {
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
	 * Search of a certain ATG-Number with the input of a AT-Number
	 * 
	 * @param atnr - The AT-Number to which you want to find the prober ATG-Number
	 * @param h - ArrayList of ATG-Object (ATGnr, ATnr, pfam)
	 * @return  a prober ATG-Number as String to the given AT-Number
	 */
	public static String searchATGwithAT(String atnr, ArrayList<ATG> h) {
		String zielseq = "Keine passende ATG-Nummer gefunden zu " + atnr;
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
	
	/**
	 * Parses a Expressionfile-Matrix (with AT-ID and Treatments)
	 * to a new Expressionfile-Matrix (with ATG-ID instead of AT-ID)
	 * 
	 * @param atgfile - Genechipfile that translates ATG to AT-ID-Numbers
	 * @param atfile - Matrixfile with AT-ID, Treatments and Expressiondata
	 * @return gives Matrix with ATG-ID instead of AT-ID back
	 * @throws IOException
	 */
	
	public static Matrix_Create ATGzuExprParser(String atgfile, String atfile) throws IOException {
		//open the ATGfile with the translation from ATG to AT
		Lesen ATGparse = new Lesen(atgfile);
		ArrayList<ATG> ATGListeTest = ATGparse.read();
		
		//open the Expressionfilematrix
		Matrix_Create matrixTest = new Matrix_Create();
		matrixTest.read(atfile);
		/*
		 * goes through every line and translates the first Element (the AT-Number)
		 * to his proper ATG-Number with the help of the ATGListeTest
		 */
		for(int r = 1; r < matrixTest.matrix.size(); r++) {
			String at_id, atg_id = "";
			at_id = matrixTest.matrix.get(r).get(0);
			//String atg_id = "";
			atg_id = searchATGwithAT(at_id, ATGListeTest);
			matrixTest.matrix.get(r).set(0, atg_id);
		}
		return matrixTest;
	}
}


