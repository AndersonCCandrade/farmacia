package br.com.alurasenac.modulo.teste;

import br.com.alurasenac.modulo.produto.ProdutoService;

public class TesteParaListarProdutos {
    private static ProdutoService service = new ProdutoService();
    public static void main(String[] args) {

        System.out.println("Listagem de Produto");
        System.out.println("_____________________________________________________");

        var produtos = service.listarProdutos();
        produtos.stream().forEach(System.out::println);

        System.out.println("_____________________________________________________");


    }
}
