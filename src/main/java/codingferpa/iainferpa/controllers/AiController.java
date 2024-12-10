package codingferpa.iainferpa.controllers;

import codingferpa.iainferpa.services.AiService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@AllArgsConstructor
public class AiController {

  private final AiService aiService;

  @PostMapping("/with-memory/{id}")
  public ResponseEntity<String> chat (@RequestBody() String joke, @PathVariable() int id) {
    return ResponseEntity.ok(
            aiService.respond(id, joke)
    );
  }

  @PostMapping("/no-memory")
  public ResponseEntity<String> chat (@RequestBody() String joke) {
    return ResponseEntity.ok(
            aiService.respond(joke)
    );
  }
}
