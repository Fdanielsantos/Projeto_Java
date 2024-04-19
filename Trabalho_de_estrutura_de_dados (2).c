#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <locale.h>
#define ERRO 0
#define MAX_ALUNOS 100
#define MAX_LINE_SIZE 100
typedef struct {
    char nome[50];
    char curso[50];
    float nota1;
    float nota2;
} Aluno;
const char* determinarSituacao(float media) {
    if (media >= 7.0) {
        return "APROVADO";
    } else {
        return "REPROVADO";
    }
}
int main() {
setlocale(LC_ALL, "pt_BR.utf8");
    FILE *entrada, *saida;
    char linha[MAX_LINE_SIZE];
    Aluno alunos[MAX_ALUNOS];
    entrada = fopen("DadosEntrada.csv", "r");
    if (entrada == NULL) {
        printf("Erro ao abrir arquivo de entrada.\n");
        return 1;
    }
    saida = fopen("SituacaoFinal.csv", "w");
    if (saida == NULL) {
        printf("Erro ao criar arquivo de saída.\n");
        fclose(entrada);
        return 1;
    }
    int primeiraLinha = 1;
    int numAlunos = 0;
    while (fgets(linha, sizeof(linha), entrada)) {
    	if (primeiraLinha) {
            primeiraLinha = 0; 
            continue; 
        }
      sscanf(linha, "%[^,],%*[^,],%[^,],%f,%f", alunos[numAlunos].nome, alunos[numAlunos].curso, &alunos[numAlunos].nota1, &alunos[numAlunos].nota2);
        float media = (alunos[numAlunos].nota1 + alunos[numAlunos].nota2) / 2;        
        const char *situacao = determinarSituacao(media);
        fprintf(saida, "%s, %.2f, %s\n", alunos[numAlunos].nome, media, situacao);
        numAlunos++;    
}
    fclose(entrada);
    fclose(saida);
    printf("Processamento concluído. Verifique o arquivo SituacaoFinal.csv.\n");
    return 0;
}

