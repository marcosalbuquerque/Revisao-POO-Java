package AT2;

import java.util.ArrayList;

class ItemMenu {

    public ItemMenu(int id, String nome, double preco, String descricao) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }

    private int id;
    private String nome;
    private double preco;
    private String descricao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return nome +
                "\nID: " + id +
                "\nPreço: R$ " + preco +
                "\nDescrição: " + descricao;
    }
}

class Comida extends ItemMenu {
    private String tipo;
    public Comida(int id, String nome, double preco, String descricao, String tipo) {
        super(id, nome, preco, descricao);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    @Override
    public String toString() {
        return super.toString() +
                "\nTipo: " + tipo;
    }


}

class Bebida extends ItemMenu {
    private int volume;
    public Bebida(int id, String nome, double preco, String descricao, int volume) {
        super(id, nome, preco, descricao);
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nVolume: " + volume + " ml";
    }
}

class Sobremesa extends ItemMenu {
    public Sobremesa(int id, String nome, double preco, String descricao) {
        super(id, nome, preco, descricao);
    }
}

class Pedido {
    private int idPedido;
    private String cliente;
    private ArrayList<ItemMenu> itens;
    private double valorTotal;
    private String formaPagamento;

    public Pedido(int idPedido, String cliente) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.valorTotal = 0;
        formaPagamento = "Não escolhida";
    }

    public void adicionarItem(ItemMenu item) {
        itens.add(item);
        valorTotal += item.getPreco();
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public String getCliente() {
        return cliente;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void fecharPedido(String formaPagamento) {
        this.formaPagamento = formaPagamento;
        System.out.println(toString());
        System.out.println("Pedido fechado com sucesso! Volte sempre!");
    }

    @Override
    public String toString() {
        StringBuilder pedido = new StringBuilder();
        pedido.append(cliente + ": \n");
        pedido.append("ID do pedido: " + idPedido);
        pedido.append("\n\n-- Itens -- \n");

        for (ItemMenu item : itens) {
            pedido.append(item.toString()).append("\n\n");
        }
        pedido.append("--------");
        pedido.append("\n\nValor Total: R$" + valorTotal);
        pedido.append("\nForma de Pagamento: " + formaPagamento);
        return pedido.toString();

    }
}




public class DeliveryTest {
    public static void main(String[] args) {
        Pedido pedido = new Pedido(1, "Michel");
        pedido.adicionarItem(new Comida(10, "Hamburguer do Tigrão",
                30, "Um delicioso hamburguer artesanal de picanha com bacon", "Lanche"));
        pedido.adicionarItem(new Bebida(2, "Coca-Cola Zero", 8, "Coca-Cola KS", 290));
        pedido.adicionarItem(new Sobremesa(5, "Pudim", 15, "Pudim de leite com muito amor"));
        pedido.fecharPedido("PIX");
        pedido.toString();
    }
}
