package service;

import java.util.List;
import java.util.Optional;

import entity.Cliente;

public interface ClienteService {
	
	void add(Cliente C);
	
	List<Cliente> list();

	void delete(Cliente cliente);
	
	Optional<Cliente> findById(long idCliente);

	void deleteById(Long idCliente);
}
