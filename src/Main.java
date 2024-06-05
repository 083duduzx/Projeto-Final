/*
 As funcionalidades básicas do sistema devem ser:
 ------------------------------(EM PROCESSO)------------------------------------------------
• Adicionar novos usuários (gerente, vendedor, caixa, cliente, fornecedor):

OBS: falta adicionar caixa e fornecedor

 ------------------------------(EM PROCESSO)------------------------------------------------
• Gerenciar produtos:
Atributos essenciais de um produto: nome, categoria, fornecedor, preço, quantidadeEmEstoque,
descrição (Outros atributos podem ser colocados):

OBS: falta adicionar a descrição

------------------------------(NÃO FEZ AINDA)------------------------------------------------
• Registrar vendas;
Atributos essenciais de uma venda: data, produto(s), vendedor, cliente, valorTotal (Outros atributos
podem ser colocados):(NÃO FIZ AINDA)
• Oferta de descontos;
• Pesquisar produtos;
• Gerar relatórios de vendas e de estoque.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Produto> produtos = new ArrayList<>();
    private static List<Usuario> usuarios = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar produto");
            System.out.println("2. Listar produtos");
            System.out.println("3. Adicionar usuário");
            System.out.println("4. Listar usuários");
            System.out.println("5. Sair");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    adicionarProduto();
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    adicionarUsuario();
                    break;
                case 4:
                    listarUsuarios();
                    break;
                case 5:
                    System.out.println("SAINDO!!!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void adicionarProduto() {
        System.out.println("Digite o ID do produto:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consome a nova linha
        System.out.println("Digite o nome do produto:");
        String nome = scanner.nextLine();
        System.out.println("Digite o preço do produto:");
        double preco = scanner.nextDouble();
        System.out.println("Digite a quantidade do produto:");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); // Consome a nova linha
        System.out.println("Digite o fornecedor do produto:");
        String fornecedor = scanner.nextLine();

        Produto produto = new Produto(id, nome, preco, quantidade, fornecedor);
        produtos.add(produto);
        System.out.println("Produto adicionado com sucesso!");
    }

    private static void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            for (Produto produto : produtos) {
                System.out.println(produto);
            }
        }
    }

    private static void adicionarUsuario() {
        System.out.println("Digite o tipo de usuário (gerente, vendedor ou cliente):");
        String tipo = scanner.nextLine();
        System.out.println("Digite o nome do usuário:");
        String nome = scanner.nextLine();
        System.out.println("Digite o CPF do usuário:");
        String cpf = scanner.nextLine();
        System.out.println("Digite o numero de telefone do usuário:");
        String telefone = scanner.nextLine();

        Usuario usuario;
        switch (tipo.toLowerCase()) {
            case "gerente":
                System.out.println("Digite o salário do gerente:");
                double salario = scanner.nextDouble();
                usuario = new Gerente(nome, cpf, telefone, salario);
                break;
            case "vendedor":
                System.out.println("Digite a comissão do vendedor:");
                double comissao = scanner.nextDouble();
                usuario = new Vendedor(nome, cpf, telefone, comissao);
                break;
            case "cliente":
                System.out.println("Digite o endereço do cliente:");
                String endereco = scanner.nextLine();
                usuario = new Cliente(nome, cpf, telefone, endereco);
                break;
            default:
                System.out.println("Tipo de usuário inválido.");
                return;
        }
        usuarios.add(usuario);
        System.out.println("Usuário adicionado com sucesso!");
    }

    private static void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
        } else {
            for (Usuario usuario : usuarios) {
                System.out.println(usuario.mostrarMonitor()); // Chamando o método mostrarMonitor()
            }
        }
    }
}
