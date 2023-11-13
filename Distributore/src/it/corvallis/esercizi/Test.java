package it.corvallis.esercizi;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		DistributoreBenzina distributore1 = new DistributoreBenzina("marco", "Lecce", "distributore economico", 50, 0);
		distributore1.setPrezzo(1);
		System.out.println(distributore1.getNome_distributore() + " " + distributore1.getCittà());
/*
		try {
			distributore1.erogazione(20);
		} catch (DistributoreException e) {
			System.out.println(e.getMessage());
		}
*/
		
		try {
			distributore1.erogazione(20);
		} catch (DistributoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		DistributoreBenzina distributore2 = new DistributoreBenzina("mario", "Lecce", "distributore caro", 50, 0);
		distributore2.setPrezzo(2);
		System.out.println("\n" + distributore2.getNome_distributore() + " " + distributore2.getCittà());

		try {
			distributore1.erogazione(60);
		} catch (DistributoreException e) {
			System.out.println(e.getMessage());
		}

		DistributoreDiesel distributore3 = new DistributoreDiesel("mario", "Lecce", "distributore caro", 50, 0);
		distributore3.setPrezzo(2);
		System.out.println("\n" + distributore3.getNome_distributore() + " " + distributore3.getCittà());

		try {
			distributore1.erogazione(60);
		} catch (DistributoreException e) {
			System.out.println(e.getMessage());
		}

		if (distributore1.compareTo(distributore2) == -1) {
			System.out.printf("\nil distriburore %s ha meno litri a disposizione di %s",
					distributore1.getNome_distributore(), distributore2.getNome_distributore());
		}
		if (distributore1.compareTo(distributore2) == 0) {
			System.out.println("i due distributori hanno lo stesso numero di litri a disposizione");
		}

		Distributore test = new DistributoreBenzina("mario", "Lecce", "distributore caro", 50, 0);
		Distributore test2 = new DistributoreDiesel("mario", "Lecce", "distributore caro", 50, 0);

		if (test instanceof DistributoreBenzina) {
			System.out.println("Prodotto: benzina");
		} else if (test instanceof DistributoreDiesel) {
			System.out.println("Prodotto: diesel");
		}

		if (test2 instanceof DistributoreBenzina) {
			System.out.println("Prodotto: benzina");
		} else if (test2 instanceof DistributoreDiesel) {
			System.out.println("Prodotto: diesel");
		}

		List<DistributoreBenzina> listaBenzina = new ArrayList<>();
		listaBenzina.add(distributore1);
		
		List<DistributoreDiesel> listaDiesel = new ArrayList<>();
		listaDiesel.add(distributore3);
		
		List<Distributore> distributori = new ArrayList<>();
		distributori.add(distributore1);
		distributori.add(distributore2);
		distributori.add(distributore3);
		distributori.add(test);
		distributori.add(test2);
		
		Distributore test3 = distributori.get(0);
		
		try {
			test3.erogazione(20);
		} catch (DistributoreException e) {
			System.out.println("Prodotto: diesel");
		}
	}

}
