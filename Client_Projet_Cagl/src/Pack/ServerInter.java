package Pack;

import java.rmi.RemoteException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.net.ServerSocket;
import java.net.Socket;
	public class ServerInter extends java.rmi.server.UnicastRemoteObject implements InterfaceInter{
		private static final long serialVersionUID = 1L;
		
		public ServerInter() throws RemoteException {System.out.println("Serveur RMI..");}
		
		public String processRequest(int id, String referenceChain, String request) throws RemoteException{
	        // Faites quelque chose avec la chaîne, par exemple, l'afficher côté serveur
	        //System.out.println("les services demandes par le client"+id+" Sont "+ referenceChain+" ...Request ="+request);
	        
	        // Logique pour surveiller le jeton et rediriger les requêtes
	        // ...
	        System.out.println(request);
	        
	        if(request.equals("S0")) {
	        	                      try{
					
					                     /*------------------ send request to Serv1(TCP)----------------------------*/
					                     Socket s1 = new Socket("localhost",2001);
					                     System.out.println("connected to server Serv1...");
					
					                     ObjectOutputStream outServ1 = new ObjectOutputStream(s1.getOutputStream());
					                     String stringID = Integer.toString(id);
					                     outServ1.writeObject(request);
					                     outServ1.writeObject(stringID);
					                     
					                     
					                     s1.close();
				                         outServ1.close();
				    
				                         /*------------------ send request to Serv1(TCP)----------------------------*/
				                         
				                         /*------------------ receive request from Serv1(TCP)----------------------------*/
				                         ServerSocket S1 = new ServerSocket(1099);
				             	         System.out.println("Serveur ServInter en attente...");
				                         Socket connexion1 = S1.accept();
				                         System.out.println("Server1 accepted...");

				                         ObjectInputStream inServ1 = new ObjectInputStream(connexion1.getInputStream());

				                         String service = (String) inServ1.readObject(); // Recevoir Service de service

				                         System.out.println(service);
				                         S1.close();
				                         connexion1.close();
				                         inServ1.close();
				                         return service;
				                         /*------------------ receive request from Serv1(TCP)----------------------------*/
				                         
				                        }catch(Exception e){System.out.println(e.toString());}
	                                  
	        }else  if(request.equals("S1")) {
                try{

                   /*------------------ send request to Serv1(TCP)----------------------------*/
                   Socket s1 = new Socket("localhost",2001);
                   System.out.println("connected to server Serv1...");

                   ObjectOutputStream outServ1 = new ObjectOutputStream(s1.getOutputStream());

                   String stringID = Integer.toString(id);
                   outServ1.writeObject(request);
                   outServ1.writeObject(stringID);
                   
                   s1.close();
                   outServ1.close();


                   /*------------------ send request to Serv1(TCP)----------------------------*/
                   
                   /*------------------ receive request from Serv1(TCP)----------------------------*/
                   ServerSocket S1 = new ServerSocket(1099);
       	           System.out.println("Serveur ServInter en attente...");
                   Socket connexion1 = S1.accept();
                   System.out.println("Server1 accepted...");

                   ObjectInputStream inServ1 = new ObjectInputStream(connexion1.getInputStream());

                   String service = (String) inServ1.readObject(); // Recevoir Service de service

                   System.out.println(service);
                   S1.close();
                   connexion1.close();
                   inServ1.close();
                   return service;
                   /*------------------ receive request from Serv1(TCP)----------------------------*/
                  }catch(Exception e){System.out.println(e.toString());}
                  
                  
	        }else  if("S2".equals(request)) {
                try{

                   /*------------------ send request to Serv1(TCP)----------------------------*/
                   Socket s1 = new Socket("localhost",2001);
                   System.out.println("connected to server Serv1...");

                   ObjectOutputStream outServ1 = new ObjectOutputStream(s1.getOutputStream());

                   String stringID = Integer.toString(id);
                   outServ1.writeObject(request);
                   outServ1.writeObject(stringID);
                   
                   s1.close();
                   outServ1.close();


                   /*------------------ send request to Serv1(TCP)----------------------------*/
                   
                   /*------------------ receive request from Serv1(TCP)----------------------------*/
                   ServerSocket S1 = new ServerSocket(1099);
       	           System.out.println("Serveur ServInter en attente...");
                   Socket connexion1 = S1.accept();
                   System.out.println("Server1 accepted...");

                   ObjectInputStream inServ1 = new ObjectInputStream(connexion1.getInputStream());

                   String service = (String) inServ1.readObject(); // Recevoir Service de service

                   System.out.println(service);
                   S1.close();
                   connexion1.close();
                   inServ1.close();
                   return service;
                   /*------------------ receive request from Serv1(TCP)----------------------------*/
                  }catch(Exception e){System.out.println(e.toString());}
                  
                  
	        }else  if("S3".equals(request)) {
                try{

                   /*------------------ send request to Serv1(TCP)----------------------------*/
                   Socket s1 = new Socket("localhost",2001);
                   System.out.println("connected to server Serv1...");

                   ObjectOutputStream outServ1 = new ObjectOutputStream(s1.getOutputStream());

                   String stringID = Integer.toString(id);
                   outServ1.writeObject(request);
                   outServ1.writeObject(stringID);
                   
                   s1.close();
                   outServ1.close();


                   /*------------------ send request to Serv1(TCP)----------------------------*/
                   
                   /*------------------ receive request from Serv1(TCP)----------------------------*/
                   ServerSocket S1 = new ServerSocket(1099);
       	           System.out.println("Serveur ServInter en attente...");
                   Socket connexion1 = S1.accept();
                   System.out.println("Server1 accepted...");

                   ObjectInputStream inServ1 = new ObjectInputStream(connexion1.getInputStream());

                   String service = (String) inServ1.readObject(); // Recevoir Service de service

                   System.out.println(service);
                   S1.close();
                   connexion1.close();
                   inServ1.close();
                   return service;
                   /*------------------ receive request from Serv1(TCP)----------------------------*/
                  }catch(Exception e){System.out.println(e.toString());}
                  
	        }else  if("S4".equals(request)) {       
	        
	        	                      try{
				
	        	                    	  /*------------------ send request to Serv2(TCP)----------------------------*/
                                          Socket s2 = new Socket("localhost",2002);
                                          System.out.println("connected to server Serv2...");

                                          ObjectOutputStream outServ2 = new ObjectOutputStream(s2.getOutputStream());

                                          String stringID = Integer.toString(id);
                                          outServ2.writeObject(request);
                                          outServ2.writeObject(stringID);
                                          
                                          s2.close();
                                          outServ2.close();


                                          /*------------------ send request to Serv2(TCP)----------------------------*/
                                          
                                          /*------------------ receive request from Serv2(TCP)----------------------------*/
 				                          ServerSocket S2 = new ServerSocket(1099);
 				             	          System.out.println("Serveur ServInter en attente...");
 				                          Socket connexion2 = S2.accept();
 				                          System.out.println("Server2 accepted...");

 				                          ObjectInputStream inServ2 = new ObjectInputStream(connexion2.getInputStream());

 				                          String service = (String) inServ2.readObject(); // Recevoir Service de service

 				                          System.out.println(service);
 				                          S2.close();
 				                          connexion2.close();
 				                          inServ2.close();
 				                          return service;
 				                         /*------------------ receive request from Serv2(TCP)----------------------------*/
                                      }catch(Exception e){System.out.println(e.toString());}
	        	                       
	                                  
	        }else  if("S5".equals(request)) {      
		        
                try{

              	  /*------------------ send request to Serv2(TCP)----------------------------*/
                    Socket s2 = new Socket("localhost",2002);
                    System.out.println("connected to server Serv2...");

                    ObjectOutputStream outServ2 = new ObjectOutputStream(s2.getOutputStream());

                    String stringID = Integer.toString(id);
                    outServ2.writeObject(request);
                    outServ2.writeObject(stringID);
                    
                    s2.close();
                    outServ2.close();


                    /*------------------ send request to Serv2(TCP)----------------------------*/
                    /*------------------ receive request from Serv2(TCP)----------------------------*/
                     ServerSocket S2 = new ServerSocket(1099);
        	          System.out.println("Serveur ServInter en attente...");
                     Socket connexion2 = S2.accept();
                     System.out.println("Server2 accepted...");

                     ObjectInputStream inServ2 = new ObjectInputStream(connexion2.getInputStream());

                     String service = (String) inServ2.readObject(); // Recevoir Service de service

                     System.out.println(service);
                     S2.close();
                     connexion2.close();
                     inServ2.close();
                     return service;
                    /*------------------ receive request from Serv2(TCP)----------------------------*/
                }catch(Exception e){System.out.println(e.toString());}
                 
                
	        }else  if("S6".equals(request)) {       
		        
                try{

              	  /*------------------ send request to Serv2(TCP)----------------------------*/
                    Socket s2 = new Socket("localhost",2002);
                    System.out.println("connected to server Serv2...");

                    ObjectOutputStream outServ2 = new ObjectOutputStream(s2.getOutputStream());

                    String stringID = Integer.toString(id);
                    outServ2.writeObject(request);
                    outServ2.writeObject(stringID);
                    
                    s2.close();
                    outServ2.close();


                    /*------------------ send request to Serv2(TCP)----------------------------*/
                    
                    /*------------------ receive request from Serv2(TCP)----------------------------*/
                     ServerSocket S2 = new ServerSocket(1099);
        	          System.out.println("Serveur ServInter en attente...");
                     Socket connexion2 = S2.accept();
                     System.out.println("Server2 accepted...");

                     ObjectInputStream inServ2 = new ObjectInputStream(connexion2.getInputStream());

                     String service = (String) inServ2.readObject(); // Recevoir Service de service

                     System.out.println(service);
                     S2.close();
                     connexion2.close();
                     inServ2.close();
                     return service;
                    /*------------------ receive request from Serv2(TCP)----------------------------*/
                }catch(Exception e){System.out.println(e.toString());}
                 
                
	        }else  if("S7".equals(request)) {
	        	                      try{
					
	        	                    	  /*------------------ send request to Serv3(TCP)----------------------------*/
                                         Socket s3 = new Socket("localhost",2003);
                                         System.out.println("connected to server Serv3...");

                                         ObjectOutputStream outServ3 = new ObjectOutputStream(s3.getOutputStream());

                                         String stringID = Integer.toString(id);
                                         outServ3.writeObject(request);
                                         outServ3.writeObject(stringID);
                                         
                                         s3.close();
                                         outServ3.close();


                                         /*------------------ send request to Serv3(TCP)----------------------------*/
                                         /*------------------ receive request from Serv3(TCP)----------------------------*/
				                          ServerSocket S3 = new ServerSocket(1099);
				             	          System.out.println("Serveur ServInter en attente...");
				                          Socket connexion3 = S3.accept();
				                          System.out.println("Server3 accepted...");

				                          ObjectInputStream inServ3 = new ObjectInputStream(connexion3.getInputStream());

				                          String service = (String) inServ3.readObject(); // Recevoir Service de service

				                          System.out.println(service);
				                          S3.close();
				                          connexion3.close();
				                          inServ3.close();
				                          return service;
				                         /*------------------ receive request from Serv3(TCP)----------------------------*/
                                         }catch(Exception e){System.out.println(e.toString());}
                 
                                         
	        }else  if("S8".equals(request)) {
                try{

              	  /*------------------ send request to Serv3(TCP)----------------------------*/
                   Socket s3 = new Socket("localhost",2003);
                   System.out.println("connected to server Serv3...");

                   ObjectOutputStream outServ3 = new ObjectOutputStream(s3.getOutputStream());

                   String stringID = Integer.toString(id);
                   outServ3.writeObject(request);
                   outServ3.writeObject(stringID);
                   
                   s3.close();
                   outServ3.close();


                   /*------------------ send request to Serv3(TCP)----------------------------*/
                   /*------------------ receive request from Serv3(TCP)----------------------------*/
                   ServerSocket S3 = new ServerSocket(1099);
      	          System.out.println("Serveur ServInter en attente...");
                   Socket connexion2 = S3.accept();
                   System.out.println("Server3 accepted...");

                   ObjectInputStream inServ3 = new ObjectInputStream(connexion2.getInputStream());

                   String service = (String) inServ3.readObject(); // Recevoir Service de service

                   System.out.println(service);
                   S3.close();
                   connexion2.close();
                   inServ3.close();
                   return service;
                  /*------------------ receive request from Serv3(TCP)----------------------------*/
                   }catch(Exception e){System.out.println(e.toString());}

                  
	        }else  if("S9".equals(request)) {
                try{

              	  /*------------------ send request to Serv3(TCP)----------------------------*/
                   Socket s3 = new Socket("localhost",2003);
                   System.out.println("connected to server Serv3...");

                   ObjectOutputStream outServ3 = new ObjectOutputStream(s3.getOutputStream());

                   String stringID = Integer.toString(id);
                   outServ3.writeObject(request);
                   outServ3.writeObject(stringID);
                   
                   s3.close();
                   outServ3.close();


                   /*------------------ send request to Serv3(TCP)----------------------------*/
                   /*------------------ receive request from Serv3(TCP)----------------------------*/
                   ServerSocket S3 = new ServerSocket(1099);
      	          System.out.println("Serveur ServInter en attente...");
                   Socket connexion2 = S3.accept();
                   System.out.println("Server3 accepted...");

                   ObjectInputStream inServ3 = new ObjectInputStream(connexion2.getInputStream());

                   String service = (String) inServ3.readObject(); // Recevoir Service de service

                   System.out.println(service);
                   S3.close();
                   connexion2.close();
                   inServ3.close();
                   return service;
                  /*------------------ receive request from Serv3(TCP)----------------------------*/
                   }catch(Exception e){System.out.println(e.toString());}

                   
	        	                
	        }else  if("S10".equals(request)) {
	        	           
	        	                        try{
					
	        	                        	/*------------------ send request to Serv4(TCP)----------------------------*/
                                           Socket s4 = new Socket("localhost",2004);
                                           System.out.println("connected to server Serv4...");

                                           ObjectOutputStream outServ4 = new ObjectOutputStream(s4.getOutputStream());

                                           String stringID = Integer.toString(id);
                                           outServ4.writeObject(request);
                                           outServ4.writeObject(stringID);
                                           
                                           s4.close();
                                           outServ4.close();


                                           /*------------------ send request to Serv4(TCP)----------------------------*/
                                           
                                           /*------------------ receive request from Serv4(TCP)----------------------------*/
 				                          ServerSocket S4 = new ServerSocket(1099);
 				             	          System.out.println("Serveur ServInter en attente...");
 				                          Socket connexion4 = S4.accept();
 				                          System.out.println("Server4 accepted...");

 				                          ObjectInputStream inServ4 = new ObjectInputStream(connexion4.getInputStream());

 				                          String service = (String) inServ4.readObject(); // Recevoir Service de service

 				                          System.out.println(service);
 				                          S4.close();
 				                          connexion4.close();
 				                          inServ4.close();
 				                          return service;
 				                         /*------------------ receive request from Serv4(TCP)----------------------------*/
                                       }catch(Exception e){System.out.println(e.toString());}

                                       
	        }else  if("S11".equals(request)) {
 	           
                try{

                	/*------------------ send request to Serv4(TCP)----------------------------*/
                   Socket s4 = new Socket("localhost",2004);
                   System.out.println("connected to server Serv4...");

                   ObjectOutputStream outServ4 = new ObjectOutputStream(s4.getOutputStream());

                   String stringID = Integer.toString(id);
                   outServ4.writeObject(request);
                   outServ4.writeObject(stringID);
                   
                   s4.close();
                   outServ4.close();


                   /*------------------ send request to Serv4(TCP)----------------------------*/
                   
                   /*------------------ receive request from Serv4(TCP)----------------------------*/
                   ServerSocket S4 = new ServerSocket(1099);
      	           System.out.println("Serveur ServInter en attente...");
                   Socket connexion4 = S4.accept();
                   System.out.println("Server4 accepted...");

                   ObjectInputStream inServ4 = new ObjectInputStream(connexion4.getInputStream());

                   String service = (String) inServ4.readObject(); // Recevoir Service de service

                   System.out.println(service);
                   S4.close();
                   connexion4.close();
                   inServ4.close();
                   return service;
                  /*------------------ receive request from Serv4(TCP)----------------------------*/
               }catch(Exception e){System.out.println(e.toString());}

                
	        }else  if("S12".equals(request)) {
	 	           
                try{

                	/*------------------ send request to Serv4(TCP)----------------------------*/
                   Socket s4 = new Socket("localhost",2004);
                   System.out.println("connected to server Serv4...");

                   ObjectOutputStream outServ4 = new ObjectOutputStream(s4.getOutputStream());

                   String stringID = Integer.toString(id);
                   outServ4.writeObject(request);
                   outServ4.writeObject(stringID);
                   
                   s4.close();
                   outServ4.close();


                   /*------------------ send request to Serv4(TCP)----------------------------*/
                   
                   /*------------------ receive request from Serv4(TCP)----------------------------*/
                   ServerSocket S4 = new ServerSocket(1099);
       	           System.out.println("Serveur ServInter en attente...");
                   Socket connexion4 = S4.accept();
                   System.out.println("Server4 accepted...");

                   ObjectInputStream inServ4 = new ObjectInputStream(connexion4.getInputStream());

                   String service = (String) inServ4.readObject(); // Recevoir Service de service

                   System.out.println(service);
                   S4.close();
                   connexion4.close();
                   inServ4.close();
                   return service;
                   /*------------------ receive request from Serv4(TCP)----------------------------*/
               }catch(Exception e){System.out.println(e.toString());}

                
	        	                  
	        }else  if("S13".equals(request)) {
	        	                       try{
						
	        	                    	   /*------------------ send request to Ser5(TCP)----------------------------*/
                                          Socket s5 = new Socket("localhost",2005);
                                          System.out.println("connected to server Serv5...");

                                          ObjectOutputStream outServ5 = new ObjectOutputStream(s5.getOutputStream());

                                          String stringID = Integer.toString(id);
                                          outServ5.writeObject(request);
                                          outServ5.writeObject(stringID);
                                          
                                          s5.close();
                                          outServ5.close();


                                          /*------------------ send request to Serv5(TCP)----------------------------*/
                                          
                                          /*------------------ receive request from Serv5(TCP)----------------------------*/
                                          ServerSocket S5 = new ServerSocket(1099);
                              	           System.out.println("Serveur ServInter en attente...");
                                          Socket connexion5 = S5.accept();
                                          System.out.println("Server5 accepted...");

                                          ObjectInputStream inServ5 = new ObjectInputStream(connexion5.getInputStream());

                                          String service = (String) inServ5.readObject(); // Recevoir Service de service

                                          System.out.println(service);
                                          S5.close();
                                          connexion5.close();
                                          inServ5.close();
                                          return service;
                                          /*------------------ receive request from Serv4(TCP)----------------------------*/
                                       }catch(Exception e){System.out.println(e.toString());}

                                        
	        }else  if("S14".equals(request)) {
                try{
	
             	   /*------------------ send request to Ser5(TCP)----------------------------*/
                   Socket s5 = new Socket("localhost",2005);
                   System.out.println("connected to server Serv5...");

                   ObjectOutputStream outServ5 = new ObjectOutputStream(s5.getOutputStream());

                   String stringID = Integer.toString(id);
                   outServ5.writeObject(request);
                   outServ5.writeObject(stringID);
                   
                   s5.close();
                   outServ5.close();


                   /*------------------ send request to Serv5(TCP)----------------------------*/
                   
                   /*------------------ receive request from Serv5(TCP)----------------------------*/
                   ServerSocket S5 = new ServerSocket(1099);
       	           System.out.println("Serveur ServInter en attente...");
                   Socket connexion5 = S5.accept();
                   System.out.println("Server5 accepted...");

                   ObjectInputStream inServ5 = new ObjectInputStream(connexion5.getInputStream());

                   String service = (String) inServ5.readObject(); // Recevoir Service de service

                   System.out.println(service);
                   S5.close();
                   connexion5.close();
                   inServ5.close();
                   return service;
                   /*------------------ receive request from Serv5(TCP)----------------------------*/
                }catch(Exception e){System.out.println(e.toString());}

                
	        }else  if("S15".equals(request)) {
                try{
	
             	   /*------------------ send request to Ser5(TCP)----------------------------*/
                   Socket s5 = new Socket("localhost",2005);
                   System.out.println("connected to server Serv5...");

                   ObjectOutputStream outServ5 = new ObjectOutputStream(s5.getOutputStream());

                   String stringID = Integer.toString(id);
                   outServ5.writeObject(request);
                   outServ5.writeObject(stringID);
                   
                   s5.close();
                   outServ5.close();


                   /*------------------ send request to Serv5(TCP)----------------------------*/
                   
                   /*------------------ receive request from Serv5(TCP)----------------------------*/
                   ServerSocket S5 = new ServerSocket(1099);
       	           System.out.println("Serveur ServInter en attente...");
                   Socket connexion5 = S5.accept();
                   System.out.println("Server5 accepted...");

                   ObjectInputStream inServ5 = new ObjectInputStream(connexion5.getInputStream());

                   String service = (String) inServ5.readObject(); // Recevoir Service de service

                   System.out.println(service);
                   S5.close();
                   connexion5.close();
                   inServ5.close();
                   return service;
                   /*------------------ receive request from Serv5(TCP)----------------------------*/
                }catch(Exception e){System.out.println(e.toString());}

                 
	        }else { System.out.println("aucun choix..........");}
	        
	        
	        return "";
	    }

		
		
		

		public static void main(String[] args) throws RemoteException {
				
				
			ServerInter s = new ServerInter();
			System.out.println("Serveur en éxécution");
			Registry reg = LocateRegistry.createRegistry(3333); // LocateRegistry c'est une classe qui offre la méthode CreateRegistry
			System.out.println("création de registre...");
			reg.rebind("Refs",s);
			
			
			
	}






		}

