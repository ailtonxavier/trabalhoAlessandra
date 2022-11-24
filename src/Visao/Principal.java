package Visao;
import Dominio.Cliente;
import java.util.ArrayList;
import Persistencia.ClienteDAO;

import java.util.Scanner;
public class Principal {
    public static void main(String arg[]){
        int op, i, idaux;
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        ClienteDAO cliDAO = new ClienteDAO();
        Scanner teclado = new Scanner(System.in);
        Cliente client;
        do {
            System.out.println("--------------------------");
            System.out.println("           MENU           ");
            System.out.println("--------------------------");
            System.out.println("1 - CADASTRAR CLIENTE");
            System.out.println("2 - BUSCAR CLIENTE");
            // procurar contato && procurar endereço
            System.out.println("3 - RELATÓRIO DE CLIENTES");
            System.out.println("4 - RESERVAR CAMPO");
            System.out.println("5 - ALTERAR CONTATO");
            System.out.println("6 - EXCLUIR CLIENTE");
            System.out.println("7 - RELATÓRIO DE ALUGUEIS");
            System.out.println("8 - SAIR DO SISTEMA");
            op = teclado.nextInt();
            switch (op){
                case 1:
                    System.out.println("CADASTRANDO CLIENTE\n");
                    System.out.println("DIGITE O CPF DO CLIENTE: ");
                    idaux = teclado.nextInt();
                    teclado.nextLine();
                    client = cliDAO.buscar(idaux);
                    if(client==null){
                        client = new Cliente();
                        client.setPk_cpf(idaux);
                        System.out.println("DIGITE O NOME DO CLIENTE: ");
                        client.setNome(teclado.nextLine());
                        System.out.println("DIGITE O LOGIN DO CLIENTE: ");
                        client.setLogin(teclado.nextLine());
                        System.out.println("DIGITE A SENHA DO CLIENTE: ");
                        client.setSenha(teclado.nextLine());
                        client.isAtivo(true);
                    }
                    break;
                case 2: break;
                case 3:
                    System.out.println("RELATÓRIO DE CLIENTES");
                    clientes = cliDAO.emitirRelatorioClientes();
                    for(i = 0; i < clientes.size(); i++){
                        System.out.println("CPF: "+clientes.get(i).getPk_cpf());
                        System.out.println("NOME: "+clientes.get(i).getNome());
                        System.out.println("SENHA: "+clientes.get(i).getSenha());
                        System.out.println("LOGIN: "+clientes.get(i).getLogin());
                        System.out.println("ATIVO: "+clientes.get(i).getAtivo()+"\n");
                    }
                    break;
                case 4: break;
                case 5: break;
                case 6: break;
                case 7: break;
                case 8: break;
                default: break;
            }
        }while(op != 8);

    }
}
