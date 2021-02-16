package coop.tecso.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import coop.tecso.examen.model.Acount;

public interface AcountRepository extends JpaRepository<Acount, Long> {

}
