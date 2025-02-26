package primeiroSpring.aula1.Controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import primeiroSpring.aula1.model.dto.ClientePostRequestDTO;
import primeiroSpring.aula1.model.dto.ClientePutRequestDTO;
import primeiroSpring.aula1.model.entity.Cliente;
import primeiroSpring.aula1.service.ClienteService;

import java.util.List;

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
    public Cliente editar(@RequestBody @Valid ClientePutRequestDTO clienteDTO,
                          @PathVariable Integer id){
        return service.editar(clienteDTO, id);
    }

//    @PatchMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public Cliente alterarContas( @PathVariable Integer id, @RequestParam Integer idConta){
//        return service.alterarConta(id, idConta);
//    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente buscarCliente(@PathVariable Integer id){
        return service.buscar(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<Cliente> buscarClientes(@PageableDefault(
            size = 20,
            sort = "nome",
            direction = Sort.Direction.DESC,
            page = 0
    ) Pageable pageable){
        return service.buscar(pageable);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerCliente(@PathVariable Integer id){
        service.remover(id);
    }
}
