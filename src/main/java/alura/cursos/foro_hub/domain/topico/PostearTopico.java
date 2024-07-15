package alura.cursos.foro_hub.domain.topico;

import alura.cursos.foro_hub.domain.curso.DatosCurso;
import jakarta.validation.constraints.Pattern;

public record PostearTopico(
        String titulo,
        String mensaje,
        String status,
        int curso_id,
        int usuario_id
) {
}
