package Principal;
import Modelo.*;
import DAO.*;
import Telas.*;
import excecoes.AutenticacaoException;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import java.util.*;
//import java.JOptionPane.*;
import java.io.*;
import java.util.Scanner;

public class principal {
    public static void main(String[] args) {
        
        System.out.println("Entrando no menu");
        
        Scanner scanner = new Scanner(System.in);
        AutorDAO daoAutor = new AutorDAO();
        CategoriaDAO daoCategoria = new CategoriaDAO();
        EmprestimoDAO daoEmprestimo = new EmprestimoDAO();
        FuncionarioDAO daoFuncionario = new FuncionarioDAO();
        LivroDAO daoLivro = new LivroDAO();
        UsuarioDAO daoUsuario = new UsuarioDAO();
        new TelaPrincipal(daoFuncionario,daoUsuario,daoLivro,daoEmprestimo,daoAutor).setVisible(true);
        System.out.println("Bem-vindo ao sistema de gerenciamento de biblioteca!");
        
        System.out.println("Por favor, digite o usuário do administrador:");
        String usuarioAdm = scanner.nextLine();
        System.out.println("Por favor, digite a senha do administrador:");
        String senhaAdm = scanner.nextLine();
        
        int opcao;
        
        do {
            
            System.out.println("Bem vindo a lista de menus, digite uma opção:");
            System.out.println("1 - Menu de Usuário Administrador:");
            System.out.println("2 - Menu de Usuário Funcionário:");
            System.out.println("3 - Menu de Usuário Comum:");
            System.out.println("4 - Sair");
            
            opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao) {
                case 1 : {  // Menu de administrador
                    System.out.println("Digite o usuário do Administrador:");
                    String tempUsuarioAdm = scanner.nextLine();
                    System.out.println("Digite a senha do Administrador:");
                    String tempSenhaAdm = scanner.nextLine();
                    try{
                        if (usuarioAdm.equals(tempUsuarioAdm) && senhaAdm.equals(tempSenhaAdm)){
                            System.out.println("Autenticação bem sucedida! Bem vindo ao menu de administrador!!");
                            menuAdministrador(daoLivro, daoUsuario, daoFuncionario, daoAutor, daoCategoria, daoEmprestimo);
                        }
                        else {
                            throw new AutenticacaoException();
                        }
                    }catch (AutenticacaoException e){
                        System.out.println(e.getMessage());
                    }
                }
                case 2 : {  // Menu de funcionário
                    System.out.println("Digite o seu ID de Funcionário:");
                    int idFunc = scanner.nextInt();
                    try {
                        Funcionario funcionarioAtual = daoFuncionario.localizar(idFunc);
                        if (funcionarioAtual != null) {
                            System.out.println("Autenticação bem sucedida! Bem vindo, " + funcionarioAtual.get_nome() + " " + funcionarioAtual.get_sobrenome() + ", ao menu de funcionário!!");
                            while (true) {
                                System.out.println("===== Menu de Funcionário =====");
                                System.out.println("1. Cadastrar Empréstimo");
                                System.out.println("2. Voltar ao Menu Anterior");
                                System.out.println("===============================");

                                int opcaoMenu = scanner.nextInt();
                                scanner.nextLine(); // Limpar o buffer

                                switch (opcaoMenu) {
                                    case 1 : {
                                        // Cadastrar Empréstimo
                                        cadastraEmprestimo(daoEmprestimo, funcionarioAtual, daoUsuario, daoLivro);
                                    }
                                    case 2 : {
                                        System.out.println("Voltando ao Menu Anterior...");
                                        return; // Voltar ao menu anterior
                                    }
                                    default :
                                        System.out.println("Opção inválida!");
                                }  
                            }     
                        }
                        else{
                            throw new AutenticacaoException();
                        }
                    }catch (AutenticacaoException e){
                        System.out.println(e.getMessage());
                    }
                }
                case 3 : {  // Menu de usuário
                    System.out.println("Digite o seu ID de usuário:");
                    int idUser = scanner.nextInt();
                    try{
                        Usuario userAtual = daoUsuario.localizar(idUser);
                        if(userAtual != null){
                            System.out.println("Autenticação bem sucedida! Bem vindo, " + userAtual.get_nome() + " " + userAtual.get_sobrenome() + ", ao menu de usuário!!");
                            while (true) {
                                System.out.println("===== Menu de Usuario =====");
                                System.out.println("1. Consultar livro");
                                System.out.println("2. Voltar ao Menu Anterior");
                                System.out.println("===============================");

                                int opcaoMenu = scanner.nextInt();
                                scanner.nextLine(); // Limpar o buffer

                                switch (opcaoMenu) {
                                    case 1 : {
                                        // Consulta livro
                                        consultarLivroPorId(daoLivro);
                                       
                                    }
                                    case 2 : {
                                        System.out.println("Voltando ao Menu Anterior...");
                                        return; // Voltar ao menu anterior
                                    }
                                    default :
                                        System.out.println("Opção inválida!");
                                }
                            }
                        }
                        else{
                            throw new AutenticacaoException();
                        }
                        
                    }catch (AutenticacaoException e){
                        System.out.println(e.getMessage());
                    }
                }
                case 4 : System.out.println("Saindo do sistema. Obrigado!");
                default : System.out.println("Opção inválida. Tente novamente:");
                    
            }
            
        } while (opcao != 4);
        
        
    }
    
    // Função para cadastrar um novo funcionário
    public static void cadastraFuncionario(FuncionarioDAO daoFuncionario){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite o nome do usuário:");
        String nomeFuncionario = scanner.nextLine();

        System.out.println("Digite o sobrenome do funcionário:");
        String sobrenomeFuncionario = scanner.nextLine();

        System.out.println("Digite a matrícula do funcionário:");
        int matriculaFuncionario = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        
        // Criando objeto com os dados informados
        Funcionario novoFuncionario = new Funcionario(0,nomeFuncionario,sobrenomeFuncionario,matriculaFuncionario);
        daoFuncionario.incluir(novoFuncionario);
        System.out.println("Funcionário cadastrado com sucesso!");
        System.out.println("Funcionário criado com ID: " + novoFuncionario.get_id());
    }
    
    // Função para cadastrar um novo Autor
    public static void cadastraAutor(AutorDAO daoAutor) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do autor:");
        String nomeAutor = scanner.nextLine();

        System.out.println("Digite o sobrenome do autor:");
        String sobrenomeAutor = scanner.nextLine();

        System.out.println("Digite a biografia do autor:");
        String biografiaAutor = scanner.nextLine();

        // Criando objeto com os dados informados
        Autor novoAutor = new Autor(0, nomeAutor, sobrenomeAutor, biografiaAutor);
        daoAutor.incluir(novoAutor);
        System.out.println("Autor cadastrado com sucesso!");
        System.out.println("Autor criado com ID: " + novoAutor.get_id());
    }
    
    // Função para cadastrar uma nova Categoria
    public static void cadastraCategoria(CategoriaDAO daoCategoria) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o título da categoria:");
        String tituloCategoria = scanner.nextLine();

        // Criando objeto com os dados informados
        Categoria novaCategoria = new Categoria(0, tituloCategoria);
        daoCategoria.incluir(novaCategoria);
        System.out.println("Categoria cadastrada com sucesso!");
        System.out.println("Categoria criada com ID: " + novaCategoria.getId());
    }
    
    // Função para cadastrar um novo Usuário
    public static void cadastraUsuario(UsuarioDAO daoUsuario) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do usuário:");
        String nomeUsuario = scanner.nextLine();

        System.out.println("Digite o sobrenome do usuário:");
        String sobrenomeUsuario = scanner.nextLine();

        System.out.println("Digite o registro acadêmico do usuário:");
        int registroAcademicoUsuario = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        // Criando objeto com os dados informados
        Usuario novoUsuario = new Usuario(0, nomeUsuario, sobrenomeUsuario, registroAcademicoUsuario);
        daoUsuario.incluir(novoUsuario);
        System.out.println("Usuário cadastrado com sucesso!");
        System.out.println("Usuário criado com ID: " + novoUsuario.get_id());
    }
    
    // Função para cadastrar um novo livro
    public static void cadastraLivro(LivroDAO daoLivro, CategoriaDAO daoCategoria, AutorDAO daoAutor) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o título do livro:");
        String tituloLivro = scanner.nextLine();

        // Lógica para cadastrar categorias associadas ao livro.
        System.out.println("Digite o ID da categoria do livro (ou -1 para encerrar o cadastro de categorias):");
        int idCategoria = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        List<Integer> categoriasLivro = new ArrayList<>();
        while (idCategoria != -1) {
            Categoria categoria = daoCategoria.localizar(idCategoria);
            if (categoria != null) {
                categoriasLivro.add(idCategoria);
                System.out.println("Categoria adicionada ao livro!");
            } else {
                System.out.println("Categoria não encontrada! Tente novamente.");
            }

            System.out.println("Digite o ID da categoria do livro (ou -1 para encerrar o cadastro de categorias):");
            idCategoria = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer
        }

        // Lógica para cadastrar autores associados ao livro.
        System.out.println("Digite o ID do autor do livro (ou -1 para encerrar o cadastro de autores):");
        int idAutor = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        List<Integer> autoresLivro = new ArrayList<>();
        while (idAutor != -1) {
            Autor autor = daoAutor.localizar(idAutor);
            if (autor != null) {
                autoresLivro.add(idAutor);
                System.out.println("Autor adicionado ao livro!");
            } else {
                System.out.println("Autor não encontrado! Tente novamente.");
            }

            System.out.println("Digite o ID do autor do livro (ou -1 para encerrar o cadastro de autores):");
            idAutor = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer
        }

        // Criando objeto com os dados informados
        Livro novoLivro = new Livro(0, tituloLivro, categoriasLivro, autoresLivro);
        daoLivro.incluir(novoLivro);
        System.out.println("Livro cadastrado com sucesso!");
        System.out.println("Livro criado com ID: " + novoLivro.getId());
    }
    
    // Função para cadastrar um empréstimo
    public static void cadastraEmprestimo(EmprestimoDAO daoEmprestimo, Funcionario funcionario, UsuarioDAO daoUsuario, LivroDAO daoLivro) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o ID do Usuário que está pegando o livro emprestado:");
        int idUsuario = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        Usuario usuario = daoUsuario.localizar(idUsuario);

        if (usuario == null) {
            System.out.println("Usuário não encontrado! Empréstimo não pode ser realizado.");
            return;
        }

        System.out.println("Digite o ID do Livro que será emprestado:");
        int idLivro = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        Livro livro = daoLivro.localizar(idLivro);

        if (livro == null) {
            System.out.println("Livro não encontrado! Empréstimo não pode ser realizado.");
            return;
        }

        System.out.println("Digite a data de Empréstimo (dd/MM/yyyy):");
        String dataEmprestimoStr = scanner.nextLine();
        Date dataEmprestimo;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dataEmprestimo = dateFormat.parse(dataEmprestimoStr);
        } catch (ParseException ex) {
            System.out.println("Data inválida! Certifique-se de digitar no formato dd/MM/yyyy.");
            return;
        }

        // Criando objeto com os dados informados
        Emprestimo novoEmprestimo = new Emprestimo(0, funcionario, usuario, livro, dataEmprestimo);
        daoEmprestimo.incluir(novoEmprestimo);
        System.out.println("Empréstimo cadastrado com sucesso!");
        System.out.println("Empréstimo criado com ID: " + novoEmprestimo.getId());
    }
    
    public static void consultarLivroPorId(LivroDAO daoLivro) {
        // Mostrar a lista de livros com seus IDs para que o usuário possa escolher qual consultar
        List<Livro> listaLivros = daoLivro.getLista();
        if (listaLivros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado no momento.");
            return;
        }

        System.out.println("Lista de Livros:");
        for (Livro livro : listaLivros) {
            System.out.println("ID: " + livro.getId() + ", Título: " + livro.getTitulo());
        }

        // Pedir o ID do livro para a consulta
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o ID do livro que deseja consultar:");
        int idLivro = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        Livro livroEncontrado = daoLivro.localizar(idLivro);

        if (livroEncontrado == null) {
            System.out.println("Nenhum livro encontrado com o ID: " + idLivro);
        } else {
            System.out.println("Livro encontrado:");
            System.out.println("ID: " + livroEncontrado.getId() + ", Título: " + livroEncontrado.getTitulo());
            System.out.println("Categorias: " + livroEncontrado.getCategorias());
            System.out.println("Autores: " + livroEncontrado.getAutores());
        }
    }
    
    
    
    public static void menuAdministrador(LivroDAO daoLivro, UsuarioDAO daoUsuario, FuncionarioDAO daoFuncionario, AutorDAO daoAutor, CategoriaDAO daoCategoria, EmprestimoDAO daoEmprestimo) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===== Menu Administrador =====");
            System.out.println("1. Gerenciar Livros");
            System.out.println("2. Gerenciar Usuários");
            System.out.println("3. Gerenciar Funcionários");
            System.out.println("4. Gerenciar Autores");
            System.out.println("5. Gerenciar Categorias dos Livros");
            System.out.println("6. Sair do Menu Administrador");
            System.out.println("===============================");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1 : gerenciarLivros(daoLivro, daoCategoria, daoAutor);
                case 2 : gerenciarUsuarios(daoUsuario);
                case 3 : gerenciarFuncionarios(daoFuncionario);
                case 4 : gerenciarAutores(daoAutor);
                case 5 : gerenciarCategorias(daoCategoria);
                case 6 : {
                    System.out.println("Saindo do Menu Administrador...");
                    return; // Voltar para o menu principal
                }
                default : System.out.println("Opção inválida!");
            }
        }
    }
        
    // Função para o menu de Adm, de gerenciamento de funcionário
    public static void gerenciarFuncionarios(FuncionarioDAO daoFuncionario) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===== Gerenciar Funcionários =====");
            System.out.println("1. Cadastrar Novo Funcionário");
            System.out.println("2. Atualizar Funcionário");
            System.out.println("3. Remover Funcionário");
            System.out.println("4. Listar Funcionários");
            System.out.println("5. Localizar Funcionário");
            System.out.println("6. Voltar ao Menu Anterior");
            System.out.println("===============================");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1 : {
                    // Cadastrar Novo Funcionário
                    cadastraFuncionario(daoFuncionario);
                }
                case 2 : {
                    // Atualizar Funcionário
                    System.out.println("Digite o ID do funcionário que deseja atualizar:");
                    int idFuncionario = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer
                    Funcionario funcionario = daoFuncionario.localizar(idFuncionario);
                    if (funcionario != null) {
                        daoFuncionario.atualizar(funcionario);
                    } else {
                        System.out.println("Funcionário não encontrado!");
                    }
                }
                case 3 : {
                    // Remover Funcionário
                    System.out.println("Digite o ID do funcionário que deseja remover:");
                    int idFuncionario = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer
                    Funcionario funcionario = daoFuncionario.localizar(idFuncionario);
                    if (funcionario != null) {
                        daoFuncionario.remover(funcionario);
                        System.out.println("Funcionário removido com sucesso!");
                    } else {
                        System.out.println("Funcionário não encontrado!");
                    }
                }
                case 4 : {
                    // Listar Funcionários
                    List<Funcionario> funcionarios = daoFuncionario.getLista();
                    if (funcionarios.isEmpty()) {
                        System.out.println("Nenhum funcionário cadastrado.");
                    } else {
                        System.out.println("Lista de Funcionários:");
                        for (Funcionario funcionario : funcionarios) {
                            System.out.println(funcionario.toString());
                        }
                    }
                }
                case 5 : {
                    // Localizar Funcionário
                    System.out.println("Digite o ID do funcionário que deseja localizar:");
                    int idFuncionario = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer
                    Funcionario funcionario = daoFuncionario.localizar(idFuncionario);
                    if (funcionario != null) {
                        System.out.println("Funcionário encontrado:");
                        System.out.println(funcionario.toString());
                    } else {
                        System.out.println("Funcionário não encontrado!");
                    }
                }
                case 6 : {
                    System.out.println("Voltando ao Menu Anterior...");
                    return; // Voltar ao menu anterior
                }
                default :
                    System.out.println("Opção inválida!");
            }
        }
    }
    
    public static void gerenciarUsuarios(UsuarioDAO daoUsuario) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===== Gerenciar Usuários =====");
            System.out.println("1. Cadastrar Novo Usuário");
            System.out.println("2. Atualizar Usuário");
            System.out.println("3. Remover Usuário");
            System.out.println("4. Listar Usuários");
            System.out.println("5. Localizar Usuário");
            System.out.println("6. Voltar ao Menu Anterior");
            System.out.println("===============================");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1 : {
                    // Cadastrar Novo Usuário
                    cadastraUsuario(daoUsuario);
                }
                case 2 : {
                    // Atualizar Usuário
                    System.out.println("Digite o ID do usuário que deseja atualizar:");
                    int idUsuario = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer
                    Usuario usuario = daoUsuario.localizar(idUsuario);
                    if (usuario != null) {
                        daoUsuario.atualizar(usuario);
                    } else {
                        System.out.println("Usuário não encontrado!");
                    }
                }
                case 3 : {
                    // Remover Usuário
                    System.out.println("Digite o ID do usuário que deseja remover:");
                    int idUsuario = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer
                    Usuario usuario = daoUsuario.localizar(idUsuario);
                    if (usuario != null) {
                        daoUsuario.remover(usuario);
                        System.out.println("Usuário removido com sucesso!");
                    } else {
                        System.out.println("Usuário não encontrado!");
                    }
                }
                case 4 : {
                    // Listar Usuários
                    List<Usuario> usuarios = daoUsuario.getLista();
                    if (usuarios.isEmpty()) {
                        System.out.println("Nenhum usuário cadastrado.");
                    } else {
                        System.out.println("Lista de Usuários:");
                        for (Usuario usuario : usuarios) {
                            System.out.println(usuario.toString());
                        }
                    }
                }
                case 5 : {
                    // Localizar Usuário
                    System.out.println("Digite o ID do usuário que deseja localizar:");
                    int idUsuario = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer
                    Usuario usuario = daoUsuario.localizar(idUsuario);
                    if (usuario != null) {
                        System.out.println("Usuário encontrado:");
                        System.out.println(usuario.toString());
                    } else {
                        System.out.println("Usuário não encontrado!");
                    }
                }
                case 6 : {
                    System.out.println("Voltando ao Menu Anterior...");
                    return; // Voltar ao menu anterior
                }
                default :
                    System.out.println("Opção inválida!");
            }
        }
    }
    
    
    public static void gerenciarLivros(LivroDAO daoLivro, CategoriaDAO daoCategoria, AutorDAO daoAutor) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===== Gerenciar Livros =====");
            System.out.println("1. Cadastrar Novo Livro");
            System.out.println("2. Atualizar Livro");
            System.out.println("3. Remover Livro");
            System.out.println("4. Listar Livros");
            System.out.println("5. Localizar Livro");
            System.out.println("6. Voltar ao Menu Anterior");
            System.out.println("===============================");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1 : {
                    // Cadastrar Novo Livro
                    cadastraLivro(daoLivro, daoCategoria, daoAutor);
                }
                case 2 : {
                    // Atualizar Livro
                    System.out.println("Digite o ID do livro que deseja atualizar:");
                    int idLivro = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer
                    Livro livro = daoLivro.localizar(idLivro);
                    if (livro != null) {
                        daoLivro.atualizar(livro);
                    } else {
                        System.out.println("Livro não encontrado!");
                    }
                }
                case 3 : {
                    // Remover Livro
                    System.out.println("Digite o ID do livro que deseja remover:");
                    int idLivro = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer
                    Livro livro = daoLivro.localizar(idLivro);
                    if (livro != null) {
                        daoLivro.remover(livro);
                        System.out.println("Livro removido com sucesso!");
                    } else {
                        System.out.println("Livro não encontrado!");
                    }
                }
                case 4 : {
                    // Listar Livros
                    List<Livro> livros = daoLivro.getLista();
                    if (livros.isEmpty()) {
                        System.out.println("Nenhum livro cadastrado.");
                    } else {
                        System.out.println("Lista de Livros:");
                        for (Livro livro : livros) {
                            System.out.println(livro.toString());
                        }
                    }
                }
                case 5 : {
                    // Localizar Livro
                    System.out.println("Digite o ID do livro que deseja localizar:");
                    int idLivro = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer
                    Livro livro = daoLivro.localizar(idLivro);
                    if (livro != null) {
                        System.out.println("Livro encontrado:");
                        System.out.println(livro.toString());
                    } else {
                        System.out.println("Livro não encontrado!");
                    }
                }
                case 6 : {
                    System.out.println("Voltando ao Menu Anterior...");
                    return; // Voltar ao menu anterior
                }
                default :
                    System.out.println("Opção inválida!");
            }
        }
    }
    
    public static void gerenciarAutores(AutorDAO daoAutor) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===== Gerenciar Autores =====");
            System.out.println("1. Cadastrar Novo Autor");
            System.out.println("2. Atualizar Autor");
            System.out.println("3. Remover Autor");
            System.out.println("4. Listar Autores");
            System.out.println("5. Localizar Autor");
            System.out.println("6. Voltar ao Menu Anterior");
            System.out.println("===============================");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1 : {
                    // Cadastrar Novo Autor
                    cadastraAutor(daoAutor);
                }
                case 2 : {
                    // Atualizar Autor
                    System.out.println("Digite o ID do autor que deseja atualizar:");
                    int idAutor = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer
                    Autor autor = daoAutor.localizar(idAutor);
                    if (autor != null) {
                        daoAutor.atualizar(autor);
                    } else {
                        System.out.println("Autor não encontrado!");
                    }
                }
                case 3 : {
                    // Remover Autor
                    System.out.println("Digite o ID do autor que deseja remover:");
                    int idAutor = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer
                    Autor autor = daoAutor.localizar(idAutor);
                    if (autor != null) {
                        daoAutor.remover(autor);
                        System.out.println("Autor removido com sucesso!");
                    } else {
                        System.out.println("Autor não encontrado!");
                    }
                }
                case 4 : {
                    // Listar Autores
                    List<Autor> autores = daoAutor.getLista();
                    if (autores.isEmpty()) {
                        System.out.println("Nenhum autor cadastrado.");
                    } else {
                        System.out.println("Lista de Autores:");
                        for (Autor autor : autores) {
                            System.out.println(autor.toString());
                        }
                    }
                }
                case 5 : {
                    // Localizar Autor
                    System.out.println("Digite o ID do autor que deseja localizar:");
                    int idAutor = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer
                    Autor autor = daoAutor.localizar(idAutor);
                    if (autor != null) {
                        System.out.println("Autor encontrado:");
                        System.out.println(autor.toString());
                    } else {
                        System.out.println("Autor não encontrado!");
                    }
                }
                case 6 : {
                    System.out.println("Voltando ao Menu Anterior...");
                    return; // Voltar ao menu anterior
                }
                default :
                    System.out.println("Opção inválida!");
            }
        }
    }
    
    
    public static void gerenciarCategorias(CategoriaDAO daoCategoria) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===== Gerenciar Categorias =====");
            System.out.println("1. Cadastrar Nova Categoria");
            System.out.println("2. Atualizar Categoria");
            System.out.println("3. Remover Categoria");
            System.out.println("4. Listar Categorias");
            System.out.println("5. Localizar Categoria");
            System.out.println("6. Voltar ao Menu Anterior");
            System.out.println("===============================");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1 : {
                    // Cadastrar Nova Categoria
                    cadastraCategoria(daoCategoria);
                }
                case 2 : {
                    // Atualizar Categoria
                    System.out.println("Digite o ID da categoria que deseja atualizar:");
                    int idCategoria = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer
                    Categoria categoria = daoCategoria.localizar(idCategoria);
                    if (categoria != null) {
                        daoCategoria.atualizar(categoria);
                    } else {
                        System.out.println("Categoria não encontrada!");
                    }
                }
                case 3 : {
                    // Remover Categoria
                    System.out.println("Digite o ID da categoria que deseja remover:");
                    int idCategoria = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer
                    Categoria categoria = daoCategoria.localizar(idCategoria);
                    if (categoria != null) {
                        daoCategoria.remover(categoria);
                        System.out.println("Categoria removida com sucesso!");
                    } else {
                        System.out.println("Categoria não encontrada!");
                    }
                }
                case 4 : {
                    // Listar Categorias
                    List<Categoria> categorias = daoCategoria.getLista();
                    if (categorias.isEmpty()) {
                        System.out.println("Nenhuma categoria cadastrada.");
                    } else {
                        System.out.println("Lista de Categorias:");
                        for (Categoria categoria : categorias) {
                            System.out.println(categoria.toString());
                        }
                    }
                }
                case 5 : {
                    // Localizar Categoria
                    System.out.println("Digite o ID da categoria que deseja localizar:");
                    int idCategoria = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer
                    Categoria categoria = daoCategoria.localizar(idCategoria);
                    if (categoria != null) {
                        System.out.println("Categoria encontrada:");
                        System.out.println(categoria.toString());
                    } else {
                        System.out.println("Categoria não encontrada!");
                    }
                }
                case 6 : {
                    System.out.println("Voltando ao Menu Anterior...");
                    return; // Voltar ao menu anterior
                }
                default :
                    System.out.println("Opção inválida!");
            }
        }
    }
}