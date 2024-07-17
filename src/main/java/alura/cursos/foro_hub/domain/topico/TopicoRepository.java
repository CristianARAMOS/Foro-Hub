package alura.cursos.foro_hub.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TopicoRepository extends JpaRepository<Topic, Long> {
    Page<Topic> findByActivoTrue(Pageable pageable);
}
