package Modelo;
import java.util.List;

public class Funcionario extends Pessoa{ //classe Funcionario com heranca de Pessoa
    private int matricula;
    
    public Funcionario(){}
    public Funcionario(int id, String nome, String sobrenome, int matricula){
        super(id, nome, sobrenome);
        this.matricula = matricula;
    }
    
    public int get_matricula(){
        return matricula;
    }
    public void set_matricula(int matricula){
        this.matricula = matricula;
    }
    
    
    @Override
    public String toString(){
        return super.toString() + "Funcionario{" + "matrícula: " + matricula + '}';
    }
}
