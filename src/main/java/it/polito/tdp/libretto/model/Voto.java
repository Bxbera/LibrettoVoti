package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class Voto {
	private String corso;
	private int punti; // da 18 a 31
	private LocalDate dataEsame;
	public Voto(String corso, int punti, LocalDate dataEsame) {
		super();
		this.corso = corso;
		this.punti = punti;
		this.dataEsame = dataEsame;
	}
	
	/**
	 * Questo è il copy costructor, che prende un oggetto dello stesso tipo e lo copia
	 * @param v
	 */
	public Voto(Voto v) {
		this.corso = v.corso;
		this.punti = v.punti;
		this.dataEsame = v.dataEsame;
	}
	public String getCorso() {
		return corso;
	}
	public void setCorso(String corso) {
		this.corso = corso;
	}
	public int getPunti() {
		return punti;
	}
	public void setPunti(int punti) {
		this.punti = punti;
	}
	public LocalDate getDataEsame() {
		return dataEsame;
	}
	public void setDataEsame(LocalDate dataEsame) {
		this.dataEsame = dataEsame;
	}
	
	@Override
	public String toString() {
		return corso + " ( "+punti+" punti) " + dataEsame;
	}
	
	/**
	 * Confronta due oggetti Voto in base al nome del corso e al punteggio, per vedere se è un duplicato
	 * @param altro, un altro oggetto Voto
	 * @return true se i due oggetti sono equivalenti per quegli attributi, false se non lo sono
	 */
	public boolean confrontaVotoPerEsameEPunti(Voto altro) {
		if(this.corso.equals(altro.getCorso()) && this.punti == altro.getPunti()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Confronta due oggetti Voto in base al nome del corso e al punteggio, per vedere se c'è un conflitto
	 * cioè stesso corso e diverso voto
	 * @param altro, un altro oggetto Voto
	 * @return true se i due oggetti sono equivalenti per quegli attributi, false se non lo sono
	 */
	public boolean isConflitto(Voto altro) {
		if(this.corso.equals(altro.getCorso()) && this.punti != altro.getPunti()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Metodo che fa una copia di questo oggetto voto
	 */
	public Voto clone() {
		return new Voto(this.corso, this.punti, this.dataEsame);
	}
	
	
}
