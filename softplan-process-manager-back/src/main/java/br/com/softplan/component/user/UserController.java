package br.com.softplan.component.user;

import br.com.softplan.component.user.dto.UserInputDto;
import br.com.softplan.component.user.dto.UserOutputDto;
import br.com.softplan.config.security.RolesAllowedConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PreAuthorize("hasAnyRole('"
            + RolesAllowedConstants.ADMIN + "', '"
            + RolesAllowedConstants.TRIATOR + "')")
    @PostMapping
    public ResponseEntity<Long> create(@RequestBody UserInputDto user) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(user));
    }

    @PreAuthorize("hasAnyRole('"
            + RolesAllowedConstants.ADMIN + "', '"
            + RolesAllowedConstants.TRIATOR + "')")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Long> update(@RequestBody UserInputDto user, @PathVariable final Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.update(user, id));
    }

    @PreAuthorize("hasAnyRole('"
            + RolesAllowedConstants.ADMIN + "', '"
            + RolesAllowedConstants.TRIATOR + "')")
    @GetMapping
    public ResponseEntity<List<UserOutputDto>> findAll() {
        return ResponseEntity.ok().body(userService.findAll());
    }

    @PreAuthorize("hasAnyRole('"
            + RolesAllowedConstants.ADMIN + "', '"
            + RolesAllowedConstants.TRIATOR + "')")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id) throws Exception {
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
    }
}
