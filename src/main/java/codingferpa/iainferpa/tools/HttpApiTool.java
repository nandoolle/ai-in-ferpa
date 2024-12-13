package codingferpa.iainferpa.tools;

import codingferpa.iainferpa.providers.OpenExchangeProvider;
import dev.langchain4j.agent.tool.Tool;

public class HttpApiTool {

  private final OpenExchangeProvider openExchangeProvider = new OpenExchangeProvider();

  @Tool("Converte uma quantia de dinheiro de uma moeda para outra")
  public double convert(double amount, String from, String to) {
    System.out.println("Chamando API e convertendo . . . ");
    return amount * openExchangeProvider.rates.get(to) / openExchangeProvider.rates.get(from);
  }

  @Tool("Retorna o nome completo de uma moeda dada sua abreviação")
  public String getCurrency(String abbreviation) {
    System.out.printf("Chamando API e retornando nome da moeda . . .");
    return openExchangeProvider.currencies.get(abbreviation);
  }

}