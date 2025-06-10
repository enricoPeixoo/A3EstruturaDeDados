package arvorebinaria;

import javax.swing.*;
import java.awt.*;

public class ArvoreAVLViewer extends JPanel {
    private Elemento raiz;

    public ArvoreAVLViewer(Elemento raiz) {
        this.raiz = raiz;
    }

    public void setRaiz(Elemento raiz) {
        this.raiz = raiz;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        desenharArvore(g, raiz, getWidth() / 2, 30, getWidth() / 4);
    }

    private void desenharArvore(Graphics g, Elemento node, int x, int y, int espaco) {
        if (node == null) return;

        g.setColor(Color.BLACK);
        g.fillOval(x - 15, y - 15, 30, 30);
        g.setColor(Color.WHITE);
        g.drawString(String.valueOf(node.valor), x - 7, y + 5);

        g.setColor(Color.BLACK);

        if (node.esquerda != null) {
            g.drawLine(x, y, x - espaco, y + 50);
            desenharArvore(g, node.esquerda, x - espaco, y + 50, espaco / 2);
        }

        if (node.direita != null) {
            g.drawLine(x, y, x + espaco, y + 50);
            desenharArvore(g, node.direita, x + espaco, y + 50, espaco / 2);
        }
    }
}
