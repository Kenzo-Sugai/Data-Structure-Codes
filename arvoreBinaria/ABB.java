package arvorebusca;

class No{
    public int valor;
    public No dir;
    public No esq;
    
    No(int valor){
        this.valor = valor;
        this.dir = null;
        this.esq = null;
    }
    
}

interface IABB {
    boolean insere(int valor);
    boolean busca(int valor);
    void imprime(No pai);
}

class ABB implements IABB {
    public No raiz;
    
    @Override
    public boolean insere(int valor){
        No novo = new No(valor);
        if(raiz == null){
            raiz = novo;
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
        
        if(novo.valor > anterior.valor) atual.dir = novo;
        else if(novo.valor < anterior.valor) atual.esq = novo;
        
        return true;
    }
    
    @Override
    public boolean busca(int raiz){
        return true;
    }
    
    @Override
    public void imprime(No pai){
        if(pai == null) return;
        
        System.out.println(pai.valor);
        imprime(pai.esq);
        imprime(pai.dir);
        
    }
      
}


public class Arvorebusca {

    public static void main(String[] args) {
       ABB arvore = new ABB();
       
       arvore.insere(20);
       arvore.insere(10);
       arvore.insere(30);
       arvore.insere(5);
       arvore.insere(12);
       arvore.insere(3);
       arvore.insere(7);
       
       arvore.imprime(arvore.raiz);
    }
    
}
