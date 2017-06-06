import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.senac.SimpleJava.Console;

public class LerArquivo {
	public void run(){
		//printArchive();
		//Console.println(findRoom("room 10"));
		Rooms();
	/*for(int i=0; i<20; i++){
		Console.println(rooms[i]);
	}*/
	}
	public void printArchive(){
		String linha = "ND";
		try{
			@SuppressWarnings("resource")
			Scanner arq = new Scanner(new File("data/Labirinto.txt")).useDelimiter("\n");
			while(arq.hasNext()){
				linha = arq.next();
				Console.println(linha);
			}
			arq.close();
			}catch (IOException ioe) {
				System.err.printf("Erro na abertura do arquivo: %s.\n",
						ioe.getMessage());
			}
	}
	@SuppressWarnings("resource")
	public String findRoom(String numRoom){
		String linha = "ND";
		try{
			Scanner arq = new Scanner(new File("data/Labirinto.txt")).useDelimiter("\n");
			while(arq.hasNext()){
				linha = arq.next();
				if(linha.startsWith(numRoom)){
					return linha;
				}
				
			}
			arq.close();
			}catch (IOException ioe) {
				System.err.printf("Erro na abertura do arquivo: %s.\n",
						ioe.getMessage());
			}
		return linha;
		
	}
	public Sala[] rooms = new Sala[32];
	
	public void Rooms(){
		String direction;
		String exit;
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
					
					exit = arq.next();
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

