package dagatecompany.agenda.repository;

import dagatecompany.agenda.model.Contacto;
<<<<<<< HEAD
=======
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
>>>>>>> 2745562bca63603c9b3a057becc04471228b6d63
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactoRepository extends JpaRepository<Contacto,Integer> {
<<<<<<< HEAD
=======
    Page<Contacto> findByNombreContaining(String nombre, Pageable pageable);

>>>>>>> 2745562bca63603c9b3a057becc04471228b6d63
}
