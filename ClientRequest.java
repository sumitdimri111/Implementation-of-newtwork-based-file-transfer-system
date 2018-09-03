package ClientServerModel;

import java.io.*;
import java.net.Socket;

public class ClientRequest extends Server {
    
    protected Socket soc;
    protected Socket soc2;
    ClientRequest(Socket clientSocket, Socket clientSocket2) {
        this.soc = clientSocket;
        this.soc2 = clientSocket2;
        StatusDesign.setServerStatus("New client connected to the Server");
        System.out.println("New client connected to the Server");
        System.out.println(soc);
        System.out.println(soc2);
        new temp().start();
    }

    class temp extends Thread {
        temp() {}

        @Override
        public void run() {
            DataOutputStream dout;
            BufferedReader br;
            DataInputStream in;

            String uname = "", pword = "";

            try {
                    in = new DataInputStream(soc.getInputStream());
                    dout = new DataOutputStream(soc.getOutputStream());

                while(true) {
                    System.out.println("Waiting for client request...");
                    String request = (String)in.readUTF();                      //Accept the client request
                    
                    StatusDesign.setServerStatus(uname +" requested for " +request);    //Set server status for clint
                
                    //check if client request for login and validate user
                    if(request.equals("login")) {
                        uname = (String)in.readUTF();
                        pword = (String)in.readUTF();

                        int test = 0;
                        String line;
                        String file = "C:\\Users\\user\\Documents\\NetBeansProjects\\ClientServer\\src\\ClientServerModel\\Java\\users.txt";
                        br = new BufferedReader(new FileReader(file));
                        while((line=br.readLine()) != null) {
                            String []check = line.split("\\s");
                            if(check[0].equals(uname) && check[1].equals(pword)) {
                                dout.writeUTF("Username Password is Correct!");
                                StatusDesign.setServerStatus(uname +" logged in to the Server");
                                test = 1;
                                break;
                            }
                        }
                        if(test == 0) {
                            dout = new DataOutputStream(soc.getOutputStream());
                            dout.writeUTF("Username Password is Incorrect!");
                        }
                    }
                    
                    //check if client request for List of file
                    if(request.equals("list of file")) {
                        String temp = "C:\\Users\\user\\Documents\\NetBeansProjects\\ClientServer\\src\\ClientServerModel\\Java\\data\\" +uname +".txt";
                        DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
                        File file = new File(temp);
                        byte[] b = new byte[(int) file.length()];
                        try (FileInputStream fis = new FileInputStream(file)) {
                            fis.read(b);
                        }
                        dos.writeInt((int) file.length());
                        dos.flush();
                        dos.write(b, 0, b.length);
                        dos.flush();
                    }
                    
                    //check if client request for download file
                    if(request.equals("download file")) {
                        in = new DataInputStream(soc.getInputStream());
                        String readFileName = (String)in.readUTF();
                        
                        StatusDesign.setServerStatus(uname +" requested for " +request +" " +readFileName);
                        
                        String ext = "";
                        if(readFileName.lastIndexOf(".") != -1 && readFileName.lastIndexOf(".") != 0)
                            ext = readFileName.substring(readFileName.lastIndexOf(".")+1);

                        String filePath = "C:\\Users\\user\\Documents\\NetBeansProjects\\ClientServer\\src\\ClientServerModel\\Java\\files\\" +readFileName;

                        //Check if file exist in the server
                        File f = new File(filePath);
                        if(!f.exists()) {
                            dout.writeUTF("file does not exists");
                            continue;
                        }
                        dout.writeUTF("file exists");

                        //Send file to the client
                        if(ext.equals("txt") || ext.equals("exe") ||ext.equals("jpg") || ext.equals("png")) {
                            DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
                            File file = new File(filePath);
                            byte[] b = new byte[(int) file.length()];
                            try (FileInputStream fis = new FileInputStream(file)) {
                                fis.read(b);
                            }
                            dos.writeInt((int) file.length());
                            dos.flush();
                            dos.write(b, 0, b.length);
                            dos.flush();
                        }
                    }
                }
            }
            catch (IOException e) {
                try {
                    //Close socket connection when exited
                    soc.close();
                    soc2.close();
                    System.out.println("Server Closed!");
                }
                catch(IOException ex) {
                }
                System.out.println("Server IO Exception!");
            }
        }
    }
    
    public static void main(String[] args) {
    }

}
