package model;

public class Cliente {
    int codigo;
    String nome;
    String cpf;

    
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cliente(){

    }
    public Cliente(int codigo, String cpf, String nome){
        this.codigo = codigo;
        this.cpf = cpf;
        this.nome = nome;
    }
    /*public void exibirDadosClientes(){
        System.out.println("Código: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("CPF: "+cpf);
    }*/
}
