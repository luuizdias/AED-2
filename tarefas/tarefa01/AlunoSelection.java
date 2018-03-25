
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Luiz Dias
 */
public class AlunoSelection {

    int Chave;
    String Nome;

    public AlunoSelection(String Nome, int Chave) {
        this.Chave = Chave;
        this.Nome = Nome;
    }

    public AlunoSelection() {
    }

    public int getChave() {
        return Chave;
    }

    public void set(AlunoSelection alun) {
        this.Chave = alun.getChave();
        this.Nome = alun.getNome();
    }

    public String getNome() {
        return Nome;
    }

    public static void Imprime(ArrayList<AlunoSelection> dados) {

        for (int i = 0; i < dados.size(); i++) {
            System.out.println(dados.get(i).Nome + " " + dados.get(i).Chave);
        }
    }

    public static void selectionSort(ArrayList<AlunoSelection> dados) {
        AlunoSelection aux = new AlunoSelection();
        int i, j, menor;
        for (i = 0; i < dados.size(); i++) {
            menor = i;
            for (j = i + 1; j < dados.size(); j++) {
                if (comparaNome(dados.get(menor), dados.get(j))) {
                    menor = j;
                }
            }
            aux.set(dados.get(i));
            dados.get(i).set(dados.get(menor));
            dados.get(menor).set(aux);
        }
    }

    public static boolean comparaNome(AlunoSelection alunoMenor, AlunoSelection alunoJ) {
        if (alunoMenor.getChave() < alunoJ.getChave()) {
            return true;
        } else if (alunoMenor.getChave() == alunoJ.getChave()) {
            return alunoMenor.getNome().compareTo(alunoJ.getNome()) > 0;
        } else {
            return false;
        }
    }

    public static void alunoReprovado(ArrayList<AlunoSelection> dados) {
        System.out.println(dados.get(dados.size() - 1).getNome());
    }

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        //lê a qtde de elementos que o vetor terá
        int n = ler.nextInt();
        ArrayList<AlunoSelection> dados = new ArrayList();

        for (int i = 0; i < n; i++) {
            AlunoSelection adicionar = new AlunoSelection(ler.next(), ler.nextInt());
            dados.add(adicionar);
        }

        AlunoSelection.selectionSort(dados);

        AlunoSelection.alunoReprovado(dados);
    }
}
