/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listadetarefas;

/**
 *
 * @author frede
 */
public class Tarefa {
    private String titulo;
    private boolean finalizada = false;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    
    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }
    

}
