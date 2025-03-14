package model;

import java.io.Serializable;

public class Pessoa implements Serializable {
    
    protected String nome;
    protected int id;
    
    public Pessoa(String nome, int id){
        this.nome = nome;
        this.id = id;
    }
    
    public void exibir(){
        System.out.println("Nome: " + this.nome);
        System.out.println("ID: " + this.id);
    }  
    
    protected String getNome(){
        return nome;
    }
    
    protected int getId(){
        return id;
    }
    
    protected void setNome(String nome){
        this.nome = nome;
    }
    
    protected void setId(int id){
        this.id = id;
    } 
}
