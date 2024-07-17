package alura.cursos.foro_hub.contoller;

import alura.cursos.foro_hub.domain.usuario.DatosAutenticaionUsuario;
import alura.cursos.foro_hub.domain.usuario.Usuario;
import alura.cursos.foro_hub.infra.security.DatosJWToken;
import alura.cursos.foro_hub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticationController {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticationUsuario(@RequestBody @Valid DatosAutenticaionUsuario datos){
        Authentication authToken = new UsernamePasswordAuthenticationToken(datos.login(),datos.clave());
         var usuarioAutenticado = authenticationManager.authenticate(authToken);
         var JWToken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return  ResponseEntity.ok(new DatosJWToken(JWToken));
    }
}
