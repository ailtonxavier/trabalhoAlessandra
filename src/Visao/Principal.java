package Visao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import Dominio.*;
<<<<<<< HEAD
import Persistencia.ClienteDAO;
import Persistencia.EnderecoDAO;
import Persistencia.ContatoDAO;
import Persistencia.AluguelDAO;
import Persistencia.CampoDAO;
//imports
=======
import Persistencia.*;

>>>>>>> ca78836e6fe4a0315dd3cff3dd41e434a49e82a1
public class Principal {
    public static void main(String[] args) {

//        String data = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//        String hora   = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
//        System.out.println(hora);
//        System.out.println(data);

        // variaveis
        Scanner teclado = new Scanner(System.in);
        int op, op2, i;
        int aux1, aux2,aux3;
        String cpfaux;
        ClienteDAO clienteDAO = new ClienteDAO();
<<<<<<< HEAD
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        ContatoDAO contatoDAO = new ContatoDAO();
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
=======
        ContatoDAO contatoDAO = new ContatoDAO();
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        AluguelDAO aluguelDAO = new AluguelDAO();
        ArrayList<Cliente> clientes;
        ArrayList<Aluguel> alugueis;
        Contato contatoVisao;
>>>>>>> ca78836e6fe4a0315dd3cff3dd41e434a49e82a1
        Cliente clienteVisao;
        Endereco enderecoVisao;
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
            System.out.println("------------------------------------");
            System.out.println("--------- MENU DE PRINCIPAL --------");
            System.out.println("------------------------------------");
            System.out.println("1 - ####### MENU DE CLIENTES #######");
            System.out.println("2 - ####### MENU DE ALUGUEIS #######");
            System.out.println("3 - ####### ENCERRAR PROGRAMA ######");
            System.out.print("SELECIONE UMA OPÇÃO: ");
            op = teclado.nextInt();
            teclado.nextLine();
            System.out.println();
            switch (op){
                case 1:
                    do {
                        System.out.println("------------------------------------");
                        System.out.println("---------- MENU DE CLIENTES --------");
                        System.out.println("------------------------------------");
                        System.out.println("1 - ####### INSERIR CLIENTE ########");
                        System.out.println("2 - ######## BUSCAR CLIENTE ########");
                        System.out.println("3 - ##### RELATÓRIO DE CLIENTES ####");
                        System.out.println("4 - ####### ALTERAR CLIENTE ########");
                        System.out.println("5 - ##### EXCLUSAO DE CLIENTE ######");
                        System.out.println("6 - ### VOLTAR AO MENU PRINCIPAL ###");
                        System.out.print("SELECIONE UMA OPÇÃO: ");
                        op2 = teclado.nextInt();
                        teclado.nextLine();
                        switch (op2){
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
                                    contatoVisao = new Contato();
                                    enderecoVisao = new Endereco();
                                    clienteVisao.setPk_cpf(cpfaux); // cpf pego logo acima
                                    System.out.println("DIGITE O NOME: ");
                                    clienteVisao.setNome(teclado.nextLine());
                                    System.out.println("DIGITE O LOGIN: ");
                                    clienteVisao.setLogin(teclado.nextLine());
                                    System.out.println("DIGITE A SENHA: ");
                                    clienteVisao.setSenha(teclado.nextLine());
                                    clienteVisao.setAtivo(true);
                                    clienteDAO.setInserir(clienteVisao);

                                    contatoVisao.setPk_fk_cpf(cpfaux);
                                    System.out.println("DIGITE SEU EMAIL: ");
                                    contatoVisao.setEmail(teclado.nextLine());
                                    System.out.println("DIGITE SEU CELULAR: ");
                                    contatoVisao.setCelular(teclado.nextLine());
                                    System.out.println("DESEJA DEIXAR O TELEFONE FIXO?\n1 - SIM\t2 - NÃO");
                                    aux1 = teclado.nextInt();
                                    while(aux1 != 1 && aux1 != 2) {
                                        System.out.println("DESEJA DEIXAR O TELEFONE FIXO?\n1 - SIM\t2 - NÃO");
                                        aux1 = teclado.nextInt();
                                    }
                                    if(aux1 == 1){
                                            teclado.nextLine();
                                            System.out.println("DIGITE SEU TELEFONE FIXO: ");
                                            contatoVisao.setTelFixo(teclado.nextLine());
                                            System.out.println("DESEJA DEIXAR O TELEFONE COMERCIAL?\n1 - SIM\t2 - NÃO");
                                            aux1 = teclado.nextInt();
                                            while(aux1 != 1 && aux1 != 2){
                                                System.out.println("DESEJA DEIXAR O TELEFONE COMERCIAL?\n1 - SIM\t2 - NÃO");
                                                aux1 = teclado.nextInt();
                                            };
                                            if(aux1 == 1){
                                                teclado.nextLine();
                                                System.out.println("DIGITE SEU TELEFONE COMERCIAL: ");
                                                contatoVisao.setTelComercial(teclado.nextLine());
                                            }
                                        }
                                        teclado.nextLine();
                                    contatoDAO.setInserir(contatoVisao);


                                    System.out.println("DIGITE SUA CIDADE: ");
                                    enderecoVisao.setCidade(teclado.nextLine());
                                    System.out.println("DIGITE SEU BAIRRO: ");
                                    enderecoVisao.setBairro(teclado.nextLine());
                                    System.out.println("DIGITE SEU ESTADO: ");
                                    enderecoVisao.setEstado(teclado.nextLine());
                                    System.out.println("DIGITE O NOME DA RUA: ");
                                    enderecoVisao.setRua(teclado.nextLine());
                                    System.out.println("DIGITE O NUMERO DA CASA: ");
                                    enderecoVisao.setNumero(teclado.nextLine());
                                    enderecoVisao.setPk_fk_cpf(cpfaux);

                                    enderecoDAO.setInserir(enderecoVisao);

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
                                    contatoDAO.excluir(cpfaux);
                                    enderecoDAO.excluir(cpfaux);
                                    clienteDAO.excluir(cpfaux);
                                    System.out.println("EXCLUSÃO REALIZADA COM SUCESSO");
                                } else {
                                    System.out.println("CONTATO NÃO CADASTRADO");
                                }
                                break;
                            case 6:
                                System.out.println("");
                                break;
                            default:
                                System.out.println("OPÇÃO INVÁLIDA");
                                break;
                        }
                    } while(op2 != 6);
                    break;
                case 2:
                    do {
                        System.out.println("------------------------------------");
                        System.out.println("---------- MENU DE ALUGUEIS --------");
                        System.out.println("------------------------------------");
                        System.out.println("1 - ######### ALUGAR CAMPO #########");
                        System.out.println("2 - #### BUSCAR ALUGUEIS POR CPF ###");
                        System.out.println("3 - ##### RELATÓRIO DE ALUGUEIS ####");
                        System.out.println("4 - ########### EXCLUSAO ###########");
                        System.out.println("5 - ### VOLTAR AO MENU PRINCIPAL ###");
                        System.out.print("SELECIONE UMA OPÇÃO: ");
                        op2 = teclado.nextInt();
                        teclado.nextLine();
                        switch(op2){
                            case 1:
                                /*#######################################
                                ############ ALUGUEL DE CAMPO ###########
                                #######################################*/
                                System.out.println("DIGITE O CPF DO CLIENTE: ");
                                cpfaux = teclado.nextLine();
                                if(clienteDAO.getCliente(cpfaux) != null){
                                    System.out.println("Contato existe");
                                } else {
                                    System.out.println("CADASTRE UM CLIENTE PARA ALUGAR UM CAMPO");
                                }
                                break;
                            case 2:
                                /*#######################################
                                ############ BUSCAR ALUGUEL #############
                                #######################################*/
                                // ALTERAR

                                System.out.println("BUSCANDO ALUGUEL");
                                System.out.println("DIGITE O CPF DO CONTATO: ");
                                cpfaux = teclado.nextLine();
                                clienteVisao = clienteDAO.getCliente(cpfaux);
                                if(clienteVisao != null){
                                    alugueis = aluguelDAO.getAluguel(cpfaux);
                                    for(i = 0; i < alugueis.size(); i++){
                                        System.out.println("####################################");
                                        System.out.println("CPF: "+ alugueis.get(i).getFk_cpf());
                                        System.out.println("ID: "+ alugueis.get(i).getId());
                                        System.out.println("DATA: "+ alugueis.get(i).getData());
                                        System.out.println("HORA: "+ alugueis.get(i).getHora());
                                        System.out.println("VALOR TOTAL: "+ alugueis.get(i).getValorTotal());
                                        System.out.println("####################################\n");
                                    }
                                } else {
                                    System.out.println("CLIENTE NÃO CADASTRADO!");
                                }

                                break;
                            case 3:
                                alugueis = aluguelDAO.getRelatorio();
                                for(i = 0; i < alugueis.size(); i++){
                                    System.out.println("####################################\n");
                                    System.out.println("CPF: "+ alugueis.get(i).getId());
                                    System.out.println("NOME: "+ alugueis.get(i).getData());
                                    System.out.println("LOGIN: "+ alugueis.get(i).getHora());
                                    System.out.println("SENHA: "+ alugueis.get(i).getValorTotal());
                                    System.out.println("ATIVO: "+ alugueis.get(i).getFk_cpf());
                                    System.out.println("####################################\n");
                                }
                                break;
                            default: break;
                        }
                    }while(op2 != 3);

                    break;
                case 3:
                    System.out.println("PROGRAMA ENCERRADO...");
                    break;
                default:
                    System.out.println("OPÇÃO INVÁLIDA");
            }
        } while (op != 3);

    }
}
/*
1º contato
2 endereço
3 campo
4 aluguel
5 cliente
* */