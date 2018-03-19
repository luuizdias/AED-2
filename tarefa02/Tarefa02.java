
import java.util.ArrayList;
import java.util.Scanner;

/*
Entrada:
    A primeira linha da entrada consiste em um numero inteiro N (1 <= N <= 100) indicando o
    numero de alunos na fila. Cada uma das N linhas seguintes contem o nome do aluno e a nota
    obtida por ele na materia de matematica de acordo com a ordem de chegada na cantina. O
    nome consiste em uma sequencia de no maximo 20 caracteres e a nota compreende de um
    numero inteiro entre 0 e 100.
 Saida:
    Imprima o nome dos alunos que nao precisarao trocar de lugar mesmo apos a fila ser reordenada,
    sendo um aluno por linha e de acordo com ordem em que eles chegaram na cantina.
 */
/**
 * HEAPSORT
 *
 * @author Luiz Henrique Moreira Dias
 * @author 86892
 * @since 17/03/2018
 */
class Aluno {

    private String nome;
    private int nota;
    private int lugarInicial;

    public Aluno() {
    }

    public Aluno(String nome, int nota, int lugarInicial) {
        this.nome = nome;
        this.nota = nota;
        this.lugarInicial = lugarInicial;
    }

    public void setAluno(Aluno aluno) {
        this.nome = aluno.getNome();
        this.nota = aluno.getNota();
        this.lugarInicial = aluno.getLugarInicial();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getLugarInicial() {
        return lugarInicial;
    }
}

class HeapSort {

    private final ArrayList<Aluno> alunos;

    public HeapSort(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    public void heapRefaz(int esq, int dir) {
        Aluno aux = new Aluno();
        int i, j;

        i = esq;
        j = (i * 2) + 1;
        aux.setAluno(alunos.get(i));

        while (j <= dir) {
            if ((j < dir) && (alunos.get(j).getNota() > alunos.get(j + 1).getNota())) {
                j++;
            }
            if (aux.getNota() <= alunos.get(j).getNota()) {
                if (aux.getNota() == alunos.get(j).getNota()) {
                    if (aux.getLugarInicial() > alunos.get(j).getLugarInicial()) {
                        break;
                    }
                } else {
                    break;
                }
            }
            alunos.set(i, alunos.get(j));
            i = j;
            j = (i * 2) + 1;
        }
        alunos.set(i, aux);
    }

    public void heapConstroi(int n) {
        int esq;
        esq = (n / 2) - 1;

        while (esq >= 0) {
            heapRefaz(esq, n - 1);
            esq--;
        }
    }

    public void heapSort(int n) {
        Aluno aux = new Aluno();
        int m;

        heapConstroi(n);
        m = n - 1;

        while (m > 0) {
            aux.setAluno(alunos.get(m));
            alunos.set(m, alunos.get(0));
            alunos.set(0, aux);
            m--;
            heapRefaz(0, m);

        }
    }
}

class Utils {

    public void Imprime(ArrayList<Aluno> dados) {
        for (int i = 0; i < dados.size(); i++) {
            System.out.println(dados.get(i).getNome() + " " + dados.get(i).getNota());
        }
    }

    public void retornaAlunoPosicaoCerta(ArrayList<Aluno> original, ArrayList<Aluno> copia) {
        int i;
        for (i = 0; i < original.size(); i++) {
            if (original.get(i).getNome() == null ? copia.get(i).getNome() == null : original.get(i).getNome().equals(copia.get(i).getNome())) {
                System.out.println(copia.get(i).getNome());
            }
        }
    }
}

public class Tarefa02 {

    public static void main(String[] args) {
        Utils util = new Utils();

        Scanner ler = new Scanner(System.in);
        ArrayList<Aluno> alunos = new ArrayList();
        ArrayList<Aluno> vetorOrdenado = new ArrayList();

        int n = ler.nextInt();
        for (int i = 0; i < n; i++) {
            String nome = ler.next();
            int nota = ler.nextInt();
            Aluno adicionar = new Aluno(nome, nota, i + 1);
            Aluno adicionar1 = new Aluno(nome, nota, i + 1);
            alunos.add(adicionar);
            vetorOrdenado.add(adicionar1);
        }

        HeapSort ordenar = new HeapSort(vetorOrdenado);

        ordenar.heapRefaz(0, n - 1);
        ordenar.heapConstroi(n);
        ordenar.heapSort(n);

        util.retornaAlunoPosicaoCerta(alunos, vetorOrdenado);
    }
}
