package CTI.Bibliotheque.service;

import CTI.Bibliotheque.model.Emprunt;
import CTI.Bibliotheque.repository.EmpruntRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpruntService {

    @Autowired
    private EmpruntRepository empruntRepository;

    public EmpruntService(EmpruntRepository empruntRepository) {
        this.empruntRepository = empruntRepository;
    }

    public List<Emprunt> getAllEmprunts() {
        return empruntRepository.findAll();
    }

    public Optional<Emprunt> getEmpruntById(Long id) {
        return empruntRepository.findById(id);
    }

    public Emprunt createEmprunt(Emprunt emprunt) {
        return empruntRepository.save(emprunt);
    }

    public Emprunt updateEmprunt(Long id, Emprunt newEmprunt) {
        Optional<Emprunt> optionalEmprunt = empruntRepository.findById(id);
        if (optionalEmprunt.isPresent()) {
            Emprunt existingEmprunt = optionalEmprunt.get();
            existingEmprunt.setAdherent(newEmprunt.getAdherent());
            existingEmprunt.setOuvrage(newEmprunt.getOuvrage());
            existingEmprunt.setDateEmprunt(newEmprunt.getDateEmprunt());
            existingEmprunt.setDateRetourPrevu(newEmprunt.getDateRetourPrevu());
            return empruntRepository.save(existingEmprunt);
        } else {
            throw new EntityNotFoundException("Emprunt non trouvé avec l'identifiant: " + id);
        }
    }

    public void deleteEmprunt(Long id) {
        empruntRepository.deleteById(id);
    }
}
