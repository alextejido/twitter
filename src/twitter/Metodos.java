/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.*;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;


/**
 *
 * @author Alex
 */
public class Metodos {
   

    static ConfigurationBuilder cb;
    static Twitter twitter;
    static Status status;
    static DirectMessage message;
    static ArrayList <Status> twits = new ArrayList<Status>();
    static Iterator <Status>it = twits.iterator();
    /**
     * Permission to use twiter
     */
    public Metodos() {
        
    }
    /**
     * Method to access the api
     */
    public static void conexion(){
        
        cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey("HM2EWw6abBIbfqcyi8CGL9CRW");
        cb.setOAuthConsumerSecret("KhekAUCcCGZ6Me4dRtoDp5faeqiEw34z9bvDT2lAN1lmbdHU6s");
        cb.setOAuthAccessToken("2987504416-JR7fYucp8VuUEkuH9DiloAK9jqnfyWuI3ZRG0dl");
        cb.setOAuthAccessTokenSecret("LhrTvDfdvSjeh3nygEo2BYmi2a3UtoxyDacIOwIK4r8Zz");
        TwitterFactory tf = new TwitterFactory(cb.build());
        twitter = tf.getInstance();
    }
/**
 * Method to get the twitter timeline
 */
    public static void lineaTiempo() {

        List<Status> statuses = null;

        try {
            statuses = twitter.getHomeTimeline();
        } catch (TwitterException ex) {
            java.util.logging.Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
            System.out.println("Showing home timeline.");
            for (Status status : statuses) {
                System.out.println(status.getUser().getName() + ":"
                        + status.getText());
                twits.add(status);
            }
    }
/**
 * Method to post a new twit
 * @param latestStatus message to new twit
 */
    public static void twittear(String latestStatus) {

        try {
            status = twitter.updateStatus(latestStatus);
            System.out.println("Successfully updated the status to [" + status.getText() + "].");
        } catch (TwitterException ex) {
            java.util.logging.Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
/**
 * Seach for twits
 * 
 * @param busqueda name of the twit you are looking for
 */
    public static void buscartwitt(String busqueda) {

        Query query = new Query(busqueda);
        QueryResult result;
        try {
            result = twitter.search(query);
            for (Status status : result.getTweets()) {
                System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
                
            }
        } catch (TwitterException ex) {
            java.util.logging.Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Method to send a md
     *
     * @param destinatario profile that will recive the md
     * 
     * @param mensaje messege to send
     */
    public static void enviarMensaje(String destinatario, String mensaje) {

        try {

            message = twitter.sendDirectMessage(destinatario, mensaje);
        } catch (TwitterException ex) {
            java.util.logging.Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Sent: " + message.getText() + " to @" + message.getRecipientScreenName());

    }
    
}
