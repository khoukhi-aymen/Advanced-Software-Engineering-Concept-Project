package Pack;
import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Stateless
public class ServiceBean implements IService{
		@PersistenceContext
		EntityManager em;
		 public void ajouter(Service produit) {
		      em.persist(produit);
		   }
		   public Service rechercherService(int id) {
		      return em.find(Service.class, id);
		   }
		   public List<Service> listerTousLesServices() {
			    return em.createQuery("SELECT s FROM Service s ORDER BY s.id").getResultList();
	       }
		   
		   
		   
		   public void ajouterServerDetails(ServerDetails ServerDetails) {
			      em.persist(ServerDetails);
		   }
		   
		   
		   public ServerDetails rechercherServerDetails(int id) {
			      return em.find(ServerDetails.class, id);
			   }
		   
		   public List<ServerDetails> listerTousLesServerDetails() {
				    return em.createQuery("SELECT s FROM ServerDetails s ORDER BY s.id").getResultList();
		   }
		
				
		
	}


