package aula.sala.mssala.repository;

import aula.sala.mssala.model.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaRepositorio extends JpaRepository<Sala,Long> {
}
