package com.lane.relatoriosapi.controller;

import com.itextpdf.text.DocumentException;
import com.lane.relatoriosapi.model.Relatorio;
import com.lane.relatoriosapi.service.RelatorioService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/relatorios")
public class RelatorioController {

    @Autowired
    private RelatorioService service;

    // POST /api/relatorios - Criar Relatório 
    @PostMapping
    public ResponseEntity<Relatorio> criarRelatorio(@RequestBody Relatorio relatorio) {
        Relatorio salvo = service.salvar(relatorio);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    // GET /api/relatorios - Listar todos os Relatórios 
    @GetMapping
    public ResponseEntity<List<Relatorio>> buscarTodos() {
        List<Relatorio> relatorios = service.buscarTodos();
        return ResponseEntity.ok(relatorios);
    }

    // GET /api/relatorios/{id} - Buscar Relatório por ID 
    @GetMapping("/{id}")
    public ResponseEntity<Relatorio> buscarPorId(@PathVariable Long id) {
        Relatorio relatorio = service.buscarPorId(id);
        return ResponseEntity.ok(relatorio);
    }

    // PUT /api/relatorios/{id} - Atualizar Relatório 
    @PutMapping("/{id}")
    public ResponseEntity<Relatorio> atualizarRelatorio(@PathVariable Long id, @RequestBody Relatorio relatorio) {
        Relatorio atualizado = service.atualizar(id, relatorio);
        return ResponseEntity.ok(atualizado);
    }

    // DELETE /api/relatorios/{id} - Deletar Relatório 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarRelatorio(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    // GET /api/relatorios/{id}/pdf - Gerar PDF
    @GetMapping("/{id}/pdf")
    public ResponseEntity<byte[]> gerarPdf(@PathVariable Long id) throws DocumentException {
        var relatorio = service.buscarPorId(id);
        var pdf = service.gerarPdf(relatorio);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=relatorio.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf.readAllBytes());
    }
}

