package model;

import java.io.IOException;

public class TestRepositorios {
    public static void main(String[] args){
        // Pessoa Fisica
        try{
            PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
            repo1.inserir(new PessoaFisica("Godalfredo Silva", 1, "123.456.789-10", 25));
            repo1.inserir(new PessoaFisica("Josenilda Santos", 2, "123.456.789-11", 17));
            
            String arquivoPessoasFisicas = "pessoas_fisicas.bin";
            repo1.persistir(arquivoPessoasFisicas);
            System.out.println("Dados de Pessoa Fisica Armazenados.");
            
            PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
            repo2.recuperar(arquivoPessoasFisicas);
            
            System.out.println("Pessoas Fisicas Recuperadas: ");
            for(PessoaFisica pessoa : repo2.obterTodos()){
                pessoa.exibir();
            }
        }catch (IOException | ClassNotFoundException e){
            System.out.println("Erro na manipulacao do repositorio." + e.getMessage());
        }
        
        //Pessoa Juridica
        try{
            PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
            repo3.inserir(new PessoaJuridica("Godalfredo Silva", 1, "12.345.678/000-90"));
            repo3.inserir(new PessoaJuridica("Josenilda Santos", 2, "12.345.678/000-91"));
            
            String arquivoPessoaJuridica = "pessoa_juridica.bin";
            repo3.persistir(arquivoPessoaJuridica);
            System.out.println("Dados de Pessoa Juridicas Armazenados.");
            
            PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
            repo4.recuperar(arquivoPessoaJuridica);
            
            System.out.println("Pessoas Juridicas Recuperadas: ");
            for(PessoaJuridica pessoa : repo4.obterTodos()){
                pessoa.exibir();
            }
        }catch (IOException | ClassNotFoundException e){
            System.out.println("Erro na manipulacao do repositorio." + e.getMessage());
        }
    }
}
