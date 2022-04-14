package soprajc.CompetitionSpring.model;

public class JsonViews {

	public static class Common {

	};

	public static class EvenementWithOrganisateur extends Common {

	}
	public static class EvenementWithEpreuve extends Common {

	}

	public static class EpreuveWithAthlete extends Common {

	}
	public static class EpreuveWithEvenement extends Common {

	}

	public static class EpreuveWithReservation extends Common {

	}
	
	public static class AthleteWithEpreuve extends Common {

	}
	
	public static class CompteWithReservation {

	}
	
	public static class OrganisteurWithEvenements extends Common {

	}
	
	

	public static class AthleteEpreuve extends Common{
		
	}
	public static class ReservationWithEpreuve extends AthleteEpreuve {

	}
	
}
