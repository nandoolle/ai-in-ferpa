package codingferpa.iainferpa.controllers;

import codingferpa.iainferpa.repositories.models.Voice;
import codingferpa.iainferpa.services.AiService;
import codingferpa.iainferpa.services.TextToSpeechService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/v1")
@AllArgsConstructor
public class AiController {

  private final AiService aiService;

  @GetMapping("/with-memory")
  public ResponseEntity<String> chatWithMemory(@RequestParam() int id, @RequestParam() String message) {
    return ResponseEntity.ok(aiService.respond(id, message));
  }

  @GetMapping("/no-memory")
  public ResponseEntity<String> chatWithoutMemory(@RequestParam() String message) {
    return ResponseEntity.ok(aiService.respond(message));
  }

  @GetMapping("/with-db")
  public ResponseEntity<String> chatWithDbAccess(@RequestParam() String message) {
    return ResponseEntity.ok(aiService.respondWithDb(message));
  }

  @GetMapping("/http-api")
  public ResponseEntity<String> chatWithHttpApi(@RequestParam() String message) {
    return ResponseEntity.ok(aiService.respondWithHttpApi(message));
  }

  @GetMapping("/generate-image")
  public ResponseEntity<URI> generateImage(@RequestParam() String message) {
    return ResponseEntity.ok(aiService.respondWithImage(message));
  }

}
