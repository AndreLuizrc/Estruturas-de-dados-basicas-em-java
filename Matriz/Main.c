#include <stdio.h>
typedef struct {
    int numero;
    CelulaMatriz *prox, *ant;
    CelulaMatriz *sup, *inf;
}CelulaMatriz;



CelulaMatriz* novaCelula(int numero){
    CelulaMatriz* nova = (CelulaMatriz*) malloc(sizeof(CelulaMatriz));
    nova->numero = numero;
    nova->ant = nova->prox = nova->inf = nova->sup = NULL;
    return nova;
}

CelulaMatriz* insertMatriz(CelulaMatriz* inicio, int linha, int coluna, int numero){
    CelulaMatriz* nova = novaCelula(numero);
    CelulaMatriz* celulaAtual = inicio;
    for(int i = 0; i < linha; i++){
        
    }
}


