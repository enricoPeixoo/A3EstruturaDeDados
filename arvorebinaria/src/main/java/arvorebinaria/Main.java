package arvorebinaria;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        ArvoreBinaria avl = new ArvoreBinaria();

        // Inserções
        avl.adicionar(7);
        avl.adicionar(6);
        avl.adicionar(9);
        avl.adicionar(5);
        avl.adicionar(4);
        
        

        // Remoções
        //avl.remover(1);

        System.out.println("Número de rotações: "+ avl.getNumeroRotacoes());

        // Criar a janela
        JFrame frame = new JFrame("Árvore AVL");
        ArvoreAVLViewer painel = new ArvoreAVLViewer(avl.getRaiz());
        frame.add(painel);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }
}