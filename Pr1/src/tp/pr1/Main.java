package tp.pr1;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Street[] mapa = crearMapa();
		RobotEngine robot = new RobotEngine(mapa[4].getPlace1(), Direction.NORTH, mapa);
		robot.startEngine();
		
	}
	
	/**
	 * Genera el mapa del mundo por donde se movera el robot
	 * @return - Devuelve el mapa del mundo por donde se movera el robot
	 */
	
	private static Street[] crearMapa() 
	{
		Place p1 = new Place ("Plaza de España", false, "Es una plaza");
		Place p2 = new Place ("Callao", false, "Esta cerca de Sol");
		Place p3 = new Place ("Mayor", false,"Plaza mayor de Madrid");
		Place p4 = new Place ("Sol", false, "Es el centro de Madrid");
		Place p5 = new Place ("Jacionto Benavente", false, "Se le puso ese nombre en honor a un escritor");
		Place p6 = new Place ("Neptuno", false, "Donde se celebran los triunfos del ATM");
		Place p7 =new Place ("Atocha", false, "Donde se encuentra la esatcion de Atocha");
		Place p8 = new Place ("Cibeles", false, "Fuente con una señora y dos leones");
		Place p9 = new Place ("Colon", true, "Una plaza muy grande");
		Place p10= new Place ("Puerta de Alcala", true, "Un gran monumeto muy conocido");
		Street s[]=new Street[11];
		s[0]=new Street(p1, Direction.EAST, p2);
		s[1]=new Street(p1,Direction.SOUTH, p3);
		s[2]= new Street(p3, Direction.EAST,p4);
		s[3]=new Street(p2, Direction.SOUTH,p4);
		s[4]=new Street(p4, Direction.EAST,p8);
		s[5]=new Street(p4,Direction.SOUTH, p5);
		s[6]= new Street(p8,Direction.SOUTH,p6);
		s[7] = new Street(p5, Direction.EAST,p6);
		s[8] = new Street(p8,Direction.NORTH,p9);
		s[9] = new Street (p6, Direction.SOUTH,p7);
		s[10] = new Street (p8, Direction.EAST,p10);
		return s;
		
	}

}
