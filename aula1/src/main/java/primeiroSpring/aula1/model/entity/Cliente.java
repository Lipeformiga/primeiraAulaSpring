package primeiroSpring.aula1.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import primeiroSpring.aula1.model.dto.cliente.ClienteContaGetResponseDTO;
import primeiroSpring.aula1.model.dto.cliente.ClienteResponseDTO;
import primeiroSpring.aula1.model.dto.conta.ContaClienteResponseDTO;

import java.util.*;
import java.util.stream.Collectors;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "tb_cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Long cpf;
    @OneToMany(mappedBy = "titular")
    private Set<Conta> contas;

    public void addConta(@NotNull Conta conta) {
        this.contas.add(conta);
    }

    public void removerConta(@NotNull Conta conta) {
        this.contas.remove(conta);
    }

    public Set<Conta> getContas() {
        if(this.contas != null) {
            return Collections.unmodifiableSet(this.contas);
        }
        return new HashSet<>();
    }

    public ClienteContaGetResponseDTO convert() {
        return new ClienteContaGetResponseDTO(
                this.id,this.nome,this.cpf
        );
    }

    public ClienteResponseDTO convertoToClienteResponseDTO() {
        Set<ContaClienteResponseDTO> contasDTO = this.contas.stream().map(Conta::convertToContaClienteResponseDTO).collect(Collectors.toSet());
        return new ClienteResponseDTO(this.id,this.nome,this.cpf, contasDTO);
    }
}