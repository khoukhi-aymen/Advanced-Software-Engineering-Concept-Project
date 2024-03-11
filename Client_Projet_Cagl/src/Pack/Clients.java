package Pack;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Scanner;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Clients {
    private static final int NUM_CLIENTS = 6;
    private static final int INITIAL_DELAY = 5000; // 100 secondes de délai initial pour simuler la perte du jeton
    private static Client[] clients;

    public static void main(String[] args) {
    	Timer timer = new Timer();
    	clients = new Client[NUM_CLIENTS];

        for (int i = 0; i < NUM_CLIENTS; i++) {
        	clients[i] = new Client(i, timer);
            
        }

        // Initialisation de l'anneau
        for (int i = 0; i < NUM_CLIENTS; i++) {
            int nextClient = (i + 1) % NUM_CLIENTS;
            clients[i].setNextClient(clients[nextClient]);
        }

        // Le premier client (client 0) démarre avec le jeton c-a-d le client 0 qui va commancer leur demandes
        // si on veur faire le cas d'echecs c-a-d il ya pas de reponse en cas de probleme resaux on va supprimer 
        // cette instruction et donc il suffit d'attendre INITIAL_DELAY pour dire que le jeton est perdu 
        //clients[0].setHasToken(true);

        // Démarrage des clients
        for (int i = 0; i < NUM_CLIENTS; i++) {
            clients[i].start();
        }

     // Simulation de la perte de jeton
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Perte de jeton détectée! Lancement de l'élection...");
                clients[1].initiateElection(); // Le client 1 lance l'élection en cas de perte de jeton
                System.out.println("demmarage des threads..........;");
                //clients[1].passToken();
            }
        }, INITIAL_DELAY);
    }

    static class Client extends Thread {
        private int id;
        private Client nextClient;
        private volatile boolean hasToken = false;
        private Timer timer;
        private volatile boolean hasInitiatedElection = false;
        private volatile boolean hasTokenLossNotification = false;

        public Client(int id,Timer timer) {
            this.id = id;
            this.timer = timer;
        }

        public void setNextClient(Client nextClient) {
            this.nextClient = nextClient;
        }

        public void setHasToken(boolean hasToken) {
            this.hasToken = hasToken;
        }

        public void initiateElection() {
            if (!hasToken && !hasInitiatedElection) {
            	hasInitiatedElection = true;
                System.out.println("Client " + id + " a le jeton et lance l'élection.");

                // Diffusion de notification de perte de jeton à tous les clients sauf au client qui lance l'élection
                for (int i = 0; i < clients.length; i++) {
                    int receiverId = (id + i) % clients.length;
                    if (receiverId != id) {
                        
                        System.out.println("Client " + id + " a notifié Client " + receiverId + " de la perte de jeton.");
                        clients[receiverId].receiveTokenLossNotification();
                    }
                }

                // Attend un court moment pour laisser le temps aux clients de recevoir la notification
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                
             // Passe le jeton après avoir notifié tous les clients
                passToken();   
            }
        }

        
        
        



        
        
        public boolean hasReceivedTokenLossNotification() {
            return hasTokenLossNotification;
        }

        public void receiveTokenLossNotification() {
            // Simule la réception de l'information de perte de jeton
            System.out.println("Client " + id + " a reçu une notification de perte de jeton.");
            hasTokenLossNotification = true;
        }




        public void passToken() {
            hasToken = false;
            hasInitiatedElection = false; // Réinitialise la variable d'élection
            System.out.println("Client " + id + " passe le jeton à Client " + nextClient.id);
            nextClient.receiveToken();
            // Réinitialise le timer après avoir passé le jeton
            resetTimer();
        }
        
        
     // Ajoute cette méthode pour réinitialiser le timer
        private void resetTimer() {
            timer.cancel();
            timer = new Timer();
            nextClient.timer = timer; // Réinitialise le timer pour le prochain client
            //System.out.println("Réinitialise le timer pour le prochain client");
        }

        public void receiveToken() {
            hasToken = true;
            System.out.println("Client " + id + " a reçu le jeton.");
        }

        @Override
        public void run() {
            while (true) {
                if (hasToken) {
                    // Client actuel a le jeton, effectue des actions ici
                    System.out.println("Client " + id + " exécute une action...");
                    
                    try {
                        Scanner SC = new Scanner(System.in);
                        
                        String M;
                        String request = "";
                            System.out.println("****************MENU SERVICE******************");
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
                     


                    System.out.println("------->Client " + id + " a demmander le service"+request+"<-------");
                    System.out.println();
                    String chaineRefClient0 = "S7, S10, S1, S2, S4, S3, S0, S6, S12, S11, S8, S5, S2, S1, S0, S5, S1, S7, S9, S2.FIN";
                    String chaineRefClient1 = "S15, S1, S4, S2, S3, S6, S7, S10, S1, S13, S6, S14, S2, S0, S1, S3, S2, S7, S0, S1.FIN";
                    String chaineRefClient2 = "S10, S3, S6, S4, S2, S7, S0, S3, S12, S8, S7, S0, S6, S5, S3, S2, S1, S7, S0, S4. FIN";
                    String chaineRefClient3 = "S13, S2, S1, S7, S0, S4, S6, S5, S11, S0, S14, S3, S9, S1, S0, S3, S6, S7, S12, S11, FIN";
                    String chaineRefClient4 = "S2, S14, S1, S7, S6, S3, S0, S5, S2, S15, S7, S0, S4, S12, S3, S6, S7, S2, S1, S13. FIN";
                    String chaineRefClient5 = "S5, S4, S1, S3, S10, S7, S6, S0, S13, S2, S1, S7, S6, S3, S15, S2, S1, S14, S5, S6. FIN";
                    
                    try{
            			Registry reg = LocateRegistry.getRegistry("localhost",1099);
            			InterfaceInter i = (InterfaceInter) reg.lookup("Refs");
            			String ACK;
            			switch(id) {
            			   case 0: 
            			           ACK = i.processRequest(0,chaineRefClient0, request);
            			           System.out.println(ACK);
                       			   System.out.println();
                       			   System.out.println();
            			           break;
            			   case 1: ACK = i.processRequest(1,chaineRefClient1, request);
            			           System.out.println(ACK);
               			           System.out.println();
               			           System.out.println();
    			                   break;
            			   case 2: ACK = i.processRequest(2,chaineRefClient2, request);
            			           System.out.println(ACK);
               			           System.out.println();
               			           System.out.println();
    			                   break;
            			   case 3: ACK = i.processRequest(3,chaineRefClient3, request);
            			           System.out.println(ACK);
               			           System.out.println();
               			           System.out.println();
    			                   break;
            			   case 4: ACK = i.processRequest(4,chaineRefClient4, request);
            			           System.out.println(ACK);
               			           System.out.println();
               			           System.out.println();
    			                   break;
            			   case 5: ACK = i.processRequest(5,chaineRefClient5, request);
            			           System.out.println(ACK);
               			           System.out.println();
               			           System.out.println();
    			                   break;
            			}
            		}
            		catch(Exception e){System.out.println(e.getMessage());}
   
                    
                    // Après avoir effectué le service, le client passe le jeton
                    passToken();
                    //System.out.println("--------------");
                }catch (Exception e) {
                	System.out.println("Erreur lors de la communication RMI : " + e.getMessage());
                }
            }
        }
    }
    }
  }
















