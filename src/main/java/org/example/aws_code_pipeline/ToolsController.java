package org.example.aws_code_pipeline;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tools")
public class ToolsController {

    @GetMapping
    public ResponseEntity<List<String>> findAllTools() {
        return ResponseEntity.ok(List.of(
                "Jenkins",
                "GitLab CI",
                "GitHub Actions",
                "TeamCity",
                "AWS CodePipeline"
        ));
    }

    @GetMapping("/current")
    public ResponseEntity<String> currentTool() {
        return ResponseEntity.ok("AWS CodePipeline");
    }

}
