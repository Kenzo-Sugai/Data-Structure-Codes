package Main;

/**
 * @author      : lopespt (lopespt@$HOSTNAME)
 * @file        : main
 * @created     : quarta set 01, 2021 21:38:51 -03
 */

interface ILista{
  public boolean insere(int valor);
  public boolean remove(int idx);
  public int busca(int valor);
  public void imprime();
}

class No {
    No anterior;
    No proximo;
    int valor;
}

class LDDE implements ILista {
    public No primeiro = null;
    
    @Override
    public boolean insere(int valor){
        No novo = new No();
        novo.valor = valor;
        novo.anterior = null;
        novo.proximo = null;
        No atual = null;
        No prox = primeiro;
        No ultimo = null;
        
        while(atual != null && atual.proximo != null && atual.proximo.valor < valor){
            atual = prox;
            prox = prox.proximo;
        }
        
        if(atual != null){
            atual.proximo = novo;
        } else {
            primeiro = novo;
        }
        
        novo.anterior = atual;
        
        novo.proximo = prox;
        
        if(prox != null)
            prox.anterior = novo;
        else
            ultimo = novo;
        
        return true;
    }
    public boolean remove(int idx){
      return false;
    }
    public int busca(int valor){
      return 0;
    }
    public void imprime(){
        No atual = primeiro;
        while(atual != null){
            System.out.println(atual.valor);
            atual = atual.proximo;
        }
    }
}

class Lista implements ILista{
  private int n;
  private int capacity;
  private int[] v;
  public Lista(int capacity){
    this.n = 0;
    this.capacity = capacity;
    this.v = new int[this.capacity];
  }

  public boolean insere(int valor){
    if (this.capacity == this.n)
      return false;

    this.v[this.n] = valor;
    this.n++;
    return true;
  }

  public boolean remove(int idx){
    if (idx < 0 || idx >= this.n){
      return false;
    }
    
    for (int i = idx; i < this.n - 1; i++) {
      v[i] = v[i+1];
    }	
    n--;
    return true;
  }

  public int busca(int valor){
    for (int i = 0; i < n; i++) {
      if(v[i] == valor)
        return i;
    }

    return -1;
  }

  public void imprime(){
    for (int i = 0; i < n; i++) {
      System.out.println(v[i]);
    }
  }

}

class ListaOrdenada implements ILista{
  private int[] v;
  private int n;
  private int capacidade;
  ListaOrdenada(int capacidade){
    this.capacidade = capacidade;
    this.n = 0;
    this.v = new int[capacidade];
  }

  public boolean insere(int valor){
    if(this.capacidade == this.n){
    	return false;
    }
    else{
    	int i = 0;
    	for(; this.v[i] <= valor && i < this.n; i++);
    	
    	for(int j = this.n - 1; j >= i; j--){
    		this.v[j + 1] = this.v[j];
    	}
    	this.v[i] = valor;
    	this.n++;
    	
    	return true;
    }
    
  }
  public boolean remove(int idx){
	  if (idx < 0 || idx >= n){
		  return false;
	  }
	  for(int i = idx; i < this.n - 1; i++){
		  this.v[i] = this.v[i + 1];
	  }
	  this.n--;
	  return true;
    
  }
  public int busca(int valor){
    int esq = 0;
    int dir = n-1;

    while (esq <= dir){
      int pivo = (esq + dir)/2;
      if (valor < v[pivo] ){
        dir = pivo - 1;
      }else if (valor > v[pivo]){
        esq = pivo + 1;
      }else{
        return pivo;
      }
    }
  
    return -1;
  }
  public void imprime(){
    for (int i = 0; i < n; i++) {
      System.out.println(v[i]);
    }
  }
}
public class JavaApplication1
{
    public static void testa(ILista lista){
      System.out.println("Iniciando teste: ");
        int v[] = {6,3,8,6,4,2,8,0,1};

        for (int i : v) {
          lista.insere(i);
        }
        lista.imprime();
        System.out.println("======");
        lista.remove(3);
        lista.remove(0);
        lista.remove(lista.busca(8));
        lista.imprime();
      System.out.println("Fim do teste: ");
    }
    public static void main(String args[])
    {
      testa(new Lista(10));
      testa(new ListaOrdenada(10));
      testa(new Lista(5));
      testa(new ListaOrdenada(5));
      testa(new LDDE);
    }
}
