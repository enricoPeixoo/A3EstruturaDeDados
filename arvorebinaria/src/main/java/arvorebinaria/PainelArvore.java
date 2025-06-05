package arvorebinaria;

import javax.swing.*;
import java.awt.*;

public class PainelArvore extends JPanel{
     private final Elemento raiz;

    public PainelArvore(Elemento raiz) {
        this.raiz = raiz;
        setPreferredSize(new Dimension(800, 600));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (raiz != null) {
            desenharArvore(g, raiz, getWidth() / 2, 50, getWidth() / 4);
        }
    }

    private void desenharArvore(Graphics g, Elemento no, int x, int y, int distancia) {
        g.setColor(Color.BLACK);
        g.drawString(Integer.toString(no.valor), x - 10, y);

        if (no.esquerda != null) {
            int xFilho = x - distancia;
            int yFilho = y + 50;
            g.drawLine(x, y, xFilho, yFilho);
            desenharArvore(g, no.esquerda, xFilho, yFilho, distancia / 2);
        }

        if (no.direita != null) {
            int xFilho = x + distancia;
            int yFilho = y + 50;
            g.drawLine(x, y, xFilho, yFilho);
            desenharArvore(g, no.direita, xFilho, yFilho, distancia / 2);
        }
    }
}

