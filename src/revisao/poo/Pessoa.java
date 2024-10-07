package revisao.poo;

public class Pessoa {
    private String nome;
    private int idade;

    public String exibirDados() {
        return "Nome: " + nome + "\nIdade: " + idade;
    }

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
}

class Funcionario extends Pessoa {
    private double salario;
    private String cargo;

    public Funcionario(String nome, int idade, double salario, String cargo) {
        super(nome, idade);
        this.salario = salario;
        this.cargo = cargo;
    }

    public double calcularSalarioAnual() {
        return salario*12;
    }
}

class PessoaTest {
    public static void main(String[] args) {
        Funcionario f1 = new Funcionario("Marcos", 18, 1500, "IOS Developer");
        System.out.println(f1.exibirDados() + "\nSalário Anual: R$ " + f1.calcularSalarioAnual());
    }
}