public class Livro {
    private String titulo;
    private Autor autor;
    private boolean disponivel = true;

    public Livro(String titulo, Autor autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public boolean estaDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return titulo + " - " + autor.getNome() + (disponivel ? " (Disponível)" : " (Indisponível)");
    }

}
