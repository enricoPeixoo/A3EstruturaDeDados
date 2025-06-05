package arvorebinaria;

public class ArvoreBinaria {

    Elemento raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void adicionar (int novoValor) {
        Elemento novoElemento = new Elemento (novoValor);
        if (raiz == null) {
            this.raiz = novoElemento;
        } else {
            Elemento atual = this.raiz;
            while (true) {
                if (novoElemento.valor < atual.valor) {
                    if (atual.esquerda != null) {
                        atual = atual.esquerda;
                    } else {
                        atual.esquerda = novoElemento;
                        break;
                    }
                } else {
                    if (atual.direita != null) {
                        atual = atual.direita;
                    } else {
                        atual.direita = novoElemento;
                        break;
                    }
                }
            }
        }
    }

    public boolean remover (int valor) {
        Elemento atual = this.raiz;
        Elemento paiAtual = null;

        while (atual != null) {
            if(atual.valor == valor) {
                break;
            } else if (valor < atual.valor){
                paiAtual = atual;
                atual = atual.esquerda;
            } else {
                paiAtual = atual;
                atual = atual.direita;
            }
        }

        if (atual != null) {

            
            if (atual.direita != null) { //Elemento tem 2 filhos ou só tem filho a direita
                Elemento substituto = atual.direita;
                Elemento paiSubstituto = atual;
                
                while (substituto.esquerda != null) {
                    paiSubstituto = substituto;
                    substituto = substituto.esquerda;
                }
                substituto.esquerda = atual.esquerda;
                if (paiAtual != null) {
                    if (atual.valor < paiAtual.valor) {
                        paiAtual.esquerda = substituto;
                    } else {
                        paiAtual.direita = substituto;
                    }
                } else {
                    this.raiz = substituto;
                }

                if (substituto.valor < paiSubstituto.valor) {
                    paiSubstituto.esquerda = null;
                } else {
                    paiSubstituto.direita = null;
                }

            } else if (atual.esquerda != null) { //Tem filho só a esquerda
                Elemento substituto = atual.esquerda;
                Elemento paiSubstituto = atual;
                
                while (substituto.direita != null) {
                    paiSubstituto = substituto;
                    substituto = substituto.direita;
                }

                if (paiAtual != null) {
                    if (atual.valor < paiAtual.valor) {
                        paiAtual.esquerda = substituto;
                    } else {
                        paiAtual.direita = substituto;
                    }
                } else {
                    this.raiz = substituto;
                }

                if (substituto.valor < paiSubstituto.valor) {
                    paiSubstituto.esquerda = null;
                } else {
                    paiSubstituto.direita = null;
                }

            } else { //Sem filhos
                if (paiAtual != null) {
                    if (atual.valor < paiAtual.valor) {
                        paiAtual.esquerda = null;
                    } else {
                        paiAtual.direita = null;
                    }
                } else {
                    this.raiz = null;
                }   

            }

            return true;
        } else {
            return false;
        }
    }


    public Elemento getRaiz() {
        return raiz;
    }

    
}
