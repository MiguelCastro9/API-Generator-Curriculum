package com.apiGeneratorCurriculum.controller;

import com.apiGeneratorCurriculum.model.Curriculum;
import com.apiGeneratorCurriculum.resources.ExportCurriculumPdf;
import com.itextpdf.text.BadElementException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
public class CurriculumController {
    

    
    @PostMapping("/exportPdf")
    public ResponseEntity<InputStreamResource> exportPdf(@RequestBody Curriculum curriculum, HttpServletResponse response) throws IOException, BadElementException {
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=curriculum.pdf");
        ByteArrayInputStream bais = ExportCurriculumPdf.curriculumExportPdf(curriculum);

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(bais));
    }
    
}
