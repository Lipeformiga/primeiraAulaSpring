package primeiroSpring.aula1.model;

import lombok.*;

@Data
@AllArgsConstructor
public class Conta {

    private int numero;
    private double saldo;
    private double limite;
    private String titular;
}
