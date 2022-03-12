import java.util.ArrayList;

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
		    if (this.hospedes.get(i).getIdade() >= 2) {
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
		if (this.quantidadePessoas <= 7) {
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
        	System.out.println("Olá, mundo!")
        }   
}
