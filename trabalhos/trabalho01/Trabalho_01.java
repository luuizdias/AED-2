package aed2.finalizado;


import java.util.Scanner;

/**
 * TRABALHO 01
 *
 * @author Luiz Henrique Moreira Dias
 * @author 86892
 * @since 01/04/2018
 */
class Bubble {

    int elementos;
    int turnos;
    int[] vetorSaida, vetorAuxiliar, intercambios;

    public Bubble(int elementos, int turnos, int[] intercambios) {
        this.elementos = elementos;
        this.turnos = turnos;
        this.vetorSaida = new int[elementos + 1];
        this.vetorAuxiliar = new int[elementos + 1];
        this.intercambios = intercambios;
    }

    private void vetorOrdenado() {
        int i;
        for (i = 1; i <= elementos; i++) {
            vetorSaida[i] = i;
            vetorAuxiliar[i] = i;
        }
    }

    private void trocaPosicao(int indice1, int indice2) {
        int aux1, aux2;
        aux1 = vetorSaida[indice1];
        aux2 = vetorSaida[indice2];
        vetorSaida[indice2] = aux1;
        vetorSaida[indice1] = aux2;
        vetorAuxiliar[aux1] = indice2;
        vetorAuxiliar[aux2] = indice1;
    }

    public int[] criaVetor() {
        vetorOrdenado();
        int mudarNoTurno, maiorNoTurno;
        for (int i = 1; i <= turnos; i++) {
            mudarNoTurno = intercambios[turnos - i + 1];
            if (mudarNoTurno > 0) {
                maiorNoTurno = vetorAuxiliar[turnos + 1];
                for (int j = 1; j <= mudarNoTurno; j++) {
                    trocaPosicao(maiorNoTurno + j - 1, maiorNoTurno + j - 2);
                }
            }
        }
        return vetorSaida;
    }
}

public class Trabalho_01 {

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);

        int[] intercambios;

        int elementos = ler.nextInt();
        int turnos = ler.nextInt();

        intercambios = new int[turnos + 1];
        for (int i = 1; i <= turnos; i++) {
            intercambios[i] = ler.nextInt();
        }

        Bubble bubble = new Bubble(elementos, turnos, intercambios);
        int[] vetorAOrdenar = bubble.criaVetor();

        for (int i = 1; i <= elementos; i++) {
            System.out.print(vetorAOrdenar[i] + " ");
        }
    }
}
