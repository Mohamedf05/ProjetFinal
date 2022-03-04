package util;

public class Context {

	private static Context _singleton;
	
	
	//Ici mettre: Attributs DAO en private 
	
	
	private Context () {}
	
	public static Context getSingleton() 
	{
		if(_singleton==null) 
		{
			_singleton=new Context();
		}
		
		return _singleton;
	}
	
	
	// Ici mettre : Getters et Setters DAO
}
