import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import model.Produto;
import model.Cliente;
import model.Pedido;

public class App {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Produto> produtos = new ArrayList<Produto>();
    static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    static ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
    static Random random = new Random();

    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenu();
            System.out.print("Escolha uma opção: KAIQUE É O MELHOR PROFESSOR DO MUNDO");
            opcao = sc.nextInt();
            sc.nextLine();
            limparTela();

            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    adicionarEstoque();
                    break;
                case 4:
                    removerEstoque();
                    break;
                case 5:
                    buscarProduto();
                    break;
                case 6:
                    alterarProduto();
                    break;
                case 7:
                    removerProduto();
                    break;
                case 8:
                    relatorioDeEstoque();
                    break;
                case 9:
                    pesquisarPorNome();
                    break;
                case 10:
                    cadastrarCliente();
                    break;
                case 11:
                    listarProdutos();
                    break;
                case 0:
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        sc.close();
    }

    public static void exibirMenu() {
        System.out.println("======== Cadastro de Produto ========");
        System.out.println("1 - Cadastrar produto");
        System.out.println("2 - Ver dados do produto");
        System.out.println("3 - Adicionar quantidade ao estoque");
        System.out.println("4 - Remover quantidade do estoque");
        System.out.println("5 - Buscar produto");
        System.out.println("6 - Alterar produto");
        System.out.println("7 - Remover produto");
        System.out.println("8 - Relatório de estoque");
        System.out.println("9 - Pesquisar produto por nome");
        System.out.println("10 - Cadastrar Cliente");
        System.out.println("11 - Ver dados dos clientes");
        System.out.println("0 - Sair");
        System.out.println("====================================");
    }

    public static void cadastrarProduto() {
        int codigo, quantidade;
        boolean codigoValido;
        String nome;
        double valor;

        do {
            codigoValido = true;
            System.out.print("Código: ");
            codigo = sc.nextInt();
            sc.nextLine();

            if (codigo <= 0) {
                System.out.println("Código inválido.");
                codigoValido = false;
            } else if (buscarPorCodigo(codigo) != null) {
                System.out.println("Código já cadastrado!");
                codigoValido = false;
            }
        } while (!codigoValido);

        do {
            System.out.print("Nome: ");
            nome = sc.nextLine();
            if (nome.isBlank()) {
                System.out.println("Nome inválido.");
            }
        } while (nome.isBlank());

        do {
            System.out.print("Valor: ");
            valor = sc.nextDouble();
            sc.nextLine();
            if (valor < 0) {
                System.out.println("Valor inválido.");
            }
        } while (valor < 0);

        do {
            System.out.print("Quantidade inicial em estoque: ");
            quantidade = sc.nextInt();
            sc.nextLine();
            if (quantidade < 0) {
                System.out.println("Quantidade inválida.");
            }
        } while (quantidade < 0);

        Produto produto = new Produto(codigo, nome, valor, quantidade);
        produtos.add(produto);
        System.out.println("Produto cadastrado com sucesso.");
    }

    public static void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Não há produtos cadastrados.");
        } else {
            System.out.println("\t===== PRODUTOS =====");
            int numero=1;
            for (Produto p : produtos) {
                System.out.printf("%n\t=> Produto %d <=%n", numero);
                p.exibirDados();
                numero++;
            }
        }
    }

    public static void adicionarEstoque() {
        System.out.println("===== ADICIONAR QUANTIDADE =====");
        System.out.print("Digite o código do produto: ");
        int codigo=sc.nextInt();
        sc.nextLine();

        Produto p=buscarPorCodigo(codigo);

        if (p==null) {
            System.out.println("Produto não encontrado.");
        } else {
            System.out.print("Quantidade para adicionar: ");
            int quantidade=sc.nextInt();
            sc.nextLine();

            if (quantidade<=0) {
                System.out.println("Quantidade inválida.");
            } else {
                p.adicionarEstoque(quantidade);
                System.out.println("Estoque atualizado com sucesso!");
            }
        }
    }

    public static void removerEstoque() {
        System.out.println("===== REMOVER QUANTIDADE =====");
        System.out.print("Digite o código do produto: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        Produto p = buscarPorCodigo(codigo);

        if (p==null) {
            System.out.println("Produto não encontrado.");
        } else {
            System.out.print("Quantidade para remover: ");
            int quantidade = sc.nextInt();
            sc.nextLine();

            if (quantidade<=0) {
                System.out.println("Quantidade inválida.");
            } else if (p.removerEstoque(quantidade)) {
                System.out.println("Estoque atualizado com sucesso!");
            } else {
                System.out.println("Estoque insuficiente. Disponível: " + p.getQuantidadeEmEstoque());
            }
        }
    }

    public static void buscarProduto() {
        System.out.println("===== BUSCAR =====");
        System.out.print("Digite o código: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        Produto p = buscarPorCodigo(codigo);

        if (p == null) {
            System.out.println("Produto inexistente.");
        } else {
            System.out.println("\n\t=> Produto encontrado <=");
            p.exibirDados();
        }
    }

    public static void alterarProduto() {
        System.out.println("===== ALTERAR PRODUTO =====");
        System.out.print("Digite o código do produto: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        Produto p = buscarPorCodigo(codigo);

        if (p == null) {
            System.out.println("Produto não encontrado.");
        } else {
            System.out.println("\n\t=> Dados atuais <=");
            p.exibirDados();
            System.out.println();

            String novoNome;
            double novoValor;

            do {
                System.out.print("Novo nome: ");
                novoNome = sc.nextLine();
                if (novoNome.isBlank()) {
                    System.out.println("Nome inválido.");
                }
            } while (novoNome.isBlank());

            do {
                System.out.print("Novo valor: ");
                novoValor = sc.nextDouble();
                sc.nextLine();
                if (novoValor < 0) {
                    System.out.println("Valor inválido.");
                }
            } while (novoValor < 0);

            p.setNome(novoNome);
            p.setValor(novoValor);
            System.out.println("Produto alterado com sucesso!");
        }
    }
    public static void removerProduto() {
        System.out.println("===== REMOVER PRODUTO =====");
        System.out.print("Digite o código do produto: ");
        int codigo = sc.nextInt();
        sc.nextLine();

        Produto p = buscarPorCodigo(codigo);

        if (p == null) {
            System.out.println("Produto não encontrado.");
        } else {
            System.out.println("\n\t=> Dados atuais <=");
            p.exibirDados();
            System.out.println();

            int confirmacao;
            do {
                System.out.println("Você deseja remover este produto?");
                System.out.println("\t[1] Sim | [2] Não");
                System.out.print("=> ");
                confirmacao = sc.nextInt();
                sc.nextLine();

                if (confirmacao != 1 && confirmacao != 2) {
                    System.out.println("Opção inválida.");
                }
            } while (confirmacao != 1 && confirmacao != 2);

            if (confirmacao == 1) {
                produtos.remove(p);
                System.out.println("Produto removido com sucesso!");
            } else {
                System.out.println("Remoção cancelada.");
            }
        }
    }
    public static void relatorioDeEstoque() {
        if (produtos.isEmpty()) {
            System.out.println("Não há produtos cadastrados.");
        } else {
            System.out.println("\t===== RELATÓRIO DE ESTOQUE =====");
            int numero = 1, totalQuantidade = 0;
            double totalValor = 0;

            for (Produto p : produtos) {
                System.out.printf("%n\t=> Produto %d <=%n", numero);
                p.exibirDados();

                totalQuantidade += p.getQuantidadeEmEstoque();
                totalValor += p.calcularValorEmEstoque();
                numero++;
            }

            System.out.println("\n\t===== TOTAIS =====");
            System.out.println("Quantidade total em estoque: " + totalQuantidade);
            System.out.printf("Valor total em estoque: R$ %.2f%n", totalValor);
        }
    }
    public static void pesquisarPorNome() {
        System.out.println("===== PESQUISAR POR NOME =====");
        System.out.print("Digite o nome ou parte dele: ");
        String busca = sc.nextLine();

        int encontrados = 0;

        for (Produto p : produtos) {
            if (p.getNome().toLowerCase().contains(busca.toLowerCase())) {
                encontrados++;
                System.out.println(encontrados + " - " + p.getNome() + " (Código: " + p.getCodigo() + ")");
            }
        }

        if (encontrados == 0) {
            System.out.println("Nenhum produto encontrado.");
        }
    }
    public static Produto buscarPorCodigo(int codigo) {
        for (Produto p : produtos) {
            if (p.getCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }
    public static void limparTela() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
    public static void cadastrarCliente(){
        System.out.println("===== Cadastrar Cliente =====");
        System.out.print("Digite o Nome: ");
        String nome=sc.nextLine();
        System.out.print("Digite o CPF Cliente: ");
        String cpf=sc.nextLine();
        int codigo=random.nextInt(6);

        Cliente novoCliente=new Cliente(codigo, nome, cpf);
        clientes.add(novoCliente);
        System.out.println("Cliente criado!");
    }
    public static void listarCliente(){
        if (clientes.isEmpty()) {
            System.out.println("Não há clientes cadastrados.");
        } else {
            System.out.println("\t===== CLIENTES =====");
            for (Cliente c : clientes) {
                System.out.printf("%n\t=> Cliente %d <=%n");
                System.out.println("Código: "+c.getCodigo()+"\nNome: "+c.getNome()+"\nCPF: "+c.getCpf());
            }
        }
    }
    public static void novoPedido(){
        System.out.println("===== NOVO PEDIDO =====");
        listarCliente();
        System.out.println("Selecione o Cliente: ");
        int codigo=sc.nextInt();
        limparTela();
        
        ArrayList<Integer> produtosSelecionados=new ArrayList<>();
        Integer codProduto;

        do{
            System.out.println("===== Novo Pedido =====");
            listarProdutos();
            System.out.print("Selecione o Produto: ");
            codProduto=sc.nextInt();
            produtosSelecionados.add(codProduto);
        }while(codProduto!=0);
    }
}
