package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		/* LinkedHashMap mantem os elementos na ordem que são adicionados
		 * containsKey(nome) verifica se contem a chave no map
		 * put(key, valor) adiciona elemento ao map
		 * get(key) mostra o valor contido na chave
		 * keySet() cria um set com as chaves do map
		 * size() retorna o tamanho do map*/

		Scanner sc = new Scanner(System.in);
		
		//pega o caminho do arquivo a ser lido
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();
		
		Map<String, Integer> cand = new LinkedHashMap<>();
		
		//abre o arquivo
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String line = br.readLine();//ler a primeira linha do arquivo
			
			while (line != null){//se tiver linha no arquivo
				String[] fields = line.split(",");//separa a linha do arquivo pela ","
				String nome = fields[0];//salva o nome
				Integer count = Integer.parseInt(fields[1]);//salva os votos
		
				if(cand.containsKey(nome)) {//se o nome ja tiver no map
					int votesSorFar = cand.get(nome);//pega o valor da chave passado no parametro
					cand.put(nome, count + votesSorFar);//adiciona ja existente ao valor novo
				}
				else {//se nao tiver 
					cand.put(nome, count);//salva normalmente no map
				}
				line = br.readLine();//ler a proxima linha
				
			}
			
			for(String key : cand.keySet()) {//pra cada chave no set de chaves
				
				System.out.println(key + ": " + cand.get(key));
			}
		}
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		
		sc.close();
	}

}
