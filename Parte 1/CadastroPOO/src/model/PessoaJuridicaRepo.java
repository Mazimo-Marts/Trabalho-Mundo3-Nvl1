package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PessoaJuridicaRepo {
    
    private ArrayList<PessoaJuridica> List = new ArrayList<>();
    
    public void inserir(PessoaJuridica pessoaJ){
        List.add(pessoaJ);
    }
    
    public void alterar(PessoaJuridica pessoaJ){
        for(int i=0; i < List.size(); i++){
            if(List.get(i).getId() == pessoaJ.getId()){
                List.set(i, pessoaJ);
                break;
            }
        }
    }
    
    public void excluir(int id){
        List.removeIf(pessoaJ -> pessoaJ.getId() == id);
    }
    
    public PessoaJuridica obter(int id){
        for(PessoaJuridica pessoaJ : List){
            if(pessoaJ.getId() == id){
                return pessoaJ;
            }
        }
        return null;
    }
    
    public ArrayList<PessoaJuridica> obterTodos(){
        return List;
    }
    
    public void persistir(String nomeArquivo) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomeArquivo))){
            outputStream.writeObject(List);
        }
    }
    
    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomeArquivo))){
            List = (ArrayList<PessoaJuridica>) inputStream.readObject();
        }
    }
}
