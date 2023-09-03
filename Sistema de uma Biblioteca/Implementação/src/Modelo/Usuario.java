package Modelo;
import java.util.List;

public class Usuario extends Pessoa{ //classe Usuario com heranca de Pessoa
    private int reg_academico;
    
    public Usuario(){}
    public Usuario(int id, String nome, String sobrenome, int reg_academico){
        super(id, nome, sobrenome);
        this.reg_academico = reg_academico;
    }
    
    public int getRegAcademico(){
        return reg_academico;
    }
    public void setRegAcademico(int reg_academico){
        this.reg_academico = reg_academico;
    }

    @Override
    public String toString() {
        return super.toString() + "Usuario{" + "reg_academico=" + reg_academico + '}';
    }
}

