package alura.cursos.foro_hub.domain.topico;

import alura.cursos.foro_hub.domain.respuesta.DtoRespuesta;

import java.time.LocalDate;

public record DtoRespuestaTopico(
        Long id,
        String titulo,
        String mensaje,
        String fechaDeCreacion,
        String status,
        int curso

) {
}
