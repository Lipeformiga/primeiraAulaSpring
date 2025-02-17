package primeiroSpring.aula1.Controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import primeiroSpring.aula1.model.Conta;
import primeiroSpring.aula1.service.ContaService;

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
    public String cadastrarConta(@RequestBody Conta conta){
        contaService.criarConta(conta);
        return "Conta cadastrada com sucesso!";
    }

    @GetMapping
    public List<Conta> listarContas(){
        return contaService.buscarContas();
    }

    @GetMapping("/{id}")
    public Conta nuscarContaPorId(@PathVariable Integer id){
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
        return contaService.alterarLimite(id,limite);
    }
}