package org.genexpression;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Lesen {
	String m_chInput;
	
	Lesen(String chInput)
	{
		m_chInput = chInput;	
	}
	
	public ArrayList<ATG> read () throws IOException {
		
		//Needed to select coding (UTF-8)
		BufferedReader text = new BufferedReader(new InputStreamReader(
		new FileInputStream(m_chInput), "UTF-8"));
		
		
		int zaehler = 0; 
		//Arraylist fuer ATG erstellen
		ArrayList<ATG> ATGListe = new ArrayList<ATG>();
		
		//Durch die Datei gehen; Zeile fuer Zeile
		for(String line = text.readLine(); line!= null; line = text.readLine()) {
			//Split the line into Strings which are separated by tabs
			String datavalue [] = line.split("\t"); 
			
			//mind 2 Tabs damit die Anfangszeilen übersprungen werden und kein error
			//Drittes Feld startet mit At damit AFFX-Nummern ubersprungen werden
			if(datavalue.length > 2 && datavalue[2].startsWith("At")){
				
				//falls Proteininfo vorhanden
				if(datavalue.length > 3) {
					ATG tempATG = new ATG(datavalue[0], datavalue[2], datavalue[3]);
					ATGListe.add(tempATG);
					/*System.out.println(ATGListe.get(zaehler).getATGnr()+
							", "+ATGListe.get(zaehler).getATnr()+ 
							", "+ATGListe.get(zaehler).getPfam());
							*/
					
					zaehler ++;
					
				}
				
				// falls keine Proteininfo enthalten
				else {
				//Objekt erstellen mit verschiedenen Tabs auf der txt Datei
				ATG tempATG = new ATG(datavalue[0], datavalue[2], "");
				// Importieren in die ArrayList
				ATGListe.add(tempATG);
			
				//Zum Test: Ausgabe der ATG und AT nr
				/*System.out.println(ATGListe.get(zaehler).getATGnr()+
						", "+ATGListe.get(zaehler).getATnr());
						*/
				zaehler ++;
				
				}
			}
		}
		return ATGListe;	
	}	
}
