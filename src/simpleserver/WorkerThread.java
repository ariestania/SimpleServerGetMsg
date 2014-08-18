/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleserver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author ariestania.winda
 */
public class WorkerThread extends Thread{

    private Socket socket;
    
    public WorkerThread(Socket socket) {
        this.socket = socket;
    }
    
    
    @Override
    public void run() {
        try {            
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String str;            
            while ((str = in.readLine())!= null && str.trim().length()>0) {
                    System.out.println(str);
            }
        } catch (Exception e) {
            System.out.println("error : " + e.getMessage());
        }
    }
    
}
