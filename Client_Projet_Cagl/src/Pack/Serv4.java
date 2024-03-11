package Pack;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Properties;

import javax.naming.InitialContext;
import Pack.IService;
import Pack.Service;
import Pack.ServiceBean;

public class Serv4 {

    public static void main(String[] args) {
        ServerSocket s1 = null;

        try {
            s1 = new ServerSocket(2004);

            // Initialiser le contexte en dehors de la boucle
            Properties props = new Properties();
            props.put("java.naming.factory.url.pkgs","org.jboss.ejb.client.naming");
			 props.put("jboss.naming.client.ejb.context",true);
            InitialContext context = new InitialContext(props);
            
            int port = s1.getLocalPort(); // Récupérer le port local
            String ipAddress = s1.getInetAddress().getHostAddress(); // Récupérer l'adresse IP du serveur

            while (true) {
                System.out.println("Serveur Serv4 en attente...");
                Socket connexion1 = s1.accept();
                System.out.println("Serveur Intermediare accepted...");

                ObjectInputStream inClient = new ObjectInputStream(connexion1.getInputStream());

                String service = (String) inClient.readObject(); // Recevoir Service de Client
                String idClient = (String) inClient.readObject(); // Recevoir ID de Client

                System.out.println(service);
                System.out.println("client" + idClient);

                try {
                    IService in = (IService) context.lookup("ejb:/Serveur_Architecture_Projet_cagl/ServiceBean!Pack.IService");
                    
                    ServerDetails SD = in.rechercherServerDetails(1);
                    if(SD == null) {
                    	in.ajouterServerDetails(new ServerDetails(1,"Serv4",ipAddress,port));
                    }
                    // ... votre logique de traitement avec le bean EJB
                    /*in.ajouter(new Service(1, "Aymen", "khoukhi"));

                    in.ajouter(new Service(2, "LG", "10"));
                    in.ajouter(new Service(3, "SAMSUNG", "20"));
                    in.ajouter(new Service(4, "HP", "30"));

                    List<Service> L = in.listerTousLesServices();
                    for (int i = 0; i < L.size(); i++) {
                        System.out.println(L.get(i).toString());
                    }*/
                    
                    
                    Service s;
                    switch(service) {
                    case "S10":
                    	      s = in.rechercherService(10);
                    	      //if (s != null) System.out.println(s.toString());
                    	      try {
                    	    	  /*------------------ send request to ServerInter(TCP)----------------------------*/
             	                  Socket Sinter = new Socket("localhost",1099);
             	                  System.out.println("connected to server ServInter...");
             	
             	                  ObjectOutputStream out1ServInter = new ObjectOutputStream(Sinter.getOutputStream());
             	                  if(s == null) {out1ServInter.writeObject("");}
         	                      else {
         	                      out1ServInter.writeObject(s.toString());
         	                      }
             	                  
             	                  Sinter.close();
             	                  out1ServInter.close();
                
                
                                  /*------------------ send request to ServerInter(TCP)----------------------------*/
                          	      }catch(Exception e) {System.out.println(e.toString());}
                    	      break;
                    	     
                    case "S11":
                    	      s = in.rechercherService(11);
              	              //if (s != null) System.out.println(s.toString());
              	            try {
              	            	/*------------------ send request to ServerInter(TCP)----------------------------*/
           	                  Socket Sinter = new Socket("localhost",1099);
           	                  System.out.println("connected to server ServInter...");
           	
           	                  ObjectOutputStream out1ServInter = new ObjectOutputStream(Sinter.getOutputStream());
           	                  if(s == null) {out1ServInter.writeObject("");}
       	                      else {
       	                      out1ServInter.writeObject(s.toString());
       	                      }
           	                  
           	                  Sinter.close();
           	                  out1ServInter.close();
              
              
                                /*------------------ send request to ServerInter(TCP)----------------------------*/
                        	}catch(Exception e) {System.out.println(e.toString());}
              	              break;
                    case "S12":
                    	      s = in.rechercherService(12);
        	                  //if (s != null) System.out.println(s.toString());
        	                  try {
        	                	  /*------------------ send request to ServerInter(TCP)----------------------------*/
             	                  Socket Sinter = new Socket("localhost",1099);
             	                  System.out.println("connected to server ServInter...");
             	
             	                  ObjectOutputStream out1ServInter = new ObjectOutputStream(Sinter.getOutputStream());
             	                  if(s == null) {out1ServInter.writeObject("");}
         	                      else {
         	                      out1ServInter.writeObject(s.toString());
         	                      }
             	                  
             	                  Sinter.close();
             	                  out1ServInter.close();
                
                
                                  /*------------------ send request to ServerInter(TCP)----------------------------*/
                          	 }catch(Exception e) {System.out.println(e.toString());}
        	                  break;
                    }

                    

                } catch (Exception e) {
                    e.printStackTrace();
                }
                // Pas besoin de fermer explicitement inClient ou connexion1
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            try {
                if (s1 != null && !s1.isClosed()) {
                    s1.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
