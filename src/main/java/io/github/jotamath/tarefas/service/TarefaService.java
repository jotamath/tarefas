package io.github.jotamath.tarefas.service;

import io.github.jotamath.tarefas.model.Tarefa;
import io.github.jotamath.tarefas.repository.TarefaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefaService {
    private final TarefaRepository repository;

    public TarefaService(TarefaRepository repository) {
        this.repository = repository;
    }

    public Tarefa criarTarefa(Tarefa tarefa) {
        return repository.save(tarefa);
    }

    public Tarefa atualizarStatus(Long id, boolean status) {
        Tarefa tarefa = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
        tarefa.setConcluida(status);
        return repository.save(tarefa);
    }

    public List<Tarefa> listarTarefas(boolean apenasNaoConcluidas) {
        return apenasNaoConcluidas
                ? repository.findByConcluidaorderByDataCriacaoDesc(false)
                : repository.findAll();
    }
}
