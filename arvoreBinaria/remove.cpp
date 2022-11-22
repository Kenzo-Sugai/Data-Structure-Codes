#include <iostream>
#include <string>

using namespace std;

string resp = "";

class No {
    public:
        No(int valor){
            this->valor = valor;
            this->esq = NULL;
            this->dir = NULL;
            this->pai = NULL;
        }

        int valor;
        No *esq;
        No *dir;
        No *pai;
};

class AB {

    public:

        No *raiz;

        bool insere(int valor){
            No *novo = new No(valor);
            if(raiz == NULL){
                raiz = novo;
                return true;
            }

            No *anterior = NULL;
            No *atual = raiz;

            while(atual != NULL){
                anterior = atual;
                if(valor < atual->valor) atual = atual->esq;
                else if(valor > atual->valor) atual = atual->dir;
            }

            novo->pai = anterior;

            if(valor < anterior->valor) anterior->esq = novo;
            else if(valor > anterior->valor) anterior->dir = novo;

            return true;

        }

        void imprimePREFIXO(No *pai){
            if(pai == NULL){   
                return;
            }
            resp += to_string(pai->valor);
            resp += " ";
            imprimePREFIXO(pai->esq);
            imprimePREFIXO(pai->dir);
        }

        void imprimePOSFIXO(No *pai){
            if(pai == NULL){   
                return;
            }
            imprimePOSFIXO(pai->esq);
            imprimePOSFIXO(pai->dir);
            resp += to_string(pai->valor);
            resp += " ";
        }

        void imprimeINFIXO(No *pai){
            if(pai == NULL){   
                return;
            }
            imprimeINFIXO(pai->esq);
            resp += to_string(pai->valor);
            resp += " ";
            imprimeINFIXO(pai->dir);
        }

        void busca(int valor){

            No *atual = raiz;

            while(atual != NULL){
                if(valor < atual->valor) atual = atual->esq;
                else if(valor > atual->valor) atual = atual->dir;
                else{
                    cout << valor << " existe" << endl;
                    return;
                }
            }

            cout << valor << " nao existe" << endl;

        }

        bool remove(int valor){

            No *atual = raiz;

            while(atual != NULL){
                if(valor < atual->valor) atual = atual->esq;
                else if(valor > atual->valor) atual = atual->dir;
                else{
                    remove(atual);
                    return true;
                }
            
            }

        }

        void removeCaso1(No *atual){

            No *pai = atual->pai;
            No *filho;

            if(atual->dir != NULL) filho = atual->dir;
            else filho = atual->esq;

            if(pai->dir == atual) pai->dir = filho;
            else pai->esq = filho;

            filho->pai = pai;
        }

        No* sucessor(No *atual){
            atual = atual->esq;
            while(atual->dir != NULL) atual = atual->dir;
            return atual;
        }

        void removeCaso2(No *atual){

            No *filhoRebaixado = sucessor(atual);

            atual->valor = filhoRebaixado->valor;
            remove(filhoRebaixado);

        }

        bool remove(No *atual) {
            //cout << "HERE" << endl;
            if(atual->dir == NULL && atual->esq == NULL){ // 0 FILHOS
                if(atual != raiz){
                    if(atual->pai->dir == atual) atual->pai->dir = NULL;
                    else atual->pai->esq = NULL;

                    return true;
                }
                else{
                    raiz = NULL;
                    return true;
                }
            }
            else if(atual->dir != NULL xor atual->esq != NULL){ // 1 FILHO
                if(atual != raiz) {
                    removeCaso1(atual);
                    return true;
                }
                else{
                    if(atual->dir == NULL) raiz = atual->esq;
                    else raiz = atual->dir;
                    return true;
                }
            }
            else{ // 2 FILHOS
                removeCaso2(atual);
                return true;

            }

            return true;
        }

};

int main(){

    int T, tam;
    int n;
    string t;


    AB *arv = new AB();
    while(cin >> t){
        resp = "";
        if(t == "I"){
            cin >> n;
            arv->insere(n);
        }
        if(t == "INFIXA"){
            arv->imprimeINFIXO(arv->raiz); resp.pop_back();
            cout << resp << endl;
            resp = "";
        }
        if(t == "PREFIXA"){
            arv->imprimePREFIXO(arv->raiz); resp.pop_back();
            cout << resp << endl;
            resp = "";
        }
        if(t == "POSFIXA"){
            arv->imprimePOSFIXO(arv->raiz); resp.pop_back();
            cout << resp << endl;
            resp = "";
        }
        if(t == "P"){
            cin >> n;
            arv->busca(n);
        }
        if(t == "R"){
            cin >> n;
            arv->remove(n);
        }
    }
    
}
