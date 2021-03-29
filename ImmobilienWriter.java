package immobilien;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class ImmobilienWriter {
	
	private String delimiter;
	private String lineBreak;
	
	
	public ImmobilienWriter() {
		// Trennzeichen pro Zelle
		this.delimiter = ";";
		// Zeilenumbruch (neue Zeile = ENTER)
		this.lineBreak = "\n";
	}
	
	/**
	 * diese mthode schreibt alle wohnung in eine CSV datei
	 * @param wohnungList die liste der Wohnungen
	 * @param fileName der datei name mit vollem Pfad
	 */
	public void writeWohnungenToCsV(ArrayList<Wohnung> wohnungList, String fileName) {
		try {
			File f = new File(fileName);
			BufferedWriter out = new BufferedWriter(new FileWriter(f));
			out.write(this.createHeaderAsCSVString());
			for (Wohnung w : wohnungList) {
				out.write(this.createWohnungAsCSVString(w));
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private String createHeaderAsCSVString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Name");
		buffer.append(this.delimiter);
		buffer.append("Stadt");
		buffer.append(this.delimiter);
		buffer.append("Baujahr");
		buffer.append(this.delimiter);
		buffer.append("Quadratmeter");
		buffer.append(this.delimiter);
		buffer.append("Balkon");
		buffer.append(this.delimiter);
		buffer.append("Zimmer");
		buffer.append(this.delimiter);
		buffer.append("Gesamtmiete");
		buffer.append(this.delimiter);
		buffer.append("Kaltmiete");
		buffer.append(this.delimiter);
		buffer.append("Nebenkosten");
		buffer.append(this.delimiter);
		buffer.append("Gesamtmiete pr QM");
		buffer.append(this.lineBreak);
		return buffer.toString();
	}
	
	private String createWohnungAsCSVString(Wohnung wohnung) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(wohnung.getName());
		buffer.append(this.delimiter);
		buffer.append(wohnung.getStadt());
		buffer.append(this.delimiter);
		buffer.append(wohnung.getBaujahr());
		buffer.append(this.delimiter);
		buffer.append(wohnung.getQuadratMeter());
		buffer.append(this.delimiter);
		buffer.append(wohnung.isBalkon());
		buffer.append(this.delimiter);
		buffer.append(wohnung.getAnzahlZimmer());
		buffer.append(this.delimiter);
		buffer.append(wohnung.getGesamtMiete());
		buffer.append(this.delimiter);
		buffer.append(wohnung.getKaltMiete());
		buffer.append(this.delimiter);
		buffer.append(wohnung.getNebenKosten());
		buffer.append(this.delimiter);
		buffer.append(wohnung.getGesamtmieteProQuadratmeter());
		buffer.append(this.lineBreak);
		return buffer.toString();
	}

}
