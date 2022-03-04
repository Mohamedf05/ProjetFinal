package model;

public enum Logement {

Camping(100), Hotel(1000), Villa(10), Village_Vacances(500);
	
	private int capaciteLogement;
	
	private Logement (int capaciteLogement)
	{
		this.capaciteLogement = capaciteLogement;
	}

	public int getCapaciteLogement() {
		return capaciteLogement;
	}

	public void setCapaciteLogement(int capaciteLogement) {
		this.capaciteLogement = capaciteLogement;
	}


	
	
}
