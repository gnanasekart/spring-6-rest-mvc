package tgs.springframework.spring6restmvc.controller;

import org.springframework.http.ResponseEntity;

//@ControllerAdvice
public class ExceptionController {
   // @ExceptionHandler(NotFoundException.class)
    public ResponseEntity handleNotFoundException(){
        System.out.println("In Exception handler");
        return ResponseEntity.notFound().build();
    }
}
