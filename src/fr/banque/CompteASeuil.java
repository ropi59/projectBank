package fr.banque;

public class CompteASeuil extends Compte implements ICompteASeuil{

	//attributs
	private double seuil;
	
	//constructors
	public CompteASeuil() {
		super();
	}
	
	public CompteASeuil(int numero, double solde, double seuil ) {
		super(numero, solde);
		this.seuil = seuil;
	}
	
	//getters setters
	public double getSeuil() {
		return seuil;
	}

	public void setSeuil(double seuil) {
		this.seuil = seuil;
	}
	
	//methods
	//retirer tant que l'on ne depasse pas le seuil
	public void retirer(double unMontant) throws BanqueException{
		if ((this.getSolde() - unMontant) < this.getSeuil()) {
			throw new BanqueException("Retrait impossible");
		}else {
			super.retirer(unMontant);
		}
	}

	@Override
	public String toString() {
		return "CompteASeuil [solde=" + this.getSolde() + ", numero=" + this.getNumero() + ",seuil=" + this.seuil + "]";

	}



	
	
	
}
