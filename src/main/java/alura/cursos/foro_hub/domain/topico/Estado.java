package alura.cursos.foro_hub.domain.topico;

public enum Estado {
    RESUELTO("resuelto"),
    N0RESUELTO("noresuelto");

    private String estado;

    Estado(String estado) {
        this.estado = estado;
    }
}
