package primeiroSpring.aula1.Controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import primeiroSpring.aula1.model.dto.ClientePostRequestDTO;
import primeiroSpring.aula1.model.entity.Cliente;
import primeiroSpring.aula1.service.ClienteService;

@RestController
@RequestMapping("/cliente")
@AllArgsConstructor
public class ClienteController {

    private final ClienteService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente cadastro(@RequestBody @Valid ClientePostRequestDTO clienteDTO){
        return service.cadastrar(clienteDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente editar(@RequestBody @Valid ClientePostRequestDTO clienteDTO,
                          @PathVariable Integer id){
        return service.editar(clienteDTO, id);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)

    @GetMapping
    @ResponseStatus(HttpStatus.OK)

    @GetMapping
    @ResponseStatus(HttpStatus.OK)

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
}
