package br.com.alurasenac.modulo.teste;


import br.com.alurasenac.modulo.produto.DadosDoProduto;
import br.com.alurasenac.modulo.produto.ProdutoService;

import java.util.Scanner;

public class TesteParaCadastrarProdutoNoBanco {

    private static ProdutoService service = new ProdutoService();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cadastro de Produto");
        System.out.println("_____________________________________________________");
        System.out.println("Digite o código do produto:");
        var id = scanner.nextInt();

        System.out.println("Digite o nome do produto:");
        var nome = scanner.next();

        System.out.println("Digite o valor do produto:");
        var preco = scanner.nextBigDecimal();

        System.out.println("Digite o nome do fabricante:");
        var fabricante = scanner.next();

        service.cadastraProduto(new DadosDoProduto(id,nome,preco,fabricante));

        System.out.println("Produto cadastrado com sucesso!");


    }
}
