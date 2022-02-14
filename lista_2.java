import java.util.Random;

class Main {

	static class Numeros {
		static public int geraNumero(Boolean positivos) { //Se positivos for true, apenas números positivos serão gerados. Caso contrário, números negativos e positivos poderão ser gerados, cada um com 50% de probabildiade
			Random gerador = new Random();
			if (positivos) {
				return gerador.nextInt(100) + 1;
			} else {
				int probabilidade = gerador.nextInt(2) + 1;
				if (probabilidade == 1) {
					return gerador.nextInt(100) + 1;
				} else {
					return (gerador.nextInt(100) + 1) * -1;
				}
			}
		}
	}

	static class VetorInteiros {
		static public void imprimeVetorInteiros(int vetor[], int numero_elementos) {
			for (int i = 0; i < numero_elementos; i++) {
				System.out.print(vetor[i]);
				if (i != vetor.length - 1) {
					System.out.print(" ");
				} else {
					System.out.print("\n");
				}
			}
		}
	}

	static class VetorDoubles {
		static public void imprimeVetorDoubles(double vetor[], int numero_elementos) {	
			for (int i = 0; i < numero_elementos; i++) {
				System.out.printf("%.3f", vetor[i]);
				if (i != vetor.length - 1) {
					System.out.print(" ");
				} else {
					System.out.print("\n");
				}
			}
		}	
	}

	static class Questao1 {
		public void rQ1() {
			int vetor[] = new int[10];
			double vetor_respostas[] = new double[10]; //O fato da divisão de dois inteiros gerarem um double requer que um vetor de respostas do tipo double seja criado para armazenar os resultados das divisões
			int maior_elemento = 0;
			double vetor_resposta[] = new double[10];
			int i = 0;
			//Geração dos números aleatórios para o vetor
			for (i = 0; i < 10; i++) {
				vetor[i] = Numeros.geraNumero(true);
			}
			//Impressão do vetor gerado
			VetorInteiros.imprimeVetorInteiros(vetor, 10);
			//Definição do maior elemento do vetor
			for (i = 0; i < 10; i++) {
				if (vetor[i] > maior_elemento) {
					maior_elemento = vetor[i];
				}
			}
			//Divisão de cada número do vetor original pelo maior número e armazenamento do resultado no vetor de respostas
			for (i = 0; i < 10; i++) {
				vetor_respostas[i] = Double.valueOf(vetor[i])/Double.valueOf(maior_elemento);
			}
			//Impressão do vetor de respostas
			System.out.print("\n");
			VetorDoubles.imprimeVetorDoubles(vetor_respostas, 10);
		}
	}

	static class Questao2 {
		public void rQ2 () {
			int vetor[] = new int[20];
			int i = 0;
			for (i = 0; i < 20; i++) {
				vetor[i] = Numeros.geraNumero(true);
			}
			//Iiprime o veior
			VetorInteiros.imprimeVetorInteiros(vetor, 20);
			//Troca das posições dos elementos
			for (i = 0; i < 10; i++) {
				int aux = vetor[i];
				vetor[i] = vetor[vetor.length - 1 - i];
				vetor[vetor.length - 1 - i] = aux;
			}
			//Imprime o vetor com os elementos trocados de posição
			System.out.print("\n");
			VetorInteiros.imprimeVetorInteiros(vetor, 20);
		}
	}
	
	static class Questao3 {
		public void rQ3() {
			int vetor[] = new int[100];
			int i = 0;
			int tamanho_respostas = 0;
			//Geração do vetor
			//Ao gerar o vetor, conta-se a quantidade de valores positivos e não nulos no vetor original para definir o tamanho do vetor resposta, o computando na variável tamanho_repostas
			for (i = 0; i < 100; i++) {
				vetor[i] = Numeros.geraNumero(false);
				if (vetor[i] > 0) {
					tamanho_respostas++;
				}
			}
			//Imprime o vetor original
			VetorInteiros.imprimeVetorInteiros(vetor, 100);
			//Cria o vetor resposta
			int vetor_respostas[] = new int[tamanho_respostas];
			//Percorre mais uma vez o vetor original a fim de copiar os valores positivos e não nulos para o vetor resposta
			int j = 0;
			for (i = 0; i < 100; i++) {
				if (vetor[i] > 0) {
					vetor_respostas[j] = vetor[i];
					j++;
				}
			}
			//Imprime o vetor com os valores positivos e não nulos
			System.out.print("\n");
			VetorInteiros.imprimeVetorInteiros(vetor_respostas, tamanho_respostas);
			System.out.print("\nNúmero de elementos que sobraram: " + tamanho_respostas);

		}
	}
	
	public static void main(String[] args) {
		System.out.print("Questão 1:\n");
		Questao1 objQuestao1 = new Questao1();
		objQuestao1.rQ1();
		System.out.print("\n\n");

		System.out.println("Questão 2:");
		Questao2 objQuestao2 = new Questao2();
		objQuestao2.rQ2();
		System.out.print("\n\n");

		System.out.println("Questão 3:");
		Questao3 objQuestao3 = new Questao3();
		objQuestao3.rQ3();
		System.out.print("\n");
	}
}
