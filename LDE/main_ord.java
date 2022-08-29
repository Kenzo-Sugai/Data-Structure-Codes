package lde;

class No<T>{
    public T valor;
    public No<T> proximo;
}

class LDE<T extends Comparable<T>> { // LISTA DINAMICA ENCADEADA
    private No<T> primeiro = null;
    
    public boolean insert(T valor){
        No<T> novo = new No<>();
        novo.valor = valor;
        novo.proximo = null;
        
        No<T> atual = this.primeiro;
        No<T> anterior = null;
        
        while(atual != null && atual.valor.compareTo(valor) > 0){
            anterior = atual;
            atual = atual.proximo;
        }
        
        if(anterior != null){
            anterior.proximo = novo;
        } else {
            this.primeiro = novo;
        }
        
        novo.proximo = atual;
        
        return true;
    }
    
    public void print(){
        No<T> atual = this.primeiro;
        while(atual != null){
            System.out.println(atual.valor);
            atual = atual.proximo;
        }
    }
}

public class main {

    public static void main(String[] args) {
            LDE<Integer> lde = new LDE<>();
            lde.insert(5);
            lde.insert(2);
            lde.insert(8);
            lde.insert(1);
            lde.print();
    }
    
}
