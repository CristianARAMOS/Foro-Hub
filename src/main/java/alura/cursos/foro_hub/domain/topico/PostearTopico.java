package alura.cursos.foro_hub.domain.topico;


import jakarta.validation.constraints.NotNull;

public record PostearTopico(
        @NotNull
        String titulo,
        @NotNull
        String mensaje,
        @NotNull
        Long usuario_id,
        @NotNull
        Long curso_id


) {
}
