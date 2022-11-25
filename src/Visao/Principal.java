package Visao;
import Dominio.Cliente;
import java.util.ArrayList;
import Persistencia.ClienteDAO;
import Dominio.Contato;
import Dominio.Endereco;
import Persistencia.ContatoDAO;
import Persistencia.EnderecoDAO;
import Persistencia.CampoDAO;
import Dominio.Campo;
import Dominio.Aluguel;
import Persistencia.AluguelDAO;

import java.util.Scanner;
public class Principal {
    public static void main(String arg[]){
        int op, i, idaux;
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        ClienteDAO cliDAO = new ClienteDAO();
        EnderecoDAO endDAO = new EnderecoDAO();
        ContatoDAO contDAO = new ContatoDAO();
        CampoDAO camDAO = new CampoDAO();
        AluguelDAO aluDAO = new AluguelDAO();
        Scanner teclado = new Scanner(System.in);
        Cliente client;
        Contato cont;
        Endereco local;
        Campo campo;
        Aluguel aluguel;
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
                        cont = new Contato();
                        local = new Endereco();
                        client.setPk_cpf(idaux);
                        cont.setPk_fk_cpf(idaux);
                        local.setPk_fk_cpf(idaux);
                        System.out.println("DIGITE O NOME DO CLIENTE: ");
                        client.setNome(teclado.nextLine());
                        System.out.println("DIGITE O NUMERO DO CLIENTE: ");
                        cont.setCelular(teclado.nextLine());
                        System.out.println("DIGITE O EMAIL DO CLIENTE: ");
                        cont.setEmail(teclado.nextLine());
                        System.out.println("DIGITE O TELEFONE FIXO DO CLIENTE: ");
                        cont.setTelFixo(teclado.nextLine());
                        System.out.println("DIGITE O TELEFONE COMERCIAL DO CLIENTE: ");
                        cont.setTelComercial(teclado.nextLine());
                        System.out.println("DIGITE O ESTADO DO CLIENTE: ");
                        local.setEstado(teclado.nextLine());
                        System.out.println("DIGITE A CIDADE DO CLIENTE: ");
                        local.setCidade(teclado.nextLine());
                        System.out.println("DIGITE O NOME DO BAIRRO DO CLIENTE: ");
                        local.setBairro(teclado.nextLine());
                        System.out.println("DIGITE O NOME DA RUA DO CLIENTE: ");
                        local.setRua(teclado.nextLine());
                        System.out.println("DIGITE O NUMERO DA CASA DO CLIENTE: ");
                        local.setNumero(teclado.nextLine());
                        System.out.println("DIGITE O LOGIN DO CLIENTE: ");
                        client.setLogin(teclado.nextLine());
                        System.out.println("DIGITE A SENHA DO CLIENTE: ");
                        client.setSenha(teclado.nextLine());

                        cliDAO.incluir(client);
                    }
                    break;
                case 2:
                        System.out.println("BUSCANDO CLIENTE\n");
                        System.out.println("DIGITE O NUMERO DO CPF DO CONTATO QUE DESEJA BUSCAR: ");
                        idaux = teclado.nextInt();
                        client = cliDAO.buscar(idaux);
                        if(client == null){
                            System.out.println("CLIENTE NÃO ENCONTRADO\n");
                        }else{
                            cont = contDAO.buscar(idaux);
                            local = endDAO.buscar(idaux);
                            System.out.println("Cliente: "+client.getPk_cpf()+"\n");
                            System.out.println("Nome: "+client.getNome()+"\n");
                            System.out.println("Numero: "+cont.getCelular()+"\n");
                            System.out.println("Email: "+cont.getEmail()+"\n");
                            System.out.println("Telefone Fixo: "+cont.getTelFixo()+"\n");
                            System.out.println("Telefone Comercial: "+cont.getTelComercial()+"\n");
                            System.out.println("Numero: "+cont.getCelular()+"\n");
                            System.out.println("Endereço: "+local.getEstado()+" - "+local.getCidade()+"\n");
                            System.out.println("Bairro: "+local.getBairro()+" /Rua: "+local.getRua()+" /Numero: "+local.getNumero()+"\n");

                        }
                    break;
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
                case 4:
                    System.out.println("FAZENDO RESERVA\n");
                    System.out.println("DIGITE O CPF: ");
                    idaux = teclado.nextInt();
                    client = cliDAO.buscar(idaux);
                    campo = camDAO.buscar(idaux);
                    if(client==null){
                        System.out.println("O CPF DO CLIENTE É INVÁLIDO\n");
                    }else{
                        System.out.println("RESERVA PARA O CLIENTE "+client.getNome()+"\n");
                        System.out.println("SELECIONE A QUANTIDADE DE HORAS DA RESERVA: ");
                    }
                    break;
                case 5: break;
                case 6: break;
                case 7: break;
                case 8: break;
                default: break;
            }
        }while(op != 8);

    }
}
