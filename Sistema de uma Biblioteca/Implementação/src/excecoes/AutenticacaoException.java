package excecoes;

public class AutenticacaoException extends Exception{
    public AutenticacaoException(){
        super("Cedenciais inválidas! Verifique o usuário e a senha!");
    }
}
