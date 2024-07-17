package alura.cursos.foro_hub.infra.errores;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratamientoErrores {
        
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratamientoError404(){
         return  ResponseEntity.notFound().build();
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public  ResponseEntity tratamientoErrorPost404(MethodArgumentNotValidException e){
        var errores = e.getFieldErrors().stream().map(DatoErrorValidation::new).toList();
        
        return  ResponseEntity.badRequest().body(errores);
    }
    public record DatoErrorValidation(String campo, String error){
    public  DatoErrorValidation(FieldError error){
        this(error.getField(),error.getDefaultMessage());
    }
    }
}
