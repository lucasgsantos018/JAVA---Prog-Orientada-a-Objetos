package Modelo;

public class Pessoa {  //criando classe Pessoa
    private int id;
    private String nome;
    private String sobrenome;
    
    //construtores
    public Pessoa(){};
    public Pessoa(int id, String nome, String sobrenome){
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
    }
    
    public int get_id(){return id;}
    public String get_nome(){return nome;}
    public String get_sobrenome(){return sobrenome;}
    
    public void set_id(int id) {
        this.id = id;
    }
    public void set_nome(String nome) {
        this.nome = nome;
    }
    public void set_sobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    
    @Override
    public String toString(){
        return "Nome do funcionario:" + nome +" " + sobrenome;
    }

}
