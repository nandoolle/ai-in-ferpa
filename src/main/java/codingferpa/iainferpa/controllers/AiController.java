package codingferpa.iainferpa.controllers;

import codingferpa.iainferpa.services.AiService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/v1")
@AllArgsConstructor
public class AiController {

  private final AiService aiService;

  @PostMapping("/with-memory/{id}")
  public ResponseEntity<String> chatWithMemory(@PathVariable() int id, @RequestBody() String request) {
    return ResponseEntity.ok(aiService.respond(id, request));
  }

  @PostMapping("/no-memory")
  public ResponseEntity<String> chatWithoutMemory(@RequestBody() String request) {
    return ResponseEntity.ok(aiService.respond(request));
  }

  @PostMapping("/with-db")
  public ResponseEntity<String> chatWithDbAccess(@RequestBody() String request) {
    return ResponseEntity.ok(
            aiService.respondWithDb(request)
    );
  }

  @PostMapping("/generate-image")
  public ResponseEntity<URI> generateImage(@RequestBody() String request) {
    return ResponseEntity.ok(
            aiService.respondWithImage(request).content().url()
    );
  }
}
