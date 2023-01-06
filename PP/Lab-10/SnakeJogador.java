import java.awt.Point;
import java.util.*;

public class SnakeJogador {
    private Snake jogo;
    
    public SnakeJogador(Snake jogo) {
        this.jogo = jogo;
    }
    public char getDirecao() {
        Point cabeca = jogo.getSegmentos().getFirst();
        boolean cima_livre = jogo.isCelulaLivre(cabeca.x, cabeca.y-1);
        boolean direita_livre = jogo.isCelulaLivre(cabeca.x+1, cabeca.y);
        boolean baixo_livre = jogo.isCelulaLivre(cabeca.x, cabeca.y+1);
        boolean esquerda_livre = jogo.isCelulaLivre(cabeca.x-1, cabeca.y);


        

        while (cima_livre || direita_livre || baixo_livre || esquerda_livre) {
            cabeca = jogo.getSegmentos().getFirst();
            Point comida = this.jogo.getComida();
            int x_comida = (int) comida.getX();
            int y_comida = (int) comida.getY();
            boolean comida_esquerda = Math.abs((cabeca.x - 1) - x_comida) < Math.abs((cabeca.x + 1) - x_comida);
            boolean comida_direita = Math.abs((cabeca.x + 1) - x_comida) < Math.abs((cabeca.x - 1) - x_comida);
            boolean comida_vertical = Math.abs((cabeca.x + 1) - x_comida) == Math.abs((cabeca.x - 1) - x_comida);
            boolean comida_acima = Math.abs((cabeca.y - 1) - y_comida) < Math.abs((cabeca.y + 1) - y_comida);
            boolean comida_abaixo = Math.abs((cabeca.y + 1) - y_comida) < Math.abs((cabeca.y - 1) - y_comida);
            boolean comida_horizontal = Math.abs((cabeca.y + 1) - y_comida) == Math.abs((cabeca.y - 1) - y_comida);

            if (comida_vertical) {
                if (comida_acima) {
                    if (cima_livre) {
                        return 'C';
                    } else {
                        if (direita_livre) return 'D';
                        else if (esquerda_livre) return 'E';
                        else if (baixo_livre) return 'B';
                    }
                } else if (comida_abaixo) {
                    if (baixo_livre) {
                        return 'B';
                    } else {
                        if (direita_livre) return 'D';
                        else if (esquerda_livre) return 'E';
                        else if (cima_livre) return 'C';
                    }
                } 
            }

            if (comida_horizontal) {
                if (comida_direita) {
                    if (direita_livre) {
                        return 'D';
                    } else {
                        if (cima_livre) return 'C';
                        else if (baixo_livre) return 'B';
                        else if (esquerda_livre) return 'E';
                    }
                } else if (comida_esquerda) {
                    if (esquerda_livre) {
                        return 'E';
                    } else {
                        if (cima_livre) return 'C';
                        else if (baixo_livre) return 'B';
                        else if (esquerda_livre) return 'E';
                    }
                }
            }

            if (comida_acima) {
                int distancia_acima = Math.abs(cabeca.y - y_comida);
                int distancia_direita = Math.abs((cabeca.x + 1) - x_comida);
                int distancia_esquerda = Math.abs((cabeca.x - 1) - x_comida);
                if (distancia_acima < distancia_direita && distancia_acima < distancia_esquerda) return 'C';
                else if (distancia_direita < distancia_acima && distancia_direita < distancia_esquerda) return 'D';
                else if (distancia_esquerda < distancia_acima && distancia_esquerda <  distancia_direita) return 'E';
            }

            if (comida_abaixo) {
                int distancia_acima = Math.abs(cabeca.y - y_comida);
                int distancia_direita = Math.abs((cabeca.x + 1) - x_comida);
                int distancia_esquerda = Math.abs((cabeca.x - 1) - x_comida);
                if (distancia_acima < distancia_direita && distancia_acima < distancia_esquerda) return 'C';
                else if (distancia_direita < distancia_acima && distancia_direita < distancia_esquerda) return 'D';
                else if (distancia_esquerda < distancia_acima && distancia_esquerda <  distancia_direita) return 'E';
            }

            cima_livre = jogo.isCelulaLivre(cabeca.x, cabeca.y-1);
            direita_livre = jogo.isCelulaLivre(cabeca.x+1, cabeca.y);
            baixo_livre = jogo.isCelulaLivre(cabeca.x, cabeca.y+1);
            esquerda_livre = jogo.isCelulaLivre(cabeca.x-1, cabeca.y);
        }

        ArrayList<Character> possiveisDirecoes = new ArrayList<Character>(4);
        cabeca = jogo.getSegmentos().getFirst();
        
        // Adiciona as possíveis direções na lista
        if (jogo.isCelulaLivre(cabeca.x, cabeca.y-1)) possiveisDirecoes.add('C'); // Cima
        if (jogo.isCelulaLivre(cabeca.x+1, cabeca.y)) possiveisDirecoes.add('D'); // Direita
        if (jogo.isCelulaLivre(cabeca.x, cabeca.y+1)) possiveisDirecoes.add('B'); // Baixo
        if (jogo.isCelulaLivre(cabeca.x-1, cabeca.y)) possiveisDirecoes.add('E'); // Esquerda
        
        // Não existe mais nenhuma direção disponível
        if (possiveisDirecoes.size() == 0) return 'N';
        
        // Pega um número aleatório entre 0 e o tamanho da lista e retorna a direção
        int posicao = new Random().nextInt(possiveisDirecoes.size());
        return possiveisDirecoes.get(posicao);
        
        // Não existe mais nenhuma direção disponível
        //return 'N';
    }
    
}
