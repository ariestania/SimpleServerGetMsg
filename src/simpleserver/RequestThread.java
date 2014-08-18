/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 *
 * @author ariestania.winda
 */
public class RequestThread extends Thread {

    private ServerSocket server;
    private ArrayBlockingQueue<Runnable> arrayBlockingQueue = new ArrayBlockingQueue<Runnable>(1);
    ThreadPoolExecutor pool;
    
    public RequestThread(ServerSocket server) {            
        this.server = server;
        if(this.pool==null){
            this.pool = new ThreadPoolExecutor(5, 6, 5, TimeUnit.MINUTES, arrayBlockingQueue);
        }
    }   
    
    @Override
    public void run() {
        while (true) {            
            try {
                Socket socket = server.accept();
                if(pool.getActiveCount() < pool.getMaximumPoolSize()){
                    new WorkerThread(socket).start();
                } else {
                    this.sleep(1000);
                }                
            } catch(InterruptedException ie){
                System.out.println("enterup" + ie.getMessage());
            }
            catch (IOException ex) {
                System.out.println("error: " + ex.getMessage());
            }    
        }            
    }
    
}
