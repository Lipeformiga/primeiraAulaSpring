package primeiroSpring.aula1.model.dto;

import jakarta.validation.constraints.*;
import primeiroSpring.aula1.model.entity.Cliente;
import primeiroSpring.aula1.model.entity.Conta;

import java.util.List;

public record ContaPostRequestDTO (
        @NotNull
        Cliente titular,
        @Positive @NotNull
        Integer numero,
        @PositiveOrZero
        Double limite){

    public Conta convert() {
        return Conta.builder().titular(titular).numero(numero).limite(limite).build();
    }
}
