/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ppe3;

/**
 *
 * @author enzoc
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe d'accès aux données contenant des membres statiques afin de manipuler
 * la BDD ON implémente ici le Design Pattern Singleton
 *
 * @author nc
 */
public class DaoSIO {

    /**
     * Membres static (de classe)
     *
     */
    private static String nomServeur = "10.0.10.133((";/*à corriger si c'est faux ou différent*/
    private static String port = "8083";
    private static String nomBdd = "zozo";
    private static String nomUtilisateur = "zozo";
    private static String motDePasse = "zozo";

    private static String chaineConnexion;

    //propriété non statique
    private Connection connexion;

    private static DaoSIO monDao = null;

    /**
     * Constructeur privé. Pour construire un objet, il faut utiliser la
     * méthode publique statique getDaoSIO
     *
     */
    private DaoSIO() {
        try {
            //Définition de l'emplacement de la BDD
            DaoSIO.chaineConnexion = "jdbc:mysql://10.0.10.133:" + DaoSIO.nomServeur + "/" + DaoSIO.nomBdd;

            //Création de la connexion à la BDD
            this.connexion = (Connection) DriverManager.getConnection(DaoSIO.chaineConnexion, DaoSIO.nomUtilisateur, DaoSIO.motDePasse);

        } catch (SQLException ex) {
            Logger.getLogger(DaoSIO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public static Connection getConnection()
    {
        Connection cnx = null;
        
        MysqlDataSource datasource = new MysqlDataSource();
        
        datasource.setServerName(servername);
        datasource.setUser(username);
        datasource.setPassword(password);
        datasource.setDatabaseName(dbname);
        datasource.setPortNumber(portnumber);
        
        cnx = datasource.getConnection();
        
        return cnx;
    }

    /**
     * Permet d'obtenir l'objet instancié
     * @return un Objet DaoSIO avec connexion active ... pour une certaine durée
     */
    public static DaoSIO getInstance() {

        if (DaoSIO.monDao==null ) {
            DaoSIO.monDao = new DaoSIO();
        }else{
            if(!DaoSIO.monDao.connexionActive()){
            DaoSIO.monDao = new DaoSIO();    
            }
        }
        return DaoSIO.monDao;
    }

    public Boolean connexionActive() {
        Boolean connexionActive = true;
        try {
            if (this.connexion.isClosed()) {
                connexionActive = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoSIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connexionActive;
    }
/**
 * 
 * @param sql, comportera un ordre selec
 * @return 
 */
    public ResultSet requeteSelection(String sql){
   
        try {
            Statement requete=new DaoSIO().connexion.createStatement();
            return requete.executeQuery(sql);
           
        } catch (SQLException ex) {
            Logger.getLogger(DaoSIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
       
    }
    /**
     * 
     * @param sql, comportera un ordre insert, update, select, alter, etc.
     * @return le nombre de lignes impactées par la requête action
     * 
     */
      public Integer requeteAction(String sql){
   
        try {
            Statement requete=new DaoSIO().connexion.createStatement();
            return requete.executeUpdate(sql);
           
        } catch (SQLException ex) {
            Logger.getLogger(DaoSIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
       
    }  
}
