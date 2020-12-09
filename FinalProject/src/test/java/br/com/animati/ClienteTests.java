package br.com.animati;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import entity.Cliente;
import service.ClienteService;

@SpringBootTest
class ClienteTests {
	
	@Autowired
	private ClienteService clienteService;

	void init() {
		Cliente C1 = new Cliente();
		C1.setNome("Anderson Nunes");
		C1.setCpf("4322021102-22");
		
		clienteService.add(C1);
		
		Cliente C2 = new Cliente();
		C2.setNome("Rafael Scheidt");
		C2.setCpf("0010010001-12");
		
		clienteService.add(C2);
	}
	
	@Test
	void listTest() {
		init();
		List<Cliente> list = clienteService.list();
		assertEquals(2, list.size());
	}
	
	@Test
	void deleteTest() {
		Cliente cliente = clienteService.findById(1).get();
		clienteService.delete(cliente);
		
		List<Cliente> list = clienteService.list();
		assertEquals(1, list.size());
	}
	
	@Test
	void editTest() {
		Cliente cliente = clienteService.findById(2).get();
		String nome = "Arthur Silva";
		cliente.setNome(nome);
		clienteService.add(cliente);
		
		cliente = clienteService.findById(2).get();
		assertEquals(nome, cliente.getNome());
	}

}
