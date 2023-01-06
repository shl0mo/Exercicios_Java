import java.util.*;
import java.awt.*;

public class Snake {
    private int largura, altura;
    private SnakeMain saida;
    private SnakeJogador jogador;
    
    private LinkedList<Point> segmentos;
    private char direcaoAtual;
    private Point comida;
    
    private boolean rodando;
    private int tamSegmento;
    private int delay;
    private int totalComida;

    private Random rng;

    public Snake(int largura, int altura) {
        this(largura, altura, 0);
    }

    public Snake(int largura, int altura, int semente) {
        this.largura = largura > 5 ? largura : 5;
        this.altura  = altura > 5 ? altura : 5;
        
        segmentos    = new LinkedList<Point>();
        direcaoAtual = 'D';
        
        rodando      = true;
        tamSegmento  = 25;
        delay        = 80;
        
        rng = (semente > 0) ? new Random(semente) : new Random();
        
        // Inicializa a cobra com alguns segmentos e adiciona comida
        for (int i=0; i<5; i++) segmentos.addFirst(new Point(i, altura/2));
        addComida();
    }
    
    public int getLargura() {
        return largura;
    }

    public int getAltura() {
        return altura;
    }

    public int getLarguraPixels() {
        return largura*tamSegmento;
    }

    public int getAlturaPixels() {
        return altura*tamSegmento;
    }

    public void setSaida(SnakeMain saida) {
        this.saida = saida;
    }

    public void setJogador(SnakeJogador jogador) {
        this.jogador = jogador;
    }
    
    public LinkedList<Point> getSegmentos() {
        return segmentos;
    }

    public char getDirecaoAtual() {
        return direcaoAtual;
    }
    
    public Point getComida() {
        return comida;
    }
    
    private void addComida() {
        comida = new Point(rng.nextInt(largura), rng.nextInt(altura));
        
        // Gera outra comida, enquanto a atual cair em algum segmento da cobra
        while (segmentos.contains(comida))
            comida = new Point(rng.nextInt(largura), rng.nextInt(altura));
    }
    
    public int getTotalComida() {
        return totalComida;
    }
    
    public boolean isCelulaLivre(int x,  int y) {
        // Verifica se colidiu com as bordas da arena
        if (x < 0 || x >= largura || y < 0 || y >= altura) return false;
        
        // Verifica se colidiu com a cobra
        for (Point segmentoAtual : segmentos)
            if (segmentoAtual.x == x && segmentoAtual.y == y) return false;
        
        return true;
    }

    private boolean anda(char direcao) {
        if      (direcao == 'C' && direcaoAtual != 'B') direcaoAtual = 'C'; // Cima
        else if (direcao == 'D' && direcaoAtual != 'E') direcaoAtual = 'D'; // Direita
        else if (direcao == 'B' && direcaoAtual != 'C') direcaoAtual = 'B'; // Baixo
        else if (direcao == 'E' && direcaoAtual != 'D') direcaoAtual = 'E'; // Esquerda

        // Posição da nova cabeça da cobra
        Point novoSegmento = (Point) segmentos.getFirst().clone();
        if      (direcaoAtual == 'C') novoSegmento.y--;
        else if (direcaoAtual == 'D') novoSegmento.x++;
        else if (direcaoAtual == 'B') novoSegmento.y++;
        else if (direcaoAtual == 'E') novoSegmento.x--;
        
        // Verifica se a cabeca colidiu com as bordas da arena ou com a cobra
        if (!isCelulaLivre(novoSegmento.x, novoSegmento.y)) return false;

        // Adiciona um novo segmento à cobra (no topo, cabeça)
        segmentos.addFirst(novoSegmento);
        
        // Verifica se comeu alguma comida
        if (novoSegmento.equals(comida)) {
            addComida();
            totalComida++;
        }
        else segmentos.removeLast();

        return true;
    }

    public void paintWindow(Graphics g) {
        // Pinta o fundo branco
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getLarguraPixels()+1, getAlturaPixels()+1);
        
        // Pinta a cobra
        int cor = 100;
        for (Point segmentoAtual : segmentos) {
            if (segmentoAtual == segmentos.getFirst()) g.setColor(Color.BLACK);
            else {
                Color corSegmento = new Color(cor, cor, cor);
                cor = cor < 220 ? cor + 20 : cor; 
                g.setColor(corSegmento);
            }
            g.fillRect(segmentoAtual.x*tamSegmento+1, segmentoAtual.y*tamSegmento+1, tamSegmento-1, tamSegmento-1);
        }
        
        // Pinta a comida
        g.setColor(Color.RED);
        g.fillOval(comida.x*tamSegmento+1, comida.y*tamSegmento+1, tamSegmento-2, tamSegmento-2);
        
        g.drawString(Integer.toString(totalComida), 3, getAlturaPixels()-3);
        if (!rodando) g.drawString("Fim!", getLarguraPixels()-28, getAlturaPixels()-3);
    }
    
    public void inicia() {
        while (rodando) {
            char direcao = (jogador != null ? jogador.getDirecao() : saida.getDirecao());
            
            rodando = anda(direcao);
            
            if (saida != null) {
                saida.repaint();
                
                // Sleep não é a forma mais recomendada para um loop de jogo com muitos
                // frames por segundo, mas é mais do que suficiente para o jogo atual.
                try { Thread.sleep(delay); } catch (Exception e) {}
            }
        }
        
        System.out.println("Total de comida: " + totalComida);
    }
    
}
