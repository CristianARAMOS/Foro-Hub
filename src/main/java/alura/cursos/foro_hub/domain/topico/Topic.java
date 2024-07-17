package alura.cursos.foro_hub.domain.topico;


import alura.cursos.foro_hub.domain.curso.Curso;
import alura.cursos.foro_hub.domain.respuesta.Respuesta;
import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Topic")
@Table(name = "topicos")
@EqualsAndHashCode(of = "id")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String mensaje;

    private LocalDateTime fechaCreacion;

    @Enumerated(EnumType.STRING)
    private Estado status;

    private Long usuario_id;

    private boolean activo;

    @ManyToOne
    @JoinColumn(name = "curso")
    private Curso curso;

    @OneToMany(mappedBy = "topico",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Respuesta> respuestas;

    public Topic(PostearTopico postearTopico) {
        this.titulo = postearTopico.titulo();
        this.mensaje=postearTopico.mensaje();
        this.fechaCreacion =  LocalDateTime.now();
        this.status = Estado.N0RESUELTO;
        this.activo = true;

    }
}
