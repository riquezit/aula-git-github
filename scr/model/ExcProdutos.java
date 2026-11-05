package model;

import java.util.ArrayList;
import java.util.Scanner;

public class ExcProdutos {
    static class Produto{
        String nome;
        int codigo;
        int quantidade;
        double valor;

        Produto(String nome, int codigo, int quantidade, double valor){
            this.nome=nome;
            this.codigo=codigo;
            this.valor=valor;
            this.quantidade=quantidade;
        }
    }
        static class Estante{
            Scanner sc=new Scanner(System.in);
            ArrayList<Produto> produtos=new ArrayList<Produto>();

            void cadastrarProduto(){
                System.out.println("\t====== CADASTRO ======");
                System.out.print("Nome do Produto: ");
                String nome=sc.nextLine();
                System.out.print("Código do Produto: ");
                int codigo=sc.nextInt();
                System.out.print("Valor do Produto: R$");
                double valor=sc.nextDouble();
                System.out.print("Quantidade em Estoque: ");
                int quantidade=sc.nextInt();

                produtos.add(new Produto(nome, codigo, quantidade, valor));
                System.out.println("\t=> Produto Cadastrado <=");
            }
            Produto procurarProduto(){
                System.out.println("\t====== BUSCA ======");
                System.out.print("Código do Produto: ");
                int codigo=sc.nextInt();

                for (Produto produto : produtos) {
                    if (codigo==produto.codigo) {
                        System.out.println("=> Produto Encontrado <=");
                        System.out.println("Nome: "+produto.nome);
                        System.out.println("Código: "+produto.codigo);
                        System.out.println("Valor: R$"+produto.valor);
                        System.out.println("Quantidade em Estoque: "+produto.quantidade);
                        return produto;
                    }
                }
                System.out.println("\t=> Produto Inexistente <=");
                return null;
            }
            void acrescentarEstoque(){
                Produto produto=procurarProduto();
                
                if (produto!=null) {
                    System.out.println("\t====== ACRESCENTAR ESTOQUE ======");
                    System.out.print("\nDigite o Novo Acréscimo: ");
                    int quantidade=sc.nextInt();

                    produto.quantidade+=quantidade;
                    System.out.println("Nova Quantidade: "+produto.quantidade);
                }
            }
            void retirarEstoque(){
            Produto produto=procurarProduto();

            System.out.println("\t====== RETIRAR ESTOQUE ======");
            }

            public static void main(String[] args) {
            Estante estante=new Estante();

        }
        }
        
        
    }
    
