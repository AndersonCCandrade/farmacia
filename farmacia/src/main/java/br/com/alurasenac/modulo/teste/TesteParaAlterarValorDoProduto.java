package br.com.alurasenac.modulo.teste;

import br.com.alurasenac.modulo.produto.ProdutoService;

import java.util.Scanner;

public class TesteParaAlterarValorDoProduto {

    private static ProdutoService service = new ProdutoService();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Alterando Valor do Produto");
        System.out.println("_____________________________________________________");
        System.out.println("Digite o id do produto:");
        var id = scanner.nextInt();
        System.out.println("Digite o valor do produto:");
        var valor = scanner.nextBigDecimal();

        service.alterarValorDoProduto(id,valor);
        System.out.println("Valor do produto alterado com sucesso!");
        System.out.println("_____________________________________________________");
    }
}
