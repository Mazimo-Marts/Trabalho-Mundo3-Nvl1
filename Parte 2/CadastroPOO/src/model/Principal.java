package model;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
        
    public static void main(String[] args){
            
        int opcao;
        Scanner input = new Scanner(System.in);
        PessoaFisicaRepo fisicaRepo = new PessoaFisicaRepo();
        PessoaJuridicaRepo juridicaRepo = new PessoaJuridicaRepo();
        
        do{
            System.out.println("=========Menu=========");
            System.out.println("1 - Incluir Pessoa");
            System.out.println("2 - Alterar Pessoa");
            System.out.println("3 - Excluir Pessoa");
            System.out.println("4 - Buscar pelo Id");
            System.out.println("5 - Exibir Todos");
            System.out.println("6 - Persistir Dados");
            System.out.println("7 - Recuperar Dados");
            System.out.println("0 - Finalizar Programa");
            System.out.println("======================");
            opcao = input.nextInt();
            

            try{
                switch(opcao){
                    case 1 -> incluir(input, fisicaRepo, juridicaRepo);
                    case 2 -> alterar(input, fisicaRepo, juridicaRepo);
                    case 3 -> excluir(input, fisicaRepo, juridicaRepo);
                    case 4 -> obter(input, fisicaRepo, juridicaRepo);
                    case 5 -> obterTodos(input, fisicaRepo, juridicaRepo);
                    case 6 -> salvar(input, fisicaRepo, juridicaRepo);
                    case 7 -> recuperar(input, fisicaRepo, juridicaRepo);
                    case 0 -> System.out.println("Programa Finalizado.");
                    default -> System.out.println("Opção inválida, tente novamente.");
                }
            }catch(IOException | ClassNotFoundException e){
                System.out.println("Erro: " + e.getMessage());
            }
        }while(opcao != 0);
        input.close();
    }

    private static void incluir(Scanner input, PessoaFisicaRepo fisicaRepo, PessoaJuridicaRepo juridicaRepo) {
        
        System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
        String tipo = input.next();
        
        switch (tipo) {
            case "F":
                {
                    System.out.println("Nome: ");
                    String nome = input.next();
                    input.nextLine();
                    System.out.println("Id: ");
                    int id = input.nextInt();
                    System.out.println("CPF: ");
                    String CPF = input.next();
                    System.out.println("Idade: ");
                    int idade = input.nextInt();
                    fisicaRepo.inserir(new PessoaFisica(nome, id, CPF, idade));
                    break;
                }
            case "J":
                {
                    System.out.println("Nome: ");
                    String nome = input.next();
                    System.out.println("Id: ");
                    int id = input.nextInt();
                    System.out.println("CNPJ: ");
                    String CNPJ = input.next();
                    juridicaRepo.inserir(new PessoaJuridica(nome, id, CNPJ));
                    break;
                }
            default:
                System.out.println("Tipo inválido.");
                break;
        }
    }

    private static void alterar(Scanner input, PessoaFisicaRepo fisicaRepo, PessoaJuridicaRepo juridicaRepo) {
        
        System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
        String tipo = input.next();
        System.out.println("Id: ");
        int id = input.nextInt();
        
        switch (tipo) {
            case "F":
                {
                    PessoaFisica pessoa = fisicaRepo.obter(id);
                    if(pessoa != null){
                        System.out.println("Dados atuais:");
                        pessoa.exibir();
                        System.out.println("Novo nome: ");
                        String nome = input.next();
                        System.out.println("Novo CPF: ");
                        String CPF = input.next();
                        System.out.println("Nova idade: ");
                        int idade = input.nextInt();
                        pessoa.setNome(nome);
                        pessoa.setCPF(CPF);
                        pessoa.setIdade(idade);
                        fisicaRepo.alterar(pessoa);
                        System.out.println("Pessoa Fisica alterada com sucesso.");
                        break;
                    }else{
                        System.out.println("Pessoa Fisica não existente.");
                        break;
                    }       
                }
            case "J":
                {
                    PessoaJuridica pessoa = juridicaRepo.obter(id);
                    if(pessoa != null){
                        System.out.println("Dados atuais: ");
                        pessoa.exibir();
                        System.out.println("Novo nome: ");
                        String nome = input.next();
                        System.out.println("Novo CNPJ: ");
                        String CNPJ = input.next();
                        pessoa.setNome(nome);
                        pessoa.setCNPJ(CNPJ);
                        juridicaRepo.alterar(pessoa);
                        System.out.println("Pessoa Juridica alterada com sucesso.");
                        break;
                    }else{
                        System.out.println("Pessoa Juridica não existe.");
                        break;
                    }       
                }
            default:
                System.out.println("Tipo inválido.");
                break;
        }
    }

    private static void excluir(Scanner input, PessoaFisicaRepo fisicaRepo, PessoaJuridicaRepo juridicaRepo) {
        
        System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
        String tipo = input.next();
        System.out.println("Id: ");
        int id = input.nextInt();
        
        switch (tipo) {
            case "F":
                {
                    PessoaFisica pessoa = fisicaRepo.obter(id);
                    if(pessoa != null){
                        fisicaRepo.excluir(id);
                        System.out.println("Pessoa Fisica excluída.");
                        break;
                    }else{
                        System.out.println("Pessoa Fisica não existe.");
                    }       break;
                }
            case "J":
                {
                    PessoaJuridica pessoa = juridicaRepo.obter(id);
                    if(pessoa != null){
                        juridicaRepo.excluir(id);
                        System.out.println("Pessoa Juridica excluída.");
                        break;
                    }else{
                        System.out.println("Pessoa Juridica não existe.");
                    }       break;
                }
            default:
                System.out.println("Tipo inválido.");
                break;
        }
    }

    private static void obter(Scanner input, PessoaFisicaRepo fisicaRepo, PessoaJuridicaRepo juridicaRepo) {
        
        System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
        String tipo = input.next();
        System.out.println("Id: ");
        int id = input.nextInt();
        
        switch (tipo) {
            case "F":
            {
                PessoaFisica pessoa = fisicaRepo.obter(id);
                if(pessoa != null){
                    pessoa.exibir();
                    break;
                }else{
                    System.out.println("Pessoa Fisica não existe.");
                    break;
                }
            }
            case "J":
            {
                PessoaJuridica pessoa = juridicaRepo.obter(id);
                if(pessoa != null){
                    pessoa.exibir();
                    break;
                }else{
                    System.out.println("Pessoa Juridica não existe.");
                    break;
                }
            }
            default:
                System.out.println("Tipo inválido.");
                break;
        }
    }

    private static void obterTodos(Scanner input, PessoaFisicaRepo fisicaRepo, PessoaJuridicaRepo juridicaRepo) {
       
        System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
        String tipo = input.next();
        
        switch (tipo) {
            case "F":
            {
                for(PessoaFisica pessoa : fisicaRepo.obterTodos()){
                    pessoa.exibir();
                    System.out.println("==============================");
                }
                break;
            }
            case "J":
            {
                for(PessoaJuridica pessoa : juridicaRepo.obterTodos()){
                    pessoa.exibir();
                    System.out.println("==============================");
                }
                break;
            }
            default:
                System.out.println("Tipo inválido.");
                break;
        }
    }

    private static void salvar(Scanner input, PessoaFisicaRepo fisicaRepo, PessoaJuridicaRepo juridicaRepo) throws IOException {
        System.out.println("Digite o prefixo do arquivo: ");
        String prefixo = input.next();
         
        fisicaRepo.persistir(prefixo + ".fisica.bin");
        juridicaRepo.persistir(prefixo + ".juridica.bin");
         
        System.out.println("Arquivo salvo com sucesso.");
    }

    private static void recuperar(Scanner input, PessoaFisicaRepo fisicaRepo, PessoaJuridicaRepo juridicaRepo) throws IOException, ClassNotFoundException {
        System.out.println("Digite o prefixo do arquivo: ");
        String prefixo = input.next();
         
        fisicaRepo.recuperar(prefixo + ".fisica.bin");
        juridicaRepo.recuperar(prefixo + ".juridica.bin");
         
        System.out.println("Arquivo recuperado com sucesso.");
    }
}
