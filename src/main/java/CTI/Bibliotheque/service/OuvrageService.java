package CTI.Bibliotheque.service;

import CTI.Bibliotheque.model.Ouvrage;
import CTI.Bibliotheque.repository.OuvrageRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OuvrageService {

    @Autowired
    private OuvrageRepository ouvrageRepository;

    public OuvrageService(OuvrageRepository ouvrageRepository) {
        this.ouvrageRepository = ouvrageRepository;
    }

    public List<Ouvrage> getAllOuvrages() {
        return ouvrageRepository.findAll();
    }

    public Optional<Ouvrage> getOuvrageById(Long id) {
        return ouvrageRepository.findById(id);
    }

    public Ouvrage createOuvrage(Ouvrage ouvrage) {
        return ouvrageRepository.save(ouvrage);
    }

    public Ouvrage updateOuvrage(Long id, Ouvrage newOuvrage) {
        Optional<Ouvrage> optionalOuvrage = ouvrageRepository.findById(id);
        if (optionalOuvrage.isPresent()) {
            Ouvrage existingOuvrage = optionalOuvrage.get();
            existingOuvrage.setTitre(newOuvrage.getTitre());
            existingOuvrage.setAuteur(newOuvrage.getAuteur());
            existingOuvrage.setQuantiteDisponible(newOuvrage.getQuantiteDisponible());
            return ouvrageRepository.save(existingOuvrage);
        } else {
            throw new EntityNotFoundException("Ouvrage non trouvé avec l'identifiant: " + id);
        }
    }

    public void deleteOuvrage(Long id) {
        ouvrageRepository.deleteById(id);
    }
}
