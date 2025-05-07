import adega.controller.BebidaController;
import adega.model.Bebida;
import adega.model.BebidaAlcoolica;
import adega.model.BebidaNaoAlcoolica;
import adega.util.Cores;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

        BebidaController bebida = new BebidaController();
        Scanner entradaDados = new Scanner(System.in);

        int opcao, volume, tipo, teorAlcool, bebidaId;
        String nome, fabricante, contemAcucar;
        float preco;

        BebidaAlcoolica bebidaAlcoolica = new BebidaAlcoolica(bebida.gerarNumero(), "Ambev", "Skoll", 9, 2, 5);
        BebidaNaoAlcoolica bebidaNaoAlcoolica = new BebidaNaoAlcoolica(bebida.gerarNumero(), "Ambev", "Skoll", 9, 2, "SIM");
        bebida.adicionar(bebidaAlcoolica);
        bebida.adicionar(bebidaNaoAlcoolica);


        while (true) {
            System.out.println(Cores.TEXT_GREEN_BOLD + Cores.ANSI_BLACK_BACKGROUND +
                    """
                            *******************************************************
                                            
                                            Adega do Carlos
                                            
                            *******************************************************
                                            
                                        1 - Adicionar Bebida no Estoque
                                        2 - Listar todas as Bebidas do Estoque
                                        3 - Buscar Bebida por ID
                                        4 - Atualizar Dados das Bebidas
                                        5 - Retirar Bebida do Estoque
                                        0 - Sair
                                            
                            *******************************************************
                            Entre com a opção desejada :
                            """);

            try {
                opcao = entradaDados.nextInt();
                entradaDados.skip("\\R");

                if (opcao == 0) {
                    sobre();
                    System.exit(0);
                }

                switch (opcao) {

                    case 1:
                        System.out.println("Digite o nome da Bebida!");
                        nome = entradaDados.nextLine();

                        System.out.println("Digite o Fabricante da Bebida!");
                        fabricante = entradaDados.nextLine();

                        System.out.println("Digite o Preço da Bebida!");
                        preco = entradaDados.nextFloat();

                        System.out.println("Digite o Volume da Bebida!");
                        volume = entradaDados.nextInt();

                        System.out.println(" Para Bebidas Alcóolica preciona 1 || Para Bebidas não Alcóolicas preciona 2");
                        tipo = entradaDados.nextInt();

                        switch (tipo) {
                            case 1:
                                System.out.println("Digite o teor de Álcool (%)");
                                teorAlcool = entradaDados.nextInt();
                                bebida.adicionar(new BebidaAlcoolica(bebida.gerarNumero(), fabricante, nome, preco, volume, teorAlcool));
                                System.out.println("Bebida Adicionada com Sucesso!");
                                keyPress();
                                break;
                            case 2:
                                entradaDados.skip("\\R");
                                System.out.println("Digite SIM se contém açucar || Digite NÃO se não contém açucar");
                                contemAcucar = entradaDados.nextLine();
                                bebida.adicionar(new BebidaNaoAlcoolica(bebida.gerarNumero(), fabricante, nome, preco, volume, contemAcucar));
                                System.out.println("Bebida Adicionada com Sucesso!");
                                keyPress();
                                break;
                            default:
                                System.out.println("Inválido");
                        }
                        break;
                    case 2:
                        bebida.listarTodos();
                        keyPress();
                        break;
                    case 3:
                        System.out.println("Digite o ID da Bebida que deseja buscar");
                        bebidaId = entradaDados.nextInt();
                        bebida.procurarPoId(bebidaId);
                        keyPress();
                        break;
                    case 4:
                        System.out.println("Digite o ID da Bebida que pretende Atualizar");
                        bebidaId = entradaDados.nextInt();

                        Optional<Bebida> pegaBebida = bebida.buscarNaCollection(bebidaId);

                        if (pegaBebida.isPresent()) {
                            entradaDados.skip("\\R");
                            System.out.println("Digite o nome da Bebida!");
                            nome = entradaDados.nextLine();

                            System.out.println("Digite o Fabricante da Bebida!");
                            fabricante = entradaDados.nextLine();

                            System.out.println("Digite o Preço da Bebida!");
                            preco = entradaDados.nextFloat();

                            System.out.println("Digite o Volume da Bebida!");
                            volume = entradaDados.nextInt();

                            System.out.println(" Para Bebidas Alcóolica preciona 1 || Para Bebidas não Alcóolicas preciona 2");
                            tipo = entradaDados.nextInt();

                            switch (tipo) {
                                case 1:
                                    System.out.println("Digite o teor de Álcool (%)");
                                    teorAlcool = entradaDados.nextInt();
                                    bebida.atualizar(new BebidaAlcoolica(bebidaId, fabricante, nome, preco, volume, teorAlcool));
                                    keyPress();
                                    break;
                                case 2:
                                    entradaDados.skip("\\R");
                                    System.out.println("Digite SIM se contém açucar || Digite NÃO se não contém açucar");
                                    contemAcucar = entradaDados.nextLine();
                                    bebida.atualizar(new BebidaNaoAlcoolica(bebidaId, fabricante, nome, preco, volume, contemAcucar));
                                    keyPress();
                                    break;
                            }
                        } else {
                            System.out.printf("A Bebida de ID %d não existe ", bebidaId);
                        }
                        keyPress();
                        break;
                    case 5:
                        System.out.println("Digite o ID da Bebida que deseja Remover");
                        bebidaId = entradaDados.nextInt();
                        Optional<Bebida> bebidaParaRemover = bebida.buscarNaCollection(bebidaId);
                        bebida.Remover(bebidaParaRemover.get().getId());
                        keyPress();
                        break;
                    default:
                        System.out.println("Opção Inválida");
                        keyPress();
                        break;
                }
            }catch (InputMismatchException e) {
                System.out.println("Digite os dados corretamente.");
            }


        }

    }

    public static void sobre() {
        System.out.println(Cores.TEXT_GREEN_BOLD + Cores.ANSI_BLACK_BACKGROUND + """
                
                *******************************************************
                Projecto Desenvolvido por : Ângelo dos Santos.
                Generation Brasil - angelokapunda@gmail.com
                GitHub : github.com/angelokapunda
                Linkedin : linkedin.com/in/angelokapunda
                *******************************************************
                """);
    }

    public static void keyPress() {
        try {
            System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
            System.in.read();
        } catch (IOException e) {
            System.err.println("Ocorreu um erro ao tentar ler o teclado");
        }
    }
}
