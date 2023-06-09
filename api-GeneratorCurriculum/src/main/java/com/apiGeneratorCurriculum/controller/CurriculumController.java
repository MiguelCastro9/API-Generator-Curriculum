package com.apiGeneratorCurriculum.controller;

import com.apiGeneratorCurriculum.response.CurriculumResponse;
import com.apiGeneratorCurriculum.resources.ExportCurriculumPdf;
import com.itextpdf.text.BadElementException;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Miguel Castro
 */
@RestController
@RequestMapping("/curriculum")
@CrossOrigin(origins = "*")
@Tag(name = "Curriculum")
public class CurriculumController {

    @PostMapping("/exportPdf")
    public ResponseEntity<InputStreamResource> exportPdf(@Valid @RequestBody CurriculumResponse curriculum, HttpServletResponse response) throws IOException, BadElementException {
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=curriculum.pdf");
        ByteArrayInputStream bais = ExportCurriculumPdf.curriculumExportPdf(curriculum);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(bais));
    }
}
