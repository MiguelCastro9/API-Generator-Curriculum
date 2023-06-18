package com.apiGeneratorCurriculum.resources;

import com.apiGeneratorCurriculum.response.CurriculumResponse;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.io.IOException;

/**
 *
 * @author Miguel Castro
 */
public class ExportCurriculumPdf {

    public static ByteArrayInputStream curriculumExportPdf(CurriculumResponse curriculum) throws IOException, BadElementException {

        ByteArrayOutputStream saida = new ByteArrayOutputStream();
        Document documento = new Document();
        documento.setPageSize(PageSize.A4);

        try {
            PdfWriter.getInstance(documento, saida);
            documento.open();

            Font fontTitulo = new Font(Font.FontFamily.HELVETICA, 26);
            fontTitulo.setColor(new BaseColor(0x36, 0x37, 0x44).brighter());

            Font fontSubTitulo = new Font(Font.FontFamily.HELVETICA, 15);
            fontSubTitulo.setColor(new BaseColor(0x4A, 0x86, 0xE8));

            Font fontTexto = new Font(Font.FontFamily.HELVETICA, 13);
            fontTexto.setColor(BaseColor.GRAY);

            LineSeparator linha = new LineSeparator();
            linha.setLineColor(new BaseColor(0x4A, 0x86, 0xE8));
            linha.setLineWidth(5);
            documento.add(new Chunk(linha));

            Paragraph pulaLinha = new Paragraph();
            pulaLinha.add("\n");
            documento.add(pulaLinha);

            // *********************** NOME COMPLETO *********************** //
            Paragraph paragrafoNomeCompleto = new Paragraph();
            Chunk styleNomeCompleto = new Chunk(curriculum.getNome_completo(), fontTitulo);
            paragrafoNomeCompleto.add(styleNomeCompleto);
            documento.add(paragrafoNomeCompleto);
            documento.add(pulaLinha);

            // *********************** CARGO ATUAL *********************** //
            Paragraph paragrafoCargoAtual = new Paragraph();
            Chunk styleCargoAtual = new Chunk(curriculum.getCargo_atual(), fontSubTitulo);
            paragrafoCargoAtual.add(styleCargoAtual);
            documento.add(paragrafoCargoAtual);
            documento.add(pulaLinha);
            // *********************** ESTADO E PAIS *********************** //
            Paragraph paragrafoEstadoPais = new Paragraph();
            Chunk styleEstadoPais = new Chunk(curriculum.getEstado() + " - " + curriculum.getPais(), fontTexto);
            paragrafoEstadoPais.add(styleEstadoPais);
            documento.add(paragrafoEstadoPais);

            // *********************** NÚMERO CONTATO *********************** //
            Paragraph paragrafoNumeroContato = new Paragraph();
            Chunk styleNumeroContato = new Chunk(curriculum.getNumero_contato(), fontTexto);
            paragrafoNumeroContato.add(styleNumeroContato);
            documento.add(paragrafoNumeroContato);

            // *********************** E-MAIL CONTATO *********************** //
            Paragraph paragrafoEmailContato = new Paragraph();
            Chunk styleEmailContato = new Chunk(curriculum.getEmail_contato(), fontTexto);
            paragrafoEmailContato.add(styleEmailContato);
            documento.add(paragrafoEmailContato);

            // *********************** LINKS DE CONTATO *********************** //
            Paragraph paragrafoLinksContato = new Paragraph();
            curriculum.getLinks_contato().stream()
                    .forEach(e -> {
                        Chunk styleLinksContato = new Chunk(e, fontTexto);
                        paragrafoLinksContato.add(styleLinksContato);
                        paragrafoLinksContato.add("\n");
                    });
            documento.add(paragrafoLinksContato);
            documento.add(pulaLinha);

            // *********************** OBJETIVO PROFISSIONAL *********************** //
            Paragraph paragrafoTituloObjetivoProfissional = new Paragraph();
            Chunk styleParagrafoTituloObjetivoProfissional = new Chunk("OBJETIVO PROFISIONAL", fontSubTitulo);
            paragrafoTituloObjetivoProfissional.add(styleParagrafoTituloObjetivoProfissional);
            documento.add(paragrafoTituloObjetivoProfissional);

            Paragraph paragrafoObjetivoProfissional = new Paragraph();
            Chunk styleParagrafoObjetivoProfissional = new Chunk(curriculum.getObjetivo_profissional(), fontTexto);
            paragrafoObjetivoProfissional.add(styleParagrafoObjetivoProfissional);
            documento.add(paragrafoObjetivoProfissional);
            documento.add(pulaLinha);

            // *********************** EXPERIÊNCIAS PROFISSIONAIS *********************** //
            Paragraph paragrafoTituloExperienciaProfissional = new Paragraph();
            Chunk styleParagrafoTituloExperienciaProfissional = new Chunk("EXPERIÊNCIAS PROFISSIONAIS", fontSubTitulo);
            paragrafoTituloExperienciaProfissional.add(styleParagrafoTituloExperienciaProfissional);
            documento.add(paragrafoTituloExperienciaProfissional);

            Paragraph paragrafoExperienciaProfissional = new Paragraph();
            Font fontParagrafoExperienciaProfissionalEmpresa = new Font(Font.FontFamily.HELVETICA, 13);
            fontParagrafoExperienciaProfissionalEmpresa.setColor(BaseColor.BLACK);
            Font fontParagrafoExperienciaProfissionalCargo = new Font(Font.FontFamily.HELVETICA, 13, Font.BOLD);
            fontParagrafoExperienciaProfissionalCargo.setColor(BaseColor.GRAY);
            curriculum.getExperiencias_profissionais().stream()
                    .forEach(e -> {
                        Chunk styleParagrafoExperienciaProfissionalEmpresa = new Chunk(e.getNome_empresa(), fontParagrafoExperienciaProfissionalEmpresa);
                        if (e.getData_fim() == null) {
                            e.setData_fim("Atualmente");
                        }
                        Chunk styleParagrafoExperienciaProfissionalCargoDataInicioFim = new Chunk(e.getCargo() + " " + e.getData_inicio() + " - " + e.getData_fim(), fontParagrafoExperienciaProfissionalCargo);
                        Chunk styleParagrafoExperienciaProfissionalDescricao = new Chunk(e.getDescricao_cargo(), fontTexto);
                        paragrafoExperienciaProfissional.add(styleParagrafoExperienciaProfissionalEmpresa);
                        paragrafoExperienciaProfissional.add("\n");
                        paragrafoExperienciaProfissional.add(styleParagrafoExperienciaProfissionalCargoDataInicioFim);
                        paragrafoExperienciaProfissional.add("\n");
                        paragrafoExperienciaProfissional.add(styleParagrafoExperienciaProfissionalDescricao);
                        paragrafoExperienciaProfissional.add("\n");
                    });
            documento.add(paragrafoExperienciaProfissional);
            documento.add(pulaLinha);

            // *********************** CONHECIMENTOS E EXPERIÊNCIAS *********************** //
            Paragraph paragrafoTituloConhecimentoExperiencia = new Paragraph();
            Chunk styleParagrafoTituloConhecimentoExperiencia = new Chunk("CONHECIMENTOS E EXPERIÊNCIAS", fontSubTitulo);
            paragrafoTituloConhecimentoExperiencia.add(styleParagrafoTituloConhecimentoExperiencia);
            documento.add(paragrafoTituloConhecimentoExperiencia);

            Paragraph paragrafoConhecimentoExperiencia = new Paragraph();
            curriculum.getConhecimentos().stream()
                    .forEach(e -> {
                        Chunk styleConhecimentoExperiencia = new Chunk("• " + e, fontTexto);
                        paragrafoConhecimentoExperiencia.add(styleConhecimentoExperiencia);
                        paragrafoConhecimentoExperiencia.add("\n");
                    });
            documento.add(paragrafoConhecimentoExperiencia);
            documento.add(pulaLinha);

            // *********************** FORMAÇÃO ACADÊMICA *********************** //
            Paragraph paragrafoTituloFormacaoAcademica = new Paragraph();
            Chunk styleParagrafoTituloFormacaoAcademica = new Chunk("FORMAÇÕES ACADÊMICAS", fontSubTitulo);
            paragrafoTituloFormacaoAcademica.add(styleParagrafoTituloFormacaoAcademica);
            documento.add(paragrafoTituloFormacaoAcademica);

            Paragraph paragrafoFormacaoAcademica = new Paragraph();
            curriculum.getFormacoes_academicas().stream()
                    .forEach(e -> {
                        if (e.getData_fim() == null) {
                            e.setData_fim("Atualmente");
                        }
                        Chunk styleParagrafoFormacaoAcademicaCursoDataInicioFim = new Chunk(e.getNome_curso() + " " + e.getData_inicio() + " - " + e.getData_fim(), fontTexto);
                        Chunk styleParagrafoFormacaoAcademicaInstituicao = new Chunk(e.getNome_instituicao(), fontTexto);
                        paragrafoFormacaoAcademica.add(styleParagrafoFormacaoAcademicaCursoDataInicioFim);
                        paragrafoFormacaoAcademica.add("\n");
                        paragrafoFormacaoAcademica.add(styleParagrafoFormacaoAcademicaInstituicao);
                        paragrafoFormacaoAcademica.add("\n");
                    });
            documento.add(paragrafoFormacaoAcademica);
            documento.add(pulaLinha);

            // *********************** IDIOMAS *********************** //
            Paragraph paragrafoTituloIdioma = new Paragraph();
            Chunk styleParagrafoTituloIdioma = new Chunk("IDIOMAS", fontSubTitulo);
            paragrafoTituloIdioma.add(styleParagrafoTituloIdioma);
            documento.add(paragrafoTituloIdioma);

            Paragraph paragrafoIdioma = new Paragraph();
            Font fontParagrafoIdiomaNome = new Font(Font.FontFamily.HELVETICA, 13, Font.BOLD);
            fontParagrafoIdiomaNome.setColor(BaseColor.GRAY);
            curriculum.getIdiomas().stream()
                    .forEach(e -> {
                        Chunk styleParagrafoIdiomaNome = new Chunk(e.getNome_idioma(), fontParagrafoIdiomaNome);
                        Chunk styleParagrafoIdiomaNivelConversacao = new Chunk("Conversação: " + e.getNivel_conversacao().toString() + "%", fontTexto);
                        Chunk styleParagrafoIdiomaNivelEscritaLeitura = new Chunk("Escrita/Leitura: " + e.getNivel_escrita_leitura().toString() + "%", fontTexto);
                        paragrafoIdioma.add(styleParagrafoIdiomaNome);
                        paragrafoIdioma.add("\n");
                        paragrafoIdioma.add(styleParagrafoIdiomaNivelConversacao);
                        paragrafoIdioma.add("\n");
                        paragrafoIdioma.add(styleParagrafoIdiomaNivelEscritaLeitura);
                        paragrafoIdioma.add("\n");
                        paragrafoIdioma.add("\n");
                    });
            documento.add(paragrafoIdioma);

            // *********************** COPYRIGHT *********************** //
            documento.add(new Chunk(linha));
            Paragraph paragrafoCopyright = new Paragraph();
            paragrafoCopyright.setAlignment(Element.ALIGN_CENTER);
            Font fontparagrafoCopyright = new Font(Font.FontFamily.HELVETICA, 10);
            fontparagrafoCopyright.setColor(BaseColor.GRAY);
            Chunk styleparagrafoCopyriht = new Chunk("© Generator Curriculum - Miguel Castro", fontparagrafoCopyright);
            paragrafoCopyright.add(styleparagrafoCopyriht);
            documento.add(paragrafoCopyright);
            documento.close();

        } catch (DocumentException erro) {
            erro.getMessage();
        }

        return new ByteArrayInputStream(saida.toByteArray());
    }
}
