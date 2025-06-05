package arvorebinaria;

public class Elemento {
    int valor;
    Elemento esquerda;
    Elemento direita;

    public Elemento (int novoValor) {
        this.valor = novoValor;
        this.esquerda = null;
        this.direita = null;
    }
}
