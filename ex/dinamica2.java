import java.util.*;

class EntradaProb1{
    public List<Integer> setA = new ArrayList<>();
    public List<Integer> setB = new ArrayList<>();
}

public class Main {

    public static boolean executa(EntradaProb1 p){
       Hashtable<Integer, Integer> hashA = new Hashtable<Integer, Integer>();
       Hashtable<Integer, Integer> hashB = new Hashtable<Integer, Integer>();
       
       for(int i = 0; i < p.setA.size(); i++){
           if(hashA.get(p.setA.get(i)) == null){
               hashA.put(p.setA.get(i), 0);
           }
           if(hashB.get(p.setB.get(i)) == null){
               hashB.put(p.setB.get(i), 0);
           }
           
           hashA.put(p.setA.get(i), hashA.get(p.setA.get(i))+1);
           hashB.put(p.setB.get(i), hashB.get(p.setB.get(i))+1);
       }
       
       if(hashA.equals(hashB)) return true;
       else return false;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int na = s.nextInt();
        EntradaProb1 p = new EntradaProb1();
        while(na > 0){
            p.setA.add(s.nextInt());
            na--;
        }
        int nb = s.nextInt();
        while(nb > 0){
            p.setB.add(s.nextInt());
            nb--;
        }
        System.out.println(executa(p) ? "Verdadeiro" : "Falso");
    }



}
