package fr.banque;

public class CompteASeuilRemunere extends CompteASeuil implements ICompteRemunere{

	//attributs
		private double taux;
		
	//constructors
	public CompteASeuilRemunere() {
		super();
	}
	
	public CompteASeuilRemunere(int numero, double solde, double seuil ) {
		super(numero, solde, seuil);
		
	}
		
	public CompteASeuilRemunere(int numero, double solde, double seuil, double taux) {
		super(numero, solde, seuil);
		this.taux = taux;
	}
	
	//getters setters
	@Override
	public double getTaux() {
		return taux;
	}

	@Override
	public void setTaux(double taux) {
		this.taux = taux;
	}

	//methods
	@Override
	public void retirer(double unMontant) throws BanqueException{
		if ((this.getSolde() - unMontant) < this.getSeuil()) {
			throw new BanqueException("Retrait impossible");
		}else {
			super.retirer(unMontant);
		}
	}

	@Override
	public double calculerInterets(double taux) {
		double interets = (this.taux * this.getSolde());
		System.out.println(interets);
		return interets;
	}

	@Override
	//ajouter les interets au compte
	public void verserInterets(double taux) {
		this.setSolde((this.getSolde() * this.taux) + this.getSolde());
	}

	@Override
	public String toString() {
		return "CompteASeuilRemunere [solde=" + this.getSolde() + ", numero=" + this.getNumero() + ",seuil=" + this.getSeuil() + ", taux=" + this.taux + "]";
	}
	
	






	

}
