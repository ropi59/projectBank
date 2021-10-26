package fr.banque;

import java.util.Objects;


public class Compte {

	//attributs
	private double solde;
	private int numero;
	
	//constructors
	public Compte() {
		super();
	}
	
	public Compte(int numero, double solde ) {
		super();
		this.numero = numero;
		this.solde = solde;
	}

	//getters setters
	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	//methods
	//ajouter de l'argent
	public void ajouter(double unMontant) {
		this.setSolde(this.getSolde() + unMontant);
	}
	
	//retirer de l'argent si il en reste assez sur le compte
	public void retirer(double unMontant) throws BanqueException {
		if (unMontant > this.getSolde()) {
			throw new BanqueException("Le montant de retrait ne peux pas etre superieur au solde du compte");
		}else {
			this.setSolde(Math.round(this.getSolde() - unMontant));	
		}
		
	}

	

	@Override
	public String toString() {
		return "Compte [solde=" + this.getSolde() + ", numero=" + this.getNumero() + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(numero, solde);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compte other = (Compte) obj;
		return numero == other.numero && Double.doubleToLongBits(solde) == Double.doubleToLongBits(other.solde);
	}
	
	
}
