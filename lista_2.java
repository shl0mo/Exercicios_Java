import java.util.Random;

class Main {

	static class Numeros {
		static public int geraNumero() {
			Random gerador = new Random();
			return gerador.nextInt(100) + 1;
		}
	}

	static class Questao1 {
		public void rQ1() {
			int vetor[] = new int[10];
			double vetor_respostas[] = new double[10]; //O fato da divisão de dois inteiros gerarem um double requer que um vetor de respostas do tipo double seja criado para armazenar os resultados das divisões
			int maior_elemento = 0;
			double vetor_resposta[] = new double[10];
			int i = 0;
			for (i = 0; i < 10; i++) {
				vetor[i] = Numeros.geraNumero();
			}
			//Geração dos números aleatórios para o vetor
			for (i = 0; i < 10; i++) {
				System.out.print(vetor[i]);
				if (i != vetor.length - 1) {
					System.out.print(" ");
				} else {
					System.out.print("\n");
				}
			}
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
			for (i = 0; i < 10; i++) {
				System.out.printf("%.3f", vetor_respostas[i]);
				if (i != vetor_respostas.length - 1) {
					System.out.print(" ");
				} else {
					System.out.print("\n");
				}
			}
		}
	}

	static class Questao2 {
		private void imprimeVetor(int vetor[]) {
			int i = 0;
			for (i = 0; i < 20; i++) {
				System.out.print(vetor[i]);				
				if (i != vetor.length - 1) {
					System.out.print(" ");
				} else {
					System.out.print("\n");
				}
			}
		}

		public void rQ2 () {
			int vetor[] = new int[20];
			int i = 0;
			for (i = 0; i < 20; i++) {
				vetor[i] = Numeros.geraNumero();
			}
			//Imprime o vetori
			imprimeVetor(vetor);
			//Troca das posições dos elementos
			for (i = 0; i < 10; i++) {
				int aux = vetor[i];
				vetor[i] = vetor[vetor.length - 1 - i];
				vetor[vetor.length - 1 - i] = aux;
			}
			//Imprime o vetor com os elementos trocados de posição
			imprimeVetor(vetor);
		}
	}

	public static void main(String[] args) {
		System.out.println("Questão 1:");
		Questao1 objQuestao1 = new Questao1();
		objQuestao1.rQ1();
		System.out.print("\n");

		System.out.println("Questão 2:");
		Questao2 objQuestao2 = new Questao2();
		objQuestao2.rQ2();
		System.out.print("\n");
	}
}
