package br.com.softplan.component.process;

import br.com.softplan.component.process.dto.ProcessDetailOutputDto;
import br.com.softplan.component.process.dto.ProcessFeedbackInputDto;
import br.com.softplan.component.process.dto.ProcessInputDto;
import br.com.softplan.component.process.dto.ProcessOutputDto;
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

@Api(tags = {"PROCESS"})
@RestController
@RequestMapping(value = "/process")
public class ProcessController {

    private final ProcessService processService;

    public ProcessController(ProcessService processService) {
        this.processService = processService;
    }

    @ApiOperation(value = "${process.controller.post}",
            consumes = "application/json", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created", response = Long.class)})
    @PreAuthorize("hasAnyRole('" + RolesAllowedConstants.TRIATOR + "')")
    @PostMapping
    public ResponseEntity<Long> create(@RequestBody ProcessInputDto process) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(processService.create(process));
    }

    @ApiOperation(value = "${process.controller.put}",
            consumes = "application/json", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Update", response = Long.class)})
    @PreAuthorize("hasAnyRole('" + RolesAllowedConstants.TRIATOR + "')")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Long> update(@RequestBody ProcessInputDto process, @PathVariable final Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(processService.update(process, id));
    }

    @ApiOperation(value = "${process.controller.all}", produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = ProcessOutputDto.class)})
    @PreAuthorize("hasAnyRole('"
            + RolesAllowedConstants.ADMIN + "', '"
            + RolesAllowedConstants.TRIATOR + "', '"
            + RolesAllowedConstants.FINISHER + "')")
    @GetMapping
    public ResponseEntity<List<ProcessOutputDto>> findAll() {
        return ResponseEntity.ok().body(processService.findAll());
    }

    @ApiOperation(value = "${process.controller.feedback.post}",
            consumes = "application/json", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created", response = Long.class)})
    @PreAuthorize("hasAnyRole('" + RolesAllowedConstants.TRIATOR + "', '"
            + RolesAllowedConstants.FINISHER + "')")
    @RequestMapping(value = "/feedback/{id}", method = RequestMethod.POST)
    public ResponseEntity<Long> insertFeedback(@RequestBody ProcessFeedbackInputDto inputDto, @PathVariable final Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(processService.insertFeedback(inputDto, id));
    }

    @ApiOperation(value = "${process.controller.detail}", produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = ProcessDetailOutputDto.class)})
    @PreAuthorize("hasAnyRole('"
            + RolesAllowedConstants.ADMIN + "', '"
            + RolesAllowedConstants.TRIATOR + "', '"
            + RolesAllowedConstants.FINISHER + "')")
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public ResponseEntity<ProcessDetailOutputDto> getDetail(@PathVariable final Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(processService.getDetail(id));
    }
}
