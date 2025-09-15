/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serversocketdemo;

import java.net.ServerSocket;

/**
 *
 * @author carlo
 */
public class Server {
    static ServerSocket servidor;
    int porta = 12345;

    public Server() {
        try {
            servidor = new ServerSocket(porta);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
