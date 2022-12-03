package Visao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import Dominio.*;
import Persistencia.ClienteDAO;

public class Principal {
    public static void main(String[] args) {

        String data = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String hora   = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println(hora);
        System.out.println(data);

        // variaveis
        Scanner teclado = new Scanner(System.in);
        int op, op2, i;
        String cpfaux;
        ClienteDAO clienteDAO = new ClienteDAO();
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        Cliente clienteVisao;
        // fim das variaveis

        // CPF/NOME/LOGIN/SENHA/ATIVO

        // programa
        /*
        MENU PRINCIPAL
        MENU DE CLIENTES
        MENU DE ALUGUEIS
        MENU DE CAMPO
        SAIR
        */
        do {
            System.out.println("########## MENU PRINCIPAL ###########");
            System.out.println("1 - ####### MENU DE CLIENTES ########");
            System.out.println("2 - ####### MENU DE ALUGUEIS ########");
            System.out.println("3 - ############# SAIR ##############");
            op2 = teclado.nextInt();
        } while (op2 != 4);
        do {
            System.out.println("######### MENU DE CLIENTES ##########");
            System.out.println("1 - ####### INSERIR CLIENTE ########");
            System.out.println("2 - ############ BUSCAR ############");
            System.out.println("3 - ########## RELATÓRIO ###########");
            System.out.println("4 - ########### ALTERAR ############");
            System.out.println("5 - ########### EXCLUSAO ###########");
            op = teclado.nextInt();
            teclado.nextLine();
            switch (op){
                case 1:
                    /*########################################
                    ########## INSERÇÃO DE CLIENTES ##########
                    #########################################*/
                    System.out.println("INSERIR CONTATO");
                    System.out.println("DIGITE O CPF DO CLIENTE: ");
                    cpfaux = teclado.nextLine();
                    clienteVisao = clienteDAO.getCliente(cpfaux);
                    if(clienteVisao == null){
                        clienteVisao = new Cliente();
                        clienteVisao.setPk_cpf(cpfaux); // cpf pego logo acima
                        System.out.println("Digite o nome: ");
                        clienteVisao.setNome(teclado.nextLine());
                        System.out.println("DIGITE O LOGIN: ");
                        clienteVisao.setLogin(teclado.nextLine());
                        System.out.println("DIGITE A SENHA: ");
                        clienteVisao.setSenha(teclado.nextLine());
                        clienteVisao.setAtivo(true);
                        clienteDAO.setInserir(clienteVisao);
                        System.out.println("CLIENTE INSERIDO COM SUCESSO!");
                    } else {
                        System.out.println("Cliente já cadastrado");
                    }
                    break;
                case 2:
                    /*###################################
                    ########## BUSCAR CLIENTES ##########
                    ###################################*/
                    System.out.println("BUSCANDO CONTATO");
                    System.out.println("DIGITE O CPF DO CONTATO: ");
                    cpfaux = teclado.nextLine();
                    clienteVisao = clienteDAO.getCliente(cpfaux);
                    if(clienteVisao != null){
                        System.out.println("CPF: " + clienteVisao.getPk_cpf());
                        System.out.println("NOME: " + clienteVisao.getNome());
                        System.out.println("LOGIN: " + clienteVisao.getLogin());
                        System.out.println("SENHA: " + clienteVisao.getSenha());
                        System.out.println("ATIVO: " + clienteVisao.getAtivo());
                    } else {
                        System.out.println("CLIENTE NÃO CADASTRADO!");
                    }
                    break;
                case 3:
                    /*########################################
                    ########## RELATÓRIO DE CLIENTES #########
                    #########################################*/
                    clientes = clienteDAO.getRelatorio();
                    for(i = 0; i < clientes.size(); i++){
                        System.out.println("####################################\n");
                        System.out.println("CPF: "+ clientes.get(i).getPk_cpf());
                        System.out.println("NOME: "+ clientes.get(i).getNome());
                        System.out.println("LOGIN: "+ clientes.get(i).getLogin());
                        System.out.println("SENHA: "+ clientes.get(i).getSenha());
                        System.out.println("ATIVO: "+ clientes.get(i).getAtivo());
                        System.out.println("####################################\n");
                    }
                    break;
                case 4:
                    /*#######################################
                    ############ ALTERAR CLIENTES ###########
                    #######################################*/
                    System.out.println("ALTERANDO CONTATO");
                    System.out.println("DIGITE O CPF DO CLIENTE: ");
                    cpfaux = teclado.nextLine();
                    clienteVisao = clienteDAO.getCliente(cpfaux);
                    if(clienteVisao != null){
                        clienteVisao = new Cliente();
                        clienteVisao.setPk_cpf(cpfaux);
                        System.out.println("DIGITE O NOVO NOME: ");
                        clienteVisao.setNome(teclado.nextLine());
                        System.out.println("DIGITE O NOVO LOGIN: ");
                        clienteVisao.setLogin(teclado.nextLine());
                        System.out.println("DIGITE A NOVA SENHA: ");
                        clienteVisao.setSenha(teclado.nextLine());
                        clienteVisao.setAtivo(true);
                        clienteDAO.setAlterar(clienteVisao);
                        System.out.println("ALTERAÇÃO EFETUADA COM SUCESSO");
                    } else {
                        System.out.println("CONTATO NÃO CADASTRADO!");
                    }
                    break;
                case 5:
                    /*#######################################
                    ############ EXCLUIR CLIENTES ###########
                    #######################################*/
                    System.out.println("EXCLUINDO CONTATO...");
                    System.out.println("DIGITE O CPF DO CLIENTE: ");
                    cpfaux = teclado.nextLine();
                    clienteVisao = clienteDAO.getCliente(cpfaux);
                    if(clienteVisao != null){
                        clienteDAO.excluir(cpfaux);
                        System.out.println("EXCLUSÃO REALIZADA COM SUCESSO");
                    } else {
                        System.out.println("CONTATO NÃO CADASTRADO");
                    }
                    break;
            }
        } while(op != 6);
    }
}
