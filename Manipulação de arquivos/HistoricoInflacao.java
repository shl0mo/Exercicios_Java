import java.util.*;
import java.io.*;

public class HistoricoInflacao {
	private List<Inflacao> serie;
	
	public void lerInflacao(String nome){
            this.serie = new ArrayList<Inflacao>();
            LeituraInflacao objLeituraInflacao = new LeituraInflacao();
            objLeituraInflacao.abrir(nome);
            objLeituraInflacao.ler(this.serie);
            objLeituraInflacao.fechar();
	}
	
	public void escreverInflacao(String nome){
            EscritaInflacao objEscritaInflacao = new EscritaInflacao();
            objEscritaInflacao.abrir(nome);
            objEscritaInflacao.salvar(this.serie);
            objEscritaInflacao.fechar();
	}
	
	public List<Inflacao> getSerie(){
            return serie;
	}
	
	public void ordenar(){
            Collections.sort(serie);
	}
	

	static class Inflacao implements Comparable<Inflacao> {	
	    private int ano;
	    private double [] indices;
	    private double acumulado;
	    public Inflacao(int ano, double [] valores, double acumulado){
	    	this.indices = Arrays.copyOf(valores, valores.length);
	    	this.ano = ano;		
		this.acumulado = acumulado;
	    }
	    public double[] indices(){
		return indices;
	    }	
		
	    public int ano(){
		return ano;
	    }
		
	    public double indiceMes(int mes) throws ArrayIndexOutOfBoundsException{
		return indices[mes]; 
	    }
	    public double acumulado(){
		return acumulado;
	    }
	    public String toString(){
		return "Ano: " + ano + " Indices mensais: "	+ Arrays.toString(indices()) + " Acumulado: " + acumulado;
	    }
	    
	    @Override
	    public int compareTo(Inflacao inflacao2) {
		if (this.acumulado < inflacao2.acumulado) {
		    return -1;
		}
		if (this.acumulado > inflacao2.acumulado) {
		    return 1;
		}
		return 0;
	    }
	}

	static class LeituraInflacao extends HistoricoInflacao {
	    BufferedReader br;

	    public void abrir(String nomeArquivo) {
		try {
		    this.br = new BufferedReader(new FileReader(nomeArquivo));
		} catch (IOException ioe) {
		    ioe.printStackTrace();
		}
	    }

	    public void fechar() {
		try {
		    this.br.close();
		} catch (IOException ioe) {
		    ioe.printStackTrace();
		}
	    }

	    public void ler(List<Inflacao> serie) {
		try {
		    int linhas_percorridas = 1;
		    while (br.ready()) {
		        String linha = br.readLine();
		        //System.out.println(linha);
		        char[] array_linha = linha.toCharArray();
		        int num_elementos = 0;
		        for (int i = 0; i < array_linha.length; i++) {
		            if (array_linha[i] == ';') {
		                num_elementos++;
		            }
		        }
		        num_elementos++;
		        if (linhas_percorridas != 1) {
		            String dados[] = new String[num_elementos];
		            dados = linha.split(";");
		            int ano = Integer.valueOf(dados[0]);
		            double indices[] = new double[num_elementos - 2];
		            int i = 0;
		            int numero = 0;
		            for (int j = 1; j < dados.length - 1; j++) {
		                if (j != dados.length - 1) {
		                    if (!dados[j].equals("-")) {
		                        String str_dado = dados[j].replaceAll(",",".");
		                        indices[i] = Double.parseDouble(str_dado);
		                    } else {
		                        indices[i] = -1000;
		                    }
		                }
		                i++;
		            }
		            String str_dado = dados[dados.length - 1].replaceAll(",",".");
		            double acumulado = Double.parseDouble(str_dado);
		            Inflacao elemento_inflacao = new Inflacao(ano, indices, acumulado);
		            serie.add(elemento_inflacao);
		        }
		        linhas_percorridas++;
		    }
		} catch (IOException ioe) {
		    ioe.printStackTrace();
		}
	    }
	}

	static class EscritaInflacao {
	    BufferedWriter bw;
	    
	    public void abrir(String nomeArquivo) {
		try {
		    File arq = new File(nomeArquivo);
		    if (!arq.exists()) {
		        arq.createNewFile();
		    }
		    this.bw = new BufferedWriter (new FileWriter(nomeArquivo));
		} catch (IOException ioe) {
		    ioe.printStackTrace();
		}
		
	    }
	    
	    public void fechar() {
		try {
		    this.bw.close();
		} catch (IOException ioe) {
		    ioe.printStackTrace();
		}
	    }
	    
	    public void salvar(List<Inflacao> serie) {
		try {
		    bw.write("Ano;Jan;Fev;Mar;Abr;Mai;Jun;Jul;Ago;Set;Out;Nov;Dez;Acumulado anual");
		    bw.write("\n");
		    for (int i = 0; i < serie.size(); i++) {
		        //Grava o ano no arquivo:
		        bw.write(serie.get(i).ano() + ";");
		        //Grava os elementos do array indices[] no arquivo:
		        for (int j = 0; j < serie.get(i).indices().length; j++) {
		            if (serie.get(i).indices()[j] == -1000.0) {
		                bw.write("-");
		            } else {
		                bw.write("" + serie.get(i).indices()[j] + "");
		            }
		            bw.write(";");
		        }
		        //Grava o campo "acumulado" da Collection List<Inflacao> no arquivo:
		        bw.write("" + serie.get(i).acumulado() + "");
		        if (i != serie.size() - 1) bw.write("\n");
		    }
		} catch (IOException ioe) {
		    ioe.printStackTrace();
		}
	    }
	}



	public static void main(String[] args) {
            HistoricoInflacao objHistorico = new HistoricoInflacao();
            System.out.println("Escolha uma das opcões abaixo:");
            System.out.println("1 - Ler arquivo com uma série anual da inflação");
            System.out.println("2 - Gravar um arquivo com uma série de registros de inflação na ordem crescente do acumulado");
            System.out.println("3 - Mostrar na tela n registros com menor inflação acumulada");
            System.out.println("4 - Sair");
            Scanner sc = new Scanner(System.in);
            Scanner sc_str = new Scanner(System.in);
            int num = sc.nextInt();
            while (num < 1 || num > 4) {
                System.out.println("Escolha uma opção válida");
                num = sc.nextInt();
            }
            int leu_arquivo = 0;
            String nomeArquivo_ler;
            String nomeArquivo_escrever;
            while (num != 4) {
                if (num == 1) {
                    System.out.println("Informe o nome do arquivo com os registros de inflação:");
                    nomeArquivo_ler = sc_str.nextLine();
                    File arq = new File(nomeArquivo_ler);
                    while (!arq.exists()) {
                        System.out.println("Arquivo não existe. Insira o nome de um arquivo existente");
                        nomeArquivo_ler = sc.nextLine();
                        arq = new File(nomeArquivo_ler);
                    }
                    objHistorico.lerInflacao(nomeArquivo_ler);
                    leu_arquivo = 1;
                    System.out.println("Arquivo lido\n");
                } else if ((num == 2 && leu_arquivo == 0) || (num == 3 && leu_arquivo == 0)) {
                    while (num != 1 && num != 4) {
                        System.out.println("O arquivo não foi lido. Entre com a opção 1 para realizar a leitura:");
                        num = sc.nextInt();
                    }
                    if (num == 1) {
                        System.out.println("Informe o nome do arquivo com os registros de inflação:");
                        nomeArquivo_ler = sc_str.nextLine();
                        File arq = new File(nomeArquivo_ler);
                        while (!arq.exists()) {
                            System.out.println("Arquivo não existe. Insira o nome de um arquivo existente");
                            nomeArquivo_ler = sc.nextLine();
                            arq = new File(nomeArquivo_ler);
                        }
                        objHistorico.lerInflacao(nomeArquivo_ler);
                        leu_arquivo = 1;
                        System.out.println("\nArquivo lido\n");
                    } else if (num == 4) {
                        break;
                    }
                }
                if (num == 2) {
                    System.out.println("Informe o nome do arquivo no qual quer guardar os registros de inflação:");
                    nomeArquivo_escrever = sc_str.nextLine();
                    objHistorico.ordenar();
                    objHistorico.escreverInflacao(nomeArquivo_escrever);
                } else if (num == 3) {
                    System.out.println("Informe um número n de registros com menor valor acumulado:");
                    System.out.print("n: ");
                    int n = sc.nextInt();
                    objHistorico.ordenar();
                    for (int i = 0; i < n; i++) {
                        System.out.println(objHistorico.serie.get(i));
                    }
                }
            System.out.println("Escolha uma das opcões abaixo:");
            System.out.println("1 - Ler arquivo com uma série anual da inflação");
            System.out.println("2 - Gravar um arquivo com uma série de registros de inflação na ordem crescente do acumulado");
            System.out.println("3 - Mostrar na tela n registros com menor inflação acumulada");
            System.out.println("4 - Sair");
            num = sc.nextInt();
            System.out.print("\n");
            }
        return;
	}
}
