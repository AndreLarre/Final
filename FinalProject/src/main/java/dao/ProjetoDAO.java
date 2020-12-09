package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Projeto;

public interface ProjetoDAO extends JpaRepository<Projeto, Long> {

}
