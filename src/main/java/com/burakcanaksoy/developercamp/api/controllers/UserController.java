package com.burakcanaksoy.developercamp.api.controllers;

import com.burakcanaksoy.developercamp.business.abstracts.UserService;
import com.burakcanaksoy.developercamp.core.utilities.results.DataResult;
import com.burakcanaksoy.developercamp.core.utilities.results.ErrorDataResult;
import com.burakcanaksoy.developercamp.entities.concretes.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody User user) {
        return ResponseEntity.ok(userService.add(user));
    }

    @GetMapping("/get-email")
    public DataResult<User> findByEmail(@RequestParam("email") String email){
        return userService.findByEmail(email);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        Map<String,String> errors = new HashMap<>();
        for(FieldError fieldError : exception.getBindingResult().getFieldErrors()){
            errors.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        return new ErrorDataResult<>(errors,"Validation Exceptions");
    }
}
