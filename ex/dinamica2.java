package hash_dinamic;
import java.util.*;
        
public class Hash_dinamic {
    
    public static void test(ArrayList<Integer> A, ArrayList<Integer> B){
       Hashtable<Integer, Integer> hashA = new Hashtable<Integer, Integer>();
       Hashtable<Integer, Integer> hashB = new Hashtable<Integer, Integer>();
       
       for(int i = 0; i < A.size(); i++){
           if(hashA.get(A.get(i)) == null){
               hashA.put(A.get(i), 0);
           }
           if(hashB.get(B.get(i)) == null){
               hashB.put(B.get(i), 0);
           }
           
           hashA.put(A.get(i), hashA.get(A.get(i))+1);
           hashB.put(B.get(i), hashB.get(B.get(i))+1);
       }
       
       if(hashA.equals(hashB)) System.out.println("Verdadeiro");
       else System.out.println("Falso");
       
    }
    
    public static void main(String[] args) {
        
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();
        A.add(2); A.add(5); A.add(6); A.add(8); A.add(10); A.add(2); A.add(2);
        B.add(2); B.add(5); B.add(5); B.add(8); B.add(10); B.add(5); B.add(6);
        test(A, B);
        A.clear(); B.clear();
        A.add(1); A.add(1); A.add(1); A.add(1); A.add(1); A.add(1); A.add(2);
        B.add(1); B.add(1); B.add(1); B.add(2); B.add(1); B.add(1); B.add(1);
        test(A, B);
        
       
        
    }
    
    
    
}
