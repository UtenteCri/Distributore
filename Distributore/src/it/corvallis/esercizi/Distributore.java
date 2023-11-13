package it.corvallis.esercizi;

public abstract class Distributore implements Comparable<Distributore> {
	protected String proprietario;
	protected String citta;
	protected String nome_distributore;
	protected int serbatoio;
	protected float prezzo;

	public Distributore(String proprietario, String citta, String nome_distributore, int serbatoio,
			float prezzo) {
		super();
		this.proprietario = proprietario;
		this.citta = citta;
		this.nome_distributore = nome_distributore;
		this.serbatoio = serbatoio;
		this.prezzo = prezzo;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	public int getSerbatorio() {
		return serbatoio;
	}

	public void setSerbatorio(int serbatorio) {
		this.serbatoio = serbatorio;

	}

	public void erogazione(int quantita) throws DistributoreException {
		if (controllo(quantita) == -1) {
//				System.out.println("litri in serbatoio non sufficienti");
			throw new DistributoreException("litri in serbatoio non sufficienti");
		}
		if (controllo(quantita) == 1) {
			serbatoio = serbatoio - quantita;
			System.out.printf("ho erogato: %d l;  costo: EUR %.2f\n", quantita, quantita * prezzo);
		}

	}

	private int controllo(int quantita) {
		if (this.serbatoio < quantita) {
			return -1;
		}
		if (this.serbatoio == quantita) {
			return 0;
		}
		return 1;
	}

	private boolean controlloBoolean(int quantita) {
		boolean controllo = false;

		if (this.serbatoio < quantita) {
			controllo = false;
		} else if (this.serbatoio == quantita) {
			controllo = true;
		}

		return controllo;
	}

	public String getProprietario() {
		return proprietario;
	}

	public String getCittà() {
		return citta;
	}

	public String getNome_distributore() {
		return nome_distributore;
	}

	@Override
	public int compareTo(Distributore o) {
		if (serbatoio > o.serbatoio) {
			return 1;
		}
		if (serbatoio < o.serbatoio) {
			return -1;
		}
		return 0;
	}
}
