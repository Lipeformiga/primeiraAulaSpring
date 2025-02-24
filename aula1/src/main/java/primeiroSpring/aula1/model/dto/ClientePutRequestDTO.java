package primeiroSpring.aula1.model.dto;

import primeiroSpring.aula1.model.entity.Conta;

import java.util.List;

public record ClientePutRequestDTO(
        String nome,
        Long cpf,
        List<Conta> contas
) {
}
