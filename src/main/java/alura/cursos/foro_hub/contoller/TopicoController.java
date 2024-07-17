package alura.cursos.foro_hub.contoller;


import alura.cursos.foro_hub.domain.curso.Curso;
import alura.cursos.foro_hub.domain.curso.CursoRepository;

import alura.cursos.foro_hub.domain.respuesta.DtoRespuesta;
import alura.cursos.foro_hub.domain.respuesta.Respuesta;
import alura.cursos.foro_hub.domain.respuesta.RespuestaRepository;
import alura.cursos.foro_hub.domain.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private RespuestaRepository respuestaRepository;
    private DtoRespuestaTopico dtoRespuestaTopico;
    private URI url;

    @PostMapping
    public ResponseEntity<DtoRespuestaTopico> hacerUnTopico(@RequestBody @Valid PostearTopico postearTopico, UriComponentsBuilder uriComponentsBuilder) {
        Topic topic = new Topic(postearTopico);
        topic.setUsuario_id(Long.valueOf(postearTopico.usuario_id()));
        System.out.println(postearTopico.curso_id());
        Optional<Curso> curso = cursoRepository.findById(postearTopico.curso_id());
        if (curso.isPresent()) {
            Curso curso1 = curso.get();
            System.out.println(curso1);
            topic.setCurso(curso1);
            topicoRepository.save(topic);
            dtoRespuestaTopico = new DtoRespuestaTopico(topic);
            url = uriComponentsBuilder.path("topicos/{id}").buildAndExpand(topic.getId()).toUri();

        }
        return ResponseEntity.created(url).body(dtoRespuestaTopico);


    }

    @GetMapping
    public ResponseEntity<Page<DtoRespuestaTopico>> listarTopicos(@PageableDefault(size = 3) Pageable pageable) {
        return ResponseEntity.ok(topicoRepository.findByActivoTrue(pageable).map(DtoRespuestaTopico::new));
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity mostrarTopico(@PathVariable Long id) {
        Topic topic = topicoRepository.getReferenceById(id);
        List<Respuesta> respuestas = respuestaRepository.findByTopico(topic);
        List<DtoRespuesta> respuestas1 = respuestas.stream()
                .map(r->new DtoRespuesta(r.getMensaje(),r.getUsuario())).toList();
        var dtosTopico = new DtoTopico(topic.getTitulo(),topic.getMensaje(),topic.getFechaCreacion().toString(),topic.getStatus().toString(),respuestas1);
        return ResponseEntity.ok(dtosTopico);
    }


}