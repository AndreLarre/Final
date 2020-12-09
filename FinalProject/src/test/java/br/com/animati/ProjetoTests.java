package br.com.animati;

import service.ProjetoService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import entity.Projeto;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProjetoTests {
    @Autowired
    private ProjetoService projetoService;

    void init() {
        Projeto p1 = new Projeto();
        p1.setNome("Anderson Nunes");
        p1.setSenha("12345");

        projetoService.add(p1);

        Projeto p2 = new Projeto();
        p2.setNome("Rafael Scheidt");
        p2.setSenha("54321");

        projetoService.add(p2);
    }

    @Test
    void listTest() {
        init();
        List<Projeto> list = projetoService.list();
        assertEquals(2, list.size());
    }

    @Test
    void deleteTest() {
    	Projeto projeto = projetoService.findById(1).get();
        projetoService.delete(projeto);

        List<Projeto> list = projetoService.list();
        assertEquals(1, list.size());
    }

    @Test
    void editTest() {
    	Projeto projeto = projetoService.findById(2).get();
        String nome = "Joao Silva";
        projeto.setNome(nome);
        projetoService.add(projeto);

        projeto = projetoService.findById(2).get();
        assertEquals(nome, projeto.getNome());
    }
}
