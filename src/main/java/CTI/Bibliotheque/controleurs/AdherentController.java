package CTI.Bibliotheque.controleurs;

import CTI.Bibliotheque.model.Adherent;
import CTI.Bibliotheque.service.AdherentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/adherents")
public class AdherentController {

    @Autowired
    private AdherentService adherentService;

    @GetMapping
    public ResponseEntity<List<Adherent>> getAllAdherents() {
        List<Adherent> adherents = adherentService.getAllAdherents();
        return ResponseEntity.ok(adherents);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Adherent> getAdherentById(@PathVariable Long id) {
        Adherent adherent = (Adherent) adherentService.getAdherentById(id)
                .orElseThrow(() -> new EntityNotFoundException("Adhérent non trouvé avec l'identifiant: " + id));
        return ResponseEntity.ok(adherent);
    }

    @PostMapping
    public ResponseEntity<Adherent> createAdherent(@RequestBody Adherent adherent) {
        Adherent createdAdherent = adherentService.createAdherent(adherent);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAdherent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Adherent> updateAdherent(@PathVariable Long id, @RequestBody Adherent newAdherent) {
        Adherent updatedAdherent = adherentService.updateAdherent(id, newAdherent);
        return ResponseEntity.ok(updatedAdherent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdherent(@PathVariable Long id) {
        adherentService.deleteAdherent(id);
        return ResponseEntity.noContent().build();
    }
}

