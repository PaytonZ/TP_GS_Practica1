package tp.pr1;

public class Place {
	
	private String Lugar;
	private boolean MotherShip;
	private String Definicion;
	
	/**
	 * Contructora que crea un Place.
	 * @param l - Nombre del lugar.
	 * @param m - Si esta la Mothership o no.
	 * @param d - Descripción del lugar.
	 */
	
	public Place(String l, boolean m, String d)
	{
		this.Definicion=d;
		this.Lugar=l;
		this.MotherShip=m;
		
	}
	
	/**
	 * Comprueba si el lugar es la Mothership
	 * @return Devuelve true si el lugar es la Mothership y false en caso contrario.
	 */
	
	public boolean isSpaceship ()
	{
		return this.MotherShip;
	}
	
	/**
	 * Convierte el Place en un String para devolverlo por pantalla.
	 */
	
	public String toString()
	{
		return this.Lugar+ ":  " + this.Definicion;
	}

}
