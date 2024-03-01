import br.com.alurasenac.modulo.exception.RegraDeNegocioException;
import br.com.alurasenac.modulo.produto.DadosDoProduto;
import br.com.alurasenac.modulo.produto.DadosDoProdutoID;
import br.com.alurasenac.modulo.produto.ProdutoService;

import java.util.Scanner;

public class FarmaciaApplication {

    private static ProdutoService service = new ProdutoService();
    private static Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    public static void main(String[] args) {

        var opcao = exibirMenu();
        while (opcao != 6) {
            try {
                switch (opcao) {
                    case 1:
                        listarProduto();
                        break;
                    case 2:
                        adicionarProduto();
                        break;
                    case 3:
                        editarProduto();
                        break;
                    case 4:
                        removerProduto();
                        break;
                    case 5:
                        buscarProdutoPorID();
                        break;
                }
            } catch (RegraDeNegocioException e) {
                System.out.println("Erro: " +e.getMessage());
                System.out.println("Pressione qualquer tecla e de ENTER para voltar ao menu");
                scanner.next();
            }
            opcao = exibirMenu();
        }

        System.out.println("Finalizando a aplicação.");
    }

    private static int exibirMenu() {
        System.out.println("""
                FARMACIA - ESCOLHA UMA OPÇÃO:
                1 - Listar produto
                2 - Adicionar produto
                3 - Editar valor do produto
                4 - Excluir produto
                5 - Buscar produto por ID
                6 - Sair
                """);
        return scanner.nextInt();
    }

    private static void listarProduto() {
        System.out.println("Listagem de Produto");
        System.out.println("_____________________________________________________");

        var produtos = service.listarProdutos();
        produtos.stream().forEach(System.out::println);

        System.out.println("_____________________________________________________");
        System.out.println("Pressione qualquer tecla e de ENTER para voltar ao menu principal");
        scanner.next();
    }

    private static void adicionarProduto() {
        System.out.println("Cadastro de Produto");
        System.out.println("_____________________________________________________");

        System.out.println("Digite o nome do produto:");
        var nome = scanner.next();

        System.out.println("Digite o valor do produto:");
        var preco = scanner.nextBigDecimal();

        System.out.println("Digite o nome do fabricante:");
        var fabricante = scanner.next();

        service.cadastraProduto(new DadosDoProduto(nome,preco,fabricante));

        System.out.println("Produto cadastrado com sucesso!");
        System.out.println("_____________________________________________________");
        System.out.println("Pressione qualquer tecla e de ENTER para voltar ao menu principal");
        scanner.next();
    }

    private static void editarProduto() {
        System.out.println("Alterando Valor do Produto");
        System.out.println("_____________________________________________________");
        System.out.println("Digite o id do produto:");
        var id = scanner.nextInt();
        System.out.println("Digite o valor do produto:");
        var valor = scanner.nextBigDecimal();

        service.alterarValorDoProduto(id,valor);
        System.out.println("Valor do produto alterado com sucesso!");
        System.out.println("_____________________________________________________");
        System.out.println("Pressione qualquer tecla e de ENTER para voltar ao menu principal");
        scanner.next();
    }

    private static void removerProduto() {
        System.out.println("Excluindo Produto");
        System.out.println("_____________________________________________________");
        System.out.println("Digite o id do produto:");
        var id = scanner.nextInt();

        service.excluirProduto(id);
        System.out.println("Produto excluido com sucesso!");
        System.out.println("_____________________________________________________");
        System.out.println("Pressione qualquer tecla e de ENTER para voltar ao menu principal");
        scanner.next();
    }

    private static void buscarProdutoPorID() {
        System.out.println("Listagem de Produto por ID");
        System.out.println("_____________________________________________________");
        System.out.println("Digite o id do produto:");
        var id = scanner.nextInt();

        var produto = service.listarProdutoPorID(id);
        System.out.println(produto);

        System.out.println("_____________________________________________________");
        System.out.println("Pressione qualquer tecla e de ENTER para voltar ao menu principal");
        scanner.next();
    }

}

