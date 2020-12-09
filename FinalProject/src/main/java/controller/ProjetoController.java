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

import entity.Projeto;
import service.ProjetoService;

public class ProjetoController {
	@Autowired
	private ProjetoService projetoService;
	
	@RequestMapping("/projeto")
	public List<Projeto> list() {
		return projetoService.list();
	}
	
	@PostMapping("/projeto")
	public void save(@RequestBody Projeto P) {
		projetoService.add(P);
	}

	@DeleteMapping("/projeto/{idProjeto}")
	public void delete(@PathVariable long idProjeto) {
		projetoService.deleteById(idProjeto);
	}

	@RequestMapping("/projeto/{idProjeto}")
	public Projeto findById(@PathVariable long idProjeto) {
		return projetoService.findById(idProjeto).get();
	}

	@PutMapping("/projeto/{idProjeto}")
	public void update(@PathVariable long idProjeto, @RequestBody Projeto newProjeto) {
		Optional<Projeto> oldProjeto = projetoService.findById(idProjeto);
		if (oldProjeto.isPresent()) {
			Projeto projeto = oldProjeto.get();
			projeto.setNome(newProjeto.getNome());
			projeto.setSenha(newProjeto.getSenha());
			projeto.setEmpresa(newProjeto.getEmpresa());
			projetoService.add(projeto);
		}
	}
}
