package pruebaBusca;
import java.util.*;
public class Test_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String jug = "";
		int n = 0;
		System.out.println("Introduzca usuario (si no quiere enter): ");
		jug = s.nextLine();
		System.out.println("Introduzca nivel (1,2,3): ");
		n = s.nextInt();
		Tablero t = new Tablero(n);
		t.setJugador(jug);

	}

}
