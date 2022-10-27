import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author : lopespt (lopespt@$HOSTNAME)
 * @file : Main
 * @created : segunda out 24, 2022 10:28:32 -03
 */

class No {
    public int valor;
    public int altura;
    public List<No> filhos;

    No(int valor) {
        this.valor = valor;
        altura = 0;
        filhos = new ArrayList<>();
    }

    public boolean adicionaFilho(No filho) {
        return filhos.add(filho);
    }

}

class Arvore {
    private No raiz;
    private int altura = -1;

    Arvore(No raiz) {
        this.raiz = raiz;
    }



    public int getAlturaArvore() {
        PercorreArvore(raiz, 0);
        return altura;

    }

    private void PercorreArvore(No pai, int cnt){
        if(pai == null) return;

        if(cnt > altura) altura = cnt;

        for (No filho : pai.filhos) {
            PercorreArvore(filho, cnt + 1);
        }
    }

    public void imprimeArvore() {
        imprimeSubArvore(raiz);
    }

    public void imprimeSubArvore(No n) {
        if (n == null)
            return;

        System.out.printf("%d\n", n.valor);
        for (No filho : n.filhos) {
            imprimeSubArvore(filho);
        }
    }

}

public class Main {

    public static void main(String[] args) throws IOException {
        Map<Integer, No> hash = new HashMap<>();
        No raiz = null;
        try (Scanner scan = new Scanner(System.in)) {
            String op = scan.next();
            while (!op.toLowerCase().equals("x")) {
                switch (op.toLowerCase()) {
                    case "c":
                        No novo = new No(scan.nextInt());
                        hash.put(novo.valor, novo);
                        break;
                    case "p":
                        No filho = hash.get(scan.nextInt());
                        No pai = hash.get(scan.nextInt());
                        pai.adicionaFilho(filho);
                        break;
                    case "r":
                        raiz = hash.get(scan.nextInt());
                }
                op = scan.next();
            }
        }

        Arvore a = new Arvore(raiz);
        a.imprimeArvore();
        System.out.printf("Altura: %d\n", a.getAlturaArvore());
    }
}
