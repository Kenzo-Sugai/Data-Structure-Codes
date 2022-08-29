#include <iostream>

using namespace std;

class No{
  public:
    int valor;
    No *proximo;
    No(int valor);
    int getValor();
    No getProximo();
};

int No::getValor(){
    return valor;
}

No No::getProximo(){
    return *proximo;
}


No::No(int valor) : valor(valor), proximo(NULL) {}

class ILista{
  public:
    virtual bool insere(int valor) = 0;
    virtual bool remove(int idx) = 0;
    virtual int busca(int valor) = 0;
    virtual void imprime() = 0;
    virtual ~ILista() = default;
};

class LDE : public ILista{
  private:
    No *primeiro;
    int n;
  public:
    bool insere(int valor);
    bool remove(int idx);
    int busca(int valor);
    void imprime();
    LDE();
};

LDE::LDE() : primeiro(NULL), n(0) {}

bool LDE::insere(int valor){
  No *temp = new No(valor);
  if(temp == NULL) return false;
  No *anterior = NULL;
  No *atual = primeiro;
  while(atual != NULL && atual->valor < valor){
    anterior = atual;
    atual = atual->proximo;
  }

  if(anterior != NULL) anterior->proximo = temp;
  else primeiro = temp;

  temp->proximo = atual;
  n++;
  return true;
}

void LDE::imprime(){
  No *temp = primeiro;
  while(temp != NULL){
    cout << temp->valor << endl;
    temp = temp->proximo;
  }
}

bool LDE::remove(int idx) {
  No *atual = primeiro;
  No *anterior = NULL;
  int index = 0;
  while(atual->proximo != NULL && idx != index){
    index++;
    atual = atual->proximo;
    anterior = atual;
  }
  if(anterior == NULL){
    primeiro = atual->proximo;
    n--;
  }
  else{
    anterior->proximo = atual->proximo;
    n--;
  }
  atual = NULL;
  return true;
}

int LDE::busca(int valor) {
  No *atual = primeiro;
  No *anterior = NULL;
  int index = 0;
  while(atual->proximo != NULL){
    if(atual->valor == valor) return index;
    index++;
    atual = atual->proximo;
    anterior = atual;
  }
  return -1;
}


int main() {
  LDE *l = new LDE();

  l->insere(1);
  l->insere(5);
  l->insere(3);
  l->insere(9);
  l->insere(2);
  l->insere(0);
  cout << "===================" << endl;
  l->imprime();
  l->remove(3);
  cout << "===================" << endl;
  l->imprime();
  l->remove(0);
  cout << "===================" << endl;
  l->imprime();
  l->remove(3);
  cout << "===================" << endl;
  l->imprime();
  l->insere(9);
  cout << "===================" << endl;
  l->imprime();
  cout << "Buscas:" << endl;
  for (int i = 0; i < 10; i++) {
    cout << i << " = " << l->busca(i) << endl;
  }
}
