package primeiroSpring.aula1.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import primeiroSpring.aula1.model.Conta;
import primeiroSpring.aula1.repository.ContaRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ContaService {

    private ContaRepository contaRepository;


    public void criarConta(Conta conta) {
        contaRepository.save(conta);
    }

    public List<Conta> buscarContas() {
        return contaRepository.findAll();
    }

    public Conta buscarConta(Integer id) {
        return contaRepository.findById(id).get();
    }

    public void deletarConta(Integer id) {
        contaRepository.deleteById(id);
    }

    public Conta atualizarConta(Conta conta,Integer id ) {
        conta.setId(id);
        return contaRepository.save(conta);
    }

    public Conta alterarLimite(Integer id, Double limite) {
        Conta conta = buscarConta(id);
        conta.setLimite(limite);
        return contaRepository.save(conta);
    }
}
