package io.github.jotamath.tarefas.controller;

import io.github.jotamath.tarefas.model.Tarefa;
import io.github.jotamath.tarefas.service.TarefaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
@RequiredArgsConstructor
public class TarefaController {
    private final TarefaService service;

    public TarefaController(TarefaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Tarefa> criarTarefa(@RequestBody Tarefa tarefa) {
        return ResponseEntity.ok(service.criarTarefa(tarefa));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Tarefa> atualizarStatus(
            @PathVariable Long id,
            @RequestParam boolean concluida
    ) {
        return ResponseEntity.ok(service.atualizarStatus(id, concluida));
    }

    @GetMapping
    public ResponseEntity<List<Tarefa>> listarTarefas(
            @RequestParam(defaultValue = "false") boolean apenasNaoConcluidas
    ) {
        return ResponseEntity.ok(service.listarTarefas(apenasNaoConcluidas));
    }
}
