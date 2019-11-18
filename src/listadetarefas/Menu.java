/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listadetarefas;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author frede
 */
public class Menu {

    public static void main(String[] args) {

        String email, senha;

        ArrayList<Usuario> Usuarios = new ArrayList();

        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("|| INDEX ||");
            System.out.println("============");
            System.out.println("[1] fazer cadastro");
            System.out.println("[2] fazer login");
            System.out.println("[3] encerrar o programa");
            System.out.print("Digite a opção: ");
            switch (scan.nextInt()) {
                
                case 1:
                    scan.nextLine();
                    System.out.println("|| Página de cadastro ||");
                    System.out.print("Digite o email: ");
                    email = scan.nextLine();
                    System.out.print("Digite a senha: ");
                    senha = scan.nextLine();
                    if (!(email.contains("@")) || senha.length() <= 5 || senha.length() >= 16) {
                        System.out.println("Email ou senha incorretos");
                        System.out.println("Email deve ter um '@'");
                        System.out.println("A senha deve ter mais de 5 caracteres e menos de 16");
                        System.out.println("pressione enter para continuar");
                        scan.nextLine();

                    } else {
                        Usuario user = new Usuario();
                        user.setEmail(email);
                        user.setSenha(senha);
                        Usuarios.add(user);
                        System.out.println("Cadastro efetuado com sucesso");
                        System.out.println("pressione enter para continuar");
                        scan.nextLine();
                    }
                    break;

                case 2:
                    scan.nextLine();
                    System.out.println("|| Página de login ||");
                    System.out.print("Digite o email: ");
                    email = scan.nextLine();
                    System.out.print("Digite a senha: ");
                    senha = scan.nextLine();
                    Usuario u = new Usuario();
                    u.setEmail(email);
                    u.setSenha(senha);
                    if (!(Usuarios.contains(u))) {
                        System.out.println("Email ou senha incorretos. Redirecionando para Index...");
                        System.out.println("Pressione enter para continuar");
                        scan.nextLine();

                    } else {
                        System.out.println("Login feito com sucesso!\n");
                        while (true) {
                            
                            System.out.println("|| Home Page ||");
                            System.out.println("===============");
                            System.out.println("[1] Listar tarefas");
                            System.out.println("[2] Listar tarefas finalizadas");
                            System.out.println("[3] Listar tarefas não finalizadas");
                            System.out.println("[4] Adicionar nova tarefa");
                            System.out.println("[5] finalizar tarefa");
                            System.out.println("[6] remover tarefa");
                            System.out.println("[7] logout");
                            System.out.println("Digite a opção: ");

                            switch (scan.nextInt()) {
                                case 1:
                                    scan.nextLine();
                                    if (u.listaTarefas.isEmpty()) {
                                        System.out.println("Lista de tarefas VAZIA. Redirecionando para Home Page...");
                                        System.out.println("Pressione enter para retornar para a Home Page");
                                        scan.nextLine();
                                    } else {
                                        for (int i = 0; i < u.listaTarefas.size(); i++) {
                                            System.out.println("Tarefa " + (i + 1) + "\nTitulo:  " + u.listaTarefas.get(i).getTitulo());
                                            System.out.println("Finalizada:  " + u.listaTarefas.get(i).isFinalizada());

                                        }
                                    }
                                    break;

                                case 2:
                                    scan.nextLine();
                                    System.out.println("|| Tarefas Finalizadas ||");
                                    if (!(u.HaTarefasFinalizadas())) {
                                        System.out.println("Nenhuma tarefa para mostrar.Redirecionando para Home Page");
                                        System.out.println("Pressione enter para voltar para Home Page");
                                        scan.nextLine();
                                    } else {
                                        for (int i = 0; i < u.listaTarefas.size(); i++) {
                                            if (u.listaTarefas.get(i).isFinalizada()) {
                                                System.out.println("Tarefa " + (i + 1) + "\nTitulo:  " + u.listaTarefas.get(i).getTitulo());
                                                System.out.println("Finalizada:  " + u.listaTarefas.get(i).isFinalizada());
                                            }
                                        }
                                    }
                                    break;
                                case 3:
                                    scan.nextLine();
                                    System.out.println("|| Tarefas em Aberto ||");
                                    if (!(u.HaTarefasNaoFinalizadas())) {
                                        System.out.println("Nenhuma tarefa para mostrar.Redirecionando para Home Page");
                                        System.out.println("Pressione enter para voltar para Home Page");
                                        scan.nextLine();
                                    } else {
                                        for (int i = 0; i < u.listaTarefas.size(); i++) {
                                            if (!(u.listaTarefas.get(i).isFinalizada())) {
                                                System.out.println("Tarefa " + (i + 1) + "\nTitulo:  " + u.listaTarefas.get(i).getTitulo());
                                                System.out.println("Finalizada:  " + u.listaTarefas.get(i).isFinalizada());
                                            }
                                        }
                                    }
                                    break;
                                case 4:
                                    scan.nextLine();
                                    Tarefa tarefa = new Tarefa();
                                    System.out.println("|| Nova Tarefa ||");
                                    System.out.println("=================");
                                    System.out.println("Digite o título: ");
                                    tarefa.setTitulo(scan.nextLine());
                                    u.listaTarefas.add(tarefa);
                                    System.out.println("Tarefa adicionada com sucesso!");
                                    System.out.println("Pressione enter para voltar para Home Page");
                                    scan.nextLine();
                                    break;
                                case 5:
                                    scan.nextLine();
                                    System.out.println("|| Finalizar tarefa ||");
                                    if (!(u.HaTarefasNaoFinalizadas())) {
                                        System.out.println("Nenhuma tarefa para mostrar.Redirecionando para Home Page");
                                        System.out.println("Pressione enter para voltar para Home Page");
                                        scan.nextLine();
                                    } else {
                                        while (true) {
                                            for (int i = 0; i < u.listaTarefas.size(); i++) {
                                                if (!(u.listaTarefas.get(i).isFinalizada())) {
                                                    System.out.println("[" + i + "]" + u.listaTarefas.get(i).getTitulo());
                                                }

                                            }
                                            System.out.println("Digite a tarefa que deseja finalizar: ");
                                            int i = scan.nextInt();
                                            if (u.listaTarefas.get(i).isFinalizada() || i >= u.listaTarefas.size()) {
                                                System.out.println("número de referência inválido.");
                                            }
                                            else{
                                                u.listaTarefas.get(i).setFinalizada(true);
                                                System.out.println("Tarefa finalizada com sucesso!");
                                                System.out.println("Pressione enter para voltar para Home Page");
                                                scan.nextLine();
                                                break;
                                            }
                                            
                                        }
                                        
                                    }
                                    break;
                                case 6:
                                    scan.nextLine();
                                    System.out.println("|| Remover Tarefa ||");
                                    System.out.println("====================");
                                    while(true){
                                    for (int i = 0; i < u.listaTarefas.size(); i++) {
                                            System.out.println("[" + (i) + "]" + u.listaTarefas.get(i).getTitulo());
                                        }
                                        System.out.println("Digite a tarefa que deseja remover: ");
                                        int i =scan.nextInt();
                                        if(i >= u.listaTarefas.size())
                                            System.out.println("Numero de referência inválido");
                                        else{
                                            u.listaTarefas.remove(i);
                                        break;
                                        }
                                        
                                    }
                                case 7:
                                    scan.nextLine();
                                    System.out.println("Fazendo logout...");
                                    return;
                            }
                        }
                    }

                    break;
                case 3:
                    scan.nextLine();
                    System.out.println("Encerrando o programa.");
                    return;
            }
        }
    }
}
