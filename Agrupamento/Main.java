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

	static class Hospede {
		private int codigo;
		private String nome;
		private String endereco;
		private int idade;
	}
	
	public class Suite {
	    private int numero;
	    private String tipo;
	    private int capacidade;
	    private double valorDiaria;
	}
	
	public static void main(String[] args) {
        	System.out.println("Olá, mundo!")
        }   
}
