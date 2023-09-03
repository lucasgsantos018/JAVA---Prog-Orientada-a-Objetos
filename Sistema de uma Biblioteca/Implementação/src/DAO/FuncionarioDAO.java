package DAO;
import Dados.Dados;
import java.util.List;
import Modelo.Funcionario;
import Modelo.Pessoa;
import java.util.Scanner;

/**
 *
 * @author lucas
 */
public class FuncionarioDAO extends Pessoa implements DAO<Funcionario>{
    private final Scanner scanner;
    
    public FuncionarioDAO(){
        scanner = new Scanner(System.in);
    }
    
    @Override
    public void incluir(Funcionario funcionario){
        int novoId = Dados.listaDeFuncionarios.size() + 1;
        funcionario.set_id(novoId);
        Dados.listaDeFuncionarios.add(funcionario);
        System.out.println(novoId);
    }
    
    @Override
    public Funcionario localizar(int id){
        System.out.println(Dados.listaDeFuncionarios.size());
        for(Funcionario funcionario : Dados.listaDeFuncionarios){
            if (funcionario.get_id() == id){
                return funcionario;
            }
        }
        return null;
    }
    
    @Override
    public void atualizar(Funcionario funcionario){
        System.out.println("Qual item deseja atualizar?");
        System.out.println("1. Nome");
        System.out.println("2. Sobrenome");
        System.out.println("3. Matrícula");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        
        switch (opcao) {
            case 1 : {
                System.out.println("Digite o novo nome:");
                String novoNome = scanner.nextLine();
                funcionario.set_nome(novoNome);
                System.out.println("Nome atualizado com sucesso!");
            }
            case 2 : {
                System.out.println("Digite o novo sobrenome:");
                String novoSobrenome = scanner.nextLine();
                funcionario.set_sobrenome(novoSobrenome);
                System.out.println("Sobrenome atualizado com sucesso!");
            }
            case 3 : {
                System.out.println("Digite a nova matrícula:");
                int novaMatricula = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer
                funcionario.set_matricula(novaMatricula);
                System.out.println("Matrícula atualizada com sucesso!");
            }
            default : System.out.println("Opção inválida!");
        }
    }
    
    @Override
    public void remover(Funcionario funcionario){
        Dados.listaDeFuncionarios.remove(funcionario);
    }
    
    @Override
    public List<Funcionario> getLista(){
        return Dados.listaDeFuncionarios;
    }
}
