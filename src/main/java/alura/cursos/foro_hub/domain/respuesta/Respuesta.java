package alura.cursos.foro_hub.domain.respuesta;

import alura.cursos.foro_hub.domain.topico.Topic;
import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Respuesta")
@Table(name = "respuestas")
@EqualsAndHashCode(of = "id")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensaje;
    @ManyToOne
    @JoinColumn(name = "topico")
    private Topic topico;

    private LocalDateTime fechaCreacion;

    private   Long usuario;

    private   Boolean activo;

    public Respuesta(PostearRespuestaDto postearRespuestaDto) {
        this.mensaje = postearRespuestaDto.mensaje();
        this.fechaCreacion = LocalDateTime.now();
        this.usuario = postearRespuestaDto.id();
        this.activo = true;
    }
}

