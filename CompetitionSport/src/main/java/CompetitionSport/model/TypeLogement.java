package CompetitionSport.model;

public enum TypeLogement {

Camping(100), Hotel(1000), Villa(10), Village_Vacances(500);
	
	private int capaciteLogement;
	
	private TypeLogement (int capaciteLogement)
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
