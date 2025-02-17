package primeiroSpring.aula1.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "tb_conta")
public class Conta {

    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    @Column(name = "numero_da_conta", nullable = false, unique = true)
    private Integer numero;
    @NonNull
    private Double saldo;
    @NonNull
    private Double limite;
    @NonNull
    @Column(nullable = false)
    private String titular;
}