package ClientServerModel;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connection extends Thread {
    
    private static Socket s;
    private static Socket s2;
    private static ServerSocket ss;
    private static ServerSocket ss2;
    @Override
    public void run() {
        final int PORT = 20;
        final int PORT2 = 21;

        try {
            ss = new ServerSocket(PORT);
            ss2 = new ServerSocket(PORT2);

        } catch (IOException e) {
            System.out.println("IO Exception server connection!");
        }
        while (true) {
            try {
                s = ss.accept();
                s2 = ss2.accept();
                new ClientRequest(s, s2);
            } catch (IOException e) {
                System.out.println("I/O error: " + e);
                try {
                    s.close();
                    ss.close();
                } catch (IOException ex) {
                    Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        
    }

}
