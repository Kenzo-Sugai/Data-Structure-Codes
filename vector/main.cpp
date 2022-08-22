#include <iostream>
#include <cstdlib>

using namespace std;

class ILista {

  public:
    
    virtual bool insere(int valor){};
    virtual bool remove(int idx){};
    virtual int busca(int valor){};
    virtual void imprime(){};

};

class Lista : public ILista {

  private:

    int n;
    int capacity;
    int *v = NULL;

    public:

      Lista(int capacity);
      bool insere(int valor);
      bool remove(int idx);
      int busca(int valor);
      void imprime();
};

Lista::Lista(int capacity){
  this->n = 0;
  this->capacity = capacity;
  this->v = new int[capacity];
}

bool Lista::insere(int valor){
  if(this->capacity == this->n) return false;

  this->v[this->n] = valor;
  this->n++;
  return true;

}

bool Lista::remove(int idx){
  if(idx < 0 || idx >= this->n) return false;

  for(int i = idx; i < this->n - 1; i++){
    this->v[i] = this->v[i + 1];
  }
  this->n--;
  return true;
}

int Lista::busca(int valor){
  for (int i = 0; i < n; i++) {
    if(v[i] == valor) return i;
  }
  return -1;
}

void Lista::imprime(){
  for(int i = 0; i < this->n; i++){
    cout << this->v[i] << endl;
  }
}

class ListaOrdenada : public ILista {

  private:

    int *v = NULL;
    int n = 0;
    int capacity;

  public:

    ListaOrdenada(int capacity);
    bool insere(int valor);
    bool remove(int idx);
    int busca(int valor);
    void imprime();
};

ListaOrdenada::ListaOrdenada(int capacity){
  this->n = 0;
  this->capacity = capacity;
  this->v = new int[capacity];
}

bool ListaOrdenada::insere(int valor){
  if(this->capacity == this->n) return false;
  else{
    int i = 0;
    for(; this->v[i] <= valor && i < this->n; i++);
    
    for(int j = this->n - 1; j >= i; j--){
      this->v[j + 1] = this->v[j];
    }
    this->v[i] = valor;
    this->n++;
    
    return true;
  }
}

bool ListaOrdenada::remove(int idx){
  if (idx < 0 || idx >= n) return false;

  for(int i = idx; i < this->n - 1; i++){
    this->v[i] = this->v[i + 1];
  }
  this->n--;
  return true;
}

int ListaOrdenada::busca(int valor){
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

void ListaOrdenada::imprime(){
  for (int i = 0; i < n; i++) {
    cout << v[i] << endl;
  }
}

void testa(ILista *lista){

  cout << "Iniciando o teste: " << endl;
  int v[] = {6, 3, 8, 6, 4, 2, 8, 0, 1};

  for(auto &i: v) lista->insere(i);
  lista->imprime();
  cout << "======" << endl;
  lista->remove(3);
  lista->remove(0);
  lista->remove(lista->busca(8));
  lista->imprime();

  cout << "======" << endl;

  cout << "Fim do teste: " << endl;
}

int main(){
  ILista *t1 = new Lista(10);
  ILista *t2 = new ListaOrdenada(10);
  ILista *t3 = new Lista(5);
  ILista *t4 = new ListaOrdenada(5);
  testa(t1);
  testa(t2);
  testa(t3);
  testa(t4);
}
