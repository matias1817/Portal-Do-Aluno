package br.ifpe.pp2.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifpe.pp2.entities.Instituição;

public interface InstituiçãoDAO extends JpaRepository<Instituição, Integer> {
	public Instituição findBynumeroAndEnderecoAndSite(String numero, String endereco, String site);

}
