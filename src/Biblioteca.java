import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<String> registrosEmprestimos = new ArrayList<>();

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void exibirLivros() {
        System.out.println("Livros disponíveis:");
        for (Livro livro : livros) {
            if (livro.estaDisponivel()) {
                System.out.println(livro);
            }
        }
    }

    public void exibirLivrosIndice() {
        System.out.println("Livros disponíveis:");
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).estaDisponivel()) {
                System.out.println(i + " - " + livros.get(i).getTitulo());
            }
        }
    }

    public void emprestarLivro(int id, String nomeUsuario) {
        Livro livro = livros.get(id);

        if (!livro.estaDisponivel()) {
            System.out.println("Esse livro já foi emprestado: " + livro.getTitulo());
            return;
        }

        livro.setDisponivel(false);
        registrosEmprestimos.add(nomeUsuario + " pegou emprestado o livro: " + livro.getTitulo());
        System.out.println("Obrigado(a), " + nomeUsuario + "! Você pegou emprestado o livro: " + livro.getTitulo());
    }

    public void exibirLivrosEmprestados() {
        System.out.println("Livros emprestados:");
        for (String registro : registrosEmprestimos) {
            System.out.println(registro);
        }
    }

    public boolean todosLivrosEmprestados() {
        for (Livro livro : livros) {
            if (livro.estaDisponivel()) {
                return false;
            }
        }
        return true;
    }

}
