
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Luiz Dias
 */
public class AlunoInsertion {

    int Chave;
    String Nome;

    public AlunoInsertion(String Nome, int Chave) {
        this.Chave = Chave;
        this.Nome = Nome;
    }

    public AlunoInsertion() {
    }

    public int getChave() {
        return Chave;
    }

    public void set(AlunoInsertion alun) {
        this.Chave = alun.getChave();
        this.Nome = alun.getNome();
    }

    public String getNome() {
        return Nome;
    }

    public static void Imprime(ArrayList<AlunoInsertion> dados) {

        for (int i = 0; i < dados.size(); i++) {
            System.out.println(dados.get(i).Nome + " " + dados.get(i).Chave);
        }
    }

    public static void insertionSort(ArrayList<AlunoInsertion> dados) {
        AlunoInsertion aux = new AlunoInsertion();
        int i, j;
        for (i = 1; i < dados.size(); i++) {
            aux.set(dados.get(i));
            j = i - 1;
            while ((j >= 0) && comparaNome(j, aux, dados)) {
                dados.get(j + 1).set(dados.get(j));
                j--;
            }
            dados.get(j + 1).set(aux);
        }
    }

    public static boolean comparaNome(int j, AlunoInsertion aux, ArrayList<AlunoInsertion> dados) {
        if (dados.get(j).getChave() > aux.getChave()) {
            return true;
        } else if (dados.get(j).getChave() == aux.getChave()) {
            return dados.get(j).getNome().compareTo(aux.getNome()) < 0;
        } else {
            return false;
        }
    }

    public static void alunoReprovado(ArrayList<AlunoInsertion> dados) {
        System.out.println(dados.get(0).Nome);
    }

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        //lê a qtde de elementos que o vetor terá
        int n = ler.nextInt();
        ArrayList<AlunoInsertion> dados = new ArrayList();

        for (int i = 0; i < n; i++) {
            AlunoInsertion adicionar = new AlunoInsertion(ler.next(), ler.nextInt());
            dados.add(adicionar);
        }

        AlunoInsertion.insertionSort(dados);

        AlunoInsertion.alunoReprovado(dados);
    }
}
