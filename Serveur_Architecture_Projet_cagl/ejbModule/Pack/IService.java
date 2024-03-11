package Pack;

import java.util.List;

import jakarta.ejb.Remote;

@Remote
public interface IService {
    void ajouter(Service service);
    Service rechercherService(int id);
    List<Service> listerTousLesServices();
    void ajouterServerDetails(ServerDetails ServerDetails);
    ServerDetails rechercherServerDetails(int id);
    List<ServerDetails> listerTousLesServerDetails();
}

