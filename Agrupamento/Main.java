import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public class Reserva {
	    
	    private ArrayList<Hospede> hospedes;
	    private Suite suite;
	    private int quantidadePessoas;
	    private int quantidadeDias;
	    
	    Reserva (ArrayList<Hospede> hospedes, Suite suite, int quantidadeDias) {
		this.hospedes = hospedes;
		this.suite = suite;
		for (int i = 0; i < this.hospedes.size(); i++) {
		    if (this.hospedes.get(i).getIdade() > 2) {
		        this.quantidadePessoas = this.quantidadePessoas + 1;
		    }
		}
		this.quantidadeDias = quantidadeDias;        
	    }
	    
	    public int getQuantidadePessoas () {
		return this.quantidadePessoas;
	    }
	    
	    public int getQuantidadeDias () {
		return this.quantidadeDias;
	    }
	    
	    public boolean verificarCapacidade() {
		if (this.getQuantidadePessoas() <= this.suite.getCapacidade()) {
		    return true;
		} else {
		    return false;
		}
	    }
	    
	    public double calcularDiaria() {
		if (getQuantidadeDias() <= 7) {
		    return this.suite.getValorDiaria() * this.quantidadeDias;
		} else {
		    return 0.9*(this.suite.getValorDiaria() * this.quantidadeDias);
		}
	    }
	    
	}

	public class Hospede {
    
	    private int codigo;
	    private String nome;
	    private String endereco;
	    private int idade;
	    
	    Hospede (int codigo, String nome, String endereco, int idade) {
		setCodigo(codigo);
		setNome(nome);
		setEndereco(endereco);
		setIdade(idade);
	    }
	    
	    public int getCodigo () {
		return this.codigo;
	    }
	    
	    public String getNome () {
		return this.nome;
	    }
	    
	    public String getEndereco () {
		return this.endereco;
	    }
	    
	    public int getIdade () {
		return this.idade;
	    }
	    
	    public void setCodigo (int codigo) {
		this.codigo = codigo;
	    }
	    
	    public void setNome (String nome) {
		this.nome = nome;
	    }
	    
	    public void setEndereco (String endereco) {
		this.endereco = endereco;
	    }
	    
	    public void setIdade (int idade) {
		this.idade = idade;
	    }
	    
	    @Override
	    public String toString() {
		return "{ codigo: " + this.codigo + ", nome: " + this.nome + ", endereco: " + this.endereco + ", " + this.endereco + ", idade: " + this.idade + " }";
	    }
	    
	}
	
	public class Suite {
    
	    private int numero;
	    private String tipo;
	    private int capacidade;
	    private double valorDiaria;
	    
	    Suite (int numero, String tipo, int capacidade, double valorDiaria) {
		setNumero(numero);
		setTipo(tipo);
		setCapacidade(capacidade);
		setValorDiaria(valorDiaria);
	    }
	    
	    public int getNumero () {
		return this.numero;
	    }
	    
	    public String getTipo () {
		return this.tipo;
	    }
	    
	    public int getCapacidade () {
		return this.capacidade;
	    }
	    
	    public double getValorDiaria() {
		return this.valorDiaria;
	    }
	    
	    public void setNumero (int numero) {
		this.numero = numero;
	    }
	    
	    public void setTipo (String tipo) {
		this.tipo = tipo;
	    }
	    
	    public void setCapacidade (int capacidade) {
		this.capacidade = capacidade;
	    }
	    
	    public void setValorDiaria (double valorDiaria) {
		this.valorDiaria = valorDiaria;
	    }
	}


	
	public static void main(String[] args) {
		//Caso 1 - suíte com capacidade suficiente e reserva sem desconto
		Suite suite1 = new Suite(1, "tipo 1", 7, 100);
		Hospede hospede1 = new Hospede(1, "José", "Rua 1", 40);
		Hospede hospede2 = new Hospede(2, "Joana",  "Rua 1", 38);
		Hospede hospede3 = new Hospede(3, "João", "Rua 1", 16);
		Hospede hospede4 = new Hospede(4, "Heloísa", "Rua 1", 1);
		ArrayList<Hospede> hospedes1 = new ArrayList<>(Arrays.asList(hospede1, hospede2, hospede3, hospede4));
		Reserva reserva1 = new Reserva(hospedes1, suite1, 7); //7 diárias
		System.out.println("Reserva 1: ");
		if (reserva1.verificarCapacidade()) {
		    System.out.println("A suíte 1 possui capacidade");
		    //Para esse caso, como uma das pessoas é menor de dois anos, a quantidade das pessoas consideradas na reserva deve ser 3 e não 4:
		    System.out.println("Quantidade de pessoas na reserva: " + reserva1.getQuantidadePessoas());
		    //Preço da diária:
		    System.out.println("Preço: " + reserva1.calcularDiaria()); //Não haverá desconto, pois as diárias não superam 7. O total deve ser 700
		} else {
		    System.out.println("Não há capacidade na suíte 1. A capacidade máxima é " + suite1.getCapacidade());
		}
		System.out.print("\n");
		
		//Caso 2 - suíte com capacidade suficiente e com desconto
		Suite suite2 = new Suite(1, "tipo 2", 4, 100);
		Hospede hospede1_1 = new Hospede(1, "Carlos", "Rua 2", 35);
		Hospede hospede2_1 = new Hospede(2, "Luana", "Rua 2", 37);
		Hospede hospede3_1 = new Hospede(3, "Gabriel", "Rua 2", 10);
		ArrayList<Hospede> hospedes2 = new ArrayList<>(Arrays.asList(hospede1_1, hospede2_1, hospede3_1));
		System.out.println("Reserva 2: ");
		Reserva reserva2 = new Reserva(hospedes2, suite2, 9); //9 diárias
		if (reserva2.verificarCapacidade()) {
		    System.out.println("A suíte 2 possui capacidade");
		    //Como não há menores de 2 anos, todas as pessoas são consideradas no total da reserva. Deste modo, temos 3 pessoas na reserva:
		    System.out.println("Quantidade de pessoas na reserva: " + reserva2.getQuantidadePessoas());
		    //Preço da diária:
		    System.out.println("Preço: " + reserva2.calcularDiaria()); //Como as dirárias superam 7, o total deve ser 90% de 900
		} else {
		    System.out.println("Não há capacidade na suíte 2. A capacidade máxima é " + suite2.getCapacidade());
		}
		System.out.print("\n");
		
		//Caso 3 - suíte sem capacidade suficiente
		Suite suite3 = new Suite(3, "tipo 3", 5, 130);
		Hospede hospede1_2 = new Hospede(1, "João", "Rua 3", 25);
		Hospede hospede2_2 = new Hospede(2, "Bruno", "Rua 4", 32);
		Hospede hospede3_2 = new Hospede(3, "Larissa", "Rua 5", 26);
		Hospede hospede4_2 = new Hospede(4, "Tatiana", "Rua 6", 20);
		Hospede hospede5_2 = new Hospede(5, "Lucas", "Rua 7", 18);
		Hospede hospede6_2 = new Hospede(5, "Juliana", "Rua 8", 27);
		ArrayList<Hospede> hospedes3 = new ArrayList<>(Arrays.asList(hospede1_2, hospede2_2, hospede3_2, hospede4_2, hospede5_2, hospede6_2)); //6 hóspedes para uma capacidade de 5
		Reserva reserva3 = new Reserva(hospedes3, suite3, 8);
		System.out.println("Reserva 3");
		if (reserva3.verificarCapacidade()) {
		    System.out.println("A suíte 3 possui capacidade");
		    //Como não há menores de 2 anos, todas as pessoas são consideradas no total da reserva
		    System.out.println("Quantidade de pessoas na reserva: " + reserva3.getQuantidadePessoas());
		    //Preço da diária:
		    System.out.println("Preço: " + reserva3.calcularDiaria()); //Como as dirárias superam 7, o total deve ser 90% de 900
		} else {
		    System.out.println("Não há capacidade na suíte 3. A capacidade máxima é " + suite3.getCapacidade());
		}
		System.out.print("\n");
	}   
}
