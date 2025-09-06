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
public class Produtora implements Runnable{
    private ArrayList<Integer> buffer;

    public Produtora(ArrayList<Integer> buffer) {
        this.buffer = buffer;
    }
    //gera um numero aleatorio entre 0 e 100
    private int gerarNumeroAleatorio(){
        return (int) Math.round(Math.random() * 101);
    }
    @Override
    public void run() {
        try{
            //produz os produtos
            do{
                
            if(buffer.size()<5){
                
                buffer.add(gerarNumeroAleatorio());
              
            }else{
                System.out.println("buffer cheio");
            }
           }while(buffer.size() < 5);
            //notifica a consumidora que o produto foi produzido
           synchronized (buffer) {
               buffer.notifyAll();
           }

        }catch(Exception e){
            System.out.println("Aconteceu um erro na execução:" + e);
        }
    }


    
}
