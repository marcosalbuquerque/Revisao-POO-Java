package revisao.poo;

import java.util.ArrayList;
import java.util.List;

public abstract class Veiculo {
    private String marca;
    private String modelo;
    private int ano;

    public Veiculo(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public abstract void exibirInformacoes();
}

class Carro extends Veiculo {
    public Carro(String marca, String modelo, int ano) {
        super(marca, modelo, ano);
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("-- Carro --");
        System.out.println("Marca: " + getMarca());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Ano: " + getAno());
        System.out.println("-----------");
        System.out.println(" ");
    }

}

class Moto extends Veiculo {
    public Moto(String marca, String modelo, int ano) {
        super(marca, modelo, ano);
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("-- Moto --");
        System.out.println("Marca: " + getMarca());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Ano: " + getAno());
        System.out.println("----------");
        System.out.println(" ");
    }
}

class Concessionaria {
    private ArrayList<Veiculo> veiculos = new ArrayList<>();

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }
    public void removerVeiculo(Veiculo veiculo) {
        veiculos.remove(veiculo);
    }

    public void listarVeiculos() {
        System.out.println("---- Veiculos ----");
        for (Veiculo v : veiculos) {
            v.exibirInformacoes();
        }
        System.out.println("------------------");
        System.out.println(" ");
    }
}

class VeiculoTest {
    public static void main(String[] args) {
        Concessionaria cons1 = new Concessionaria();
        Carro civic = new Carro("Honda", "Civic", 2020);
        cons1.adicionarVeiculo(civic);
        cons1.adicionarVeiculo(new Moto("Honda", "CB1000", 2002));
        cons1.adicionarVeiculo(new Veiculo("Generico", "Generico", 2000) {
            @Override
            public void exibirInformacoes() {
                System.out.println("-- Veiculo --");
                System.out.println("Marca: " + getMarca());
                System.out.println("Modelo: " + getModelo());
                System.out.println("Ano: " + getAno());
                System.out.println("-------------");
                System.out.println(" ");
            }
        });
        cons1.listarVeiculos();
        civic.exibirInformacoes();
        cons1.removerVeiculo(civic);
        cons1.listarVeiculos();

    }
}