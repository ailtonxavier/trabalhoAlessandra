package Visao;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import Dominio.*;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int op, op2, i;
        int idaux, auxQtdHoras, auxValorTotal;
        String cpfaux, auxDataLocal, auxHoraLocal, auxData, auxHoraReserva;

        ArrayList<Cliente> clientes;
        ArrayList<Aluguel> alugueis;
        Contato contatoVisao;
        Cliente clienteVisao;
        Endereco enderecoVisao;
        Aluguel aluguelVisao;


        clienteVisao = new Cliente();
        contatoVisao = new Contato();
        enderecoVisao = new Endereco();
        aluguelVisao = new Aluguel();

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
                                if(clienteVisao.queryCliente(cpfaux) == null){
                                    clienteVisao.setPk_cpf(cpfaux);

                                    System.out.println("DIGITE O NOME: ");
                                    clienteVisao.setNome(teclado.nextLine());
                                    System.out.println("DIGITE O LOGIN: ");
                                    clienteVisao.setLogin(teclado.nextLine());
                                    System.out.println("DIGITE A SENHA: ");
                                    clienteVisao.setSenha(teclado.nextLine());
                                    clienteVisao.setAtivo(true);
                                    clienteVisao.insertCliente(clienteVisao);
                                    // contato
                                    contatoVisao.setPk_fk_cpf(cpfaux);
                                    System.out.println("DIGITE SEU EMAIL: ");
                                    contatoVisao.setEmail(teclado.nextLine());
                                    System.out.println("DIGITE SEU CELULAR: ");
                                    contatoVisao.setCelular(teclado.nextLine());
                                    System.out.println("DIGITE SEU TELEFONE FIXO: ");
                                    contatoVisao.setTelFixo(teclado.nextLine());
                                    System.out.println("DIGITE SEU TELEFONE COMERCIAL: ");
                                    contatoVisao.setTelComercial(teclado.nextLine());
                                    System.out.println("DIGITE SUA CIDADE: ");
                                    // endereço
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

                                    clienteVisao.insertContato(contatoVisao);
                                    clienteVisao.insertEndereco(enderecoVisao);
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
                                if(clienteVisao.queryCliente(cpfaux) != null){
                                    contatoVisao = clienteVisao.queryContato(cpfaux);
                                    enderecoVisao = clienteVisao.queryEndereco(cpfaux);
                                    System.out.println("######################################\n" +
                                                       "########## DADOS DO CLIENTE ##########\n" +
                                                       "######################################");
                                    System.out.println("NOME: " + clienteVisao.queryCliente(cpfaux).getNome());
                                    System.out.println("CPF: " + clienteVisao.queryCliente(cpfaux).getPk_cpf());
                                    System.out.println("LOGIN: " + clienteVisao.queryCliente(cpfaux).getLogin());
                                    System.out.println("SENHA: " + clienteVisao.queryCliente(cpfaux).getSenha());
                                    System.out.println("ATIVO: " + clienteVisao.queryCliente(cpfaux).getAtivo());
                                    System.out.println("########## CONTATO #########");
                                    System.out.println("CELULAR: "+contatoVisao.getCelular());
                                    System.out.println("EMAIL: "+contatoVisao.getEmail());
                                    System.out.println("TELEFONE COMERCIAL: "+contatoVisao.getTelComercial());
                                    System.out.println("TELEFONE FIXO: "+contatoVisao.getTelFixo());
                                    System.out.println("########## ENDEREÇO ##########");
                                    System.out.println("ESTADO: "+enderecoVisao.getEstado());
                                    System.out.println("CIDADE: "+enderecoVisao.getCidade());
                                    System.out.println("BAIRRO: "+enderecoVisao.getBairro());
                                    System.out.println("RUA: "+enderecoVisao.getRua());
                                    System.out.println("NÚMERO: "+enderecoVisao.getNumero());
                                } else {
                                    System.out.println("CLIENTE NÃO CADASTRADO!");
                                }
                                break;
                            case 3:
                                /*########################################
                                ########## RELATÓRIO DE CLIENTES #########
                                #########################################*/
                                clientes = clienteVisao.queryClientes();
                                for(i = 0; i < clientes.size(); i++){
                                    System.out.println("NOME: "+ clientes.get(i).getNome());
                                    System.out.println("CPF: "+ clientes.get(i).getPk_cpf());
                                    System.out.println("LOGIN: "+ clientes.get(i).getLogin());
                                    System.out.println("SENHA: "+ clientes.get(i).getSenha());
                                    System.out.println("ATIVO: "+ clientes.get(i).getAtivo());
                                    System.out.println("####################################");
                                }
                                break;
                            case 4:
                                /*#######################################
                                ############ ALTERAR CLIENTES ###########
                                #######################################*/
                                System.out.println("ALTERANDO CONTATO");
                                System.out.println("DIGITE O CPF DO CLIENTE: ");
                                cpfaux = teclado.nextLine();
                                if(clienteVisao.queryCliente(cpfaux) != null){
                                    clienteVisao = new Cliente();
                                    clienteVisao.setPk_cpf(cpfaux);
                                    System.out.println("DIGITE O NOVO NOME: ");
                                    clienteVisao.setNome(teclado.nextLine());
                                    System.out.println("DIGITE O NOVO LOGIN: ");
                                    clienteVisao.setLogin(teclado.nextLine());
                                    System.out.println("DIGITE A NOVA SENHA: ");
                                    clienteVisao.setSenha(teclado.nextLine());
                                    clienteVisao.updateCliente(clienteVisao);
                                    System.out.println("DESEJA ALTERAR SEU CONTATO:\n");
                                    System.out.println("1-SIM \t 2-NÃO");
                                    if(teclado.nextInt() == 1){
                                        teclado.nextLine();
                                        contatoVisao = new Contato();
                                        contatoVisao.setPk_fk_cpf(cpfaux);
                                        System.out.println("DIGITE O NOVO EMAIL: ");
                                        contatoVisao.setEmail(teclado.nextLine());
                                        System.out.println("DIGITE SEU NOVO NÚMERO: ");
                                        contatoVisao.setCelular(teclado.nextLine());
                                        System.out.println("DIGITE SEU NOVO TELEFONE FIXO: ");
                                        contatoVisao.setTelFixo(teclado.nextLine());
                                        System.out.println("DIGITE SEU NOVO TELEFONE COMERCIAL: ");
                                        contatoVisao.setTelComercial(teclado.nextLine());
                                        clienteVisao.updateContato(contatoVisao);
                                    } else {
                                        clienteVisao.updateContato(clienteVisao.getContato());
                                    }
                                    System.out.println("DESEJA ALTERAR O ENDEREÇO: \n");
                                    System.out.println("1- SIM \t 2- NÃO");
                                    if(teclado.nextInt() == 1){
                                        teclado.nextLine();
                                        enderecoVisao = new Endereco();
                                        enderecoVisao.setPk_fk_cpf(cpfaux);
                                        System.out.println("DIGITE SEU ESTADO: ");
                                        enderecoVisao.setEstado(teclado.nextLine());
                                        System.out.println("DIGITE SUA CIDADE: ");
                                        enderecoVisao.setCidade(teclado.nextLine());
                                        System.out.println("DIGITE SEU BAIRRO: ");
                                        enderecoVisao.setBairro(teclado.nextLine());
                                        System.out.println("DIGITE O NOME DA SUA RUA: ");
                                        enderecoVisao.setRua(teclado.nextLine());
                                        System.out.println("DIGITE O NÚMERO DA SUA CASA: ");
                                        enderecoVisao.setNumero(teclado.nextLine());
                                        clienteVisao.updateEndereco(enderecoVisao);
                                    } else {
                                        clienteVisao.updateEndereco(clienteVisao.getEndereco());
                                    }
                                    clienteVisao.setAtivo(true);
                                    clienteVisao.updateCliente(clienteVisao);
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
                                if(clienteVisao.queryCliente(cpfaux) != null){
                                    clienteVisao.deleteAluguel(cpfaux);
                                    clienteVisao.deleteContato(cpfaux);
                                    clienteVisao.deleteEndereco(cpfaux);
                                    clienteVisao.deleteCliente(cpfaux);
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
                        System.out.println("4 - #### EXCLUIR ALUGUEL POR ID ####");
                        System.out.println("5 - ### EXCLUIR VÁRIOS ALUGUEIS ####");
                        System.out.println("6 - ### VOLTAR AO MENU PRINCIPAL ###");
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
                                    if (clienteVisao.queryCliente(cpfaux) != null) {
                                        auxDataLocal = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                                        auxHoraLocal = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
                                        System.out.print("DIGITE A DATA DA RESERVA\nDD/MM/AAAA: ");
                                        auxData = teclado.nextLine();
                                        System.out.print("DIGITE A HORA DA RESERVA: ");
                                        auxHoraReserva = teclado.nextLine();
                                        System.out.print("DIGITE A QUANTIDADE DE HORAS DA RESERVA: ");
                                        auxQtdHoras = teclado.nextInt();
                                        aluguelVisao = new Aluguel();
                                        aluguelVisao.setFk_cpf(cpfaux);
                                        aluguelVisao.setData(auxData);
                                        aluguelVisao.setHora(auxHoraReserva);
                                        aluguelVisao.setQtdHoras(auxQtdHoras);
                                        aluguelVisao.setDataDaReserva(auxDataLocal);
                                        auxValorTotal = aluguelVisao.getQtdHoras() * 50;
                                        aluguelVisao.setValorTotal(auxValorTotal);
                                        aluguelVisao.setHoraDaReserva(auxHoraLocal);
                                        aluguelVisao.insertAluguel(aluguelVisao);
                                        System.out.println("ALUGUEL REALIZADO COM SUCESSO!");
                                    } else {
                                        System.out.println("CADASTRE UM CLIENTE PARA ALUGAR UM CAMPO");
                                    }


                                break;
                            case 2:
                                /*#######################################
                                ####### BUSCAR ALUGUEL POR CPF ##########
                                #######################################*/
                                System.out.println("Digite o CPF do cliente desejado: ");
                                cpfaux = teclado.nextLine();
                                if(clienteVisao.queryCliente(cpfaux) == null)
                                    System.out.println("CLIENTE NÃO CADASTRADO!");
                                else {
                                    System.out.println("CLIENTE LOCALIZADO!");
                                    clienteVisao = clienteVisao.queryCliente(cpfaux);
                                    alugueis = aluguelVisao.queryAlugueis();
                                    for(i = 0; i < alugueis.size(); i++){
                                        System.out.println("ID: " + alugueis.get(i).getId());
                                        System.out.println("DATA: " + alugueis.get(i).getData());
                                        System.out.println("DATA DA RESERVA: " + alugueis.get(i).getHoraDaReserva());
                                        System.out.println("HORA: " + alugueis.get(i).getHora());
                                        System.out.println("QUANTIDADE DE HORAS ALUGADAS: "+alugueis.get(i).getQtdHoras());
                                        System.out.println("VALOR TOTAL: " + alugueis.get(i).getValorTotal());
                                        System.out.println("####################################");
                                    }
                                    System.out.println("RELATÓRIO DE ALUGUEIS DE "+ clienteVisao.getNome().toUpperCase());
                                    System.out.println("CPF DO CLIENTE: "+ clienteVisao.getPk_cpf());
                                }
                                break;
                            case 3:
                                /*#####################################
                                ####### RELATÓRIO DE ALUGUEIS #########
                                #####################################*/
                                alugueis = aluguelVisao.queryAlugueis();
                                for(i = 0; i < alugueis.size(); i++){
                                    clienteVisao.queryAlugueis();
                                    System.out.println("NOME: "+ clienteVisao.queryCliente(alugueis.get(i).getFk_cpf()).getNome().toUpperCase());
                                    System.out.println("ID: "+ alugueis.get(i).getId());
                                    System.out.println("CPF: "+ alugueis.get(i).getFk_cpf());
                                    System.out.println("DATA: "+ alugueis.get(i).getData());
                                    System.out.println("DATA DA RESERVA: "+ alugueis.get(i).getDataDaReserva());
                                    System.out.println("HORA: "+ alugueis.get(i).getHora());
                                    System.out.println("HORA DA RESERVA: "+ alugueis.get(i).getHoraDaReserva());
                                    System.out.println("QUANTIDADE DE HORAS RESERVADAS: "+alugueis.get(i).getQtdHoras());
                                    System.out.println("VALOR TOTAL: "+ alugueis.get(i).getValorTotal());
                                    System.out.println("####################################");
                                }
                                break;
                            case 4:
                                /*#######################################
                                ######## DELETAR ALUGUEL POR ID #########
                                #######################################*/
                                System.out.println("DIGITE O ID DO ALUGUEL\nQUE DESEJA EXCLUIR: ");
                                idaux = teclado.nextInt();
                                aluguelVisao.deleteAluguel(idaux);
                                System.out.println("ALUGUEL EXCLUIDO COM SUCESSO!");
                                break;
                            case 5:
                                /*#######################################
                                ###### DELETAR ALUGUEIS POR CPF #########
                                #######################################*/
                                System.out.println("DIGITE O CPF DE QUEM DESEJA EXCLUIR: ");
                                cpfaux = teclado.nextLine();
                                aluguelVisao.deleteAluguel(cpfaux);
                                System.out.println("ALUGUEL EXCLUIDO COM SUCESSO!");
                                break;
                            default:
                                System.out.println("VOCÊ DIGITOU UM VALOR ERRADO"); break;
                        }
                        System.out.println("");
                    }while(op2 != 6);
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