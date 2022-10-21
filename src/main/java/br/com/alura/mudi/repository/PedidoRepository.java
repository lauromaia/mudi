package br.com.alura.mudi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.mudi.modelo.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
