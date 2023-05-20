package com.apiGeneratorCurriculum.resources;

import com.apiGeneratorCurriculum.model.Curriculum;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.TextField;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miguel Castro
 */
public class ExportCurriculumPdf {

    public static ByteArrayInputStream curriculumExportPdf(Curriculum curriculum) throws IOException, BadElementException {

        ByteArrayOutputStream saida = new ByteArrayOutputStream();
        Document documento = new Document();
        documento.setPageSize(PageSize.A4);

        try {
            PdfWriter.getInstance(documento, saida);
            documento.open();
            
            //LineSeparator linha = new LineSeparator();
            //linha.setLineColor(new BaseColor(0x36, 0x37, 0x44));
            //linha.setLineWidth(5);
            //documento.add(new Chunk(linha));

            Paragraph pulaLinha = new Paragraph();
            pulaLinha.add("\n");
            // *********************** NOME COMPLETO *********************** //
            Paragraph paragrafoNomeCompleto = new Paragraph();
            Font fontNomeCompleto = new Font(Font.FontFamily.HELVETICA, 26);
            fontNomeCompleto.setColor(new BaseColor(0x36, 0x37, 0x44).brighter());
            Chunk styleNomeCompleto = new Chunk(curriculum.getNome_completo(), fontNomeCompleto);
            paragrafoNomeCompleto.add(styleNomeCompleto);
            documento.add(paragrafoNomeCompleto);
            // *********************** CARGO ATUAL *********************** //
            Paragraph paragrafoCargoAtual = new Paragraph();
            Font fontCargoAtual = new Font(Font.FontFamily.HELVETICA, 15);
            fontCargoAtual.setColor(new BaseColor(0x4A, 0x86, 0xE8));
            Chunk styleCargoAtual = new Chunk(curriculum.getCargo_atual(), fontCargoAtual);
            paragrafoCargoAtual.add(styleCargoAtual);
            documento.add(paragrafoCargoAtual);
            documento.add(pulaLinha);
            // *********************** ESTADO E PAIS *********************** //
            Paragraph paragrafoEstadoPais = new Paragraph();
            Font fontEstadoPais = new Font(Font.FontFamily.HELVETICA, 13);
            fontEstadoPais.setColor(BaseColor.GRAY);
            Chunk styleEstadoPais = new Chunk(curriculum.getEstado() + " - " + curriculum.getPais(), fontEstadoPais);
            paragrafoEstadoPais.add(styleEstadoPais);
            documento.add(paragrafoEstadoPais);
            // *********************** NÚMERO CONTATO *********************** //
            Paragraph paragrafoNumeroContato = new Paragraph();
            Font fontNumeroContato = new Font(Font.FontFamily.HELVETICA, 13);
            fontNumeroContato.setColor(BaseColor.GRAY);
            Chunk styleNumeroContato = new Chunk(curriculum.getNumero_contato(), fontNumeroContato);
            paragrafoNumeroContato.add(styleNumeroContato);
            documento.add(paragrafoNumeroContato);
            // *********************** E-MAIL CONTATO *********************** //
            Paragraph paragrafoEmailContato = new Paragraph();
            Font fontEmailContato = new Font(Font.FontFamily.HELVETICA, 13);
            fontEmailContato.setColor(BaseColor.GRAY);
            Chunk styleEmailContato = new Chunk(curriculum.getEmail_contato(), fontEmailContato);
            paragrafoEmailContato.add(styleEmailContato);
            documento.add(paragrafoEmailContato);
            // *********************** E-MAIL CONTATO *********************** //
            Paragraph paragrafoLinksContato = new Paragraph();
            //List<String> listaLinksContato = Arrays.asList(curriculum.getLinks_contato());
            Font fontLinksContato = new Font(Font.FontFamily.HELVETICA, 13);
            fontLinksContato.setColor(BaseColor.GRAY);
            curriculum.getLinks_contato().stream()
                    .forEach(e -> {
                        Chunk styleLinksContato = new Chunk(e, fontLinksContato);
                        paragrafoLinksContato.add(styleLinksContato);
                        paragrafoLinksContato.add("\n");
                    });
            documento.add(paragrafoLinksContato);
            documento.add(pulaLinha);
            // *********************** OBJETIVO PROFISSIONAL *********************** //
            Paragraph paragrafoTituloObjetivoProfissional = new Paragraph();
            Font fontparagrafoTituloObjetivoProfissional = new Font(Font.FontFamily.HELVETICA, 15);
            fontparagrafoTituloObjetivoProfissional.setColor(new BaseColor(0x4A, 0x86, 0xE8));
            Chunk styleparagrafoTituloObjetivoProfissional = new Chunk("Objetivo Profissional", fontparagrafoTituloObjetivoProfissional);
            paragrafoTituloObjetivoProfissional.add(styleparagrafoTituloObjetivoProfissional);
            documento.add(paragrafoTituloObjetivoProfissional);
            
            Paragraph paragrafoObjetivoProfissional = new Paragraph();
            Font fontparagrafoObjetivoProfissional = new Font(Font.FontFamily.HELVETICA, 13);
            fontparagrafoObjetivoProfissional.setColor(BaseColor.GRAY);
            Chunk styleparagrafoObjetivoProfissional = new Chunk(curriculum.getObjetivo_profissional(), fontparagrafoObjetivoProfissional);
            paragrafoObjetivoProfissional.add(styleparagrafoObjetivoProfissional);
            documento.add(paragrafoObjetivoProfissional);
            
            documento.close();

        } catch (DocumentException erro) {
            erro.getMessage();
        }

        return new ByteArrayInputStream(saida.toByteArray());
    }
}
