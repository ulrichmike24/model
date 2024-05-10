package CTI.Bibliotheque.repository;

import CTI.Bibliotheque.model.Don;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonRepository extends JpaRepository<Don, Long> {
}

