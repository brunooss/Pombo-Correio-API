package com.bossindustries.pombocorreioserver.resource;

import com.bossindustries.pombocorreioserver.model.Response;
import com.bossindustries.pombocorreioserver.model.User;
import com.bossindustries.pombocorreioserver.service.implementation.UserServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static java.util.Map.*;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImplementation userServiceImplementation;

    @GetMapping("/usersList")
    public ResponseEntity<Response> getUsers() {
        return ResponseEntity.ok(
            Response.builder()
                    .timestamp(now())
                    .data(of("users", userServiceImplementation.usersList(30)))
                    .message("Users retrieved")
                    .status(OK)
                    .statusCode(OK.value())
                    .build()
        );
    }

    @PostMapping("/saveUser")
    public ResponseEntity<Response> saveUser(@RequestBody @Valid User user) {
        return ResponseEntity.ok(
            Response.builder()
                    .timestamp(now())
                    .data(of("user", userServiceImplementation.createUser(user)))
                    .message("User created/updated")
                    .status(CREATED)
                    .statusCode(CREATED.value())
                    .build()
        );
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<Response> getUser(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timestamp(now())
                        .data(of("user", userServiceImplementation.getUser(id)))
                        .message("User retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<Response> deleteUser(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timestamp(now())
                        .data(of("deletedUser", userServiceImplementation.deleteUser(id)))
                        .message("User deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
}
