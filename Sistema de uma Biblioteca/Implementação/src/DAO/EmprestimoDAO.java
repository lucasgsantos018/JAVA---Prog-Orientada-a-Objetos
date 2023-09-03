package DAO;
import Dados.Dados;
import java.util.List;
import Modelo.Emprestimo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

/**
 *
 * @author lucas
 */
public class EmprestimoDAO implements DAO<Emprestimo> {
    private final Scanner scanner;

    public EmprestimoDAO() {
        scanner = new Scanner(System.in);
    }
    
    @Override
    public void incluir(Emprestimo emprestimo) {
        int novoId = Dados.listaDeEmprestimos.size() + 1;
        emprestimo.setId(novoId);
        Dados.listaDeEmprestimos.add(emprestimo);
    }
    
    @Override
    public Emprestimo localizar(int id){
        for (Emprestimo emprestimo : Dados.listaDeEmprestimos){
            if(emprestimo.getId() == id){
                return emprestimo;
            }
        }
        return null;
    }
    
    @Override
    public void atualizar(Emprestimo emprestimo){
        System.out.println("Qual item deseja atualizar?");
        System.out.println("1. Funcionário");
        System.out.println("2. Usuário");
        System.out.println("3. Livro");
        System.out.println("4. Data de Empréstimo");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        switch (opcao) {
            case 1 : {
                System.out.println("Digite o novo ID do Funcionário:");
                int novoIdFuncionario = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer
                emprestimo.getFuncionario().set_id(novoIdFuncionario);
                System.out.println("Funcionário atualizado com sucesso!");
            }
            case 2 : {
                System.out.println("Digite o novo ID do Usuário:");
                int novoIdUsuario = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer
                emprestimo.getUsuario().set_id(novoIdUsuario);
                System.out.println("Usuário atualizado com sucesso!");
            }
            case 3 : {
                System.out.println("Digite o novo ID do Livro:");
                int novoIdLivro = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer
                emprestimo.getLivro().setId(novoIdLivro);
                System.out.println("Livro atualizado com sucesso!");
            }
            case 4 : {
                System.out.println("Digite a nova Data de Empréstimo (dd/MM/yyyy):");
                String novaDataStr = scanner.nextLine();
                try {
                    Date novaDataEmprestimo = new SimpleDateFormat("dd/MM/yyyy").parse(novaDataStr);
                    emprestimo.setDataEmprestimo(novaDataEmprestimo);
                    System.out.println("Data de Empréstimo atualizada com sucesso!");
                } catch (ParseException ex) {
                    System.out.println("Data inválida! Certifique-se de digitar no formato dd/MM/yyyy.");
                }
            }
            default : System.out.println("Opção inválida!");
        }
    }
    
    @Override
    public void remover(Emprestimo emprestimo){
        Dados.listaDeEmprestimos.remove(emprestimo);
    }
    
    @Override
    public List<Emprestimo> getLista(){
        return Dados.listaDeEmprestimos;
    }
}
