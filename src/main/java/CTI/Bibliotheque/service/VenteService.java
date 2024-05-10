package CTI.Bibliotheque.service;

import CTI.Bibliotheque.model.Vente;
import CTI.Bibliotheque.repository.VenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VenteService {

    @Autowired
    private VenteRepository venteRepository;


    public void afficherVente(Long id) {
        Vente vente = venteRepository.findById(id).orElse(null);
        if (vente != null) {
            System.out.println("ID de la vente : " + vente.getId());
            System.out.println("Ouvrage vendu : " + vente.getOuvrageVendu().getTitre()); // Supposons que le titre soit un attribut de l'ouvrage
            System.out.println("Prix : " + vente.getPrix());
            System.out.println("Date de vente : " + vente.getDateVente());
        } else {
            System.out.println("Aucune vente trouvée avec l'ID : " + id);
        }
    }


    public void enregistrerVente(Vente vente) {
        venteRepository.save(vente);
        System.out.println("La vente a été enregistrée avec succès.");
    }


    public void genererRecuVente(Vente vente) {
        // Logique pour générer le reçu
        System.out.println("Reçu généré pour la vente avec l'ID : " + vente.getId());
    }

    public void mettreAJourStock(Vente vente) {
    }
}

