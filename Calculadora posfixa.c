#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

#define MAXSTACK 100
#define POSTFIXSIZE 100

// Estrutura da pilha
typedef struct {
    int topo;
    int itens[MAXSTACK];
} Pilha;

// Funções da pilha
void inicializar(Pilha *p) {
    p->topo = -1;
}

int estaVazia(Pilha *p) {
    return p->topo == -1;
}

int estaCheia(Pilha *p) {
    return p->topo == MAXSTACK - 1;
}

void empilhar(Pilha *p, int valor) {
    if (estaCheia(p)) {
        printf("A pilha esta cheia\n");
        exit(1);
    }
    p->itens[++(p->topo)] = valor;
}

int desempilhar(Pilha *p) {
    if (estaVazia(p)) {
        printf("A pilha esta vazia\n");
        exit(1);
    }
    return p->itens[(p->topo)--];
}

// Função para avaliar expressão pós-fixa
int avaliarPosfixa(char *exp) {
    Pilha p;
    inicializar(&p);
    char *e = exp;

    while (*e != '\0') {
        // Se o caractere for um dígito, empilhe-o
        if (isdigit(*e)) {
            int num = 0;
            // Lidar com números de múltiplos dígitos
            while (isdigit(*e)) {
                num = num * 10 + (*e - '0');
                e++;
            }
            empilhar(&p, num);
        }
        // Se o caractere for um operador, desempilhe dois elementos, aplique o operador e empilhe o resultado
        else if (*e == '+' || *e == '-' || *e == '*' || *e == '/') {
            int valor2 = desempilhar(&p);
            int valor1 = desempilhar(&p);
            int resultado;

            switch (*e) {
                case '+':
                    resultado = valor1 + valor2;
                    break;
                case '-':
                    resultado = valor1 - valor2;
                    break;
                case '*':
                    resultado = valor1 * valor2;
                    break;
                case '/':
                    resultado = valor1 / valor2;
                    break;
                default:
                    printf("Operador incorreto\n");
                    exit(1);
            }
            empilhar(&p, resultado);
            e++;
        }
        // Pular qualquer espaço em branco
        else {
            e++;
        }
    }
    // O resultado final será o único elemento restante na pilha
    return desempilhar(&p);
}

int main() {
    char exp[POSTFIXSIZE];
    printf("Digite uma expressao posfixa: ");
    fgets(exp, POSTFIXSIZE, stdin);

    // Avaliar a expressão pós-fixa
    int resultado = avaliarPosfixa(exp);
    printf("Resultado da avaliacao da expressao posfixa: %d\n", resultado);

    return 0;
}

