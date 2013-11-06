package tp.pr1;
import tp.pr1.Action;
import tp.pr1.Rotation;


public class Instruction {
	private Action accion;
	private Rotation rotacion;
	
	/**
	 * Constructora por defecto. Devuelve acción y rotación a UNKNOWN
	 */
	public Instruction()
	{
		this.accion = Action.UNKNOWN;
		this.rotacion = Rotation.UNKNOWN;		
	}
	
	/**
	 * Constructora que recibe una Action y genera la rotación a UNKNOWN.
	 * @param a - Acción de la instrucción
	 */
	
	public Instruction (Action a)
	{
		this.accion = a;
		this.rotacion = Rotation.UNKNOWN;
	}
	
	/**
	 * Contructora que recibe una Action y una Rotation.
	 * @param a - Acción de la instrucción.
	 * @param r - Rotación de la instrucción.
	 */
	
	public Instruction (Action a, Rotation r)
	{
		this.accion=a;
		this.rotacion=r;
	}
	
	
	/**
	 * Comprueba que la instrucción sea correcta y no sea Action y Rotation UNKNOWN.
	 * @return devuelve true si la instrucción es valida y devuelve false si la instrucción no sea valida: Action = UNKNOWN o Action = TURN y Rotation = UNKNOWN.
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
	 * Devuelve la acción
	 * @return - Devuelve la acción.
	 */
	public Action getAction()
	{ 
		return this.accion;
	}
	
	/**
	 * Devuelve la rotación.
	 * @return - Devuelve la rotación.
	 */
	
	public Rotation getRotation()
	{
		return this.rotacion;
	}
	
	/**
	 * Modifica la acción de la instrucción
	 * @param a - Acción que quieres meter a la instrucción
	 */
	
	public void setAction(Action a)
	{
		this.accion=a;
	}
	
	/**
	 * Modifica la rotación de la instrucción
	 * @param d - Rotación que quieres meter en la instrucción.
	 */
	
	public void setDirection(Rotation d)
	{
		this.rotacion=d;
	}
	
	
	
}
