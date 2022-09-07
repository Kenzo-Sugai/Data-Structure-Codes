interface ILista{
  boolean insere(int valor);
    boolean remove(int idx);
    void imprime();
    void imprimeReverso();
    int busca(int valor);
}

class No {
    No anterior;
    No proximo;
    int valor;
}

class LDDE implements ILista {
  private No primeiro = null;
  private No ultimo = null;
  private int n = 0;

  public int getN() {
      return n;
  }

  public void setN(int n) {
      this.n = n;
  }

  @Override
  public boolean insere(int valor){
    // instanciar o novo objeto na LDDE 
    No novo = new No();
    novo.valor = valor;
    novo.proximo = null;
    novo.anterior = null;

    // apontadores para percorrer a LDDE
    No anterior = null;
    No atual = primeiro;

    // percorrer a LDDE até encontrar o valor correto
    while(atual != null && atual.valor < valor){
      anterior = atual;
      atual = atual.proximo;
    }

    // caso: anterior é null
    if(anterior == null) primeiro = novo;
    else anterior.proximo = novo;

    novo.anterior = anterior; 

    // caso: atual é null
    if(atual == null) ultimo = novo;
    else atual.anterior = novo;

    novo.proximo = atual;

    this.n++;
    
    return true;
  }

  @Override
  public int busca(int valor){
    No atual = primeiro;
    int idx = 0;
    while(atual != null && atual.valor < valor){
      atual = atual.proximo;
      idx++;
    }
    if(atual != null && atual.valor == valor){
      return idx;
    }
    else{
      return 0;
    }
  }

  @Override
  public boolean remove(int idx){
    // apontadores para percorrer a LDDE
    No anterior = null;
    No atual = primeiro;

    int index = 0;

    // percorrer a LDDE até encontrar o index correto    
    while(atual != null && index != idx){
      anterior = atual;
      atual = atual.proximo;
      index++;
    }

    // caso: atual é null
    if(atual == null) return false;

    // caso: anterior é null
    if(anterior == null) primeiro = atual.proximo;
    else anterior.proximo = atual.proximo;

    // caso: proximo é null
    if(atual.proximo == null) ultimo = anterior;
    else atual.proximo.anterior = anterior;

    // apagar objeto (setar null)
    atual = null;

    this.n--;

    return true;   
  }
  
  @Override
  public void imprime() {
    No atual = primeiro;
    while(atual != null) {
      System.out.println(atual.valor);
      atual = atual.proximo;
    }
  }

  @Override
  public void imprimeReverso() {
    No atual = ultimo;
    while(atual != null) {
      System.out.println(atual.valor);
      atual = atual.anterior;
    }
  }
  
}


public class Main {
    public static void imprime(ILista l, String titulo) {
        System.out.println("==" + titulo + "==");
        l.imprime();
        System.out.println("=====Reverso====");
        l.imprimeReverso();
        System.out.println("======FIM=======");
    }
    public static void main(String[] args) {
        ILista l = new LDDE();
        l.insere(20);
        l.insere(10);
        l.insere(5);
        l.insere(35);
        l.insere(200);
        imprime(l, "Após Inserções");

        l.remove(3);
        imprime(l, "Após Remove indice 3");

        l.remove(l.busca(10));
        imprime(l, "Após Remove número 10");

        while(l.remove(0));

        imprime(l, "Após Remover todos");
    }
}
