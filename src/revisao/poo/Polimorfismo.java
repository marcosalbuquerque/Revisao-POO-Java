package Polimorfismo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

abstract class Pagamento {
    abstract void processarPagamento(double valor);
}

class CartaoCredito extends Pagamento {
    private double saldo;

    public CartaoCredito(double saldo) {
        this.saldo = saldo;
    }

    @Override
    void processarPagamento(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido para continuar com a compra.");
            return;
        }
        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("\n-- CARTÃO DE CRÉDITO --");
            System.out.println("Transação aprovada com sucesso!");
            System.out.println("Saldo atual: R$ " + saldo);
        } else {
            System.out.println("Saldo insuficiente para efetuar o pagamento!");
        }
    }

    public String getSaldo() {
        return "Saldo: R$ "+ saldo;
    }
}

class PayPal extends Pagamento {
    private String senha;
    private double saldo;

    public PayPal(String senha, double saldo) {
        this.senha = senha;
        this.saldo = saldo;
    }

    @Override
    void processarPagamento(double valor) {
        Scanner in = new Scanner(System.in);
        if (valor <= 0) {
            System.out.println("Valor inválido para continuar com a compra.");
            return;
        }

        System.out.println("\n-- PAYPAL --");
        System.out.print("Digite a senha para efetuar o pagamento: ");
        String checksenha = in.nextLine();

        if (checksenha.equals(senha)) {
            if (saldo >= valor) {
                saldo -= valor;
                System.out.println("Transação aprovada com sucesso!");
                System.out.println("Saldo atual: R$ " + saldo);
            } else {
                System.out.println("Saldo insuficiente para efetuar o pagamento!");
            }
        } else {
            System.out.println("Senha inválida!");
        }
    }
}

class Boleto extends Pagamento {
    private String nome;
    private LocalDate vencimento = LocalDate.now().plusDays(3);
    private String codigo = gerarCodigo();
    public Boleto(String nome) {
        this.nome = nome;
    }

    private String gerarCodigo() {
        int tamanho = 8;
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder codigo = new StringBuilder();

        for (int i = 0; i < tamanho; i++) {
            int index = random.nextInt(caracteres.length());
            codigo.append(caracteres.charAt(index));
        }
        return codigo.toString();
    }

    @Override
    void processarPagamento(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido para gerar o boleto.");
            return;
        }
        System.out.println("\n-- BOLETO --");
        System.out.println("Boleto gerado com sucesso!");
        System.out.println("Nome: " + nome);
        System.out.println("Valor: R$ " + valor);
        System.out.println("Código: " + codigo);
        System.out.println("Validade: " + getVencimento());

    }

    public LocalDate getVencimento() {
        return vencimento;
    }
}
class PolimorfismoTest {
    public static void main(String[] args) {
        ArrayList<Pagamento> pagamentos = new ArrayList<>();
        CartaoCredito cc = new CartaoCredito(10);
        PayPal user = new PayPal("abc123", 10);
        Boleto boleto = new Boleto("Mouse");

        pagamentos.add(cc);
        pagamentos.add(user);
        pagamentos.add(boleto);

        for (Pagamento p : pagamentos) {
            p.processarPagamento(5);
        }

    }
}

