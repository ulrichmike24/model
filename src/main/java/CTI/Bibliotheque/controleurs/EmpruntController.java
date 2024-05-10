package CTI.Bibliotheque.controleurs;

import CTI.Bibliotheque.model.Emprunt;
import CTI.Bibliotheque.service.EmpruntService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emprunts")
public class EmpruntController {

    @Autowired
    private EmpruntService empruntService;

    @GetMapping
    public ResponseEntity<List<Emprunt>> getAllEmprunts() {
        List<Emprunt> emprunts = empruntService.getAllEmprunts();
        return ResponseEntity.ok(emprunts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Emprunt> getEmpruntById(@PathVariable Long id) {
        Emprunt emprunt = empruntService.getEmpruntById(id)
                .orElseThrow(() -> new EntityNotFoundException("Emprunt non trouvé avec l'identifiant: " + id));
        return ResponseEntity.ok(emprunt);
    }

    @PostMapping
    public ResponseEntity<Emprunt> createEmprunt(@RequestBody Emprunt emprunt) {
        Emprunt createdEmprunt = empruntService.createEmprunt(emprunt);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmprunt);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Emprunt> updateEmprunt(@PathVariable Long id, @RequestBody Emprunt newEmprunt) {
        Emprunt updatedEmprunt = empruntService.updateEmprunt(id, newEmprunt);
        return ResponseEntity.ok(updatedEmprunt);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmprunt(@PathVariable Long id) {
        empruntService.deleteEmprunt(id);
        return ResponseEntity.noContent().build();
    }
}
