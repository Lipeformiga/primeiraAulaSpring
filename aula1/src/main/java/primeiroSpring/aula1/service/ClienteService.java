package primeiroSpring.aula1.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import primeiroSpring.aula1.model.exceptions.MesmoTitularException;
import primeiroSpring.aula1.model.dto.cliente.ClientePostRequestDTO;
import primeiroSpring.aula1.model.dto.cliente.ClientePutRequestDTO;
import primeiroSpring.aula1.model.entity.Cliente;
import primeiroSpring.aula1.model.entity.Conta;
import primeiroSpring.aula1.repository.ClienteRepository;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ClienteService {

    private ClienteRepository repository;
    private final ContaService contaService;

    public Cliente cadastrar(@Valid ClientePostRequestDTO clienteDTO) {
        Cliente cliente = clienteDTO.convert();
        return repository.save(cliente);
    }

    public Cliente editar(@Valid ClientePutRequestDTO clienteDTO, @NotNull @Positive Integer id) {

        if (repository.existsById(id)) {
            Cliente cliente = clienteDTO.convert();
            // tem que colocar pois o cliente ainda não tem id:
            cliente.setId(id);
            return repository.save(cliente);
        }
        throw new NoSuchElementException();
    }

    public Cliente alterarConta(@NotNull @Positive Integer id, @NotNull @Positive Integer idConta) {
        Cliente cliente = repository.findById(id).get();
        Conta conta = contaService.buscarConta(idConta);
        if (cliente.getContas().contains(conta)) {
            cliente.removerConta(conta);
        } else if (conta.getTitular() == null) {
                cliente.addConta(conta);
        } else {
            throw new MesmoTitularException();
        }
        return repository.save(cliente);
    }

    public Cliente buscar(@NotNull @Positive Integer id) {
        return repository.findById(id).get();
    }

    public Page<Cliente> buscar(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public void remover(@NotNull @Positive Integer id) {
        repository.deleteById(id);
    }
}
