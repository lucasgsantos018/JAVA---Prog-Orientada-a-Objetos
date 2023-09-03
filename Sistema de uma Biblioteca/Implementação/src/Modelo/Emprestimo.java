package Modelo;

import java.util.List;
import java.util.Date;

public class Emprestimo {
    private int id;
    private Funcionario funcionario;    
    private Usuario usuario;
    private Livro livro;
    private Date dataEmprestimo;

    public Emprestimo(int id, Funcionario funcionario, Usuario usuario, Livro livro, Date dataEmprestimo) {
        this.id = id;
        this.funcionario = funcionario;
        this.usuario = usuario;
        this.livro = livro;
        this.dataEmprestimo = dataEmprestimo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    @Override
    public String toString() {
        return "Emprestimo{" + "id=" + id + ", funcionario=" + funcionario + ", usuario=" + usuario + ", livro=" + livro + ", dataEmprestimo=" + dataEmprestimo + '}';
    }
}
