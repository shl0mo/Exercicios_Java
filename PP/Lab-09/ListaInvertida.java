import java.util.Hashtable;
import java.util.LinkedList;

public class ListaInvertida {
	private Hashtable<String, LinkedList<String>> tabela;

	public ListaInvertida () {
		this.tabela = new Hashtable<String, LinkedList<String>>();
	}

	public LinkedList<String> busca (String palavra) {
		return this.tabela.get(palavra);
	}

	public boolean insere (String palavra, String documento) {
		LinkedList lista_ligada = busca(palavra);
		if (lista_ligada != null) {
			if (!lista_ligada.contains(documento)) {
				lista_ligada.add(documento);
				return true;	
			} else {
				return false;
			}
		} else {
			LinkedList<String> nova_lista_ligada = new LinkedList<String>();
			nova_lista_ligada.add(documento);
			this.tabela.put(palavra, nova_lista_ligada);
			return true;
		}
	}

	public String toString () {
		return this.tabela.toString();
	}
}
