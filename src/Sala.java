import com.senac.SimpleJava.Console;

public class Sala {
	
	private int[] exits = new int[6];
	public void addExit(String directionExit, String room){
		//	exits[directionExit] = room;
			//informar a direcao de saida se haver� saida ou n�o para cada posicao, cima, baixo, esq, dir, sobe ou desce
		Console.println(directionExit,"- DIRECAO  ",room, " - ROOM");
	}
}
