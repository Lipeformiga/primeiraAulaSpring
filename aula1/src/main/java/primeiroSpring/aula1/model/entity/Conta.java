package primeiroSpring.aula1.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    @ManyToMany(mappedBy = "contas")
    private List<Cliente> titulares;

//    public static ContaBuilder builder(){
//        return new ContaBuilder();
//    }
//
//    public static class ContaBuilder{
//        private Integer id;
//        private Integer numero;
//        private Double saldo;
//        private Double limite;
//        private String titular;
//
//        public ContaBuilder titular(String titular){
//            this.titular = titular;
//            return this;
//        }
//
//        public ContaBuilder numero(Integer titular){
//            this.limite = limite;
//            return this;
//        }
//
//        public ContaBuilder limite(double limite){
//            this.limite = limite;
//            return this;
//        }
//
//        public Conta build(){
//            return new Conta(id,numero,saldo,limite,titular);
//        }
//    }
}