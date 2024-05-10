package CTI.Bibliotheque.service;

import CTI.Bibliotheque.model.Adherent;
import CTI.Bibliotheque.repository.AdherentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdherentService {

    @Autowired
    private AdherentRepository adherentRepository;


    public List<Adherent> afficher() {
        return adherentRepository.findAll();
    }


    public Adherent ajouter(Adherent adherent) {
        return adherentRepository.save(adherent);
    }


    public Adherent modifier(Adherent adherent) {
        return adherentRepository.save(adherent);
    }


    public void supprimer(Long id) {
        adherentRepository.deleteById(id);
    }

    public <HistoriqueAction> List<HistoriqueAction> suivreHistorique(Long idAdherent) {
        Adherent adherent = adherentRepository.findById(idAdherent).orElse(null);
        if (adherent != null) {
            return adherent.getHistoriqueActions();
        }
        return null;
    }

    public List<Adherent> getAllAdherents() {
        return null;
    }

    public Optional<Object> getAdherentById(Long id) {
        return null;
    }

    public Adherent createAdherent(Adherent adherent) {
        return adherent;
    }

    public Adherent updateAdherent(Long id, Adherent newAdherent) {
        return newAdherent;
    }

    public void deleteAdherent(Long id) {
    }
}
