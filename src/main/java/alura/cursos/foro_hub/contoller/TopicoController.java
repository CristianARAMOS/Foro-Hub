package alura.cursos.foro_hub.contoller;

import alura.cursos.foro_hub.domain.respuesta.DtoRespuesta;
import alura.cursos.foro_hub.domain.topico.DtoRespuestaTopico;
import alura.cursos.foro_hub.domain.topico.PostearTopico;
import alura.cursos.foro_hub.domain.topico.Topic;
import alura.cursos.foro_hub.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private TopicoRepository topicoRepository;
    @PostMapping
    public ResponseEntity<DtoRespuestaTopico> hacerUnTopico(@RequestBody PostearTopico postearTopico, UriComponentsBuilder uriComponentsBuilder) {
        Topic topic = new Topic(postearTopico);
        topic.setUsuario_id(postearTopico.usuario_id());
        Topic topic1 = topicoRepository.save(topic);
        DtoRespuestaTopico dtoRespuestaTopico =  new DtoRespuestaTopico(  topic.getId(),topic.getTitulo(),topic.getMensaje(),topic.getFechaCreacion().toString(),topic.getStatus().toString(),topic.getCurso_id());
        URI url = uriComponentsBuilder.path("topicos/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(url).body(dtoRespuestaTopico);

    }


}