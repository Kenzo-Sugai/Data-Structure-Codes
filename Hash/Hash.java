package javaapplication1;
import java.util.ArrayList;

class Hash{
    private int max;
    private ArrayList<Integer> v[];
    private int n;
    Hash(int max){
        this.max = max;
        this.v = new ArrayList[max];
        this.n = 0;
    }
    
    int fHash(int x){
        return x % this.max;
    }
    
    boolean insere(int x){
        if(n >= max) return false;
        
        int idx = fHash(x);
        this.v[idx].add(x);
        n++;
        return true;
    }
}


public class JavaApplication1 {

    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
