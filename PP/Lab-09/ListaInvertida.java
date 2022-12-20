package br.edu.ufam.icomp.lab_excecoes;

import java.util.Hashtable;
import java.util.LinkedList;

public class ListaInvertida {
	private Hashtable<String, LinkedList<String>> tabela;

	public ListaInvertida () {
		this.tabela = new Hashtable<String, LinkedList<String>>();
	}

	public Hashtable<String, LinkedList<String>> getTabela () {
		return this.tabela;
	}

	public boolean insere (String palavra, String documento) {
		LinkedList lista_ligada = getTabela().get(palavra);
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
			getTabela().put(palavra, nova_lista_ligada);
			return true;
		}
	}

	/*public LinkedList<String> getLista (String palavra) {
		return this.tabela.get(palavra);
	}*/

	public static void main (String args[]) {
		ListaInvertida lista_invertida = new ListaInvertida();
		System.out.println(lista_invertida.insere("palavra1", "documento1"));
		System.out.println(lista_invertida.insere("palavra1", "documento1"));
		System.out.println(lista_invertida.insere("palavra1", "documento2"));

		
	}
}
