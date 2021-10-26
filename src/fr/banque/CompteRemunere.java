package fr.banque;

public class CompteRemunere extends Compte implements ICompteRemunere{

	//attributs
	private double taux;
	
	//constructors
	public CompteRemunere() {
		super();
	}
	
	public CompteRemunere(int numero, double solde, double taux) throws BanqueException{
		super(numero, solde);
		this.setTaux(taux);
	}
	
	//getters setters
	public double getTaux() {
		return taux;
	}

	//verifier si le taux est entre 0 et 1 avant de le seter
	public void setTaux(double taux) throws BanqueException{
		if (taux > 1) {
			throw new BanqueException("Le taux est trop important, il doit etre inférieur à 1");
		}else if (taux <0) {
			throw new BanqueException("Le taux ne peut pas etre négatif");
		}else {
		this.taux = taux;
		}
	}
	
	//methods
	public double calculerInterets(double taux) {
		double interets = (this.taux * this.getSolde());
		System.out.println(interets);
		return interets;
	}
	
	//ajouter les interets au compte
	public void verserInterets(double taux) {
		this.setSolde((this.getSolde() * this.getTaux()) + this.getSolde());
	}

	@Override
	public String toString() {
		return "CompteRemunere [solde=" + this.getSolde() + ", numero=" + this.getNumero() + ",taux=" + taux + "]";
	}





	
	
}
