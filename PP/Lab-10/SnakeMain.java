import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class SnakeMain extends JFrame implements KeyListener {
    private Snake  jogo;
    private JPanel panel;
    private int    ultimaTecla;

    public SnakeMain(Snake jogo) {
        super("Snake");

        this.jogo = jogo;
        this.panel = new JPanel();

        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setPreferredSize(new Dimension(jogo.getLarguraPixels(), jogo.getAlturaPixels()));
        pack();
        setResizable(false);
        panel.setBounds(0, 0, jogo.getLarguraPixels(), jogo.getAlturaPixels());
        panel.addKeyListener(this);
        panel.setFocusable(true);
        panel.setDoubleBuffered(true);
        add(panel);
        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        jogo.paintWindow(panel.getGraphics());
        Toolkit.getDefaultToolkit().sync();
    }

    public void keyPressed(KeyEvent e) {
        ultimaTecla = e.getKeyCode();
    }

    public char getDirecao() {
        if      (ultimaTecla == KeyEvent.VK_UP)    return 'C';  // Cima
        else if (ultimaTecla == KeyEvent.VK_RIGHT) return 'D';  // Direita
        else if (ultimaTecla == KeyEvent.VK_DOWN)  return 'B';  // Baixo
        else if (ultimaTecla == KeyEvent.VK_LEFT)  return 'E';  // Esquerda
        else return 'N'; // Desconhecido
    }

    public static void main(String[] args) {

        Snake jogo = new Snake(30, 20);
        
        // Para jogar na janela usando teclado
        SnakeMain janela = new SnakeMain(jogo);
        jogo.setSaida(janela);
        jogo.setJogador(null);
        jogo.inicia();

        SnakeJogador jogador = new SnakeJogador(jogo);
        SnakeMain janela = new SnakeMain(jogo);
        jogo.setSaida(janela);
        jogo.setJogador(jogador);
        jogo.inicia();


    }

    public void keyReleased(KeyEvent arg0) {}
    public void keyTyped(KeyEvent arg0) {}
}
