package alura.cursos.foro_hub.domain.topico;

import alura.cursos.foro_hub.domain.respuesta.DtoRespuesta;
import alura.cursos.foro_hub.domain.respuesta.Respuesta;

import java.util.Comparator;
import java.util.List;

public record DtoTopico(
        String titulo,

        String mensaje,

        String fechaCreacion,

        String status,

        List<DtoRespuesta> respuestas
) {


    public DtoTopico(String titulo, String mensaje, String fechaCreacion,String status, List<DtoRespuesta> respuestas ) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fechaCreacion =fechaCreacion;
        this.status = status;
        this.respuestas = respuestas;
    }
}
