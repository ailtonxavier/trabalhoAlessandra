package Visao;

import java.util.Scanner;
public class Principal {
    public static void main(String arg[]){
        Scanner teclado = new Scanner(System.in);
        int op, i, op2;

        // MENU PRINCIPAL
        do {
            System.out.println("----------------------");
            System.out.println("         MENU         ");
            System.out.println("----------------------");
            System.out.println("1 - RESERVAR CAMPO");
            System.out.println("2 - BUSCAR CLIENTE");
            System.out.println("3 - CADASTRAR CLIENTE");
            System.out.println("4 - ALTERAR CONTATO");
            System.out.println("5 - EXCLUIR CLIENTE");
            System.out.println("6 - SAIR DO SISTEMA");
            System.out.print("DIGITE UMA OPÇÃO: ");
            op = teclado.nextInt();
            switch (op){
                case 1: break;
                case 2:
                    do {System.out.println("------------------------------");
                        System.out.println("        BUSCAR CLIENTE        ");
                        System.out.println("------------------------------");
                        System.out.println("1 - BUSCAR PELO CPF");
                        System.out.println("2 - BUSCAR PELO NOME");
                        System.out.println("3 - VOLTAR AO MENU PRINCIPAL");
                        op2 = teclado.nextInt();
                        switch (op2){
                            case 1: break;
                            case 2: break;
                            case 3: break;
                            default:
                                System.out.println("VOCÊ DIGITOU UMA OPÇÃO INVÁLIDA,\nSELECIONE UMA OPÇÃO VÁLIDA"); break;
                        }
                    } while(op2 != 3);
                    System.out.println("2 - BUSCAR CLIENTE");
                    break;
                case 3: break;
                case 4: break;
                case 5: break;
                case 6: break;
                default: System.out.println("VOCÊ DIGITOU UMA OPÇÃO INVÁLIDA,\nSELECIONE OPÇÃO UMA VÁLIDA!"); break;
            }
        } while(op != 6);
        /* SUBMENU
        System.out.println("        BUSCAR CLIENTE        ")
        System.out.println("1 - BUSCAR PELO CPF")
        System.out.println("2 - BUSCAR PELO NOME")
        System.out.println("3 - VOLTAR AO MENU PRINCIPAL")
        * */
    }
}
