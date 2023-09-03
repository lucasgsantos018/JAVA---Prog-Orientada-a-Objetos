package DAO;

import Dados.Dados;
import java.util.List;
import Modelo.Autor;
import java.util.Scanner;

/**
 * Classe DAO para manipulação dos objetos da classe Autor.
 */
public class AutorDAO implements DAO<Autor> {

    private final Scanner scanner;

    public AutorDAO(){
        scanner = new Scanner(System.in);
    }

    @Override
    public void incluir(Autor autor){
        int novoId = Dados.listaDeAutores.size() + 1;
        autor.set_id(novoId);
        Dados.listaDeAutores.add(autor);
    }

    @Override
    public Autor localizar(int id){
        for(Autor autor : Dados.listaDeAutores){
            if (autor.get_id() == id){
                return autor;
            }
        }
        return null;
    }

    @Override
    public void atualizar(Autor autor) {
        System.out.println("Qual item deseja atualizar em " + autor.get_nome() + "?");
        System.out.println("1. Nome");
        System.out.println("2. Sobrenome");
        System.out.println("3. Biografia");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        switch (opcao) {
            case 1 : {
                System.out.println("Digite o novo nome:");
                String novoNome = scanner.nextLine();
                autor.set_nome(novoNome);
                System.out.println("Nome atualizado com sucesso!");
            }
            case 2 : {
                System.out.println("Digite o novo sobrenome:");
                String novoSobrenome = scanner.nextLine();
                autor.set_sobrenome(novoSobrenome);
                System.out.println("Sobrenome atualizado com sucesso!");
            }
            case 3 : {
                System.out.println("Digite a nova biografia:");
                String novaBiografia = scanner.nextLine();
                autor.set_biografia(novaBiografia);
                System.out.println("Biografia atualizada com sucesso!");
            }
            default : System.out.println("Opção inválida!");
        }
    }

    @Override
    public void remover(Autor autor){
        Dados.listaDeAutores.remove(autor);
    }

    @Override
    public List<Autor> getLista(){
        return Dados.listaDeAutores;
    }

}
