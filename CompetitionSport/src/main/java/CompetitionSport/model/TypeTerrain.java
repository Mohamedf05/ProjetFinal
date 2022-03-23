package CompetitionSport.model;

public enum TypeTerrain {

Courts(300), Dojo(80), Gymnase(1000), Hippodrome(500), Piscine(100), Piste(5000), Skatepark(200), Stade(20000), Velodrome(10000);
	
	private int capaciteTerrain;
	
	private TypeTerrain (int capaciteTerrain)
	{
		this.capaciteTerrain = capaciteTerrain;
	}

	public int getCapaciteTerrain() {
		return capaciteTerrain;
	}

	public void setCapaciteTerrain(int capaciteTerrain) {
		this.capaciteTerrain = capaciteTerrain;
	}
	
	
	
}
