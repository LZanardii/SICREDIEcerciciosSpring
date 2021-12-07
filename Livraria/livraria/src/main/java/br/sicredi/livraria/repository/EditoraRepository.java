package br.sicredi.livraria.repository;

import br.sicredi.livraria.model.Editora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EditoraRepository extends JpaRepository<Editora, Integer> {
}
