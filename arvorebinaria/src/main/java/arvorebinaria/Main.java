package arvorebinaria;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        arvore.adicionar(10);
        arvore.adicionar(8);
        arvore.adicionar(5);
        arvore.adicionar(9);
        arvore.adicionar(7);
        arvore.adicionar(18);
        arvore.adicionar(13);
        arvore.adicionar(20);


        // arvore.remover(20);
        // arvore.remover(5);
        // arvore.remover(8);
        // arvore.remover(9);
        // arvore.remover(13);
        // arvore.remover(7);
        // arvore.remover(18);
        // arvore.remover(10);

        JFrame frame = new JFrame("Visualização da Árvore Binária");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new PainelArvore(arvore.getRaiz()));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
    }
}