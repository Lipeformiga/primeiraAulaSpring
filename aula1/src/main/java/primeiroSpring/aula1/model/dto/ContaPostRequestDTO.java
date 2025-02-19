package primeiroSpring.aula1.model.dto;

import jakarta.validation.constraints.*;
import primeiroSpring.aula1.model.entity.Conta;

public record ContaPostRequestDTO (
        @NotBlank
        String titular,
        @Positive @NotNull
        Integer numero,
        @PositiveOrZero
        Double limite){

    public Conta convert() {
        return Conta.builder().titular(titular).numero(numero).limite(limite).build();
    }
}
