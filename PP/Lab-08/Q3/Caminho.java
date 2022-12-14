package br.edu.ufam.icomp.lab_excecoes;

public class Caminho {
  private Coordenada caminho[];
  private int tamanho;
  private int maxTam;

  public Caminho (int maxTam) {
    this.tamanho = 0;
    this.maxTam = maxTam;
    this.caminho = new Coordenada[maxTam];
  }

  public int tamanho () {
    return this.tamanho;
  }

  public int getMaxTam () {
    return this.maxTam;
  }


  public void addCoordenada (Coordenada coordenada) throws TamanhoMaximoExcedidoException, DistanciaEntrePontosExcedidaException {
    if (this.caminho[getMaxTam() - 1] != null) throw new TamanhoMaximoExcedidoException();
    Coordenada ultimo_ponto = null;
    if (tamanho() != 0) ultimo_ponto = this.caminho[tamanho() - 1];
    if (ultimo_ponto != null) {
        if (coordenada.distancia(ultimo_ponto) > 15.0) throw new DistanciaEntrePontosExcedidaException();
    }
    this.caminho[tamanho()] = coordenada;
    this.tamanho = this.tamanho + 1;
  }

  public void reset () {
    for (int i = 0; i < getMaxTam(); i++) {
        this.caminho[i] = null;
    }
    this.tamanho = 0;
  }

  public String toString () {
    String string = "Dados do caminho:\n  - Quantidade de pontos: ";
    int total_pontos = tamanho();
    string = string + total_pontos;
    string = string + "\n  - Pontos:\n";
    for (int i = 0; i < tamanho(); i++) {
        string = string + "    -> " + this.caminho[i].getPosX() + ", " + this.caminho[i].getPosY() + "\n";
    }
    return string;
  }
}