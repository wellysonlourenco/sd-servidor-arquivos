/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.edu.ifms.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FormServidor extends javax.swing.JFrame {
    
    private static final String diretorio_compartilhado = "diretorio_compartilhado"; //informa o diretorio

    /**
     * Creates new form FormServidor
     */
    public FormServidor() {
        initComponents();

        File compartilhadosDir = new File(diretorio_compartilhado);
        compartilhadosDir.mkdirs(); // cria um se nao existir

    }

    class servidor extends Thread {

        public void run() { //aguarda o start do jButton1 pra iniciar o servidor
            jTextArea1.append("Criando o Servidor socket...\n");

            try {
                ServerSocket serverSocket = new ServerSocket(2345); //roda no socket informado
                jTextArea1.append("Servidor rodando na porta 2345\n");

                while (true) {
                    jTextArea1.append("Aguardando conexao de cliente...\n");
                    Socket socket = serverSocket.accept();
                    jTextArea1.append("Conexao está aberto com o cliente:" + socket.getInetAddress().toString() + "\n");

                    try {
                        BufferedReader entradaTexto = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        String comando = entradaTexto.readLine(); //aguarda a solicitação do cliente

                        if (comando != null) {
                            if (comando.equals("INDEX")) { //validação entrada do cliente INDEX ou GET
                                // Envia a lista de nomes de arquivos disponíveis
                                File compartilhadosDir = new File(diretorio_compartilhado);
                                File[] arquivos = compartilhadosDir.listFiles();
                                StringBuilder fileList = new StringBuilder();
                                for (File arquivo : arquivos) {
                                    fileList.append(arquivo.getName()).append("\n");
                                }
                                BufferedWriter saidaTexto = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                                saidaTexto.write(fileList.toString());
                                saidaTexto.newLine();
                                saidaTexto.flush();

//                            jTextArea1.append("\nListando Arquivos para o cliente" + socket.getInetAddress().toString() + "\n");
//                            String[] arquivos = compartilhadosDir.list();
//                            if (arquivos != null) {
//                                PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
//                                for (String arquivo : arquivos) {
//                                    printWriter.println(arquivo);
//                                }
//
//                            }
                            } else if (comando.startsWith("GET ")) {
                                // Extrai o nome do arquivo do comando
                            String arquivoNome = comando.substring(4); //recebe o GET .TEXTOdoDownload

                            File arquivo = new File(diretorio_compartilhado, arquivoNome);
                            if (arquivo.exists()) {
                                // Envia "OK" como mensagem de confirmação
                                PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
                                jTextArea1.append("\nArquivo encontrado, respondendo o cliente: " + socket.getInetAddress().toString() + "\n");
                                printWriter.println("OK");

                                // Envia o conteúdo do arquivo
                                FileInputStream fileInputStream = new FileInputStream(arquivo);
                                byte[] buffer = new byte[8192];
                                OutputStream outputStream = socket.getOutputStream();
                                int bytesRead;
                                while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                                    outputStream.write(buffer, 0, bytesRead);
                                }
                                fileInputStream.close(); //finaliza a transferencia
                                jTextArea1.append("OK");
                                //outputStream.close();


                            } else {
                                // Envia "ERROR" como mensagem de erro
                                PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
                                printWriter.println("ERROR: Arquivo não encontrado");
                            }
                        }
                    }

                }catch (Exception e) {
                        
                    }

                socket.close();
            }

        }
        catch (IOException ex

        
            ) {
                Logger.getLogger(FormServidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel1.setText("Servidor");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("Iniciar Servidor");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jButton1)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jTextArea1.setText("");
        new servidor().start();
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormServidor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
