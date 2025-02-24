package primeiroSpring.aula1.Controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import primeiroSpring.aula1.model.dto.ContaPostRequestDTO;
import primeiroSpring.aula1.model.entity.Conta;
import primeiroSpring.aula1.service.ContaService;

import java.sql.SQLException;
import java.util.List;

//@Component é uma das anotações que identificam uma classe como a @Service e a @RestController mas generico
@RestController
@RequestMapping("/conta")
@AllArgsConstructor
public class ContaController {

    private ContaService contaService;

    //  @RequestMapping(method = RequestMethod.GET, value = "/ola")
    @GetMapping("/ola") // mesma coisa que o de cima só que de uma forma mais simplificada
    public String metodoGet(){
        return "Hello World";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Conta cadastrarConta(@RequestBody @Valid ContaPostRequestDTO contaDTO){
        return contaService.criarConta(contaDTO);
    }

    @GetMapping
    public List<Conta> listarContas(){
        return contaService.buscarContas();
    }

    @GetMapping("/page")
    public Page<Conta> listarContasPage(
            @PageableDefault(
                    size = 20,
                    sort = "saldo",
                    direction = Sort.Direction.DESC,
                    page = 0
            ) Pageable pageable){
        return contaService.buscarContas(pageable);
    }

    @GetMapping("/{id}")
    public Conta buscarContaPorId(@PathVariable Integer id){
        return contaService.buscarConta(id);
    }

    @DeleteMapping("/{id}")
    public String removerConta(@PathVariable Integer id){
        contaService.deletarConta(id);
        return "Conta removida com sucesso!";
    }

    @PutMapping("/{id}")
    public Conta atualizarConta(@PathVariable Integer id, @RequestBody Conta conta){
        return contaService.atualizarConta(conta, id);
    }

    @PatchMapping("/{id}")
    public Conta alterarLimite(@RequestParam Double limite, @PathVariable Integer id){
        return contaService.alterarLimite(id, limite);
    }
}