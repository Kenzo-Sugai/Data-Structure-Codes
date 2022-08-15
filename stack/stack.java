package lde;

class No<T>{
    public T valor;
    public No<T> proximo;
}

class LDE<T> { // LISTA DINAMICA ENCADEADA
    private No<T> primeiro = null;
    
    public boolean insert(T valor){
        No<T> novo = new No<>();
        novo.valor = valor;
        novo.proximo = null;
        
        novo.proximo = this.primeiro;
        this.primeiro = novo;
        
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
            lde.insert(6);
            lde.print();
    }
    
}
