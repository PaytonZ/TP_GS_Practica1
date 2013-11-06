package tp.pr1;
import tp.pr1.Action;
import tp.pr1.Rotation;


public class Instruction {
	private Action accion;
	private Rotation rotacion;
	
	/**
	 * Constructora por defecto. Devuelve acci�n y rotaci�n a UNKNOWN
	 */
	public Instruction()
	{
		this.accion = Action.UNKNOWN;
		this.rotacion = Rotation.UNKNOWN;		
	}
	
	/**
	 * Constructora que recibe una Action y genera la rotaci�n a UNKNOWN.
	 * @param a - Acci�n de la instrucci�n
	 */
	
	public Instruction (Action a)
	{
		this.accion = a;
		this.rotacion = Rotation.UNKNOWN;
	}
	
	/**
	 * Contructora que recibe una Action y una Rotation.
	 * @param a - Acci�n de la instrucci�n.
	 * @param r - Rotaci�n de la instrucci�n.
	 */
	
	public Instruction (Action a, Rotation r)
	{
		this.accion=a;
		this.rotacion=r;
	}
	
	
	/**
	 * Comprueba que la instrucci�n sea correcta y no sea Action y Rotation UNKNOWN.
	 * @return devuelve true si la instrucci�n es valida y devuelve false si la instrucci�n no sea valida: Action = UNKNOWN o Action = TURN y Rotation = UNKNOWN.
	 */
	
	public boolean isValid ()
	{
		if(this.accion==Action.UNKNOWN)
			return false;
		else if (this.accion==Action.TURN)
		{
			if (this.rotacion==Rotation.UNKNOWN)
				return false;
			else return true;
		} else return true;
	}
	
	/**
	 * Devuelve la acci�n
	 * @return - Devuelve la acci�n.
	 */
	public Action getAction()
	{ 
		return this.accion;
	}
	
	/**
	 * Devuelve la rotaci�n.
	 * @return - Devuelve la rotaci�n.
	 */
	
	public Rotation getRotation()
	{
		return this.rotacion;
	}
	
	/**
	 * Modifica la acci�n de la instrucci�n
	 * @param a - Acci�n que quieres meter a la instrucci�n
	 */
	
	public void setAction(Action a)
	{
		this.accion=a;
	}
	
	/**
	 * Modifica la rotaci�n de la instrucci�n
	 * @param d - Rotaci�n que quieres meter en la instrucci�n.
	 */
	
	public void setDirection(Rotation d)
	{
		this.rotacion=d;
	}
	
	
	
}
