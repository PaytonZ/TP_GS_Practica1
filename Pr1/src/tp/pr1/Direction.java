package tp.pr1;

public enum Direction {EAST, NORTH, SOUTH, WEST, UNKNOWN;

	/**
	 * Devuelve la direcci�n opuesta a la recibida.
	 * @param d - Recibe una direcci�n.
	 * @return - Devolvemos la direcci�n opuesta.
	 */

	public Direction opposite( Direction d)
	{
		switch (d)
		{
		case EAST: d=Direction.WEST; break;
		case WEST: d=Direction.EAST; break;
		case NORTH: d=Direction.SOUTH; break;
		case SOUTH: d=Direction.NORTH; break;
		case UNKNOWN: d=Direction.UNKNOWN; break;
				
		}
		return d;		
	}
	
	/**
	 * Recibe una direcci�n y devuelve la direcci�n tras girar a la izquierda.
	 * @param d - Recibe una direcci�n.
	 * @return - Devuelve la direcci�n tras girar a la izquierda.
	 */
	
	public Direction turnLeft( Direction d)
	{
		switch (d)
		{
		case EAST: d=Direction.NORTH; break;
		case WEST: d=Direction.SOUTH; break;
		case NORTH: d=Direction.WEST; break;
		case SOUTH: d=Direction.EAST; break;
		case UNKNOWN: d=Direction.UNKNOWN; break;
				
		}
		return d;		
	}
	
	/**
	 * Recibe una direcci�n y devuelve la direcci�n tras girar a la derecha.
	 * @param d - Recibe una direcci�n.
	 * @return - Devuelve la direcci�n tras girar a la derecha.
	 */
	
	public Direction turnRight( Direction d)
	{
		switch (d)
		{
		case EAST: d=Direction.SOUTH; break;
		case WEST: d=Direction.NORTH; break;
		case NORTH: d=Direction.EAST; break;
		case SOUTH: d=Direction.WEST; break;
		case UNKNOWN: d=Direction.UNKNOWN; break;
				
		}
		return d;		
	}
	
	/**
	 * Convierte el enumerado Direction a un String para poder luego mostrarlo por pantalla.
	 */
	
	public String toString()
	{
		if(this==EAST)
		{
			return "EAST";
		}
		if (this==NORTH)
		{
			return "NORTH";
		}
		if (this==SOUTH)
		{
			return "SOUTH";
		}
		else 
			return "WEST";
	}
}
