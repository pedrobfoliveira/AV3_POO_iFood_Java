package programa;

import entidades.*;
import java.util.*;

public class Aplicacao {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Fisica> pessoasFisicas = new ArrayList<>();
    private static final List<Juridica> pessoasJuridicas = new ArrayList<>();
    private static final List<Restaurante> restaurantes = new ArrayList<>();

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n=== Menu Principal ===");
            System.out.println("1. Cadastrar Pessoa Física");
            System.out.println("2. Cadastrar Pessoa Jurídica (Restaurante)");
            System.out.println("3. Adicionar Restaurante");
            System.out.println("4. Adicionar Itens ao Cardápio");
            System.out.println("5. Fazer Pedido");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> cadastrarPessoaFisica();
                case 2 -> cadastrarPessoaJuridica();
                case 3 -> adicionarRestaurante();
                case 4 -> adicionarItensCardapio();
                case 5 -> fazerPedido();
                case 6 -> System.out.println("Encerrando o programa...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 6);
    }

    private static void cadastrarPessoaFisica() {
        System.out.println("\n=== Cadastrar Pessoa Física ===");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        pessoasFisicas.add(new Fisica(nome, endereco, cpf));
        System.out.println("Pessoa Física cadastrada com sucesso!");
    }

    private static void cadastrarPessoaJuridica() {
        System.out.println("\n=== Cadastrar Pessoa Jurídica ===");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("CNPJ: ");
        String cnpj = scanner.nextLine();
        pessoasJuridicas.add(new Juridica(nome, endereco, cnpj));
        System.out.println("Pessoa Jurídica cadastrada com sucesso!");
    }

    private static void adicionarRestaurante() {
        System.out.println("\n=== Adicionar Restaurante ===");
        if (pessoasJuridicas.isEmpty()) {
            System.out.println("Nenhuma pessoa jurídica cadastrada. Cadastre uma primeiro!");
            return;
        }

        System.out.println("Selecione o dono do restaurante:");
        for (int i = 0; i < pessoasJuridicas.size(); i++) {
            System.out.println((i + 1) + ". " + pessoasJuridicas.get(i).getNome());
        }
        int escolha = scanner.nextInt() - 1;
        scanner.nextLine();
        Juridica dono = pessoasJuridicas.get(escolha);

        System.out.print("Nome do restaurante: ");
        String nome = scanner.nextLine();

        System.out.println("Escolha a categoria:");
        for (CategoriaRestaurante categoria : CategoriaRestaurante.values()) {
            System.out.println((categoria.ordinal() + 1) + ". " + categoria);
        }
        int categoriaEscolhida = scanner.nextInt() - 1;
        scanner.nextLine();
        CategoriaRestaurante categoria = CategoriaRestaurante.values()[categoriaEscolhida];

        restaurantes.add(new Restaurante(nome, categoria, dono));
        System.out.println("Restaurante adicionado com sucesso!");
    }

    private static void adicionarItensCardapio() {
        System.out.println("\n=== Adicionar Itens ao Cardápio ===");
        if (restaurantes.isEmpty()) {
            System.out.println("Nenhum restaurante cadastrado. Adicione um restaurante primeiro!");
            return;
        }

        System.out.println("Selecione o restaurante:");
        for (int i = 0; i < restaurantes.size(); i++) {
            System.out.println((i + 1) + ". " + restaurantes.get(i).getNome());
        }
        int escolha = scanner.nextInt() - 1;
        scanner.nextLine();
        Restaurante restaurante = restaurantes.get(escolha);

        System.out.print("Nome do item: ");
        String nome = scanner.nextLine();
        System.out.print("Descrição do item: ");
        String descricao = scanner.nextLine();
        System.out.print("Preço do item: ");
        double preco = scanner.nextDouble();

        restaurante.getCardapio().add(new ItemCardapio(nome, descricao, preco));
        System.out.println("Item adicionado ao cardápio!");
    }

    private static void fazerPedido() {
        System.out.println("\n=== Fazer Pedido ===");
        if (pessoasFisicas.isEmpty() || restaurantes.isEmpty()) {
            System.out.println("Certifique-se de que existem pessoas físicas e restaurantes cadastrados.");
            return;
        }

        System.out.println("Selecione a pessoa física:");
        for (int i = 0; i < pessoasFisicas.size(); i++) {
            System.out.println((i + 1) + ". " + pessoasFisicas.get(i).getNome());
        }
        int pessoaEscolhida = scanner.nextInt() - 1;
        scanner.nextLine();
        Fisica cliente = pessoasFisicas.get(pessoaEscolhida);

        System.out.println("Selecione o restaurante:");
        for (int i = 0; i < restaurantes.size(); i++) {
            System.out.println((i + 1) + ". " + restaurantes.get(i).getNome());
        }
        int restauranteEscolhido = scanner.nextInt() - 1;
        scanner.nextLine();
        Restaurante restaurante = restaurantes.get(restauranteEscolhido);

        List<ItemPedido> itens = new ArrayList<>();
        Pedido pedido = new Pedido(restaurante, itens);

        int opcao;
        do {
            System.out.println("\n=== Gerenciamento do Pedido ===");
            System.out.println("1. Adicionar Itens ao Pedido");
            System.out.println("2. Listar Itens do Pedido");
            System.out.println("3. Consultar Valor Total do Pedido");
            System.out.println("4. Finalizar Pedido");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> adicionarItensAoPedido(itens, restaurante);
                case 2 -> listarItensDoPedido(pedido);
                case 3 -> consultarValorTotalDoPedido(pedido);
                case 4 -> {
                    System.out.println("Pedido finalizado com sucesso!");
                    cliente.fazerPedido(restaurante, itens);
                }
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 4);
    }

    private static void listarItensDoPedido(Pedido pedido) {
        System.out.println("\n=== Itens do Pedido ===");
        List<ItemPedido> itens = pedido.getItens();
        if (itens.isEmpty()) {
            System.out.println("O pedido ainda não possui itens.");
            return;
        }

        for (ItemPedido item : itens) {
            System.out.printf("Item: %s | Quantidade: %d | Subtotal: R$ %.2f%n",
                    item.getItemCardapio().getNome(), item.getQuantidade(), item.calcularSubtotal());
        }
    }

    private static void consultarValorTotalDoPedido(Pedido pedido) {
        System.out.println("\n=== Valor Total do Pedido ===");
        double total = pedido.calcularTotal();
        System.out.printf("Valor total do pedido: R$ %.2f%n", total);
    }

    private static void adicionarItensAoPedido(List<ItemPedido> itens, Restaurante restaurante) {
        System.out.println("\n=== Adicionar Itens ao Pedido ===");
        List<ItemCardapio> cardapio = restaurante.getCardapio();
        if (cardapio.isEmpty()) {
            System.out.println("O cardápio do restaurante está vazio.");
            return;
        }

        System.out.println("Selecione um item do cardápio:");
        for (int i = 0; i < cardapio.size(); i++) {
            System.out.printf("%d. %s - R$ %.2f%n", i + 1, cardapio.get(i).getNome(), cardapio.get(i).getPreco());
        }
        System.out.print("Escolha um item: ");
        int opcao = scanner.nextInt();
        System.out.print("Quantidade: ");
        int quantidade = scanner.nextInt();

        ItemCardapio itemCardapio = cardapio.get(opcao - 1);
        ItemPedido itemPedido = new ItemPedido(itemCardapio, quantidade);
        itens.add(itemPedido);

        System.out.printf("Item '%s' adicionado ao pedido. Subtotal: R$ %.2f%n",
                itemPedido.getItemCardapio().getNome(), itemPedido.calcularSubtotal());
    }
}
