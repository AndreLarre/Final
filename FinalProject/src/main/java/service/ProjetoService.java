package service;

import java.util.List;
import java.util.Optional;

import entity.Projeto;

public interface ProjetoService {

	void add(Projeto p);
	
	List<Projeto> list();

	void delete(Projeto projeto);
	
	Optional<Projeto> findById(long idProjeto);

	void deleteById(Long idProjeto);

}
