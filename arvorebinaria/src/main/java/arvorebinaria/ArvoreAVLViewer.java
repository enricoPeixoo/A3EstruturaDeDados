package arvorebinaria;

import javax.swing.*;
import java.awt.*;

public class ArvoreAVLViewer extends JFrame {
    private ArvoreBinaria arvore;
    private PainelArvore painel;

    public ArvoreAVLViewer() {
        arvore = new ArvoreBinaria();
        painel = new PainelArvore(arvore.getRaiz());

        setTitle("Visualizador de Árvore AVL");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());
        add(painel, BorderLayout.CENTER);

        criarMenu();

        setVisible(true);
    }

    private void criarMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("Operações");

        JMenuItem adicionar = new JMenuItem("Adicionar");
        adicionar.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Digite o valor a adicionar:");
            if (input != null) {
                try {
                    int valor = Integer.parseInt(input);
                    arvore.adicionar(valor);
                    painel.setRaiz(arvore.getRaiz());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Entrada inválida!");
                }
            }
        });

        JMenuItem remover = new JMenuItem("Remover");
        remover.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Digite o valor a remover:");
            if (input != null) {
                try {
                    int valor = Integer.parseInt(input);
                    arvore.remover(valor);
                    painel.setRaiz(arvore.getRaiz());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Entrada inválida!");
                }
            }
        });

        JMenuItem buscar = new JMenuItem("Buscar");
        buscar.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Digite o valor a buscar:");
            if (input != null) {
                try {
                    int valor = Integer.parseInt(input);
                    boolean encontrado = arvore.buscar(valor);
                    String mensagem = encontrado ? "Valor encontrado!" : "Valor não encontrado.";
                    JOptionPane.showMessageDialog(this, mensagem);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Entrada inválida!");
                }
            }
        });

        JMenuItem rotacoes = new JMenuItem("Total de rotações");
        rotacoes.addActionListener(e -> {
            int total = arvore.getNumeroRotacoes();
            JOptionPane.showMessageDialog(this, "Total de rotações: " + total);
        });

        menu.add(adicionar);
        menu.add(remover);
        menu.add(buscar);
        menu.add(rotacoes);

        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    // Painel que desenha a árvore
    private static class PainelArvore extends JPanel {
        private Elemento raiz;

        public PainelArvore(Elemento raiz) {
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ArvoreAVLViewer());
    }
}
