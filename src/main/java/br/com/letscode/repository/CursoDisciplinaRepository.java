package br.com.letscode.repository;

import br.com.letscode.entity.CursoDisciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoDisciplinaRepository extends JpaRepository<CursoDisciplina, Integer> {


}
