package arvorebinaria;

public class ArvoreBinaria {

    Elemento raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void adicionar(int valor) {
    this.raiz = adicionarAVL(this.raiz, valor);
}

public Elemento adicionarAVL(Elemento node, int valor) {
        if (node == null)
            return new Elemento(valor);

        if (valor < node.valor) {
            node.esquerda = adicionarAVL(node.esquerda, valor);
        } else if (valor > node.valor) {
            node.direita = adicionarAVL(node.direita, valor);
        } else {
            return node; // valores duplicados não são permitidos
        }

        // Atualiza altura do nó atual
        node.altura = 1 + Math.max(altura(node.esquerda), altura(node.direita));

        // Verifica balanceamento
        int balance = fatorBalanceamento(node);

        // Casos de desbalanceamento
        if (balance > 1 && valor < node.esquerda.valor)
            return rotacaoDireita(node); // Caso Esquerda-Esquerda

        if (balance < -1 && valor > node.direita.valor)
            return rotacaoEsquerda(node); // Caso Direita-Direita

        if (balance > 1 && valor > node.esquerda.valor) {
            node.esquerda = rotacaoEsquerda(node.esquerda);
            return rotacaoDireita(node); // Caso Esquerda-Direita
        }

        if (balance < -1 && valor < node.direita.valor) {
            node.direita = rotacaoDireita(node.direita);
            return rotacaoEsquerda(node); // Caso Direita-Esquerda
        }

    return node;
    }

    public void remover(int valor) {
    this.raiz = removerAVL(this.raiz, valor);
}

public Elemento removerAVL(Elemento node, int valor) {
    if (node == null) {
        return null;
    }

    // Passo 1: Remoção padrão BST
    if (valor < node.valor) {
        node.esquerda = removerAVL(node.esquerda, valor);
    } else if (valor > node.valor) {
        node.direita = removerAVL(node.direita, valor);
    } else {
        // Nó com um ou nenhum filho
        if (node.esquerda == null || node.direita == null) {
            Elemento temp = (node.esquerda != null) ? node.esquerda : node.direita;

            // Nenhum filho
            if (temp == null) {
                node = null;
            } else {
                node = temp; // Um filho
            }
        } else {
            // Nó com dois filhos: pegar o menor da subárvore direita (sucessor)
            Elemento sucessor = getMinValueNode(node.direita);
            node.valor = sucessor.valor;
            node.direita = removerAVL(node.direita, sucessor.valor);
        }
    }

    // Se a árvore só tinha um nó
    if (node == null) {
        return null;
    }

    // Passo 2: Atualizar altura
    node.altura = 1 + Math.max(altura(node.esquerda), altura(node.direita));

    // Passo 3: Rebalancear
    int balance = fatorBalanceamento(node);

    // Casos de rebalanceamento
    if (balance > 1 && fatorBalanceamento(node.esquerda) >= 0)
        return rotacaoDireita(node); // Esquerda-Esquerda

    if (balance > 1 && fatorBalanceamento(node.esquerda) < 0) {
        node.esquerda = rotacaoEsquerda(node.esquerda);
        return rotacaoDireita(node); // Esquerda-Direita
    }

    if (balance < -1 && fatorBalanceamento(node.direita) <= 0)
        return rotacaoEsquerda(node); // Direita-Direita

    if (balance < -1 && fatorBalanceamento(node.direita) > 0) {
        node.direita = rotacaoDireita(node.direita);
        return rotacaoEsquerda(node); // Direita-Esquerda
    }

    return node;
}

// Função para encontrar o menor valor da subárvore
public Elemento getMinValueNode(Elemento node) {
    Elemento atual = node;
    while (atual.esquerda != null)
        atual = atual.esquerda;
    return atual;
}

    public Elemento getRaiz() {
        return raiz;
    }

    public int altura (Elemento elemento) {
        if (elemento == null) {
            return 0;
        }
        return elemento.altura;
    }

    public int fatorBalanceamento (Elemento elemento) {
        if (elemento == null) {
            return 0;
        }
        return altura(elemento.esquerda) - altura (elemento.direita);
    }

    public Elemento rotacaoDireita (Elemento y) {
        Elemento x = y.esquerda;
        Elemento t2 = x.direita;

        x.direita = y;
        y.esquerda = t2;

        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;

        return x;
    }

    public Elemento rotacaoEsquerda (Elemento x) {
        Elemento y = x.direita;
        Elemento t2 = y.esquerda;

        y.esquerda = x;
        x.direita = t2;

        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;
        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;

        return y;
    }

    
}
