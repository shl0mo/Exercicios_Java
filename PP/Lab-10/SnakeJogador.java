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
        boolean esqerda_livre = jogo.isCelulaLivre(cabeca.x-1, cabeca.y);

        while (cima_livre || direita_livre || baixo_livre || esquerda_livre) {
            cabeca = jogo.getSegmentos().getFirst();
            Point comida = this.jogo.getComida();
            int x_comida = comida.getX();
            int y_comida = comida.getY();
            boolean comida_esquerda = abs((cabeca.x - 1) - x_comida) < abs((cabeca.x + 1) - x_comida)
            boolean comida_direita = abs((cabeca.x + 1) - x_comida) < abs((cabeca.x - 1) - x_comida)
            boolean comida_vertical = abs((cabeca.x + 1) - x_comida) == abs((cabeca.x - 1) - x_comida)
            boolean comida_cima = abs((cabeca.y - 1) - y_comida) < abs((cabeca.y + 1) - y_comida)
            boolean comida_baixo = abs((cabeca.y + 1) - y_comida) < abs((cabeca.y - 1) - y_comida)

            if ()
            cima_livre = jogo.isCelulaLivre(cabeca.x, cabeca.y-1);
            direita_livre = jogo.isCelulaLivre(cabeca.x+1, cabeca.y);
            baixo_livre = jogo.isCelulaLivre(cabeca.x, cabeca.y+1);
            esqerda_livre = jogo.isCelulaLivre(cabeca.x-1, cabeca.y);
        }


        if () return 'C'; // Cima
        if () return 'D'; // Direita
        if () return 'B'; // Baixo
        if () return 'E'; // Esquerda
        
        // Não existe mais nenhuma direção disponível
        return 'N';
    }
    
}
