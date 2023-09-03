package DAO;
import Dados.Dados;
import java.util.List;
import Modelo.Categoria;
import java.util.Scanner;

/**
 *
 * @author lucas
 */
public class CategoriaDAO implements DAO<Categoria> {
    
    private final Scanner scanner;
    
    public CategoriaDAO(){
        scanner = new Scanner(System.in);
    }
    
    @Override
    public void incluir(Categoria categoria){
        int novoId = Dados.listaDeCategorias.size() + 1;
        categoria.setId(novoId);
        Dados.listaDeCategorias.add(categoria);
    }
    
    @Override
    public Categoria localizar(int id){
        for(Categoria categoria : Dados.listaDeCategorias){
            if (categoria.getId() == id){
                return categoria;
            }
        }
        return null;
    }
    
    @Override
    public void atualizar(Categoria categoria) {
        System.out.println("Qual item deseja atualizar?");
        System.out.println("1. Título");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        switch (opcao) {
            case 1 : {
                System.out.println("Digite o novo título:");
                String novoTitulo = scanner.nextLine();
                categoria.setTitulo(novoTitulo);
                System.out.println("Título atualizado com sucesso!");
            }
            default : System.out.println("Opção inválida!");
        }
    }
    
    @Override
    public void remover(Categoria categoria){
        Dados.listaDeCategorias.remove(categoria);
    }
    
    @Override
    public List<Categoria> getLista(){
        return Dados.listaDeCategorias;
    }
    
}
