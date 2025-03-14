package model;
import java.io.Serializable;

public class PessoaJuridica extends Pessoa implements Serializable {
    
    private String CNPJ;
    
    public PessoaJuridica(String nome, int id, String CNPJ){
        super(nome, id);
        this.CNPJ = CNPJ;
    }
    
    @Override 
    public void exibir(){
        super.exibir();
        System.out.println("CNPJ: " + CNPJ);
    }
    
    private String getCNPJ(){
        return CNPJ;
    }
    
    private void setCNPJ(String CNPJ){
        this.CNPJ = CNPJ;
    }
    
}
