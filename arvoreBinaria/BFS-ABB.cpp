#include <iostream>
#include <vector>
#include <queue>
#include <map>

#define ESQ 0
#define DIR 1

using namespace std;

void insert(vector<vector<int>> &arvore, map<int, int> &vertice, int valor, int idx){
    int atual = 0, anterior;
    while(atual != -1){
        anterior = atual;
        if(valor < vertice[atual]) atual = arvore[atual][ESQ]; 
        else if(valor > vertice[atual]) atual = arvore[atual][DIR];

    }

    if(valor < vertice[anterior]) arvore[anterior][ESQ] = idx; 
    else if(valor > vertice[anterior]) arvore[anterior][DIR] = idx;

}


int main(){

    int T, size, valor, t = 0;
    cin >> T;

    while(T--){
        t++;
        map<int, int> vertice;
        vector<vector<int>> arvore;

        cin >> size;

        arvore.resize(size);

        for(int i = 0; i < size; i++) arvore[i].resize(2, -1);


        for(int i = 0; i < size; i++){

            cin >> valor;
            vertice[i] = valor;

            if(i != 0){

                insert(arvore, vertice, valor, i);

            }

        }

        queue<int> Q;
        Q.push(0);

        cout << "Case " << t << ":" << endl;
        int v = 0;
        while(!Q.empty()){
            int u = Q.front(); Q.pop();
            v++;
            if(v == size) cout << vertice[u];
            else cout << vertice[u] << " ";

            if(arvore[u][ESQ] != -1) Q.push(arvore[u][ESQ]);
            if(arvore[u][DIR] != -1) Q.push(arvore[u][DIR]);
        }

        cout << endl << endl;
    }

}
