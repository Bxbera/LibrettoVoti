package it.polito.tdp.libretto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Libretto {
	
	private List<Voto> voti;
	
	public Libretto() {
		this.voti = new ArrayList<Voto>();
	}
	
	/**
	 * Aggiungi un nuovo voto al libretto 
	 * l'implementazione con la mappa sarebbe molto più efficente, perchè non deve fare un controllo su tutta la lista, ma vede
	 * subito se un voto è presente, dato che la chiave sarebbe il nome del corso
	 * @param v il Voto da aggiungere
	 * @return true se sono riuscito ad aggiungerlo, (false altrimenti, poteva essere un altro caso, 
	 * ma con un metodo del genere è meglio mandare un'eccezione, perchè l'utente del metodo non controlla
	 * generalmente questo valore di ritorno) oppure scatena un'eccezione
	 */
	public boolean add(Voto v) {
		if(this.isVotoPresente(v)) {
			throw new IllegalArgumentException("Voto errato: " + v);
		}
		else {
			return this.voti.add(v);
		}		
	}
	/*
	public void add(String corso, int punti, LocalDate data) {}
	*/
	// tra i due metodi è meglio usare la prima, perchè un giorno potrei voler modificare
	// la classe voto, quindi è molto meglio avere meno dipendenze possibili dai parametri
	
	/**
	 * Stampa tutti gli oggetti Voto presenti nella lista voti
	 */
	public void stamp() {
		for(Voto vi: this.voti) {
			System.out.println(vi);
		}
	}
	
	/**
	 * Stampa l'oggetto voto in modo completo, se i punti conincidono con il parametro passato
	 * @param valore il punteggio ottenuto all'esame
	 */
	public void stampaPuntiUguali(int valore) {
		for(Voto vi: this.voti) {
			if(vi.getPunti() == valore) {
				System.out.println(vi);
			}
		}
	}
	
	/**
	 * Ritorna l'oggetto Voto che ha l'attributo corso uguale al parametro
	 * @param corso la stringa con il nome del corso
	 * @return	l'oggetto Voto che ha l'attributo corso uguale al parametro oppure null (o una eccezione)
	 */
	public Voto cercaVotoPerCorso(String corso) {
		for(Voto vi: this.voti) {
			if(vi.getCorso().equals(corso)) {
				return vi;				
			}
		}
		return null;
		// al posto di null potrei far partire un'eccezione NullPointerException, 
		//così obbligo chi usa questo metodo a gestirla
	}
	
	/**
	 * Controlla se un voto è già presente nel libretto, cioè se hanno la stessa variabile che specifica il corso
	 * @param v, è l'oggetto Voto
	 * @return true se è già presente, false altrimenti
	 */
	public boolean isVotoPresente(Voto v) {
		for(Voto vi: this.voti) {
			if(vi.getCorso().equals(v.getCorso())) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * E' un metodo di "factory", chiamo un metodo che mi restituisca un altro oggetto già con certi dati; serve per creare
	 * un nuovo libretto con i nomi migliorati
	 * @return
	 */
	public Libretto librettoMigliorato() {
		Libretto migliore = new Libretto();
		// migliore.voti = this.voti;  // qui è sbagliato perchè sto creando un alias dei libretto; il problema è che quando aggiorno uno
		// aggiornerei anche l'altro, cosa che non voglio!! Quindi devo clonarla
		// migliore.voti = new ArrayList<>(this.voti);	// questo tipo di clone però condivide gli stessi oggetti, se volessi modificarli indipendentemente devo proprio crearne di nuove copie
		
		/*
		 * Qui sto facendo una clone separato dall'oggetto clonato, per farlo devo controllare che gli oggetti che clono non abbiano altri oggetti all'interno, altrimenti si verificherebbe ciò che 
		 * non volevo fare con l'oggetto Voto; scelgo di far fare la new all'interno della classe voto 
		 */
		for(Voto vi: this.voti) {
			// migliore.voti.add(vi.clone());		// con un metodo di Voto
			migliore.voti.add(new Voto(vi));		// con il copy constructor
		}
		
		for(Voto v : migliore.voti) {
			v.setPunti(v.getPunti()+2);
		}
		return migliore;
	}
	
	public void cancellaVotiInferiori(int punti) {
		List<Voto> daCancellare = new ArrayList<>();
		// in entrambe le iterazioni non sto modificando la lista che itero
		for(Voto v : this.voti) {
			if(v.getPunti()<punti) {
				daCancellare.add(v);
			}
		}
		
		for(Voto v1: daCancellare) {
			this.voti.remove(v1);
		}
		
		// Meglio: this.voti.removeAll(daCancellare);
	}
	
	public Libretto librettoOrdinatoPerNome() {
		Libretto ordinato = new Libretto();
		ordinato.voti = new ArrayList<>(this.voti);
		
		ordinato.voti.sort(new ComparatorByName());
		Collections.sort(ordinato.voti, new ComparatorByName());
		
		return ordinato;
	}
	
	public Libretto librettoOrdinatoPerVoto() {
		Libretto ordinato = new Libretto();
		ordinato.voti = new ArrayList<>(this.voti);
		
		ordinato.voti.sort(new Comparator<Voto>() {
			@Override
			public int compare(Voto o1, Voto o2) {
				return o2.getPunti() - o1.getPunti();
			}
		});
		
		return ordinato;
	}

	@Override
	public String toString() {
		String txt = "";
		for(Voto v: voti) {
			txt += v.toString() + "\n";
		}
		
		return txt;
	}
}
