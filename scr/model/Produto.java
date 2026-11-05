package model;

public class Produto {
    private int codigo;
    private String nome;
    private double valor;
    private int quantidadeEmEstoque;

    public Produto() {
    }

    public Produto(int codigo, String nome, double valor, int quantidadeEmEstoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public void exibirDados() {
        System.out.println("Código: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.printf("Valor: R$ %.2f%n", valor);
        System.out.println("Quantidade em estoque: " + quantidadeEmEstoque);
        System.out.printf("Valor total em estoque: R$ %.2f%n", calcularValorEmEstoque());
    }

    public void adicionarEstoque(int quantidade) {
        quantidadeEmEstoque += quantidade;
    }

    public boolean removerEstoque(int quantidade) {
        if (quantidade > quantidadeEmEstoque) {
            return false;
        }
        quantidadeEmEstoque -= quantidade;
        return true;
    }
    public double calcularValorEmEstoque() {
        return valor * quantidadeEmEstoque;
    }

    @Override
    public String toString() {
        return nome;
    }
}