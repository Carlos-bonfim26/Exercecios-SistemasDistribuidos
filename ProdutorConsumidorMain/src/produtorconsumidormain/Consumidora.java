/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package produtorconsumidormain;

import java.util.ArrayList;

/**
 *
 * @author carlo
 */
public class Consumidora implements Runnable {

    private ArrayList<Integer> buffer;

    public Consumidora(ArrayList<Integer> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try{
            //espera o produtor produzir
            synchronized (buffer) {
                buffer.wait();
                //consome os produtos
                while (buffer.size() > 0) {
                    if (buffer.size() > 0) {

                        System.out.println("consumindo o produto " + buffer.get(0));
                        buffer.remove(0);
                    }
                }
            }
        }catch(Exception e){
            System.out.println("Aconteceu um erro na execução:" + e);
        }
    }


}
