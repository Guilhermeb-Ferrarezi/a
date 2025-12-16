import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Pessoa> pessoas = new ArrayList<>();

        while (true) {
            System.out.print("Digite seu nome: ");
            String nome = scanner.nextLine();

            if (podeSerInt(nome)) {
                System.out.println("Nome não pode ser número");
                continue;
            }

            System.out.print("Digite sua idade: ");
            int idade = scanner.nextInt();
            scanner.nextLine();

            Pessoa informacoes = new Pessoa(nome, idade);
            pessoas.add(informacoes);

            System.out.println("\nCadastrado:");
            System.out.printf("Nome: %s%nIdade: %d%n", informacoes.nome, informacoes.idade);

            System.out.print("\nDeseja ver os cadastrados? (s/n): ");
            String opcao2 = scanner.nextLine();

            if (verificarResposta(opcao2)) {
                System.out.println("\n--- Pessoas cadastradas ---");
                for (Pessoa p : pessoas) {
                    System.out.println("Nome: " + p.nome + " | Idade: " + p.idade);
                } System.out.print("\nDeseja remover alguem? (s/n) ");
                String opcao3 = scanner.nextLine();
                if (verificarResposta(opcao3)){
                    System.out.print("Digite o primeiro nome de quem voce quer remover (Ex.: Ronaldo) ");
                    String nomeRemovido = scanner.nextLine();
                    if (removerNome(pessoas, nomeRemovido)) {
                        System.out.println("Pessoa removida com sucesso!");
                    } else {
                        System.out.println("Nome não encontrado.");
                    }
                }
            }

            System.out.print("\nDeseja continuar o cadastro? (s/n): ");
            String opcao = scanner.nextLine();

            if (!verificarResposta(opcao)) {
                break;
            }
        }

        scanner.close();
    }
    static boolean removerNome(ArrayList<Pessoa> pessoas, String nomeRemovido) {
        return pessoas.removeIf(p -> p.nome.equalsIgnoreCase(nomeRemovido));
    }

    static boolean verificarResposta(String opcao) {
        return opcao.equalsIgnoreCase("s") || opcao.equalsIgnoreCase("sim");
    }

    static boolean podeSerInt(String nome) {
        try {
            Integer.parseInt(nome);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

class Pessoa {
    String nome;
    int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
}
