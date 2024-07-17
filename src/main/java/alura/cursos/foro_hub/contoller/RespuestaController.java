package alura.cursos.foro_hub.contoller;


import alura.cursos.foro_hub.domain.curso.CursoRepository;
import alura.cursos.foro_hub.domain.respuesta.DtoPostRespuesta;
import alura.cursos.foro_hub.domain.respuesta.PostearRespuestaDto;
import alura.cursos.foro_hub.domain.respuesta.Respuesta;
import alura.cursos.foro_hub.domain.respuesta.RespuestaRepository;

import alura.cursos.foro_hub.domain.topico.Topic;
import alura.cursos.foro_hub.domain.topico.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;
@RestController
@RequestMapping("/topicos")
public class RespuestaController {


        @Autowired
        private TopicoRepository topicoRepository;
        @Autowired
        private CursoRepository cursoRepository;
        @Autowired
        private RespuestaRepository respuestaRepository;
        private DtoPostRespuesta dtoPostRespuesta;
        private URI url;

        @PostMapping("/{id}")
        public ResponseEntity<DtoPostRespuesta> responderUnTopico(
                @PathVariable Long id, @RequestBody @Valid PostearRespuestaDto postearRespuestaDto, UriComponentsBuilder uriComponentsBuilder) {
            Respuesta respuesta = new Respuesta(postearRespuestaDto);
            respuesta.setUsuario(postearRespuestaDto.id());
            Optional<Topic> topic = topicoRepository.findById(id);
            if (topic.isPresent()) {
                Topic topic1 = topic.get();
                respuesta.setTopico(topic1);
                respuestaRepository.save(respuesta);
                dtoPostRespuesta = new DtoPostRespuesta(respuesta.getId(), respuesta.getMensaje(), respuesta.getFechaCreacion().toString());
                url = uriComponentsBuilder.path("topicos/{id}").buildAndExpand(respuesta.getId()).toUri();
            }
            return ResponseEntity.created(url).body(dtoPostRespuesta);
        }
    }
