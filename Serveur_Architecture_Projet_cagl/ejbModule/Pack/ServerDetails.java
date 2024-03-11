package Pack;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ServerDetails implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	int id;
	String ServerName;
    String  IpAdress;
    int CommPort;
	public ServerDetails() {super();}
	public ServerDetails(int i, String ServerName,String  IpAdress,int CommPort) {
		this.id=i; 
		this.ServerName=ServerName;
		this.IpAdress = IpAdress;
		this.CommPort = CommPort;
   }
	
	
	
	public int getId() {
		return this.id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getServerName() {
		return this.ServerName;
	}


	public void setServerName(String ServerName) {
		this.ServerName = ServerName;
	}
	
	
	public  String getIpAdress() {
		return this.IpAdress;
	}


	public void setIpAdress(String IpAdress) {
		this.IpAdress = IpAdress;
	}
	
	
	public int getCommPort() {
		return this.CommPort;
	}


	public void setCommPort(int CommPort) {
		this.CommPort = CommPort;
	}


	public String toString() {
		return "ServerDetails [id=" + id + ", ServerName=" + ServerName +",IpAdress=" + IpAdress +",CommunicationPort=" + CommPort+ "]";
	}

}