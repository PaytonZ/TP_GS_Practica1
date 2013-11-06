package tp.pr1;

public class Interpreter {
	public static String LINE_SEPARATOR =
			System.getProperty("line.separator");
	
	public Interpreter()
	{

	}
	/**
	 * Con este método generamos la instruccion recibida por pantalla.
	 * Nos obligo a ponerlo en static, porque nos daba error sin el static.
	 * @param line - Recibimos el string introducido por el usuario por pantalla.
	 * @return - Devolvemos una intruccion generada a partir del string.
	 */
	public static Instruction generateInstruction(String line) 
	{
		String[] word = line.split(" ");
		int w= word.length;
		Action a = Action.UNKNOWN;
		Rotation r= Rotation.UNKNOWN;
		if (w==1)
		{
			if (word[0].equalsIgnoreCase("help"))
			{
				a=Action.HELP;
			}
			else if( word[0].equalsIgnoreCase("move"))
			{
				a=Action.MOVE;
			}
			else if (word[0].equalsIgnoreCase("quit"))
			{
				a=Action.QUIT;
			}
		}
		else if (w==2)
		{
			if(word[0].equalsIgnoreCase("turn"))
			{
				a=Action.TURN;
				if (word[1].equalsIgnoreCase("right") )
				{
					r=Rotation.RIGHT;
				}
				else if (word[1].equalsIgnoreCase("left"))
				{
					r=Rotation.LEFT;
				}
						
			}
		}
		
		Instruction i = new Instruction(a,r);
		return i;
	}
	
	/**
	 *  Devuelve una string con las instrucciones que entinde el robot
	 * @return - String con información de la instrucciones que comprende el robot.
	 */
	
	public static String interpreterHelp()
	{
		String s= "MOVE" + LINE_SEPARATOR + "TURN <LEFT/RIGHT>" + LINE_SEPARATOR +"HELP" +LINE_SEPARATOR +"QUIT ";
		return s;
	}
	
	
	
}
