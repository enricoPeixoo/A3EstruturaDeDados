package arvorebinaria;

public class Elemento {
    int valor;
    Elemento esquerda;
    Elemento direita;
    int altura;

    public Elemento (int novoValor) {
        this.valor = novoValor;
        this.esquerda = null;
        this.direita = null;
        this.altura = 1;
    }
}
