package controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.Cliente;
import service.ClienteService;

public class ClientesController {
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping("/Clientes")
	public List<Cliente> list() {
		return clienteService.list();
	}
	
	@PostMapping("/Clientes")
	public void save(@RequestBody Cliente C) {
		clienteService.add(C);
	}

	@DeleteMapping("/Clientes/{idCliente}")
	public void delete(@PathVariable long idAtendimento) {
		clienteService.deleteById(idAtendimento);
	}

	@RequestMapping("/Clientes/{idCliente}")
	public Cliente findById(@PathVariable long idCliente) {
		return clienteService.findById(idCliente).get();
	}

	@PutMapping("/Clientes/{idCliente}")
	public void update(@PathVariable long idAtendimento, @RequestBody Cliente newCliente) {
		Optional<Cliente> oldCliente = clienteService.findById(idAtendimento);
		if (oldCliente.isPresent()) {
			Cliente cliente = oldCliente.get();
			cliente.setNome(newCliente.getNome());
			cliente.setEmpresa(newCliente.getEmpresa());
			cliente.setCpf(newCliente.getCpf());
			clienteService.add(cliente);
		}
	}

}
