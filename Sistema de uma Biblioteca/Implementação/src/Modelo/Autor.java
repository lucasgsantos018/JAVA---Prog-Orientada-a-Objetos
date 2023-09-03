package Modelo;
import java.util.List;

public class Autor extends Pessoa{ //classe Autor com heranca de Pessoa
    private String biografia;
    
    public Autor(){}
    public Autor(int id, String nome, String sobrenome, String biografia){
        super(id, nome, sobrenome);
        this.biografia = biografia;
    }
    
    public String get_biografia(){
        return biografia;
    }
    public void set_biografia(String biografia){
        this.biografia = biografia;
    }

    @Override
    public String toString() {
        return super.toString() + "Autor{biografia: "+biografia + '}';
    }
    
}
