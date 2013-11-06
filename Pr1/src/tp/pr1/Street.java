package tp.pr1;

public class Street {
	private Place Plaza;
	private Direction Dir;
	private Place Plaza2;
	
	/**
	 * Constructora que recibe dos place y una directión
	 * @param p1 - Origen de la calle
	 * @param d - Dirección de la calle
	 * @param p2 - Destino de la calle
	 */

	public Street(Place p1, Direction d, Place p2)
	{
		this.Dir=d;
		this.Plaza=p1;
		this.Plaza2=p2;
	}
	
	/**
	 * Comprueba si hay Street desde place donde esta el robot y la direccition a la que mira el robot, devolviendo true en caso de que exista la calle y false en caso contrario 
	 * @param place - Place donde esta el robot
	 * @param whichDirection - Direction a la que mira el robot
	 * @return - True en caso que haya street y false en caso contrario
	 */
	
	public boolean comeOutFrom (Place place, Direction whichDirection)
	{
		if (place == this.Plaza)
		return (whichDirection==this.Dir);
		else if (place == this.Plaza2)
		return whichDirection.opposite(whichDirection)==this.Dir;
		else
		return false;
	}
	
	/**
	 * Recibiendo un Place devuelve el destino de la street
	 * @param whereAmI - Place del origen de la calle
	 * @return - Place destino de la Street
	 */
	
	public Place nextPlace (Place whereAmI)
	{
		if(this.Plaza==whereAmI)
			return this.Plaza2;
		else if (this.Plaza2==whereAmI)
			return this.Plaza;
		else return null;
	}
	
	/**
	 * Devuelve el origen de la street
	 * @return - Origen ce la street
	 */
	
	public Place getPlace1()
	{
		return this.Plaza;
	}
	
	/**
	 * Devuelve el destino de la street
	 * @return - Destino de la street
	 */
	
	public Place getPlace2()
	{
		return this.Plaza2;
	}
	
	/**
	 * Devuelve la direction de la street
	 * @return - Direction de la street
	 */
	
	public Direction getDirection()
	{
		return this.Dir;
	}
	
}
