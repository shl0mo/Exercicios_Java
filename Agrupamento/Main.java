import java.util.ArrayList;

public class Main {
	static class Reserva {
	    private ArrayList hospedes;
	    private Suite suite;
	    private int quantidadePessoas;
	    private int quantidadeDias;
    
	    public boolean verificarCapacidade() {
        	return true;
	    }
    
	    public double calcularDiaria() {
	        return 2.0;
	    }
	}

	public class Hospede {
	    
	    private int codigo;
	    private String nome;
	    private String endereco;
	    private int idade;
	    
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
	    
	    public void getNumero (int numero) {
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
