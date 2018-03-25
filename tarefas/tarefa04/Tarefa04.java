import java.util.ArrayList;
import java.util.Scanner;

/*
Entrada:
    A primeira linha da entrada consiste em um numero inteiro N (1 <= N <= 100) indicando a
    quantidade de camisetas a serem feitas para aquela turma. Cada uma das N linhas seguintes
    contem o nome do aluno, a cor do logo da camiseta ("branco" ou "vermelho") e o tamanho da
    camiseta ("P", "M" ou "G"). O nome consiste em uma sequencia de no maximo 20 caracteres,
    a cor compreende de uma sequencia de no maximo 10 caracteres e o tamanho consiste em um
    unico caractere.
Saida:
    Imprima as informacoes ordenadas pela cor dos detalhes em ordem ascendente, seguido pelos
    tamanhos em ordem descendente e por ultimo por ordem ascendente de nome.
 */
/**
 * QUICKSORT
 *
 * @author Luiz Henrique Moreira Dias
 * @author 86892
 * @since 24/03/2018
 */
class Pedido {

    String nomeAluno;
    String corDetalhe;
    String tamanho;

    public Pedido() {
    }

    public Pedido(String nomeAluno, String corDetalhe, String tamanho) {
        this.nomeAluno = nomeAluno;
        this.corDetalhe = corDetalhe;
        this.tamanho = tamanho;
    }

    public void setPedido(Pedido pedido) {
        this.nomeAluno = pedido.getNomeAluno();
        this.corDetalhe = pedido.getCorDetalhe();
        this.tamanho = pedido.getTamanho();
    }

    public String getCorDetalhe() {
        return corDetalhe;
    }

    public void setCorDetalhe(String corDetalhe) {
        this.corDetalhe = corDetalhe;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }
}

class Quicksort {

    private final ArrayList<Pedido> pedidos;

    public Quicksort(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    private boolean compara(Pedido primeiro, Pedido segundo) {
        if (primeiro.getCorDetalhe().compareTo(segundo.getCorDetalhe()) == 0) {
            if (primeiro.getTamanho().compareTo(segundo.getTamanho()) == 0) {
                return primeiro.getNomeAluno().compareTo(segundo.getNomeAluno()) < 0;
            } else return primeiro.getTamanho().compareTo(segundo.getTamanho()) > 0;
        } else return primeiro.getCorDetalhe().compareTo(segundo.getCorDetalhe()) < 0;
    }

    private int Particiona(int p, int r) {
        Pedido piv = new Pedido();
        piv.setPedido(pedidos.get(r));
        
        Pedido aux;
        int i, j;
        i = p;

        for (j = p; j < r; j++) {
            if (compara(pedidos.get(j), piv)) {
                aux = new Pedido();
                aux.setPedido(pedidos.get(i));
                pedidos.set(i, pedidos.get(j));
                pedidos.set(j, aux);
                i++;
            }
        }
        aux = new Pedido();
        aux.setPedido(pedidos.get(i));
        pedidos.set(i, pedidos.get(r));
        pedidos.set(r, aux);

        return i;
    }

    private void Ordena(int p, int r) {
        int j;

        if (p < r) {
            j = Particiona(p, r);
            Ordena(p, j - 1);
            Ordena(j + 1, r);
        }
    }

    public void executar(int n) {
        Ordena(0, n - 1);
    }
}

class Utils {

    public void Imprime(ArrayList<Pedido> dados) {
        for (int i = 0; i < dados.size(); i++) {
            System.out.println(dados.get(i).getCorDetalhe() + " " + dados.get(i).getTamanho() + " " + dados.get(i).getNomeAluno());
        }
    }
}

public class Tarefa04 {

    public static void main(String[] args) {
        Utils util = new Utils();

        Scanner ler = new Scanner(System.in);
        ArrayList<Pedido> pedidos = new ArrayList();

        int n = ler.nextInt();
        for (int i = 0; i < n; i++) {
            String nome = ler.next();
            String corDetalhe = ler.next();
            String tamanho = ler.next();
            Pedido adicionar = new Pedido(nome, corDetalhe, tamanho);
            pedidos.add(adicionar);
        }
        
        Quicksort quick = new Quicksort(pedidos);
        quick.executar(pedidos.size());
        
        System.out.println();
        util.Imprime(pedidos);
    }    
}
