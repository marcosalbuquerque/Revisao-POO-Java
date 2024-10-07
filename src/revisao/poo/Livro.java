package revisao.poo;

import java.util.ArrayList;
import java.util.List;

public class Livro {
    private String titulo;
    private String autor;
    private int anoPublicacao;

    public Livro(String titulo, String autor, int anoPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
}

class Biblioteca {
    ArrayList<Livro> livros = new ArrayList<>();

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }
    public void removerVeiculo(Livro livro) {
        livros.remove(livro);
    }

    public void listarLivros() {
        System.out.println("---- Livros ----");
        for (Livro l : livros) {
            System.out.println("** "+ l.getTitulo() + " **");
            System.out.println("Autor: " + l.getAutor());
            System.out.println("Ano: " + l.getAnoPublicacao() + "\n");
        }
        System.out.println("------------------\n");
    }

    public boolean buscarPorAutor(String autor) {
        for (Livro l : livros) {
            if (l.getAutor().equalsIgnoreCase(autor)) {
                return true;
            }
        }
        return false;
    }
}

class LivroTest {
    public static void main(String[] args) {
        Biblioteca b1 = new Biblioteca();
        Livro alquimista = new Livro("O Alquimista", "Paulo Coelho", 1990);
        b1.adicionarLivro(new Livro("Livro 01", "Autor 01", 2000));
        b1.adicionarLivro(alquimista);
        b1.listarLivros();
        System.out.println("Tem autor 02 na biblioteca? " + b1.buscarPorAutor("Autor 02"));
        System.out.println("Tem autor 01 na biblioteca? " + b1.buscarPorAutor("Autor 01"));
    }
}
