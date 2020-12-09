package service;

import java.util.List;
import java.util.Optional;

import dao.ClienteDAO;
import entity.Cliente;

public class ClientesImpl implements ClienteService {

	@SuppressWarnings("unused")
	private ClienteDAO dao;
	@Override
	public void add(Cliente C) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Cliente> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Cliente cliente) {
		// TODO Auto-generated method stub

	}

	@Override
	public Optional<Cliente> findById(long idCliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long idCliente) {
		// TODO Auto-generated method stub

	}

}
