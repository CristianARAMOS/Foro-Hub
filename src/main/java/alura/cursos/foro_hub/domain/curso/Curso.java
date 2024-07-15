package alura.cursos.foro_hub.domain.curso;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Curso")
@Table(name = "cursos")
@EqualsAndHashCode(of = "id")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public Curso(DatosCurso curso) {
        this.nombre = curso.nombre();
        this.categoria = Categoria.valueOf(curso.categoria());
    }
}
