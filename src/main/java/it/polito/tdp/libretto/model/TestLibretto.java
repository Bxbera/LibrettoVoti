package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class TestLibretto {

	public static void main(String[] args) {
		
		Libretto lib = new Libretto();
		
		
		lib.add(new Voto("Analisi 1", 29, LocalDate.of(2021,  2, 15)));
		lib.add(new Voto("Fisica 1", 27, LocalDate.of(2022,  1, 20)));
		lib.add(new Voto("Fisica 3", 27, LocalDate.of(2022,  1, 20)));
		lib.add(new Voto("Chimica", 20, LocalDate.of(2021,  2, 24)));
		lib.add(new Voto("Informatica", 29, LocalDate.of(2021,  5, 16)));
		lib.stamp();
		//lib.stampaPuntiUguali(29);
		//System.out.println(lib.cercaVotoPerCorso("Analisi 1"));
		Voto copia1 = new Voto("Analisi 1", 18, LocalDate.of(2021,  2, 15));
		Voto copia2 = new Voto("Analisi 1", 18, LocalDate.of(2021,  2, 15));
		//System.out.println(lib.isVotoPresente(copia1));
		//System.out.println(copia1.confrontaVotoPerEsameEPunti(copia2));
		//System.out.println(lib.add(copia1));
		
		Libretto migliore = lib.librettoMigliorato();
		
		System.out.println("Libretto con voti maggiori di 28");
		lib.cancellaVotiInferiori(28);
		lib.stamp();
		//migliore.stamp();
	}

}
