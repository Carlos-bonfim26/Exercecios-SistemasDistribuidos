/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientsocketdemo;

import java.net.Socket;

/**
 *
 * @author carlo
 */
public class Client {
    static String host = "localhost";
    static int porta = 12345;
    static Socket socket;
    
    public Client(){
        try{
            socket = new Socket(host, porta);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
