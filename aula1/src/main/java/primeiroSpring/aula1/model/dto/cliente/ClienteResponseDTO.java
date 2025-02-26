package primeiroSpring.aula1.model.dto.cliente;

import primeiroSpring.aula1.model.dto.conta.ContaClienteResponseDTO;

import java.util.Set;

public record ClienteResponseDTO(
        Integer id,
        String nome,
        Long cpf,
        Set<ContaClienteResponseDTO> contas
) {
}
