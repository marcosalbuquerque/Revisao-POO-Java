package revisao.poo;

// EXERCICIO 01
public class Produto {
    private String nome;
    private double preco;
    private int quantidadeEstoque;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    boolean aplicarDesconto(double percentual) { //0 a 100
        double valor = getPreco() - (getPreco()*(percentual/100));
        if (valor >= 0) {
            setPreco(valor);
            return true;
        }
        return false;
    }
}

class ProdutoTest {
    public static void main(String[] args) {
        Produto p1 = new Produto();
        p1.setPreco(100);
        System.out.println(p1.getPreco());
        p1.aplicarDesconto(50);
        System.out.println(p1.getPreco());
    }
}