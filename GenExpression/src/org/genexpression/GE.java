package org.genexpression;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;




public class GE {
	
	public static void main(String[] args) throws IOException {
	
	
	Lesen test = new Lesen("C:/Users/denis/Desktop/testSet.txt");
	ArrayList<ATG> ATGListeTest = test.read();
	ausgabe(ATGListeTest);
	//System.out.println(test.read().get(3).getATnr());
	
	System.out.println(searchAT("267639_at", ATGListeTest));
	System.out.println(searchAT("12345678", ATGListeTest));

	System.out.println(searchATG("At2g32950", ATGListeTest));
	System.out.println(searchATG("987654321", ATGListeTest));
	
	}
	
	/*Gib alle Objekte mit folgender ATG-Nr aus*/	
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
	
	//gibt passende ATG-Nummer zur AT-Nummer aus
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
	
	//Funktion fuer Ausgabe aller Elemente der Arrayliste
	public static void ausgabe(ArrayList<ATG> h) {
		for (int i = 0; i < h.size(); i++) {
			System.out.println(h.get(i).getATGnr()+
					", "+h.get(i).getATnr()+", "+h.get(i).getPfam());
		}
	}
	
}
