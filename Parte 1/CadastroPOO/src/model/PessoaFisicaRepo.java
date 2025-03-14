package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PessoaFisicaRepo {
    
    private ArrayList<PessoaFisica> List = new ArrayList<>();
    
    public void inserir(PessoaFisica pessoaF){
        List.add(pessoaF);
    }
    
    public void alterar(PessoaFisica pessoaF){
        for(int i=0; i < List.size(); i++){
            if(List.get(i).getId() == pessoaF.getId()){
                List.set(i, pessoaF);
                break;
            }
        }
    }
    
    public void excluir(int id){
        List.removeIf(pessoaF -> pessoaF.getId() == id);
    }
    
    public PessoaFisica obter(int id){
        for(PessoaFisica pessoaF : List){
            if(pessoaF.getId() == id){
                return pessoaF;
            }
        }
        return null;
    }
    
    public ArrayList<PessoaFisica> obterTodos(){
        return List;
    }
    
    public void persistir(String nomeArquivo) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomeArquivo))){
            outputStream.writeObject(List);
        }
    }
    
    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomeArquivo))){
            List = (ArrayList<PessoaFisica>) inputStream.readObject();
        }
    }
}
