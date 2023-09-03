package DAO;

import Dados.Dados;
import java.util.List;
import Modelo.Usuario;
import java.util.Scanner;

/**
 * Classe DAO para manipulação dos objetos da classe Usuario.
 */
public class UsuarioDAO implements DAO<Usuario> {

    private final Scanner scanner;

    public UsuarioDAO(){
        scanner = new Scanner(System.in);
    }

    @Override
    public void incluir(Usuario usuario){
        int novoId = Dados.listaDeUsuarios.size() + 1;
        usuario.set_id(novoId);
        Dados.listaDeUsuarios.add(usuario);
        System.out.println(novoId);
    }

    @Override
    public Usuario localizar(int id){
        System.out.println(Dados.listaDeUsuarios.size());
        for(Usuario usuario : Dados.listaDeUsuarios){
            if (usuario.get_id() == id){
                return usuario;
            }
        }
        return null;
    }

    @Override
    public void atualizar(Usuario usuario) {
        System.out.println("Qual item deseja atualizar em " + usuario.get_nome() + "?");
        System.out.println("1. Nome");
        System.out.println("2. Sobrenome");
        System.out.println("3. Registro Acadêmico");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        switch (opcao) {
            case 1 : {
                System.out.println("Digite o novo nome:");
                String novoNome = scanner.nextLine();
                usuario.set_nome(novoNome);
                System.out.println("Nome atualizado com sucesso!");
            }
            case 2 : {
                System.out.println("Digite o novo sobrenome:");
                String novoSobrenome = scanner.nextLine();
                usuario.set_sobrenome(novoSobrenome);
                System.out.println("Sobrenome atualizado com sucesso!");
            }
            case 3 : {
                System.out.println("Digite o novo registro acadêmico:");
                int novoRegAcademico = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer
                usuario.setRegAcademico(novoRegAcademico);
                System.out.println("Registro acadêmico atualizado com sucesso!");
            }
            default : System.out.println("Opção inválida!");
        }
    }

    @Override
    public void remover(Usuario usuario){
        Dados.listaDeUsuarios.remove(usuario);
    }

    @Override
    public List<Usuario> getLista(){
        return Dados.listaDeUsuarios;
    }
}