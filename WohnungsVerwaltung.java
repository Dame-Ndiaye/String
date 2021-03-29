package immobilien;

import java.util.ArrayList;

public class WohnungsVerwaltung {

	public static Wohnung createWohnung1() {
		Zimmer z1 = new Zimmer(8, "Küche");
		ArrayList<Zimmer> zimmer = new ArrayList<Zimmer>();
		zimmer.add(z1);
		Wohnung w = new Wohnung("Wohnung 1", "Leipzig", false, 400, 100, 1920, zimmer);
		return w;
	}
	
	public static Wohnung createWohnung2() {
		ArrayList<Zimmer> zimmerListe = new ArrayList<Zimmer>();
		zimmerListe.add(new Zimmer(10, "Bad"));
		zimmerListe.add( new Zimmer(10, "Küche"));
		zimmerListe.add(new Zimmer(20, "Schlafzimmer"));
		zimmerListe.add(new Zimmer(10, "Schlafzimmer"));
		zimmerListe.add( new Zimmer(30, "Wohnzimmer"));
		Wohnung w = new Wohnung("Wohnung 2", "Hamburg",  true, 1440, 360, 2000, zimmerListe);
		return w;
	}
	
	public static Wohnung createWohnung3() {
		ArrayList<Zimmer> zimmer = new ArrayList<Zimmer>();
		zimmer.add(new Zimmer(10, "Bad"));
		zimmer.add( new Zimmer(10, "Küche"));
		zimmer.add(new Zimmer(20, "Schlafzimmer"));
		zimmer.add(new Zimmer(20, "Schlafzimmer"));
		zimmer.add(new Zimmer(40, "Schlafzimmer"));

		zimmer.add( new Zimmer(60, "Wohnzimmer"));
		Wohnung w = new Wohnung("Wohnung 3", "Berlin",  false, 2000, 500, 2020, zimmer);
		return w;
	}	
	
	public static void main(String[] args) {
		Wohnung w1 = createWohnung1();
		Wohnung w2 = createWohnung2();
		Wohnung w3 = createWohnung3();
		ArrayList<Wohnung> wohnungen = new ArrayList<Wohnung>();
		wohnungen.add(w1);
		wohnungen.add(w2);
		wohnungen.add(w3);
		
		// print alle wohnungen
		for (int i=0;i<wohnungen.size();i++) {
			wohnungen.get(i).printWohnung();
			System.out.println();
		}
		
		// finde die größte Wohnung
		Wohnung groessteWohnung = findeGroessteWohnung(wohnungen);
		System.out.println("Die größte Wohnung ist "+groessteWohnung.getName()+" mit "+groessteWohnung.getQuadratMeter()+" Quadratmetern.");
		
		ArrayList<Wohnung> mitBalkonList = findeWohnungenMitBalkon(wohnungen);
		System.out.println("*** Wohnungen mit Balkon");
		printWohnungen(mitBalkonList);
		
		ArrayList<Wohnung> wohnungenVor2000 = findeWohnungVorJahr(wohnungen, 2000);
		System.out.println("*** Wohnungen vor 2000");
		printWohnungen(wohnungenVor2000);
		
		
		// write CSV with wohnungen
		ImmobilienWriter immoWriter = new ImmobilienWriter();
		String folder = "C:\\dame\\daten\\immobilien\\";
		String dateiName = "wohnungen.csv";
		immoWriter.writeWohnungenToCsV(wohnungen, folder+dateiName);
		
	}
	
	/**
	 * findet die größte Wohnung
	 * @param wohnungen die liste an wohnungen
	 * @return die größte wohnung
	 */
	public static Wohnung findeGroessteWohnung(ArrayList<Wohnung> wohnungen) {
		// noch keine Wohnung gefunden, daher ist die erste Wohnung die größte (ergebnis)
		Wohnung ergebnis = wohnungen.get(0);
		for (Wohnung w: wohnungen) {
			// prüfe, ob die wohnung größer ist
			if (w.getQuadratMeter() > ergebnis.getQuadratMeter()) {
				ergebnis = w;
			}
		}
		return ergebnis;
	}
	
	/**
	 * findet alle wohnungen mit balkon
	 * @param wohnungen
	 * @return
	 */
	public static ArrayList<Wohnung> findeWohnungenMitBalkon(ArrayList<Wohnung> wohnungen) {
		ArrayList<Wohnung> wohnungenMitBalkon = new ArrayList<Wohnung>();
		for (Wohnung wohnung: wohnungen) {
			// falls ein Balkon vorhanden ist, füge die wohnungen den Wohnungen mit Balkon hinzu
			if (wohnung.isBalkon()) {
				wohnungenMitBalkon.add(wohnung);
			}
		}
		// sende ergebnis mit Wohnugnen mit Balkon
		return wohnungenMitBalkon;	
	}
	
	public static ArrayList<Wohnung> findeWohnungVorJahr(ArrayList<Wohnung> wohnungen, int year) {
		ArrayList<Wohnung> ergebnisse = new ArrayList<Wohnung>();
		for (Wohnung w: wohnungen) {
			// prüfe ob die wohnung vor dem Jahr gebaut wurde
			if (w.getBaujahr() < year) {
				ergebnisse.add(w);
			}
		}
		return ergebnisse;
 	}
	
	/**
	 * schreibt alle wohnung (hilfsmethode)
	 * @param wohnungen
	 */
	public static void printWohnungen(ArrayList<Wohnung> wohnungen) {
		for (Wohnung w: wohnungen) {
			w.printWohnung();
			System.out.println();
		}
	}
	
}
