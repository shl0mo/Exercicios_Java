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
                if (comida_acima) return 'C';
                else if (comida_abaixo) return 'B'; 
            }

            if (comida_horizontal) {
                if (comida_direita) return 'D';
                else if (comida_esquerda) return 'E';
            }

            if (comida_acima) return 'C';

            if (comida_abaixo) return 'B';

            cima_livre = jogo.isCelulaLivre(cabeca.x, cabeca.y-1);
            direita_livre = jogo.isCelulaLivre(cabeca.x+1, cabeca.y);
            baixo_livre = jogo.isCelulaLivre(cabeca.x, cabeca.y+1);
            esqerda_livre = jogo.isCelulaLivre(cabeca.x-1, cabeca.y);
        }        
        
        // Não existe mais nenhuma direção disponível
        return 'N';
    }
    
}
