/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package produtorconsumidormain;

import java.util.ArrayList;

/**
 *
 * @author carlo
 */
public class ProdutorConsumidorMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        ArrayList<Integer> buffer = new ArrayList<>();
        
        
        Thread consumidor = new Thread(new Consumidora(buffer));
        Thread produtor = new Thread(new Produtora(buffer));
        Thread produtor2 = new Thread(new Produtora(buffer));
        Thread produtor3 = new Thread(new Produtora(buffer));
        Thread consumidor2 = new Thread(new Consumidora(buffer));
       
        consumidor.start();
        produtor.start();
        produtor2.start();
        produtor3.start();
        consumidor2.start();
        produtor.join();
        consumidor.join();
        produtor2.join();
        produtor3.join();
        consumidor2.join();
        System.out.println("Execução finalizada");

        for(int i = 0; i < buffer.size(); i++){
            System.out.println("produtos do buffer:"+buffer.get(i));
        }
        System.out.println("tamanho do buffer:"+ buffer.size());
    }
    
}
