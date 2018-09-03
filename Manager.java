package ClientServerModel;

import java.awt.Desktop;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Manager extends Login {
        DataOutputStream dout;
        DataInputStream dis;
        InputStream is;
        FileOutputStream fr;
        boolean fileRequest;
    
    Manager(String name) {
        initComponents();
        fileRequest = false;
        ClientStatus.setText(name);                 //Set username at the top of the GUI
    }    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        TableFiles = new javax.swing.JTable();
        Download = new javax.swing.JButton();
        Open = new javax.swing.JButton();
        FileName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        Request = new javax.swing.JButton();
        Close = new javax.swing.JButton();
        ClientStatus = new javax.swing.JLabel();
        Logout = new javax.swing.JButton();
        ProgressBar = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Client");

        TableFiles.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TableFiles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name"
            }
        ));
        jScrollPane2.setViewportView(TableFiles);

        Download.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Download.setText("Download");
        Download.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DownloadActionPerformed(evt);
            }
        });

        Open.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Open.setText("Open");
        Open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ENTER FILE NAME");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Request.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Request.setText("Request Files from Server");
        Request.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RequestActionPerformed(evt);
            }
        });

        Close.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Close.setText("Close connection");
        Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseActionPerformed(evt);
            }
        });

        ClientStatus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ClientStatus.setForeground(new java.awt.Color(255, 0, 51));
        ClientStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ClientStatus.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Logout.setText("Logout");
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });

        ProgressBar.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                ProgressBarStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Progress");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel2.setInheritsPopupMenu(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(ClientStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(126, 126, 126)
                        .addComponent(Logout))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(Request, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                        .addGap(65, 65, 65)
                        .addComponent(Close, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)))
                .addGap(41, 41, 41))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FileName)
                            .addComponent(ProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Open, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Download, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ClientStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Logout))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Request, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Close, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Open, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(Download, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(FileName, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(716, 439));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void OpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenActionPerformed
            try {
                Desktop.getDesktop().open(new File("C:\\Users\\user\\Documents\\NetBeansProjects\\ClientServer\\src\\ClientServerModel\\Java\\download"));
            } catch (IOException ex) {
                Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_OpenActionPerformed

    private void DownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DownloadActionPerformed
        if(fileRequest) {
            try {
                String sendFileName = this.FileName.getText();                  //Get the input file name

                //Extract the extension of file from entered file name
                String ext = "";
                if(sendFileName.lastIndexOf(".") != -1 && sendFileName.lastIndexOf(".") != 0)
                    ext = sendFileName.substring(sendFileName.lastIndexOf(".")+1);
                
                //check the extension of file
                if(ext.equals("txt") || ext.equals("exe") || ext.equals("jpg") || ext.equals("png")) {
                    
                    dout = new DataOutputStream(socket.getOutputStream());
                    dout.writeUTF("download file");                             //send request to server for download file
                    dout.writeUTF(sendFileName);                                //send file name to server
                    dis = new DataInputStream(socket.getInputStream());
                    String exist = (String) dis.readUTF();                      //get acknowledgement from the server if file exist
                    if(exist.equals("file does not exists")) {
                        JFrame frame = new JFrame("Error");
                        JOptionPane.showMessageDialog(frame, "File does not exist in server!");
                    }
                    else {
                        String imagePath = "C:\\Users\\user\\Documents\\NetBeansProjects\\ClientServer\\src\\ClientServerModel\\Java\\download\\" +sendFileName;
                        dis = new DataInputStream(socket.getInputStream());
                        File file = new File(imagePath);
                        int len = dis.readInt();
                        byte[] b = new byte[len];
                        FileOutputStream fos = new FileOutputStream(file);
                        dis.readFully(b);
                        fos.write(b, 0 , b.length);
                        fos.flush();
                        ProgressBar.setValue(100);

                        JFrame frame = new JFrame("Message");
                        JOptionPane.showMessageDialog(frame, "File downloaded!");
                        ProgressBar.setValue(0);
                    }
                }

                else {
                    JFrame frame = new JFrame("Error");
                    JOptionPane.showMessageDialog(frame, "Invalid File name!");
                }
            }
            catch (IOException exception) {
                System.out.println("IO Exception!");
            }
            catch (NullPointerException e){
                System.out.println("Null pointer...");
            }
        }
        else {
            JFrame frame = new JFrame("Error");
            JOptionPane.showMessageDialog(frame, "You have not requested for files!");
        }
    }//GEN-LAST:event_DownloadActionPerformed

    private void RequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RequestActionPerformed
        if(!fileRequest) {
        try {
            dout = new DataOutputStream(socket.getOutputStream());
            dout.writeUTF("list of file");
            String temp = "C:\\Users\\user\\Documents\\NetBeansProjects\\ClientServer\\src\\ClientServerModel\\Java\\temp.txt";

            dis = new DataInputStream(socket.getInputStream());
            File file = new File(temp);
            int len = dis.readInt();
            byte[] b = new byte[len];
            FileOutputStream fos = new FileOutputStream(file);
            dis.readFully(b);
            fos.write(b, 0 , b.length);
            fos.flush();
            
            DefaultTableModel model = (DefaultTableModel)TableFiles.getModel();
            model.setColumnIdentifiers(new String[]{"Files Names"});
            Object[] row = new Object[1];
            
            BufferedReader br = new BufferedReader(new FileReader(temp));
            String line;
            while((line=br.readLine()) != null) {
                row[0] = line;
                model.addRow(row);
            }
            fileRequest = true;
        }
        catch(IOException e) {
            System.out.println("IO Exception!");
        }
        }
    }//GEN-LAST:event_RequestActionPerformed

    private void CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseActionPerformed
            try {
                socket.close();
                System.exit(0);
            } catch (IOException ex) {
                Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_CloseActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        this.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_LogoutActionPerformed

    private void ProgressBarStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_ProgressBarStateChanged
        ProgressBar.setStringPainted(true);
    }//GEN-LAST:event_ProgressBarStateChanged

    public static void main(String args[]) {
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ClientStatus;
    private javax.swing.JButton Close;
    private javax.swing.JButton Download;
    private javax.swing.JTextField FileName;
    private javax.swing.JButton Logout;
    private javax.swing.JButton Open;
    private javax.swing.JProgressBar ProgressBar;
    private javax.swing.JButton Request;
    private javax.swing.JTable TableFiles;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

}
