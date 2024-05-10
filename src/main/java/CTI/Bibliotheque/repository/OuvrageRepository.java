package CTI.Bibliotheque.repository;

import CTI.Bibliotheque.model.Ouvrage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface OuvrageRepository extends JpaRepository<Ouvrage, Long> {
}
