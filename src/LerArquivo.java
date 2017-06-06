import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.senac.SimpleJava.Console;

public class LerArquivo {
	public void run(){
		//printArchive();
		//Console.println(findRoom("room 10"));
		Rooms();
	}
	public Sala[] rooms = new Sala[32];
	
	public void Rooms(){
		String direction;
		int exit;
		int roomCount = 0;
		String linha = null;
		try{
			Scanner arq = new Scanner(new File("data/Labirinto.txt"));
			linha = arq.next();
			Console.println(linha, "LINHA");
			while(linha.equalsIgnoreCase("room")){
				roomCount = arq.nextInt();
				rooms[roomCount] = new Sala();
				//While para repetir a quantidade de salas(saidas) que houver
				while(arq.hasNext()){
					direction = arq.next();
					if(direction.equalsIgnoreCase("room")){
						break;
					}else{
						exit = arq.nextInt();
						rooms[roomCount].addExit(direction, exit);
					}
				}
				if(!arq.hasNext()){
					return;
				}
				
			}
			//fecha o arquivo
			arq.close();
		}catch (IOException ioe) {
			System.err.printf("Erro na abertura do arquivo: %s.\n",
					ioe.getMessage());
		}
	}
}

