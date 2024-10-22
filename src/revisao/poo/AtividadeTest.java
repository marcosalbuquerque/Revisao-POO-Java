package AT1;

class Pessoa {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    void exibirInfo() {
        System.out.println("");
        System.out.println("Nome: " + getNome());
        System.out.println("Idade: " + getIdade());

    }
}

class Aluno extends Pessoa {
    private String matricula;

    public Aluno(String nome, int idade, String matricula) {
        super(nome, idade);
        this.matricula = matricula;
    }

    @Override
    void exibirInfo() {
        super.exibirInfo();
        System.out.println("Matrícula: " + matricula);
    }
}

class Professor extends Pessoa {
    private double salario;

    public Professor(String nome, int idade, double salario) {
        super(nome, idade);
        this.salario = salario;
    }

    @Override
    void exibirInfo() {
        super.exibirInfo();
        System.out.println("Salário: " + salario);
    }
}
public class AtividadeTest {
    public static void main(String[] args) {
        Aluno aluno = new Aluno("Marcos", 18, "UC24102315");
        Professor professor = new Professor("Victor", 30, 10000.0);
        Pessoa pessoa = new Pessoa("Pessoa", 20);

        aluno.exibirInfo();
        professor.exibirInfo();
        pessoa.exibirInfo();
    }
}
