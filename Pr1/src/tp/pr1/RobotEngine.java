package tp.pr1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RobotEngine {
	private Interpreter interprete;
	private Place plazaInicial;
	private Direction direccion;
	private ArrayList<Street> mapa;
	
	/**
	 * Constructora del RobotEngine.
	 * @param p - Lugar donde esta el robot.
	 * @param d - Dirección a la que mira el robot.
	 * @param s - Mapa del mundo.
	 */
	
	public RobotEngine(Place p, Direction d, Street[] s)
	{	
		this.interprete= new Interpreter();
		this.direccion=d;
		this.mapa = new ArrayList<Street>(Arrays.asList(s));
		this.plazaInicial=p;
	}
	
	/**
	 * Este método inicializa el motor del robot , lee lo que el usuario escribe por consola, interpreta lo introducido por el usuario, comprueba donde está el robot y en caso de estar en la MotherShip finaliza o recibiendo quit finaliza
	 */
	
	public void startEngine()
	{
		String r=this.plazaInicial.toString();
		mostrarPantalla(r);
		Instruction ins=null;
		boolean quit = false;
		while (!this.plazaInicial.isSpaceship() && !quit)
		{
			r=this.dondeMira();
			mostrarPantalla(r);
			mostrarPrompt();
			String l =leerString();
			ins=Interpreter.generateInstruction(l);
			if (!ins.isValid())
			{
				System.out.println("WALL·E says: I do not understand. Please repeat");
			}
			else
			{
				quit=this.processInstruction(ins);
				if (quit)
				{
					mostrarPantalla("WALL·E says:I understand the instruction QUIT . Bye bye.");
				}
			}
		}
		if(this.plazaInicial.isSpaceship())
		{
			mostrarPantalla("WALL·E says: I am at my spaceship. Shutting down... Bye bye");
		}
	}
	
	/**
	 * Lee lo que escribe el usuario por consola y lo guarda en un string
	 * @return - Devuelve un string con lo escrito por el usuario
	 */
	
	private static String leerString() 
	{
		Scanner sc = new Scanner(System.in);
		String a= sc.nextLine();
		return a;
	}
	
	/**
	 * Muesra por pantalla lo que tiene el string a
	 * @param a - String a escribir por pantalla
	 */
	
	private static  void mostrarPantalla(String a)
	{
		System.out.println(a);
	}
	
	/**
	 * Escribe en la consola a donde esta mirando el robot
	 * @return - Dirección a la que esta mirando el robot
	 */
	
	private String dondeMira() 
	{
		return "WALL·E is looking at direction " + this.direccion.toString();
	}
	
	/**
	 * Dada una instruction la interpreta y la ejecuta, devolviendo true en caso que la instruction sea quit y false en caso contrario
	 * @param i - Instruction a ejecutar
	 * @return - Devuelve true en caso que i==true y false en otro caso
	 */
	
	private boolean processInstruction(Instruction i)
	{
		if(i.getAction()==Action.QUIT) return true;
		else if (i.getAction()==Action.HELP)
		{
			processInstructionHelp();
			return false;
		}
		else if (i.getAction()==Action.TURN)
		{
			if (i.getRotation()==Rotation.LEFT)
			{
				this.direccion= this.direccion.turnLeft(this.direccion);
			}
			
			if (i.getRotation()==Rotation.RIGHT)
			{
				this.direccion=this.direccion.turnRight(this.direccion);
			}
			return false;
		}
		else if (i.getAction()==Action.MOVE)
		{
			
			Street s = this.dondeEstoy(this.plazaInicial);
			if (s!=null)
			{
				this.plazaInicial=s.nextPlace(this.plazaInicial);
				System.out.println("WALL·E says: Moving in direction " + this.direccion.toString());
				System.out.println(this.plazaInicial.toString());
			}
			else
			{
				mostrarPantalla("WALL·E says: Uff This street is blocked, I'm sorry, but i can't move in this direction");
			}
			return false;
		}
		else return false;
	}
	
	/**
	 * Comprueba si hay una street desde el place donde estoy en la dirección en la que está mirando el robot, devolviendo true en caso de que exista y false en caso contrario
	 * @param p - Place donde esta situado el robot
	 * @return - Devuelve true si existe la Street en la dirección que mira el robot y false en caso contrario
	 */
	
	private Street dondeEstoy(Place p)
	{
		int i=0;
		Street esta=null;
		boolean ya=false;
		Direction op = this.direccion.opposite(this.direccion);
		while(!ya && i<this.mapa.size())
		{
			if (this.mapa.get(i).getPlace1().equals(p) && this.mapa.get(i).getDirection()==this.direccion)
			{
				esta=this.mapa.get(i);
				ya=true;
			}
			if (this.mapa.get(i).getPlace2().equals(p) && this.mapa.get(i).getDirection()==op)
			{
				esta=this.mapa.get(i);
				ya=true;
			}
			i++;
		}
		return esta;
	}
	
	/**
	 * Muestra por consola la help del robot
	 */
	
	private static void processInstructionHelp()
	{
		mostrarPantalla( "The valid instructions for WALL·E are:");
		mostrarPantalla ( Interpreter.interpreterHelp());
	}
	
	/**
	 * Muestra por pantalla el prompt del robot
	 */
	
	private static void mostrarPrompt() 
	{
		mostrarPantalla("WALL·E >");
	}
}
