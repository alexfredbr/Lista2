/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listadetarefas;

import java.util.ArrayList;

/**
 *
 * @author frede
 */
public class Usuario {
    private String email, senha;
    
    ArrayList<Tarefa> listaTarefas = new ArrayList ();

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
        boolean HaTarefasFinalizadas(){
        boolean contem = false;
        for(int i = 0; i < listaTarefas.size(); i++){
            if(listaTarefas.get(i).isFinalizada()){
                contem = true;
            }
        }
        return contem;
    }
    boolean HaTarefasNaoFinalizadas(){
        boolean contem = false;
        for(int i = 0; i < listaTarefas.size(); i++){
            if(!(listaTarefas.get(i).isFinalizada())){
                contem = true;
            }
        }
        return contem;
    }
}
