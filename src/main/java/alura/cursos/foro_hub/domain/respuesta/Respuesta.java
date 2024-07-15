package alura.cursos.foro_hub.domain.respuesta;

import alura.cursos.foro_hub.domain.topico.Topic;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
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
    @JoinColumn(name = "topico_id")
    private Topic topico;

    private LocalDateTime fechaCreacion;

    private String autor;

    private Boolean solucion;

}
