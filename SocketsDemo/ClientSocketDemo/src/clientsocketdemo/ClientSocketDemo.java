/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clientsocketdemo;

import static clientsocketdemo.Client.socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author carlo
 */
public class ClientSocketDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        try {
            new Client();
            System.out.println("conectado ao servidor");

            //streams de entrada e saída
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter saida = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //envia mensagem para o servior
            System.out.println("Digite uma mensagem: ");
            String mensagem = teclado.readLine();
            saida.println(mensagem);
            
            //lê resposta servidor
            String resposta = entrada.readLine();
            System.out.println("Resposta do servidor: "+ resposta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
