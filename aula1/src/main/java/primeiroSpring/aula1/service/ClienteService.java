package primeiroSpring.aula1.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import primeiroSpring.aula1.model.dto.ClientePostRequestDTO;
import primeiroSpring.aula1.model.dto.ClientePutRequestDTO;
import primeiroSpring.aula1.model.entity.Cliente;
import primeiroSpring.aula1.repository.ClienteRepository;
import primeiroSpring.aula1.repository.ContaRepository;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ClienteService {

    private ClienteRepository repository;

    public Cliente cadastrar(@Valid ClientePostRequestDTO clienteDTO) {
        Cliente cliente = clienteDTO.convert();
        return repository.save(cliente);
    }

    public Cliente editar(@Valid ClientePutRequestDTO clienteDTO, @NotNull @Positive Integer id) {

        if (repository.existsById(id)) {
            Cliente cliente = clienteDTO.convert();
            return repository.save(cliente);
        }
        throw new NoSuchElementException();
    }

//    public Cliente alterarConta(@NotNull @Positive Integer id, @NotNull @Positive Integer idConta) {
//
//    }

    public Cliente buscar(Integer id) {
        return repository.findById(id).get();
    }

    public Page<Cliente> buscar(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public void remover(Integer id) {
        repository.deleteById(id);
    }
}
