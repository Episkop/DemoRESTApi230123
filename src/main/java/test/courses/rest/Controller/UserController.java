package test.courses.rest.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.courses.rest.Entity.UserEntity;
import test.courses.rest.Exceptions.UserAlreadyExistException;
import test.courses.rest.Exceptions.UserBDIsEmpty;
import test.courses.rest.Exceptions.UserNotFoundException;
import test.courses.rest.Servise.UserServiseImpl;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserServiseImpl userServise;

    public UserController(UserServiseImpl userServise) {
        this.userServise = userServise;
    }

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity userEntity){
        try{
            userServise.registratoin(userEntity);
            return ResponseEntity.ok("User have saved!");
        }catch (UserAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Warning!!! Server request exception!");
        }
    }

    @GetMapping
    public ResponseEntity getOneUsers(@RequestParam Long id){
        try{
            return ResponseEntity.ok(userServise.foundOneUsers(id));
        }catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Warning!!! Server request exception!");
        }
    }

    @GetMapping("/{username}")
    public ResponseEntity getOneUserName(@PathVariable String username) {
        try{
            return ResponseEntity.ok(userServise.foundOneUserName(username));
        }catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Warning!!! Server request exception!");
        }
    }

    @GetMapping("/")
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(userServise.findAll());
        }catch (UserBDIsEmpty e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Warning!!! Server request exception!");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        try{
            userServise.deleteUser(id);
            return ResponseEntity.ok("Successes! The user was deleted!"+id);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("User not found!");
        }
    }

}
