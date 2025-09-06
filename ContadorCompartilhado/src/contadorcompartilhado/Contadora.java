/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contadorcompartilhado;

/**
 *
 * @author carlo
 */
public class Contadora implements Runnable{
     private String nome;

    public Contadora(String nome) {
        this.nome = nome;
    }
    
    public void run() {
        try {
            //coloca uma pausa para simular o processamento
            Thread.sleep(10);
            for (int i = 0; i < 100; i++) {
                // incrementa o contador compartilhado
               ContadorSingleton.getInstancia().addContador();
            }
            System.out.println("O contador:" + nome + " chegou terminou");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       
    }
    
}
