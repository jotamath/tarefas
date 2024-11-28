package io.github.jotamath.tarefas.repository;

import io.github.jotamath.tarefas.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    List<Tarefa> findByConcluidaorderByDataCriacaoDesc(boolean concluida);
}
