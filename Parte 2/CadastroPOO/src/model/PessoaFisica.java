package model;
import java.io.Serializable;

public class PessoaFisica extends Pessoa implements Serializable {
    
    private String CPF;
    private int idade;
    
    public PessoaFisica(String nome, int id, String CPF, int idade){
        super(nome, id);
        this.CPF = CPF;
        this.idade = idade;
    }
    
    @Override
    public void exibir(){
        super.exibir();
        System.out.println("CPF: " + CPF);
        System.out.println("Idade: " + idade);
    }
    
    protected String getCPF(){
        return CPF;
    }
    
    protected int getIdade(){
        return idade;
    }
    
    public void setCPF(String CPF){
        this.CPF = CPF;
    }
    
    public void setIdade(int idade){
        this.idade = idade;
    }
}
