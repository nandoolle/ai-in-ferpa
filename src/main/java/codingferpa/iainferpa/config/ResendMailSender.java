package codingferpa.iainferpa.config;

import com.resend.Resend;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ResendMailSender {
  public static final Resend resend = new Resend(System.getenv("RESEND_API_KEY"));
}