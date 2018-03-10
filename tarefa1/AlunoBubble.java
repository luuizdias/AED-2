
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Luiz Dias
 */
public class AlunoBubble {

    int Chave;
    String Nome;

    public AlunoBubble(String Nome, int Chave) {
        this.Chave = Chave;
        this.Nome = Nome;
    }

    public AlunoBubble() {
    }

    public int getChave() {
        return Chave;
    }

    public void set(AlunoBubble alun) {
        this.Chave = alun.getChave();
        this.Nome = alun.getNome();
    }

    public String getNome() {
        return Nome;
    }

    public static void Imprime(ArrayList<AlunoBubble> dados) {

        for (int i = 0; i < dados.size(); i++) {
            System.out.println(dados.get(i).Nome + " " + dados.get(i).Chave);
        }
    }

    public static void bubbleSort(ArrayList<AlunoBubble> dados) {
        AlunoBubble aux = new AlunoBubble();
        int i, j;
        for (i = 0; i < dados.size() - 1; i++) {
            for (j = 1; j < dados.size(); j++) {
                if (dados.get(j).getChave() > dados.get(j - 1).getChave()) {
                    aux.set(dados.get(j));
                    dados.get(j).set(dados.get(j - 1));
                    dados.get(j - 1).set(aux);
                } else if (dados.get(j).getChave() == dados.get(j - 1).getChave()) {
                    if (dados.get(j).getNome().compareTo(dados.get(j - 1).getNome()) < 0) {
                        aux.set(dados.get(j));
                        dados.get(j).set(dados.get(j - 1));
                        dados.get(j - 1).set(aux);
                    }
                }
            }
        }
    }

    public static void alunoReprovado(ArrayList<AlunoBubble> dados) {
        System.out.println(dados.get(dados.size() - 1).Nome);
    }

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        //lê a qtde de elementos que o vetor terá
        int n = ler.nextInt();
        ArrayList<AlunoBubble> dados = new ArrayList();

        for (int i = 0; i < n; i++) {
            AlunoBubble adicionar = new AlunoBubble(ler.next(), ler.nextInt());
            dados.add(adicionar);
        }

        AlunoBubble.bubbleSort(dados);
        AlunoBubble.alunoReprovado(dados);
    }
}
