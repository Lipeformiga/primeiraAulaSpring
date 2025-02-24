package primeiroSpring.aula1.model.dto;

public record ClientePostRequestDTO(
        String nome,
        Long cpf
) {
}
