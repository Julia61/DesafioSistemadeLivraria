import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();


        Livro livro01 = new Livro("Harry Potter", new Autor("J. K. Rowling"));
        Livro livro02 = new Livro("1984", new Autor("George Orwell"));

        biblioteca.adicionarLivro(livro01);
        biblioteca.adicionarLivro(livro02);

        do {
            if (biblioteca.todosLivrosEmprestados()) {
                System.out.println("Todos os livros foram emprestados!");
                System.out.println("Gostaria de doar um novo livro? (s/n)");
                String opcaoDoar = scanner.nextLine().toLowerCase();

                while (!opcaoDoar.equals("s") && !opcaoDoar.equals("n")) {
                    System.out.println("Opção inválida! Tente novamente (s/n)");
                    opcaoDoar = scanner.nextLine().toLowerCase();
                }

                if (opcaoDoar.equals("s")) {
                    System.out.println("Qual é o título do livro?");
                    String tituloNovo = scanner.nextLine();
                    System.out.println("Qual é o autor do livro?");
                    String autorNovo = scanner.nextLine();

                    Livro livroNovo = new Livro(tituloNovo, new Autor(autorNovo));
                    biblioteca.adicionarLivro(livroNovo);

                    System.out.println("Livro doado com sucesso!");
                } else {
                    System.out.println("Obrigado por visitar a biblioteca! Até mais!");
                    break;
                }
            }


            System.out.println("Gostaria de ver os livros disponíveis? (s/n)");
            String opcao = scanner.nextLine().toLowerCase();

            while (!opcao.equals("s") && !opcao.equals("n")) {
                System.out.println("Opção inválida! Tente novamente (s/n)");
                opcao = scanner.nextLine().toLowerCase();
            }

            if (opcao.equals("s")) {
                biblioteca.exibirLivros();
            }

            System.out.println("Gostaria de pegar um livro emprestado? (s/n)");
            String opcaoEmprestado = scanner.nextLine().toLowerCase();

            while (!opcaoEmprestado.equals("s") && !opcaoEmprestado.equals("n")) {
                System.out.println("Opção inválida! Tente novamente (s/n)");
                opcaoEmprestado = scanner.nextLine().toLowerCase();
            }

            if (opcaoEmprestado.equals("s")) {
                biblioteca.exibirLivrosIndice();
                System.out.println("Digite o ID correspondente ao livro que deseja pegar emprestado:");
                try {
                    int opcaoLivro = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Por favor, insira seu nome para registrar o empréstimo:");
                    String nomeUsuario = scanner.nextLine();
                    biblioteca.emprestarLivro(opcaoLivro, nomeUsuario);
                } catch (InputMismatchException e) {
                    System.out.println("[ERRO] Digite um número válido!");
                    scanner.nextLine();
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("[ERRO] ID inválido! Tente novamente.");
                }
            } else {
                break;
            }

            System.out.println("Gostaria de ver os livros emprestados? (s/n)");
            String opcaoEmprestados = scanner.nextLine().toLowerCase();

            if (opcaoEmprestados.equals("s")) {
                biblioteca.exibirLivrosEmprestados();
            }

        } while (true);

    }
}
