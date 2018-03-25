package aed2.finalizado;


import java.util.Scanner;

/*
Entrada:
    A primeira linha de entrada contem um numero inteiro N (1 <= N <= 100000), indicando
    a quantidade de pessoas da cidade. A proxima linha consiste de varios numeros inteiros
    separados por espacos representando a altura h (20 <= h <= 230) de cada uma destas pessoas.
Saida:
    Imprima uma unica linha contendo os valores das alturas de todos os moradores da cidade
    (em cm), por ordem crescente de altura, separando-os por um espaco em branco.
 */
/**
 * COUNTINGSORT
 *
 * @author Luiz Henrique Moreira Dias
 * @author 86892
 * @since 24/03/2018
 */
class CountingSort {

    private final int[] populacao;
    private int[] contagem;
    private int[] auxiliar;

    public CountingSort(int[] populacao) {
        this.populacao = populacao;
    }

    private int maiorElemento() {
        int maior = 0;
        int i;
        for (i = 0; i < populacao.length; i++) {
            if (populacao[i] > maior) {
                maior = populacao[i];
            }
        }
        return maior;
    }

    private void ordena(int tam) {
        int i, j;
        auxiliar = new int[populacao.length];
        //contagem
        for (j = 0; j < tam; j++) {
            contagem[populacao[j]]++;
        }
        //acumula
        for (i = 1; i < contagem.length; i++) {
            contagem[i] = contagem[i] + contagem[i - 1];
        }
        //mover para posicao correta
        for (j = tam - 1; j >= 0; j--) {
            auxiliar[--contagem[populacao[j]]] = populacao[j];
        }
        //copiar auxiliar para populacao
        for (j = 0; j < tam; j++) {
            populacao[j] = auxiliar[j];
        }
    }

    public void executa() {
        int maior = maiorElemento();
        contagem = new int[maior + 1];
        ordena(populacao.length);
    }
}

public class Tarefa05_1 {

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        int[] populacao;
        int altura, i;

        int n = ler.nextInt();
        populacao = new int[n];
        for (i = 0; i < n; i++) {
            altura = ler.nextInt();
            populacao[i] = altura;
        }

        CountingSort count = new CountingSort(populacao);
        count.executa();

        for (i = 0; i < n; i++) {
            System.out.print(populacao[i] + " ");
        }
    }
}
