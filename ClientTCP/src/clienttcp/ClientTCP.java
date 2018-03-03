/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienttcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author youssef
 */
public class ClientTCP {

    private static BufferedReader getInput(Socket p) throws IOException {
        return new BufferedReader(new InputStreamReader(p.getInputStream()));
    }

    private static PrintWriter getoutput(Socket p) throws IOException {
        return new PrintWriter(new OutputStreamWriter(p.getOutputStream()));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Socket l = new Socket("localhost", 2000);
        System.out.println(l.getLocalSocketAddress());
        BufferedReader ir = getInput(l);
        PrintWriter reply = getoutput(l);
        //Envoyer une chaine
        reply.printf("Bonjour\n");
        reply.flush();
        //Récupérer la réponse puis l'afficher
        System.out.println(ir.readLine());
    }
}
