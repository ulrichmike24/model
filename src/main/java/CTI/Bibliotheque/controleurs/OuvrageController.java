package CTI.Bibliotheque.controleurs;

import CTI.Bibliotheque.model.Ouvrage;
import CTI.Bibliotheque.service.OuvrageService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ouvrages")
@CrossOrigin(origins = "*")
public class OuvrageController {

    @Autowired
    private OuvrageService ouvrageService;

    public OuvrageController(OuvrageService ouvrageService) {
        this.ouvrageService = ouvrageService;
    }

    @GetMapping
    public ResponseEntity<List<Ouvrage>> getAllOuvrages() {
        List<Ouvrage> ouvrages = ouvrageService.getAllOuvrages();
        return ResponseEntity.ok(ouvrages);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ouvrage> getOuvrageById(@PathVariable Long id) {
        Ouvrage ouvrage = ouvrageService.getOuvrageById(id)
                .orElseThrow(() -> new EntityNotFoundException("Ouvrage non trouvé avec l'identifiant: " + id));
        return ResponseEntity.ok(ouvrage);
    }

    @PostMapping
    public ResponseEntity<Ouvrage> createOuvrage(@RequestBody Ouvrage ouvrage) {
        Ouvrage createdOuvrage = ouvrageService.createOuvrage(ouvrage);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOuvrage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ouvrage> updateOuvrage(@PathVariable Long id, @RequestBody Ouvrage newOuvrage) {
        Ouvrage updatedOuvrage = ouvrageService.updateOuvrage(id, newOuvrage);
        return ResponseEntity.ok(updatedOuvrage);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOuvrage(@PathVariable Long id) {
        ouvrageService.deleteOuvrage(id);
        return ResponseEntity.noContent().build();
    }
}
