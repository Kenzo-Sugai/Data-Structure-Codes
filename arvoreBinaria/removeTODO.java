package removearv;
/**
 * @author      : lopespt (lopespt@$HOSTNAME)
 * @file        : main
 * @created     : quinta out 21, 2021 08:54:56 -03
 */

class No {
    public No(int valor) {
        this.valor = valor;
        this.esq = null;
        this.dir = null;
        this.pai = null;
    }
    public int valor;
    public No esq;
    public No dir;
    public No pai;
}

interface ArvBin {
    boolean insere(int valor);
    boolean remove(int valor);
    boolean busca(int valor);
    void imprime();
}

class ArvBinBusca implements ArvBin {
    public No raiz = null;
    private int n = 0;
    private void imprimeErd(No a) {
        if(a != null) {
            imprimeErd(a.esq);
            System.out.print(a.valor + "  ");
            imprimeErd(a.dir);
        }
    }

    public boolean insere(int valor) {
         No novo = new No(valor);
        if(raiz == null){
            raiz = novo;
            this.n++;
            return true;
        }
        
        No anterior = null;
        No atual = raiz;
        while(atual != null){
            anterior = atual;
            if(valor > atual.valor) atual = atual.dir;
            else if(atual.valor > valor) atual = atual.esq;
        }
        
        novo.valor = valor;
        
        if(novo.valor > anterior.valor) anterior.dir = novo;
        else if(novo.valor < anterior.valor) anterior.esq = novo;
        this.n++;
     
        return true;
    }
    public int getN() {
        return n;
    }
    
    private boolean isEsq(No atual){
        if(atual.esq == null) return false;
        else return true;
    }
    
    private boolean removeRec(No atual){
        if(atual.esq == null && atual.dir == null){ // 0 filhos
            if(isEsq(atual.pai)){
                atual.pai.esq = null;
            }
            else atual.pai.dir = null;
            
        } 
        else if(atual.esq != null && atual.dir != null){ // 2 filhos
            No atualsave = atual;
            atual = atual.dir;
            
            while(atual.esq != null){
                atual = atual.esq;
            }
            
            atualsave.valor = atual.valor;
            removeRec(atual);
        }
        else{ // 1 filho
            if(atual.esq == null) atual.pai.dir = atual.dir;
            else atual.pai.esq = atual.esq;
        }
       
        return true;
    }
    
    public boolean remove(int valor) {
        No atual = raiz;
        No anterior = null;
        while(atual != null){
            if(atual.valor == valor) break;
            anterior = atual;
            if(valor > atual.valor) atual = atual.dir;
            else if(atual.valor > valor) atual = atual.esq;
        }
         
        removeRec(atual);
        this.n--;
        return true;
        
    }

    public boolean busca(int valor) {
        No atual = raiz;
        while(atual != null){
            if(atual.valor == valor) return true;
            if(valor > atual.valor) atual = atual.dir;
            else if(atual.valor > valor) atual = atual.esq;
        }
        return false;
    }

    public void imprime() {
        imprimeErd(raiz);
        System.out.println();
    }

}

public class main {
    private static void testeBusca(ArvBinBusca a, int valor) {
        if (a.busca(valor)) {
            System.out.println("valor " + valor + " encontrado na arvore");
        } else {
            System.out.println("valor " + valor + " NAO encontrado na arvore");
        }
    }
    private static void testeInsere(ArvBinBusca a, int valor) {
        if (a.insere(valor)) {
            System.out.println("valor " + valor + " inserido na arvore");
            a.imprime();
            System.out.println("======== Total: " + a.getN() + " nos ===========\n");
        }
    }
    private static void testeRemove(ArvBinBusca a, int valor) {
        if (a.remove(valor)) {
            System.out.println("valor " + valor + " removido na arvore");
            a.imprime();
            System.out.println("======== Total: " + a.getN() + " nos ===========\n");
        }
    }
    public static void main(String[] args) {
        ArvBinBusca a = new ArvBinBusca();
        testeInsere(a, 51);
        testeInsere(a, 43);
        testeInsere(a, 5);
        testeInsere(a, 53);
        testeInsere(a, -15);
        testeInsere(a, 36);
        testeInsere(a, 17);
        testeInsere(a, 56);
        testeInsere(a, 55);
        testeInsere(a, 74);
        testeBusca(a, 55);
        testeBusca(a, 2);
        testeBusca(a, 15);
        testeBusca(a, 36);
        testeBusca(a, 22);
        testeBusca(a, -5);
        testeBusca(a, 55);
        testeBusca(a, 74);
        testeRemove(a, 51);
        testeRemove(a, 74);
        testeRemove(a, -15);
    }
}

3065
1228
1486
1023
3339
1121
1785
2017
2095
3149
1029
