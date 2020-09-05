package br.com.softplan.component.process;

import br.com.softplan.component.process.dto.ProcessInputDto;
import br.com.softplan.component.process.dto.ProcessOutputDto;
import br.com.softplan.config.security.RolesAllowedConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/process")
public class ProcessController {

    private final ProcessService processService;

    public ProcessController(ProcessService processService) {
        this.processService = processService;
    }

    @PreAuthorize("hasAnyRole('" + RolesAllowedConstants.TRIATOR + "')")
    @PostMapping
    public ResponseEntity<Long> create(@RequestBody ProcessInputDto process) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(processService.create(process));
    }

    @PreAuthorize("hasAnyRole('" + RolesAllowedConstants.TRIATOR + "')")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Long> update(@RequestBody ProcessInputDto process, @PathVariable final Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(processService.update(process, id));
    }

    @PreAuthorize("hasAnyRole('"
            + RolesAllowedConstants.ADMIN + "', '"
            + RolesAllowedConstants.TRIATOR + "')")
    @GetMapping
    public ResponseEntity<List<ProcessOutputDto>> findAll() {
        return ResponseEntity.ok().body(processService.findAll());
    }
}
