package br.ifpe.pp2.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifpe.pp2.entities.Periodo;

public interface PeriodoDAO extends JpaRepository<Periodo, Integer> {

}
