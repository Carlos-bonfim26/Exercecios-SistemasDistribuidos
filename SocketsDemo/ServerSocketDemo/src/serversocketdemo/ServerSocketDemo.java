/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package serversocketdemo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import static serversocketdemo.Server.servidor;

/**
 *
 * @author carlo
 */
public class ServerSocketDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            new Server();
            System.out.println("servidor iniciado. aguardando conexão...");

            //aguarda conexão do client
            Socket socket = servidor.accept();
            System.out.println("cliente conectado: " + socket.getInetAddress());

            //streams de entrada e saída
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter saida = new PrintWriter(socket.getOutputStream());

            //lê a mensagem do cliente
            String mensagem = entrada.readLine();
            System.out.println("Mensagem recebida: " + mensagem);

            //responde o cliente
            saida.println("Servidor recebeu sua mensagem: " + mensagem);

            //fecha conexões
            socket.close();
            servidor.close();
            System.out.println("Conexão encerrada");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
