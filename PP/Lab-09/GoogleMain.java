public class GoogleMain {
	public static void main (String args[]) {
		ListaInvertida lista_invertida = new ListaInvertida();
		lista_invertida.insere("palavra1", "documento1");
		lista_invertida.insere("palavra1", "documento1");
		lista_invertida.insere("palavra2", "documento2");
		lista_invertida.busca("palavra1");
		lista_invertida.busca("palavra2");
		System.out.println(lista_invertida.toString());
	}
}
