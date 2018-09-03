package ClientServerModel;

import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {
    public static Socket socket;        //it will use for request transfer
    public static Socket socket2;       //it will use for data transfer
    private boolean connect;
    private boolean login;
    
    Login() {               //constuctor which will invoke when the login class object is created
        initComponents();   //call gui components
        connect=false;
        login=false;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Port = new javax.swing.JTextField();
        Login = new javax.swing.JButton();
        Status = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Password = new javax.swing.JPasswordField();
        IP = new javax.swing.JTextField();
        Username = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Connect = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        Port2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Client");

        Port.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Port.setText("20");
        Port.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PortActionPerformed(evt);
            }
        });

        Login.setText("Login");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });

        Status.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Status.setText("Status -> Server not connected");
        Status.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Port Number");

        Password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Password.setText("123");

        IP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        IP.setText("192.168.43.36");
        IP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IPActionPerformed(evt);
            }
        });

        Username.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Username.setText("sumit");
        Username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsernameActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("IP Address");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Username");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Password");

        Connect.setText("Connect");
        Connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConnectActionPerformed(evt);
            }
        });

        Port2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Port2.setText("21");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Port, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Port2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Connect, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(IP, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(143, 143, 143))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Status, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Status, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Port)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(48, 48, 48)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Username))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Login, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Password, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(Port2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Connect))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(75, 75, 75))
        );

        setSize(new java.awt.Dimension(716, 439));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void PortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PortActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PortActionPerformed

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
        if(connect) {
                //Get the content from Textfield
            String uname = this.Username.getText();                                             
            String pword = this.Password.getText();
            
                //Check if username and password field is not empty
            if(!uname.isEmpty() && !pword.isEmpty()) {                                          
                try {
                        //create a new output data stream object
                    DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
                        //send the login reqest to the server
                    dout.writeUTF("login");                                                     

                        //send username to the server for authentication
                    dout.writeUTF(uname);
                        //send password to the server for authentication
                    dout.writeUTF(pword);

                        //create a new output data stream object
                    DataInputStream in = new DataInputStream(socket.getInputStream());
                        //get the responce from server if username password is correct
                    if(((String)in.readUTF()).equals("Username Password is Correct!")) {
                        login = true;
                    }
                    //Display error message if username password is incorrect
                    else {                                                                      
                        JFrame frame = new JFrame("Error");
                        JOptionPane.showMessageDialog(frame, "Invalid Details!");
                    }
                }
                catch (FileNotFoundException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                catch (IOException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }

                finally {
                    if(login) {
                        this.dispose();
                        new Manager(uname).setVisible(true);    //user successfully logged in
                    }
                }
            }
            
            //display error messagge if username and password filed is empty
            else {                                                                              
                JFrame frame = new JFrame("Error");
                JOptionPane.showMessageDialog(frame, "Usename and password can not be empty!");
            }
        }
        //display error messagge if server not started
        else {
            JFrame frame = new JFrame("Error");
            JOptionPane.showMessageDialog(frame, "Server not connected!");
        }
    }//GEN-LAST:event_LoginActionPerformed

    private void IPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IPActionPerformed

    private void UsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsernameActionPerformed

    private void ConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConnectActionPerformed
            if(!connect) {                              //if user is not connected
            String ip = this.IP.getText();              //get the IP from text field
            String port = this.Port.getText();          //get the port from text field
            String port2 = this.Port2.getText();
            
            if(!ip.isEmpty() && !port.isEmpty() && !port2.isEmpty()){       //check if ip and port field is not empty
                try {
                    int p = Integer.parseInt(port);
                    int p2 = Integer.parseInt(port2);
                    socket = new Socket(ip, p);         //create new Socket object
                    socket2 = new Socket(ip, p2);       //create new Socket object
                    Connect.setText("Disconnect");      //set connet button to disconnect
                    IP.setEditable(false);              //when client is connected to server set false to ip field
                    Port.setEditable(false);
                    Port2.setEditable(false);
                    Status.setText("Status -> Connected");
                    connect=true;
                }
                catch (IOException ex) {                //Display error message if server not started
                    System.out.println("Login IO Exception!");
                    JFrame frame = new JFrame("Error");
                    JOptionPane.showMessageDialog(frame, "Server not connected!");
                }
            }
        }
        else {                                          //if user is connected
            try {
                Connect.setText("Connect");
                IP.setEditable(true);
                Port.setEditable(true);
                Port2.setEditable(true);
                Status.setText("Status -> Server not connected");
                socket.close();
                socket2.close();
                connect = false;
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_ConnectActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);               //set login gui visible
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Connect;
    private javax.swing.JTextField IP;
    private javax.swing.JButton Login;
    private javax.swing.JPasswordField Password;
    private javax.swing.JTextField Port;
    private javax.swing.JTextField Port2;
    private javax.swing.JLabel Status;
    private javax.swing.JTextField Username;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
