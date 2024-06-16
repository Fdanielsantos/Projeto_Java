#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

// Definindo a estrutura da pilha
#define MAXPILHA 100
#define MAXLEN 100

typedef struct {
    int topo;
    double itens[MAXPILHA];
} Pilha;

// Inicializa a pilha
void inicializaPilha(Pilha *p) {
    p->topo = -1;
}

// Verifica se a pilha está cheia
int estaCheia(Pilha *p) {
    return p->topo == MAXPILHA - 1;
}

// Verifica se a pilha está vazia
int estaVazia(Pilha *p) {
    return p->topo == -1;
}

// Empilha um item na pilha
void empilha(Pilha *p, double valor) {
    if (!estaCheia(p)) {
        p->itens[++(p->topo)] = valor;
    } else {
        printf("Pilha cheia\n");
    }
}

// Desempilha um item da pilha
double desempilha(Pilha *p) {
    if (!estaVazia(p)) {
        return p->itens[(p->topo)--];
    } else {
        printf("Pilha vazia\n");
        return 0.0;
    }
}

// Realiza as operações
void realizaOperacao(Pilha *p, char *op) {
    double a, b;
    if (strcmp(op, "+") == 0) {
        b = desempilha(p);
        a = desempilha(p);
        empilha(p, a + b);
    } else if (strcmp(op, "-") == 0) {
        b = desempilha(p);
        a = desempilha(p);
        empilha(p, a - b);
    } else if (strcmp(op, "*") == 0) {
        b = desempilha(p);
        a = desempilha(p);
        empilha(p, a * b);
    } else if (strcmp(op, "/") == 0) {
        b = desempilha(p);
        a = desempilha(p);
        if (b != 0)
            empilha(p, a / b);
        else
            printf("Dividir por zero\n");
    } else if (strcmp(op, "^") == 0) {
        b = desempilha(p);
        a = desempilha(p);
        empilha(p, pow(a, b));
    } else if (strcmp(op, "log") == 0) {
        a = desempilha(p);
        empilha(p, log10(a));
    } else if (strcmp(op, "sen") == 0) {
        a = desempilha(p);
        empilha(p, sin(a * M_PI / 180.0)); // convertendo para radianos
    } else if (strcmp(op, "cos") == 0) {
        a = desempilha(p);
        empilha(p, cos(a * M_PI / 180.0)); // convertendo para radianos
    } else {
        printf("Operacao desconhecida: %s\n", op);
    }
}

// Avalia a expressão pós-fixada
void avaliaPosfixada(char *expr) {
    Pilha pilha;
    inicializaPilha(&pilha);

    char *token = strtok(expr, " ");
    while (token != NULL) {
        if (isdigit(token[0]) || (token[0] == '-' && isdigit(token[1]))) {
            empilha(&pilha, atof(token));
        } else {
            realizaOperacao(&pilha, token);
        }
        token = strtok(NULL, " ");
    }

    if (!estaVazia(&pilha)) {
        printf("Resultado: %f\n", desempilha(&pilha));
    } else {
        printf("Expressao invalida\n");
    }
}

int main() {
    char expr[MAXLEN];

    printf("Digite a expressao pos-fixada: ");
    fgets(expr, MAXLEN, stdin);

    // Remove a nova linha do final da string
    expr[strcspn(expr, "\n")] = '\0';

    printf("Avaliando: %s\n", expr);
    avaliaPosfixada(expr);

    return 0;
}
