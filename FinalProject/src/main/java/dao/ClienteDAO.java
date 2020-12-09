package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Cliente;

public interface ClienteDAO extends JpaRepository<Cliente, Long>{

}
