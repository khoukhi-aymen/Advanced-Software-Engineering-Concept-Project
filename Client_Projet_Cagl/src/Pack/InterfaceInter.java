package Pack;
import java.rmi.Remote;
import java.rmi.RemoteException;

	// Interface RMI pour le serveur intermédiaire
	interface InterfaceInter extends Remote {
	    public String processRequest(int  id, String referenceChain, String request) throws RemoteException;
	}


