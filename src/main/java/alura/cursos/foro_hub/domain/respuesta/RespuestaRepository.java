package alura.cursos.foro_hub.domain.respuesta;


import alura.cursos.foro_hub.domain.topico.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {
    List<Respuesta> findByTopico(Topic topic);

}
