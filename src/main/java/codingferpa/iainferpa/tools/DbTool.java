package codingferpa.iainferpa.tools;

import codingferpa.iainferpa.repositories.ConversationRepository;
import com.resend.core.exception.ResendException;
import com.resend.services.emails.model.CreateEmailOptions;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DbTool {

  @Autowired
  private ConversationRepository repository;

  @Tool("Envio o resultado via e-mail para o usuário, quando solicitado pelo usuario")
  void sendEmail(String result) {
    System.out.println("enviando email . . . ");

    var params = CreateEmailOptions.builder()
            .from("Fernando Ollé <coding.ferpa@fernandolle.com>")
            .to("fernandoribeiroolle@gmail.com")
            .subject("Programming Dad Joke Generator v2.0 - Tabajara")
            .html(
                    String.format("<strong>%s</strong>", result)
            ).build();
  }
}
