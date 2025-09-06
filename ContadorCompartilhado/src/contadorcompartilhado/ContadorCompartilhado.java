/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package contadorcompartilhado;

/**
 *
 * @author carlo
 */
public class ContadorCompartilhado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // instanceia o singleton
        ContadorSingleton singleton = ContadorSingleton.getInstancia();
        Contadora contadora1 = new Contadora("Contadora 1");
        Contadora contadora2 = new Contadora("Contadora 2");
        Contadora contadora3 = new Contadora("Contadora 3");
        Contadora contadora4 = new Contadora("Contadora 4");
        Contadora contadora5 = new Contadora("Contadora 5");
        Thread thread1 = new Thread(contadora1);
        Thread thread2 = new Thread(contadora2);
        Thread thread3 = new Thread(contadora3);
        Thread thread4 = new Thread(contadora4);
        Thread thread5 = new Thread(contadora5);
        // Inicia as threads
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        // Espera todas as threads terminarem
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();
        System.out.println("Contador final: " + singleton.contador);
    }

}
