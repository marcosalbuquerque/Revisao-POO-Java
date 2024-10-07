package revisao.poo;

import java.util.ArrayList;

public class Aluno {
    private String nome;
    private double nota;

    public Aluno(String nome, double nota) {
        this.nome = nome;
        this.nota = nota;
    }

    private static ArrayList<Aluno> alunos = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public static void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public static void removerAluno(Aluno aluno) {
        alunos.remove(aluno);
    }

    public static void listarAlunos() {
        System.out.print("Alunos: ");
        for (Aluno a : alunos) {
            System.out.print("[" + a.getNome() + "] ");
        }
        System.out.println("");
    }

    public static double calcularMedia() {
        double media = 0;
        for (Aluno a : alunos) {
            media += a.getNota();
        }

        return media/alunos.size();
    }
}

class AlunoTest {
    public static void main(String[] args) {
        Aluno.adicionarAluno(new Aluno("Marcos", 10));
        Aluno michel = new Aluno("Michel", 0);
        Aluno.adicionarAluno(michel);
        Aluno.listarAlunos();
        System.out.println(Aluno.calcularMedia());
        Aluno.removerAluno(michel);
        Aluno.listarAlunos();
    }
}
