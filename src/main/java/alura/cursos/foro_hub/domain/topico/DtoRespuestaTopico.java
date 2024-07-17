package alura.cursos.foro_hub.domain.topico;


public record DtoRespuestaTopico(
        Long id,
        String titulo,
        String mensaje,
        String fechaDeCreacion,
        String status,
        String curso


) {
    public DtoRespuestaTopico(Topic topic) {
        this(topic.getId(),topic.getMensaje(),topic.getMensaje(),topic.getFechaCreacion().toString(),topic.getStatus().toString(),topic.getCurso().getNombre());
    }


}
