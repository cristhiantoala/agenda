package dagatecompany.agenda.repository;

import dagatecompany.agenda.model.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactoRepository extends JpaRepository<Contacto,Integer> {
}
