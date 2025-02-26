package primeiroSpring.aula1.model.dto.conta;

import primeiroSpring.aula1.model.dto.cliente.ClienteContaGetResponseDTO;

public record ContaGetResponseDTO(
        Integer id,
        Integer numero,
        Double saldo,
        Double limite,
        ClienteContaGetResponseDTO titular) {

}
