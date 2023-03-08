package it.polito.tdp.libretto.model;

import java.util.ArrayList;
import java.util.List;

public class Libretto {
	
	private List<Voto> voti;
	
	public Libretto() {
		this.voti = new ArrayList<Voto>();
	}
	
	/**
	 * Aggiungi un nuovo voto al libretto 
	 * (per ora non fa nessun controllo)
	 * @param v il Voto da aggiungere
	 * @return true
	 */
	public boolean add(Voto v) {
		return this.voti.add(v);
	}
	/*
	public void add(String corso, int punti, LocalDate data) {}
	*/
	// tra i due metodi è meglio usare la prima, perchè un giorno potrei voler modificare
	// la classe voto, quindi è molto meglio avere meno dipendenze possibili dai parametri
	
	public void stamp() {
		for(Voto vi: this.voti) {
			System.out.println(vi);
		}
	}
	
	public void stampaPuntiUguali(int valore) {
		for(Voto vi: this.voti) {
			if(vi.getPunti() == valore) {
				System.out.println(vi);
			}
		}
	}
}
