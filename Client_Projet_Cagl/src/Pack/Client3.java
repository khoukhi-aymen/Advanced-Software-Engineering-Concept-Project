package Pack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import javax.swing.Timer;

public class Client3{
	private Timer timer;
    private boolean timerStarted = true;
	


	public static void main(String[] args) {
		try {
		
			while(true) {
				
				// Initialisation et démarrage du Timer avant la réception du jeton
                Client3 client = new Client3();
                client.startTimer();
				
				/*------------------ receive jeton from client2(UDP)----------------------------*/
				DatagramSocket c = new DatagramSocket(1003);
				byte[] receiveData = new byte[1024];
				DatagramPacket in_client2 = new DatagramPacket(receiveData, receiveData.length);
				c.receive(in_client2);
				String jeton = new String(in_client2.getData());
				
				/*------------------ receive jeton from client2(UDP)----------------------------*/
				
				
				if (jeton.trim().equals("jeton")) {
					System.out.println("jeton recu par le client3...."+jeton);
					// Arrêt du Timer après la réception du jeton à partir de client1
	                client.stopTimer();
				}else {
					System.out.println(jeton);
					System.out.println("Création d'un nouveau jeton..");
					client.stopTimer();
				}

				
				
				
				
				
				
				
				
				
				
				
                Scanner SC = new Scanner(System.in);
                
                String M;
                String request = "";
                    System.out.println("****************MENU SERVICE Client3******************");
                    System.out.println("0- Service0");
                    System.out.println("1- Service1");
                    System.out.println("2- Service2");
                    System.out.println("3- Service3");
                    System.out.println("4- Service4");
                    System.out.println("5- Service5");
                    System.out.println("6- Service6");
                    System.out.println("7- Service7");
                    System.out.println("8- Service8");
                    System.out.println("9- Service9");
                    System.out.println("10- Service10");
                    System.out.println("11- Service11");
                    System.out.println("12- Service12");
                    System.out.println("13- Service13");
                    System.out.println("14- Service14");
                    System.out.println("15- Service15");
                    M = SC.next();
                    switch (M) {
                        case "0":
                	        request = "S0";
                            break;
                        case "1":
                        	request = "S1";
                            break;
                        case "2":
                        	request = "S2";
                            break;
                        case "3":
                        	request = "S3";
                            break;
                        case "4":
                        	request = "S4";
                            break;
                        case "5":
                        	request = "S5";
                            break;
                        case "6":
                        	request = "S6";
                            break;
                        case "7":
                        	request = "S7";
                            break;
                        case "8":
                        	request = "S8";
                            break;
                        case "9":
                        	request = "S9";
                            break;
                        case "10":
                        	request = "S10";
                            break;
                        case "11":
                        	request = "S11";
                            break;
                        case "12":
                        	request = "S12";
                            break;
                        case "13":
                        	request = "S13";
                            break;
                        case "14":
                        	request = "S14";
                            break;
                        case "15":
                        	request = "S15";
                            break;
                    }
             


            System.out.println("------->Client3 a demmandé le service"+request+"<-------");
            System.out.println();
            String chaineRefClient3 = "S10, S3, S6, S4, S2, S7, S0, S3, S12, S8, S7, S0, S6, S5, S3, S2, S1, S7, S0, S4. FIN";
            
            try{
    			Registry reg = LocateRegistry.getRegistry("localhost",3333);
    			InterfaceInter i = (InterfaceInter) reg.lookup("Refs");
    			String ACK;
    			ACK = i.processRequest(3,chaineRefClient3, request);
    			System.out.println(ACK);
		        System.out.println();
		        System.out.println();
		        
		        System.out.println();
		        System.out.println("Si vous voulez envoyez le jeton taper 1 sinon taper 0...");
		        System.out.println();
		        int testEnvoieJeton;
		        testEnvoieJeton = SC.nextInt();
		        
		        if(testEnvoieJeton == 1) {
		        
		        /*------------------ send jeton To client4(UDP)----------------------------*/
		        DatagramSocket C = new DatagramSocket();
                jeton = "jeton";
	            byte[] sendJeton = jeton.getBytes();
	            InetAddress ip = InetAddress.getByName("localhost");
	            DatagramPacket out_client4 = new DatagramPacket(sendJeton, sendJeton.length, ip, 1004);
	            System.out.println("client3 passe le jeton to client 4...");
	            C.send(out_client4);
	            /*------------------ send jeton To client4(UDP)----------------------------*/
	            C.close();
	            
	            
		        }
		        
		        c.close();
		        
		        
				Thread.sleep(1000);
            }
            catch (Exception e) {
        	System.out.println("Erreur lors de la communication RMI : " + e.getMessage());
        }
            
         
            
            
           
		
			
		    }
			
		}catch(Exception e) {System.out.println("Exception"+e.toString());}

	}
	
	public void startTimer() {
	    ActionListener taskPerformer = new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	            // Actions à effectuer lorsque le timer se déclenche (délai écoulé)
	            System.out.println("Le délai d'attente est écoulé. le client2 n'envoie pas le jeton....");
	            // Autres actions à prendre en cas d'absence de réponse
	            startTimer();
	            try {
		            // Lecture de la valeur actuelle de la variable depuis le fichier
		            BufferedReader reader = new BufferedReader(new FileReader("src/Pack/variable.txt"));
		            String variableValue = reader.readLine();
		            reader.close();

		            int value = Integer.parseInt(variableValue);

		            if (value == 6) {
		            	
		            	// Incrémenter la variable et la stocker dans le fichier
		                value=1;
		                FileWriter writer1 = new FileWriter("src/Pack/variable.txt");
		                writer1.write(Integer.toString(value));
		                writer1.close();
		                //System.out.println("Variable initialisée à : " + value);
		            	System.out.println();
			            System.out.println();
		                //Thread.sleep(10000);
		                
		                
		                /*------------------ send jeton To client3(UDP)----------------------------*/
				        DatagramSocket C = new DatagramSocket();
				        String JETON = "fin de timer de tout les clients......";
			            byte[] sendJeton = JETON.getBytes();
			            InetAddress ip = InetAddress.getByName("localhost");
			            DatagramPacket out_client4 = new DatagramPacket(sendJeton, sendJeton.length, ip, 1004);
			            System.out.println("client3 passe le nouveau jeton to client 4...");
			            C.send(out_client4);
			            /*------------------ send jeton To client3(UDP)----------------------------*/
			            C.close();
		            } else {
		                // Incrémenter la variable et la stocker dans le fichier
		                value++;
		                FileWriter writer = new FileWriter("src/Pack/variable.txt");
		                writer.write(Integer.toString(value));
		                writer.close();
		               // System.out.println("Variable incrémentée à : " + value);
		            }
		        } catch (IOException e) {
		            System.out.println("Erreur : " + e.getMessage());
		        }
	        }
	    };

	    // Définition du timer pour démarrer au début du programme
	    int delay = 120000; // Exemple de délai de 10 secondes (ajustez selon vos besoins)
	    this.timer = new Timer(delay, taskPerformer);
	    this.timer.setRepeats(false); // Pour ne déclencher l'événement qu'une seule fois

	    System.out.println("Starting Timer...");
	    this.timer.start(); // Démarrage du timer dès le début du programme
	    }
	 
	 public void stopTimer() {
	        if (timer != null && timer.isRunning()) {
	            timer.stop();
	            System.out.println("Timer stopped.");
	        }
	    }

}
