package Modelo;
import java.util.List;

public class Categoria{
    private int id;
    private String titulo;
 
    
    public Categoria(){}
    public Categoria(int id, String titulo){
        this.id = id;
        this.titulo = titulo;
    }
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    
    public String getTitulo(){
        return titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Categoria{" + "id=" + id + ", titulo=" + titulo + '}';
    }
    
}
