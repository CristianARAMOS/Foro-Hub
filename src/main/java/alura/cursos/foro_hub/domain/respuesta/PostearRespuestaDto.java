package alura.cursos.foro_hub.domain.respuesta;

import jakarta.validation.constraints.NotNull;

public record PostearRespuestaDto(
        @NotNull
        Long id,
        @NotNull
        String mensaje



) {



}
