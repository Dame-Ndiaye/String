package immobilien;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Wohnung {
	private String name;
	private String stadt;
	private boolean balkon;
	private int kaltMiete;
	private int nebenKosten;
	private int baujahr;
	private ArrayList<Zimmer> zimmerList;
	
	/**
	 * erstellt die Wohnung
	 * @param name
	 * @param zimmer
	 * @param quadratMeter
	 * @param stadt
	 * @param balkon
	 * @param preis
	 * @param kaltMiete
	 * @param nebenKosten
	 * @param baujahr
	 */
	public Wohnung(String name, String stadt, boolean balkon, int kaltMiete,
			int nebenKosten, int baujahr, ArrayList<Zimmer> zimmerList) {
		super();
		this.name = name;
		this.stadt = stadt;
		this.balkon = balkon;
		this.kaltMiete = kaltMiete;
		this.nebenKosten = nebenKosten;
		this.baujahr = baujahr;
		this.zimmerList = zimmerList;
	}
	

	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getZimmer() {
		return this.getZimmerList().size();
	}
	
	public int getQuadratMeter() {
		int ergebnis = 0;
		for (Zimmer zimmer:zimmerList) {
			ergebnis += zimmer.getQuadratMeter();
		}
		return ergebnis;
	}

	public String getStadt() {
		return stadt;
	}
	public void setStadt(String stadt) {
		this.stadt = stadt;
	}
	public boolean isBalkon() {
		return balkon;
	}
	public void setBalkon(boolean balkon) {
		this.balkon = balkon;
	}
	public int getKaltMiete() {
		return kaltMiete;
	}
	public void setKaltMiete(int kaltMiete) {
		this.kaltMiete = kaltMiete;
	}
	public int getNebenKosten() {
		return nebenKosten;
	}
	public void setNebenKosten(int nebenKosten) {
		this.nebenKosten = nebenKosten;
	}
	public int getBaujahr() {
		return baujahr;
	}
	public void setBaujahr(int baujahr) {
		this.baujahr = baujahr;
	}

	/**
	 * berechnet die gesamtmiete (kaltmiete + nebnkosten
	 * @return gesamtmiete
	 */		
	public int getGesamtMiete() {
		return this.getKaltMiete() + this.getNebenKosten();
	}

	/**
	 * berechnet den kaltmiete pro Quadratmeter
	 * @return kaltmiete pro quadratmeter
	 */	
	public double getKaltmieteProQuadratmeter() {
		return (double) ((double) this.getKaltMiete() / (double) this.getQuadratMeter()); 
	}

	/**
	 * berechnet den nebenkosten pro Quadratmeter
	 * @return nebenkosten pro quadratmeter
	 */
	public double getNebenkostenProQuadratmeter() {
		return (double) ((double) this.getNebenKosten() / (double) this.getQuadratMeter()); 
	}
	
	/**
	 * berechnet den mietpreis pro Quadratmeter
	 * @return mietpreis pro quadratmeter
	 */
	public double getGesamtmieteProQuadratmeter() {
		return (double) ((double) this.getGesamtMiete() / (double) this.getQuadratMeter()); 
	}		
	
	public int getAlter() {
		int year = LocalDate.now().getYear();
		return year - this.getBaujahr();
	}
	
	public ArrayList<Zimmer> getZimmerList() {
		return zimmerList;
	}

	public void setZimmerList(ArrayList<Zimmer> zimmerList) {
		this.zimmerList = zimmerList;
	}
	
	public void addZimmer(Zimmer zimmer) {
		this.zimmerList.add(zimmer);
	}

	public int getAnzahlZimmer() {
		return this.zimmerList.size();
	}

	/**
	 * gibt die details der Wohnung in der Konsole aus
	 */
	public void printWohnung() {
		System.out.println("Name:\t\t"+this.getName());
		System.out.println("Zimmer:\t\t"+this.getName());
		System.out.println("Quadratmeter:\t\t"+this.getQuadratMeter());
		System.out.println("Stadt:\t\t"+this.getStadt());
		System.out.println("Balkon:\t\t"+this.isBalkon());
		System.out.println("Kaltmiete:\t\t"+this.getKaltMiete());
		System.out.println("Nebenkosten:\t\t"+this.getNebenKosten());
		System.out.println("Baujahr:\t\t"+this.getBaujahr());
		System.out.println("Gesamtmiete:\t\t"+this.getGesamtMiete());
		System.out.println("Kaltmiete pro Quadratmeter:\t\t"+this.getKaltmieteProQuadratmeter());
		System.out.println("Nebenkosten pro Quadratmeter:\t\t"+this.getNebenkostenProQuadratmeter());
		System.out.println("Gesamtmiete pro Quadratmeter:\t\t"+this.getGesamtmieteProQuadratmeter());
		System.out.println("Zimmer:");
		for (Zimmer z: this.getZimmerList()) {
			z.printZimmer();
		}	
	}
	

}
