package br.com.softplan.component.user;

import br.com.softplan.component.user.dto.UserInputDto;
import br.com.softplan.component.user.dto.UserOutputDto;
import br.com.softplan.config.security.RolesAllowedConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"USER"})
@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "${user.controller.post}",
            consumes = "application/json", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created", response = Long.class)})
    @PreAuthorize("hasAnyRole('"
            + RolesAllowedConstants.ADMIN + "', '"
            + RolesAllowedConstants.TRIATOR + "')")
    @PostMapping
    public ResponseEntity<Long> create(@RequestBody UserInputDto user) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(user));
    }

    @ApiOperation(value = "${user.controller.put}",
            consumes = "application/json", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Update", response = Long.class)})
    @PreAuthorize("hasAnyRole('"
            + RolesAllowedConstants.ADMIN + "', '"
            + RolesAllowedConstants.TRIATOR + "')")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Long> update(@RequestBody UserInputDto user, @PathVariable final Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.update(user, id));
    }

    @ApiOperation(value = "${user.controller.get}", produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = UserOutputDto.class)})
    @PreAuthorize("hasAnyRole('"
            + RolesAllowedConstants.ADMIN + "', '"
            + RolesAllowedConstants.TRIATOR + "')")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserOutputDto> getUser(@PathVariable final Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.getUser(id));
    }

    @ApiOperation(value = "${user.controller.all}", produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = UserOutputDto.class)})
    @PreAuthorize("hasAnyRole('"
            + RolesAllowedConstants.ADMIN + "', '"
            + RolesAllowedConstants.TRIATOR + "')")
    @GetMapping
    public ResponseEntity<List<UserOutputDto>> findAll() {
        return ResponseEntity.ok().body(userService.findAll());
    }

    @ApiOperation(value = "${user.controller.delete}")
    @ApiResponses(value = {@ApiResponse(code = 204, message = "No Content")})
    @PreAuthorize("hasAnyRole('"
            + RolesAllowedConstants.ADMIN + "', '"
            + RolesAllowedConstants.TRIATOR + "')")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id) throws Exception {
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
    }
}
