/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contadorcompartilhado;

/**
 *
 * @author carlo
 */
public class ContadorSingleton {
    private static ContadorSingleton instancia;
    public int contador = 0;

    private ContadorSingleton() {
    }

    // método sincronizado para incrementar o contador
    public synchronized int addContador() {
        return contador++;
    }

    // método para obter a instância única do singleton
    public static synchronized ContadorSingleton getInstancia() {
        if (instancia == null) {
            instancia = new ContadorSingleton();
        }
        return instancia;
    }
}
