package queue;
import java.util.ArrayList;
interface IFila {
    boolean enfileira(int x);
    int desenfileira() throws Exception;
    boolean isEmpty();
}

class FilaEstCircular implements IFila {
    private int lista[];
    public int TAM;
    private int inicio;
    private int fim;
    
    public FilaEstCircular(int TAM){
        lista = new int[TAM+1];
        this.TAM = TAM+1;
    }
    
    
    public boolean enfileira(int x){
        if((fim+1) % TAM == inicio){
            return false;
        }
        lista[fim] = x;
        fim = (fim+1) % TAM;
        
        return true;
    }
    
    @Override
    public int desenfileira() throws Exception {
        if(inicio == fim){
            throw new Exception("PAN!!!");
        }
        int t = lista[inicio];
        inicio = (inicio+1) % TAM;
        
        return t;
    }
    
    public boolean isEmpty(){
        return inicio == fim;
    }
}

public class Main {
    
    public static void main(String[] args) throws Exception{
        IFila queue = new FilaEstCircular(5);
        queue.enfileira(5);
        queue.enfileira(2);
        queue.enfileira(7);
        queue.enfileira(1);
        queue.enfileira(3);
        queue.enfileira(3);
        queue.enfileira(3);
        while(!queue.isEmpty()){
            int x = queue.desenfileira();
            System.out.println(x);
            
        }
    }
}
