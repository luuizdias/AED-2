package aed2.finalizado;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
Entrada:
    A primeira linha da entrada contem um numero inteiro N (0 <= N <= 100) indicando o numero
    de times no campeonato. A seguir vem N(N-1)/2 linhas indicando os resultados das partidas.
    Em cada linha sao dados quatro numeros inteiros x, y, z e w. Os numeros inteiros x e z
    pertencem ao conjunto {1, 2,...,N} e representam os numeros de incricao dos times na liga.
    Os numeros inteiros y e w sao, respectivamente, os numeros de pontos dos times x e do time
    z na partida descrita.
Saida:
    Imprima uma unica linha contendo uma permutacao dos numeros inteiros de 1 a N referente
    aos numeros de inscricao dos times em ordem de classificacao no campeonato, separando-os
    com um espaco.
 */
/**
 * MERGESORT
 *
 * @author Luiz Henrique Moreira Dias
 * @author 86892
 * @since 17/03/2018
 */
class Time {

    private int inscricao;
    private int pontos;
    private int pontosFeitos;
    private int pontosSofridos;

    public Time() {
    }

    public Time(int inscricao) {
        this.inscricao = inscricao;
        this.pontos = 0;
        this.pontosFeitos = 0;
        this.pontosSofridos = 0;
    }

    public Time(Time time) {
        this.inscricao = time.getInscricao();
        this.pontos = time.getPontos();
        this.pontosFeitos = time.getPontosFeitos();
        this.pontosSofridos = time.getPontosSofridos();
    }

    public void setTime(Time time) {
        this.inscricao = time.getInscricao();
        this.pontos = time.getPontos();
        this.pontosFeitos = time.getPontosFeitos();
        this.pontosSofridos = time.getPontosSofridos();
    }

    public int getInscricao() {
        return inscricao;
    }

    public void setInscricao(int inscricao) {
        this.inscricao = inscricao;
    }

    public int getPontos() {
        return pontos;
    }

    public void somaPontos(int pontos) {
        this.pontos = this.pontos + pontos;
    }

    public int getPontosFeitos() {
        return pontosFeitos;
    }

    public void somaPontosFeitos(int pontosFeitos) {
        this.pontosFeitos = this.pontosFeitos + pontosFeitos;
    }

    public int getPontosSofridos() {
        return pontosSofridos;

    }

    public void somaPontosSofridos(int pontosSofridos) {
        this.pontosSofridos = this.pontosSofridos + pontosSofridos;
    }

    public float getCestaAverage() {
        float cestaAverage;
        if (this.pontosSofridos == 0) {
            cestaAverage = (float) this.pontosFeitos;
            return cestaAverage;
        } else {
            cestaAverage = (float) this.pontosFeitos / this.pontosSofridos;
            return cestaAverage;
        }
    }
}

class MergeSort {

    private final ArrayList<Time> times;

    public MergeSort(ArrayList<Time> times) {
        this.times = times;
    }

    public void Intercala(int p, int q, int r) {
        int i, j, k;
        Time auxiliar[];
        //if (times.get(q).getPontos() > times.get(q + 1).getPontos()) {
        //intercala
        auxiliar = new Time[r - p + 1];

        for (i = p; i <= q; i++) {
            auxiliar[i - p] = times.get(i);
        }
        for (j = q + 1; j <= r; j++) {
            int aux = r + q + 1 - j - p;
            auxiliar[aux] = times.get(j);
        }
        i = p;
        j = r;
        //ordena
        for (k = p; k <= r; k++) {
            if (auxiliar[i - p].getPontos() < auxiliar[j - p].getPontos()) {
                times.set(k, auxiliar[i - p]);
                i++;
            } else if (auxiliar[i - p].getPontos() == auxiliar[j - p].getPontos()) {
                if (auxiliar[i - p].getCestaAverage() < auxiliar[j - p].getCestaAverage()) {
                    times.set(k, auxiliar[i - p]);
                    i++;
                } else if (auxiliar[i - p].getCestaAverage() == auxiliar[j - p].getCestaAverage()) {
                    if (auxiliar[i - p].getPontosFeitos() < auxiliar[j - p].getPontosFeitos()) {
                        times.set(k, auxiliar[i - p]);
                        i++;
                    } else if (auxiliar[i - p].getPontosFeitos() == auxiliar[j - p].getPontosFeitos()) {
                        if (auxiliar[i - p].getInscricao() < auxiliar[j - p].getInscricao()) {
                            times.set(k, auxiliar[i - p]);
                            i++;
                        } else {
                            times.set(k, auxiliar[j - p]);
                            j--;
                        }
                    } else {
                        times.set(k, auxiliar[j - p]);
                        j--;
                    }
                } else {
                    times.set(k, auxiliar[j - p]);
                    j--;
                }
            } else {
                times.set(k, auxiliar[j - p]);
                j--;
            }
        }
        //}
    }

    public void Ordena(int i, int f) {
        int m;
        if (i < f) {
            m = (i + f) / 2;
            Ordena(i, m);
            Ordena(m + 1, f);
            Intercala(i, m, f);
        }
    }

    public void mergesort() {
        Ordena(0, this.times.size() - 1);
    }

}

class Utils {

    public void Imprime(ArrayList<Time> dados) {
        for (int i = 0; i < dados.size(); i++) {
            System.out.println(dados.get(i).getInscricao() + "| " + dados.get(i).getPontos() + " " + dados.get(i).getPontosFeitos() + " " + dados.get(i).getPontosSofridos() + " " + dados.get(i).getCestaAverage());
        }
    }

    public void imprimeClassificacao(ArrayList<Time> dados) {
        for (int i = dados.size() - 1; i >= 0; i--) {
            System.out.print(dados.get(i).getInscricao() + " ");
        }
    }

    public void computarJogo(ArrayList<Time> times, int primeiroTime, int cestasPrimeiroTime, int segundoTime, int cestasSegundoTime) {
        //Primeiro time
        times.get(primeiroTime - 1).somaPontosFeitos(cestasPrimeiroTime);
        times.get(primeiroTime - 1).somaPontosSofridos(cestasSegundoTime);
        //Segundo time
        times.get(segundoTime - 1).somaPontosFeitos(cestasSegundoTime);
        times.get(segundoTime - 1).somaPontosSofridos(cestasPrimeiroTime);

        //Quem ganhou
        if (cestasPrimeiroTime > cestasSegundoTime) {
            //Primeiro time ganhou
            times.get(primeiroTime - 1).somaPontos(2);
            //perdeu
            times.get(segundoTime - 1).somaPontos(1);
        } else {
            //perdeu 
            times.get(primeiroTime - 1).somaPontos(1);
            //Segundo time ganhou
            times.get(segundoTime - 1).somaPontos(2);
        }
    }
}

public class Tarefa03 {

    public static void main(String[] args) {
        Utils util = new Utils();

        Scanner ler = new Scanner(System.in);
        //ler e setar qte de times
        ArrayList<Time> times = new ArrayList();
        int n = ler.nextInt();
        for (int i = 0; i < n; i++) {
            times.add(new Time(i + 1));
        }
        //ler e computar jogos
        int qteJogos = (n * (n - 1)) / 2;
        for (int i = 0; i < qteJogos; i++) {
            util.computarJogo(times, ler.nextInt(), ler.nextInt(), ler.nextInt(), ler.nextInt());
        }

        MergeSort merge = new MergeSort(times);
        merge.mergesort();
        util.imprimeClassificacao(times);

    }
}
