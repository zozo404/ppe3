/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
A AFFACER SI INUTILE
 */
package com.mycompany.ppe3;

/**
 *
 * @author enzoc
 */
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class DiagLogin extends JFrame implements ActionListener{

        // On retrouve ici beaucoup de variables qui auraient pue se trouver uniquement dans le constructeur ..
        private static final long serialVersionUID = 1l;
        private JTextField tfLogin = new JTextField();
        private JPasswordField pfPassWord = new JPasswordField();
        private JButton bOk = new JButton("login");
        private GridBagLayout gbl = new GridBagLayout();
        private JLabel lbLogin = new JLabel("Login : ");
        private JLabel lbPassWord = new JLabel("Password : ");
       
        public DiagLogin(){
                super("Login");
                this.setLayout(gbl);
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.fill = GridBagConstraints.BOTH;
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.weightx = 1;
                gbc.weighty = 1;
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
                gbc.insets = new Insets(5,10,2,0);
               
                gbl.setConstraints(this.lbLogin, gbc);
                this.add(this.lbLogin);

                gbc.insets = new Insets(5,0,2,10);
                gbc.gridx = 1;
                gbc.weightx = 5;
                gbl.setConstraints(this.tfLogin, gbc);
                this.add(this.tfLogin);

                gbc.insets = new Insets(0,10,2,0);
                gbc.gridx =0;
                gbc.gridy = 1;
                gbc.weightx = 1;
                gbl.setConstraints(this.lbPassWord, gbc);
                this.add(this.lbPassWord);

                gbc.insets = new Insets(0,0,2,10);
                gbc.gridx =1;
                gbc.weightx = 5;
                gbl.setConstraints(this.pfPassWord, gbc);
                this.add(this.pfPassWord);
               
                gbc.gridx =0;
                gbc.gridy = 2;
                gbc.gridwidth =2;
                gbc.weightx = 1;
                gbc.insets = new Insets(10,50,5,50);
                this.bOk.addActionListener(this);
                gbl.setConstraints(this.bOk, gbc);
                this.add(this.bOk);
               
                this.setResizable(false);
                this.setSize(200, 110);
                this.setVisible(true);
        }
       
        public void actionPerformed(ActionEvent e){
                HashMap<String,String> hmLoginPass = new HashMap<String,String>();
                hmLoginPass.put("Sateth", "pass");
                String pass = new String(this.pfPassWord.getPassword());
                String login = this.tfLogin.getText().trim();
                if(!hmLoginPass.containsKey(login))
                        return;
                if(hmLoginPass.get(login).equals(pass)){
                        this.dispose();
                        new Prog().setVisible(true); // On admet que Prog est la classe creant notre Interface
                }
               
        }

}
