package CTI.Bibliotheque.repository;

import CTI.Bibliotheque.model.Adherent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories

@Repository
public interface AdherentRepository extends JpaRepository<Adherent, Long> {
}

