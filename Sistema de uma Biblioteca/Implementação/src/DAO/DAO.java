package DAO;
import java.util.List;

/**
 *
 * @author lucas
 */
public interface DAO<T> {
    void incluir(T objeto);
    
    T localizar(int id);
    
    void atualizar(T objeto);
    
    void remover(T objeto);
    
    List<T> getLista();
}
