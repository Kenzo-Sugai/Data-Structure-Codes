#include <cstdlib>
#include <iostream>
#include <string>
#include <queue>
#include <stack>

using namespace std;

int main(int argc, char *argv[])
{
	string input;
	//entrada da string
	cin >> input;
	int count = 0;
	queue<char> M; // fila para armazenar a sequencia
	stack<char> W; // pilha para armazenar a sequencia contraria
	bool troca = true; // verificar se está antes ou depois do c
	for(int i = 0; i < input.size();i++){ // for para percorrer a string e analisar cada char
	    if((input[i] < 'a' or input[i] > 'c')){ // considerando o ascii, se for menor que a e maior que c, significa que é qualquer outro caracter sem ser o a,b,c
			cout << "MAMOU" << endl;
			cin >> input;
			return 0;
		}
		if(input[i] != 'c'){ // enquanto não chegar o c
			if(troca){ // se troca positivo = lado esquerdo
				M.push(input[i]);
			} else{// se troca negativo = lado direito
				W.push(input[i]);
			}
		} else {// troca para o lado direito quando encontra o c
			troca = false;
			count++;
		}
	}
	if(count != 1){// se houver mais de 1 c ou nao teve nenhum c), ta errado fudeu
		cout << "MAMOU" << endl;
		cin >> input;
		return 0;
	}
	while(!M.empty()){ // para acessar todos os elementos da fila enquanto for vazio
		char m = M.front(); //  frente da fila
		char w = W.top(); // topo da pilha
		W.pop(); M.pop(); // remove o topo e a frente
		if(m != w){ // se eles não forem iguais, já deu piroca, mamou e finaliza o código
            cout << "MAMOU" << endl;
            cin >> input;
            return 0;
		}
		// se todos forem iguais, ele termina se acessar a fila até fica vazia, ai printa o YES, ou seja, deu bom caraio
	}
	cout << "YES" << endl;
	cin >> input;
	
}
