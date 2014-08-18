/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleserver;

import java.io.IOException;
import java.net.ServerSocket;

/**
 *
 * @author ariestania.winda
 */
public class SimpleServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        ServerSocket server = new ServerSocket(8080);       
        new RequestThread(server).start();        
    }
}
