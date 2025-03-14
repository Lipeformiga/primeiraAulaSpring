package primeiroSpring.aula1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import primeiroSpring.aula1.model.entity.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer>, JpaSpecificationExecutor<Conta> {
}
