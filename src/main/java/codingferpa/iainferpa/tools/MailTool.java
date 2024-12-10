package codingferpa.iainferpa.tools;

import com.resend.Resend;
import com.resend.core.exception.ResendException;
import com.resend.services.emails.model.CreateEmailOptions;
import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Component;
import codingferpa.iainferpa.config.ResendMailSender;

@Component
public class MailTool {

  private final Resend resend = ResendMailSender.resend;

  @Tool("Envio o resultado para o e-mail do usuário, quando solicitado pelo usuario")
  void sendEmail(
          @P("email do usuario") String email,
          @P("mensagem a ser enviada por email") String result
  ) {
    System.out.println("enviando email . . . ");

    var params = CreateEmailOptions.builder()
            .from("AI in Ferpa <coding.ferpa@fernandolle.com>")
            .to(email)
            .subject("Programming Dad Joke Generator v2.0 - Tabajara")
            .html(
                    String.format("<strong>%s</strong>", result)
            ).build();

    try {
      this.resend.emails().send(params);
    } catch (ResendException e) {
      throw new RuntimeException(e);
    }
  }
}