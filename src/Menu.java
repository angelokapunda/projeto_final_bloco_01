import adega.util.Cores;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

        Scanner entradaDados = new Scanner(System.in);
        int opcao;

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


            opcao = entradaDados.nextInt();

            if (opcao == 0) {
                sobre();
                System.exit(0);
            }


            switch (opcao) {

                case 1:
                    System.out.println("Adicionar Bebida no Estoque");
                    keyPress();
                    break;
                case 2:
                    System.out.println("Listar todas as Bebidas do Estoque");
                    keyPress();
                    break;
                case 3:
                    System.out.println("Buscar Bebida por ID");
                    keyPress();
                    break;
                case 4:
                    System.out.println("Atualizar Dados das Bebidas");
                    keyPress();
                    break;
                case 5:
                    System.out.println("Retirar Bebida do Estoque");
                    keyPress();
                    break;
                default:
                    System.out.println("Opção Inválida");
                    keyPress();
                    break;
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
