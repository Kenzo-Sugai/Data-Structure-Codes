#include <iostream>

#define MAX 10

using namespace std;

class ILista {
  public:
    virtual bool push(int value) = 0;
    virtual bool pop() = 0;
    virtual int size() = 0;
    virtual bool printAll() = 0;
    virtual void imprime() = 0;
    virtual int top() = 0;
    ~ILista() = default;

};

class Stack : public ILista {

  private:
    int n;
    int *v;
    int capacity;

  public:

    Stack();
    bool push(int value);
    bool pop();
    int size();
    bool printAll();
    void imprime();
    int top();
};

Stack::Stack(){
  this->n = 0;
  this->capacity = MAX;
  this->v = new int[capacity];
}

bool Stack::push(int value){
  if(this->n + 1 == capacity) return false;
  this->v[n] = value;
  this->n++;
  return true;
}

bool Stack::pop(){
  if(this->n == 0) return false;
  this->n--;
  return true;
}

int Stack::size(){
  return this->n;
}

bool Stack::printAll(){
  if(this->n == 0) return false;
  for(int i = 0; i < this->n; i++){
    cout << v[i] << " ";
  }
  cout << endl;
  return true;
}

void Stack::imprime(){
  for(int i = this->n - 1 ;i >=0; i--){
    cout << v[i] << endl;
  }
}

int Stack::top(){
  return v[this->n - 1];
}

int main(){

  ILista *s = new Stack();

  s->push(1);
  s->push(2);
  s->push(3);
  s->push(4);
  s->imprime();
  cout << "TOP: " << s->top() << endl;
  cout << "----------------" << endl;
  s->pop();
  s->pop();
  s->push(5);
  s->imprime();
  cout << "TOP: " << s->top() << endl;
}
