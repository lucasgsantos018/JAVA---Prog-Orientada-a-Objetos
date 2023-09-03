package DAO;
import Dados.Dados;
import java.util.List;
import Modelo.Livro;

import java.util.Scanner;

/**
 *
 * @author lucas
 */
public class LivroDAO implements DAO<Livro> {
    
    private final Scanner scanner;
    
    public LivroDAO(){
        scanner = new Scanner(System.in);
    }
    
    @Override
    public void incluir(Livro livro){
        int novoId = Dados.listaDeLivros.size() + 1;
        livro.setId(novoId);
        Dados.listaDeLivros.add(livro);
        
    }
    
    @Override
    public Livro localizar (int id){
        for(Livro livro : Dados.listaDeLivros){
            if (livro.getId() == id){
                return livro;
            }
        }
        return null;
    }
    
 @Override
    public void atualizar(Livro livro) {
        System.out.println("Qual item deseja atualizar em " + livro.getTitulo() + "?");
        System.out.println("1. Título");
        System.out.println("2. Categorias");
        System.out.println("3. Autores");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        switch (opcao) {
            case 1 : {
                System.out.println("Digite o novo título:");
                String novoTitulo = scanner.nextLine();
                livro.setTitulo(novoTitulo);
                System.out.println("Título atualizado com sucesso!");
            }
            case 2 : {
                System.out.println("Digite o novo ID da categoria:");
                int novoIdCategoria = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer
                livro.getCategorias().add(novoIdCategoria);
                System.out.println("Categoria adicionada com sucesso!");
            }
            case 3 : {
                System.out.println("Digite o novo ID do autor:");
                int novoIdAutor = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer
                livro.getAutores().add(novoIdAutor);
                System.out.println("Autor adicionado com sucesso!");
            }
            default : System.out.println("Opção inválida!");
        }
    }
    
    @Override
    public void remover(Livro livro){
        Dados.listaDeLivros.remove(livro);
    }
    
    @Override
    public List<Livro> getLista(){
        return Dados.listaDeLivros;
    }
    
    
}
