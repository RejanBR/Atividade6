package br.com.alurasenac.farmacia;

import br.com.alurasenac.farmacia.dao.Conectyfactory;
import br.com.alurasenac.farmacia.dao.ProdutoDAO;
import br.com.alurasenac.farmacia.modelo.Produto;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static Scanner digitado = new Scanner(System.in);
    private static Conectyfactory conectando = new Conectyfactory();
    private static ProdutoDAO produtoDigitado = new ProdutoDAO(conectando.recuperarConexao());
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        //System.out.printf("Hello and welcome!");


        cadastrarProdutoNovo();
        listarProdutosTodos();


        }

    private static void listarProdutosTodos() {
    }

    private static void cadastrarProdutoNovo() {
        System.out.println("Digitar o nome do produto: ");
        var nomeDigitado = digitado.next();
        System.out.println("Digitar o fabricante:");
        var fabricanteDigitado = digitado.next();
        System.out.println("Digitar o Preço: ");
        var precoDigitado = digitado.nextFloat();

        produtoDigitado.service(new Produto(precoDigitado,nomeDigitado,fabricanteDigitado));

        //System.out.println(nomeDigitado + fabricanteDigitado + precoDigitado);
    }
package br.com.alurasenac.farmacia;

import br.com.alurasenac.farmacia.service.ProdutoService;

    public class Main {
        public static void main(String[] args) {
            ProdutoService produtoService = new ProdutoService();
            produtoService.cadastrarNovoProduto("Paracetamol", 10.9

 {
  ProdutoService produtoService = new ProdutoService();
  produtoService.cadastrarNovoProduto("Paracetamol", 10.99);





    }






    //Fim do main
}