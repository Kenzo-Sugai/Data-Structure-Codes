package lab_ed;
import java.util.*;

public class Lab_ED {

    public static void main(String[] args) {
        String input;
        Scanner scan = new Scanner(System.in);
        input = scan.nextLine();
        int count = 0;
        Queue<Character> M = new LinkedList<>();
        Stack<Character> W = new Stack<>();
        
        boolean troca = true;
        
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) < 'a' || input.charAt(i) > 'c'){
                System.out.println("FALSE");
                System.exit(0);
            }
            if(input.charAt(i) != 'c'){
                if(troca) M.add(input.charAt(i));
                else W.add(input.charAt(i));
            }
            else{
                troca = false;
                count++;
            }
        }
        if(count != 1){
            System.out.println("FALSE");
            System.exit(0);
        }
        while(!M.isEmpty()){
            char m = M.peek();
            char w = W.peek();
            System.out.println(m+" "+w);
            W.pop(); M.remove();
            if(m != w){
                System.out.println("FALSE");
                System.exit(0);
            }
        }
        System.out.println("YES");
        
        
    }
    
}
