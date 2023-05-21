package com.apiGeneratorCurriculum.resources;

import com.apiGeneratorCurriculum.model.Curriculum;
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
import java.text.SimpleDateFormat;

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

            LineSeparator linha = new LineSeparator();
            linha.setLineColor(new BaseColor(0x4A, 0x86, 0xE8));
            linha.setLineWidth(5);
            documento.add(new Chunk(linha));
            Paragraph pulaLinha = new Paragraph();
            pulaLinha.add("\n");
            documento.add(pulaLinha);
            // *********************** NOME COMPLETO *********************** //
            Paragraph paragrafoNomeCompleto = new Paragraph();
            Font fontNomeCompleto = new Font(Font.FontFamily.HELVETICA, 26);
            fontNomeCompleto.setColor(new BaseColor(0x36, 0x37, 0x44).brighter());
            Chunk styleNomeCompleto = new Chunk(curriculum.getNome_completo(), fontNomeCompleto);
            paragrafoNomeCompleto.add(styleNomeCompleto);
            documento.add(paragrafoNomeCompleto);
            paragrafoNomeCompleto.setSpacingBefore(50f);
            
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

            // *********************** LINKS DE CONTATO *********************** //
            Paragraph paragrafoLinksContato = new Paragraph();
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
            Chunk styleparagrafoTituloObjetivoProfissional = new Chunk("OBJETIVO PROFISIONAL", fontparagrafoTituloObjetivoProfissional);
            paragrafoTituloObjetivoProfissional.add(styleparagrafoTituloObjetivoProfissional);
            documento.add(paragrafoTituloObjetivoProfissional);

            Paragraph paragrafoObjetivoProfissional = new Paragraph();
            Font fontparagrafoObjetivoProfissional = new Font(Font.FontFamily.HELVETICA, 13);
            fontparagrafoObjetivoProfissional.setColor(BaseColor.GRAY);
            Chunk styleparagrafoObjetivoProfissional = new Chunk(curriculum.getObjetivo_profissional(), fontparagrafoObjetivoProfissional);
            paragrafoObjetivoProfissional.add(styleparagrafoObjetivoProfissional);
            documento.add(paragrafoObjetivoProfissional);
            documento.add(pulaLinha);

            // *********************** EXPERIÊNCIAS PROFISSIONAIS *********************** //
            Paragraph paragrafoTituloExperienciaProfissional = new Paragraph();
            Font fontparagrafoTituloExperienciaProfissional = new Font(Font.FontFamily.HELVETICA, 15);
            fontparagrafoTituloExperienciaProfissional.setColor(new BaseColor(0x4A, 0x86, 0xE8));
            Chunk styleparagrafoTituloExperienciaProfissional = new Chunk("EXPERIÊNCIAS PROFISSIONAIS", fontparagrafoTituloExperienciaProfissional);
            paragrafoTituloExperienciaProfissional.add(styleparagrafoTituloExperienciaProfissional);
            documento.add(paragrafoTituloExperienciaProfissional);

            Paragraph paragrafoExperienciaProfissional = new Paragraph();
            Font fontParagrafoExperienciaProfissionalEmpresa = new Font(Font.FontFamily.HELVETICA, 13);
            fontParagrafoExperienciaProfissionalEmpresa.setColor(BaseColor.BLACK);
            Font fontParagrafoExperienciaProfissionalCargo = new Font(Font.FontFamily.HELVETICA, 13, Font.BOLD);
            fontParagrafoExperienciaProfissionalCargo.setColor(BaseColor.GRAY);
            Font fontParagrafoExperienciaProfissionalDataInicio = new Font(Font.FontFamily.HELVETICA, 13);
            fontParagrafoExperienciaProfissionalDataInicio.setColor(BaseColor.GRAY);
            Font fontParagrafoExperienciaProfissionalDataFim = new Font(Font.FontFamily.HELVETICA, 13);
            fontParagrafoExperienciaProfissionalDataFim.setColor(BaseColor.GRAY);
            Font fontParagrafoExperienciaProfissionalDescricao = new Font(Font.FontFamily.HELVETICA, 13);
            fontParagrafoExperienciaProfissionalDescricao.setColor(BaseColor.GRAY);
            SimpleDateFormat dateFormatExperienciaProfissional = new SimpleDateFormat("MMM/yyyy");
            curriculum.getExperiencias_profissionais().stream()
                    .forEach(e -> {
                        Chunk styleParagrafoExperienciaProfissionalEmpresa = new Chunk(e.getNome_empresa(), fontParagrafoExperienciaProfissionalEmpresa);
                        String dataInicioFormatada = dateFormatExperienciaProfissional.format(e.getData_inicio());
                        String dataFimFormatada = dateFormatExperienciaProfissional.format(e.getData_fim());
                        Chunk styleParagrafoExperienciaProfissionalCargoDataInicioFim = new Chunk(e.getCargo() + " " + dataInicioFormatada + " - " + dataFimFormatada, fontParagrafoExperienciaProfissionalCargo);
                        Chunk styleParagrafoExperienciaProfissionalDescricao = new Chunk(e.getDescricao_cargo(), fontParagrafoExperienciaProfissionalDescricao);
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
            Font fontparagrafoTituloConhecimentoExperiencia = new Font(Font.FontFamily.HELVETICA, 15);
            fontparagrafoTituloConhecimentoExperiencia.setColor(new BaseColor(0x4A, 0x86, 0xE8));
            Chunk styleparagrafoTituloConhecimentoExperiencia = new Chunk("CONHECIMENTOS E EXPERIÊNCIAS", fontparagrafoTituloConhecimentoExperiencia);
            paragrafoTituloConhecimentoExperiencia.add(styleparagrafoTituloConhecimentoExperiencia);
            documento.add(paragrafoTituloConhecimentoExperiencia);

            Paragraph paragrafoConhecimentoExperiencia = new Paragraph();
            Font fontConhecimentoExperiencia = new Font(Font.FontFamily.HELVETICA, 13);
            fontConhecimentoExperiencia.setColor(BaseColor.GRAY);
            curriculum.getConhecimentos().stream()
                    .forEach(e -> {
                        Chunk styleConhecimentoExperiencia = new Chunk("• " + e, fontConhecimentoExperiencia);
                        paragrafoConhecimentoExperiencia.add(styleConhecimentoExperiencia);
                        paragrafoConhecimentoExperiencia.add("\n");
                    });
            documento.add(paragrafoConhecimentoExperiencia);
            documento.add(pulaLinha);

            // *********************** FORMAÇÃO ACADÊMICA *********************** //
            Paragraph paragrafoTituloFormacaoAcademica = new Paragraph();
            Font fontparagrafoTituloFormacaoAcademica = new Font(Font.FontFamily.HELVETICA, 15);
            fontparagrafoTituloFormacaoAcademica.setColor(new BaseColor(0x4A, 0x86, 0xE8));
            Chunk styleparagrafoTituloFormacaoAcademica = new Chunk("FORMAÇÕES ACADÊMICAS", fontparagrafoTituloFormacaoAcademica);
            paragrafoTituloFormacaoAcademica.add(styleparagrafoTituloFormacaoAcademica);
            documento.add(paragrafoTituloFormacaoAcademica);

            Paragraph paragrafoFormacaoAcademica = new Paragraph();
            Font fontParagrafoFormacaoAcademicaCurso = new Font(Font.FontFamily.HELVETICA, 13);
            fontParagrafoFormacaoAcademicaCurso.setColor(BaseColor.GRAY);
            Font fontParagrafoFormacaoAcademicaDataInicio = new Font(Font.FontFamily.HELVETICA, 13, Font.BOLD);
            fontParagrafoFormacaoAcademicaDataInicio.setColor(BaseColor.GRAY);
            Font fontParagrafoFormacaoAcademicaDataFim = new Font(Font.FontFamily.HELVETICA, 13);
            fontParagrafoFormacaoAcademicaDataFim.setColor(BaseColor.GRAY);
            Font fontParagrafoFormacaoAcademicaInstituicao = new Font(Font.FontFamily.HELVETICA, 13);
            fontParagrafoFormacaoAcademicaInstituicao.setColor(BaseColor.GRAY);
            SimpleDateFormat dateFormatFormcacaoAcademica = new SimpleDateFormat("yyyy");
            curriculum.getFormacoes_academicas().stream()
                    .forEach(e -> {
                        String dataInicioFormatada = dateFormatFormcacaoAcademica.format(e.getData_inicio());
                        String dataFimFormatada = dateFormatFormcacaoAcademica.format(e.getData_fim());
                        Chunk styleParagrafoFormacaoAcademicaCursoDataInicioFim = new Chunk(e.getNome_curso() + " " + dataInicioFormatada + " - " + dataFimFormatada, fontParagrafoFormacaoAcademicaCurso);
                        Chunk styleParagrafoFormacaoAcademicaInstituicao = new Chunk(e.getNome_instituicao(), fontParagrafoFormacaoAcademicaInstituicao);
                        paragrafoFormacaoAcademica.add(styleParagrafoFormacaoAcademicaCursoDataInicioFim);
                        paragrafoFormacaoAcademica.add("\n");
                        paragrafoFormacaoAcademica.add(styleParagrafoFormacaoAcademicaInstituicao);
                        paragrafoFormacaoAcademica.add("\n");
                    });
            documento.add(paragrafoFormacaoAcademica);
            documento.add(pulaLinha);

            // *********************** IDIOMAS *********************** //
            Paragraph paragrafoTituloIdioma = new Paragraph();
            Font fontparagrafoTituloIdioma = new Font(Font.FontFamily.HELVETICA, 15);
            fontparagrafoTituloIdioma.setColor(new BaseColor(0x4A, 0x86, 0xE8));
            Chunk styleparagrafoTituloIdioma = new Chunk("IDIOMAS", fontparagrafoTituloIdioma);
            paragrafoTituloIdioma.add(styleparagrafoTituloIdioma);
            documento.add(paragrafoTituloIdioma);

            Paragraph paragrafoIdioma = new Paragraph();
            Font fontParagrafoIdiomaNome = new Font(Font.FontFamily.HELVETICA, 13, Font.BOLD);
            fontParagrafoIdiomaNome.setColor(BaseColor.GRAY);
            Font fontParagrafoIdiomaNivelConversacao = new Font(Font.FontFamily.HELVETICA, 13);
            fontParagrafoIdiomaNivelConversacao.setColor(BaseColor.GRAY);
            Font fontParagrafoIdiomaNivelEscritaLeitura = new Font(Font.FontFamily.HELVETICA, 13);
            fontParagrafoIdiomaNivelEscritaLeitura.setColor(BaseColor.GRAY);
            curriculum.getIdiomas().stream()
                    .forEach(e -> {
                        Chunk styleParagrafoIdiomaNome = new Chunk(e.getNome_idioma(), fontParagrafoIdiomaNome);
                        Chunk styleParagrafoIdiomaNivelConversacao = new Chunk(e.getNivel_conversacao(), fontParagrafoIdiomaNivelConversacao);
                        Chunk styleParagrafoIdiomaNivelEscritaLeitura = new Chunk(e.getNivel_escrita_leitura(), fontParagrafoIdiomaNivelEscritaLeitura);
                        paragrafoIdioma.add(styleParagrafoIdiomaNome);
                        paragrafoIdioma.add("\n");
                        paragrafoIdioma.add(styleParagrafoIdiomaNivelConversacao);
                        paragrafoIdioma.add("\n");
                        paragrafoIdioma.add(styleParagrafoIdiomaNivelEscritaLeitura);
                        paragrafoIdioma.add("\n");
                        paragrafoIdioma.add("\n");
                    });
            documento.add(paragrafoIdioma);

            documento.add(new Chunk(linha));
            Paragraph paragrafoCopyright = new Paragraph();
            paragrafoCopyright.setAlignment(Element.ALIGN_CENTER);
            Font fontparagrafoCopyright = new Font(Font.FontFamily.HELVETICA, 10);
            fontparagrafoCopyright.setColor(BaseColor.GRAY);
            Chunk styleparagrafoCopyriht = new Chunk("© Curriculum Generator - Miguel Castro", fontparagrafoCopyright);
            paragrafoCopyright.add(styleparagrafoCopyriht);
            documento.add(paragrafoCopyright);
            documento.close();

        } catch (DocumentException erro) {
            erro.getMessage();
        }

        return new ByteArrayInputStream(saida.toByteArray());
    }
}
