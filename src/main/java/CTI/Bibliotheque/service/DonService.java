package CTI.Bibliotheque.service;

import CTI.Bibliotheque.model.Don;
import CTI.Bibliotheque.repository.DonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonService {

    @Autowired
    private DonRepository donRepository;

    // Méthode pour afficher un don
    public void afficherDon(Long id) {
        Don don = donRepository.findById(id).orElse(null);
        if (don != null) {
            System.out.println("ID du don : " + don.getId());
            System.out.println("Adhérent donateur : " + don.getAdherentDonateur().getNom()); // Supposons que le nom soit un attribut de l'adhérent
            System.out.println("Montant : " + don.getMontant());
            System.out.println("Date du don : " + don.getDateDon());
        } else {
            System.out.println("Aucun don trouvé avec l'ID : " + id);
        }
    }

    // Méthode pour enregistrer un don
    public void enregistrerDon(Don don) {
        donRepository.save(don);
        System.out.println("Le don a été enregistré avec succès.");
    }

    // Méthode pour générer un reçu pour un don
    public void genererRecu(Don don) {
        // Logique pour générer le reçu
        System.out.println("Reçu généré pour le don avec l'ID : " + don.getId());
    }

    public Don findById(Long id) {
        return null;
    }

    public Don save(Don don) {
        return don;
    }
}

