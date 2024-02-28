package br.com.alurasenac.modulo.teste;

import br.com.alurasenac.modulo.produto.ProdutoService;

import java.util.Scanner;

public class TesteParaExcluirProduto {
    private static ProdutoService service = new ProdutoService();
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Excluindo Produto");
        System.out.println("_____________________________________________________");
        System.out.println("Digite o id do produto:");
        var id = scanner.nextInt();

        service.excluirProduto(id);
        System.out.println("Produto excluido com sucesso!");
        System.out.println("_____________________________________________________");
    }
}
