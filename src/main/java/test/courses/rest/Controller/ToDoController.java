package test.courses.rest.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.courses.rest.Entity.ToDoEntity;
import test.courses.rest.Servise.ToDoServiceImpl;

@RestController
@RequestMapping ("/todo")
public class ToDoController {
    private final ToDoServiceImpl service;

    public ToDoController(ToDoServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity createToDo(@RequestBody ToDoEntity toDo,
                                     @RequestParam Long userId){
        try{
            return ResponseEntity.ok(service.createToDo(toDo,userId));
        }catch (Exception e){
            return  ResponseEntity.badRequest().body("Mistake!!!");
        }
    }

    @PutMapping
    public ResponseEntity completed(@RequestParam Long id){
        try{
            return ResponseEntity.ok(service.completed(id));
        }catch (Exception e){
            return  ResponseEntity.badRequest().body("Mistake!!!");
        }
    }
}
