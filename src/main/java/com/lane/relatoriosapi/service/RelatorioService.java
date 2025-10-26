package com.lane.relatoriosapi.service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.lane.relatoriosapi.exception.ResourceNotFoundException;
import com.lane.relatoriosapi.model.Relatorio;
import com.lane.relatoriosapi.repository.RelatorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class RelatorioService {

    @Autowired
    private RelatorioRepository repository;

    public Relatorio salvar(Relatorio relatorio) {
        if (relatorio.getTitulo() == null || relatorio.getTitulo().trim().isEmpty()) {
            throw new IllegalArgumentException("O título do relatório é obrigatório.");
        }
        if (relatorio.getAutor() == null || relatorio.getAutor().trim().isEmpty()) {
            throw new IllegalArgumentException("O autor do relatório é obrigatório.");
        }

        relatorio.setDataCriacao(LocalDate.now());
        relatorio.setDataMedicao(LocalDate.now());
        relatorio.setHoraMedicao(LocalTime.now());
        return repository.save(relatorio);
    }

    public List<Relatorio> buscarTodos() {
        return repository.findAll();
    }

    public Relatorio buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Relatório não encontrado com ID: " + id));
    }

    public Relatorio atualizar(Long id, Relatorio relatorioAtualizado) {
        Relatorio relatorioExistente = buscarPorId(id);

        relatorioExistente.setTitulo(relatorioAtualizado.getTitulo());
        relatorioExistente.setDescricao(relatorioAtualizado.getDescricao());
        relatorioExistente.setAutor(relatorioAtualizado.getAutor());
        relatorioExistente.setCrm(relatorioAtualizado.getCrm());
        relatorioExistente.setLargura(relatorioAtualizado.getLargura());
        relatorioExistente.setComprimento(relatorioAtualizado.getComprimento());
        relatorioExistente.setEspessura(relatorioAtualizado.getEspessura());
        relatorioExistente.setDataMedicao(relatorioAtualizado.getDataMedicao());
        relatorioExistente.setHoraMedicao(relatorioAtualizado.getHoraMedicao());

        return repository.save(relatorioExistente);
    }

    public void deletar(Long id) {
        Relatorio relatorioExistente = buscarPorId(id);
        repository.delete(relatorioExistente);
    }


    public ByteArrayInputStream gerarPdf(Relatorio relatorio) throws DocumentException {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        PdfWriter.getInstance(document, out);
        document.open();

        document.add(new Paragraph("Relatório de Macroscopia"));
        document.add(new Paragraph("Título: " + relatorio.getTitulo()));
        document.add(new Paragraph("Descrição: " + relatorio.getDescricao()));
        document.add(new Paragraph("Autor: " + relatorio.getAutor()));
        document.add(new Paragraph("CRM: " + relatorio.getCrm()));
        document.add(new Paragraph("Data: " + relatorio.getDataCriacao()));
        document.add(new Paragraph("Largura: " + relatorio.getLargura()));
        document.add(new Paragraph("Comprimento: " + relatorio.getComprimento()));
        document.add(new Paragraph("Espessura: " + relatorio.getEspessura()));
        document.add(new Paragraph("Data da Medição: " + relatorio.getDataMedicao()));
        document.add(new Paragraph("Hora da Medição: " + relatorio.getHoraMedicao()));

        document.close();
        return new ByteArrayInputStream(out.toByteArray());
    }
}

