package javaapplication1;
import java.util.ArrayList;

interface IFila {
    boolean enfileirar(int valor);
    int desefileirar();
    int tamanho();
}

class Heap implements IFila{
    private ArrayList<Integer> v;
    private int n;
    Heap(ArrayList<Integer> lista){
         v = lista;
         n = lista.size();
         int idx = ultimoPai();
         while(idx >= 0){
             sift(idx--);
         }
     }
    
    private int fe(int x){
        return 2*x + 1;
    }
    
    private int fd(int x){
        return 2*x + 2;
    }
    
    private int pai(int x){
        return (x-1)/2;
    }
    
    private int ultimoPai(){
        return pai(n - 1);
    }
    
    private void sift(int idx){
        if(idx > ultimoPai()) return;
        
        int idxMax = fe(idx);
        if(fd(idx) < n && v.get(fd(idx)) > v.get(idxMax)){
            idxMax = fd(idx);
        }

        if(v.get(idxMax) > v.get(idx)){
            int temp = v.get(idxMax);
            v.set(idxMax, v.get(idx));
            v.set(idx, temp);
            sift(idxMax);
        }
    }
    
    @Override
    public boolean enfileirar(int valor) {
        
        return false;
    }

    @Override
    public int desefileirar() {
        int temp = v.get(0);
        v.set(0, v.get(n-1));
        v.set(n-1, temp);
        n--;
        sift(0);
        return v.get(n);
    }

    @Override
    public int tamanho() {
        return 0;
    }
    
    void print(){
        System.out.print("O: ");
        v.forEach( (x) ->{
            System.out.print(x+" ");
        });
        System.out.println();
        System.out.print("n: ");
        for(int i = 0; i < n; i++){
            System.out.print(v.get(i)+" ");
        }
        System.out.println();
        
    }
    
}

public class JavaApplication1 {

    public static void main(String[] args) {
        
        ArrayList<Integer> v = new ArrayList<>();
        v.add(2);
        v.add(5);
        v.add(1);
        v.add(9);
        v.add(3);
        v.add(4);
        v.add(8);
        v.add(0);
        Heap h = new Heap(v);
        h.print();
        System.out.println("Removido: "+h.desefileirar());
        h.print();
        System.out.println("Removido: "+h.desefileirar());
        h.print();
        System.out.println("Removido: "+h.desefileirar());
        h.print();
        
        
        
    }
    
}
