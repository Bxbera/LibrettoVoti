package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class TestLibretto {

	public static void main(String[] args) {
		
		Libretto lib = new Libretto();
		
		lib.add(new Voto("Analisi 1", 29, LocalDate.of(2021,  2, 15)));
		lib.add(new Voto("Fisica 1", 29, LocalDate.of(2022,  1, 20)));
		//lib.stamp();
		lib.stampaPuntiUguali(29);
	}

}
