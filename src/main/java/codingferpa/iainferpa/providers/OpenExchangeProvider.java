package codingferpa.iainferpa.providers;

import codingferpa.iainferpa.providers.OpenExchangeRatesRecords.OpenExchangeRatesResponse;
import codingferpa.iainferpa.providers.OpenExchangeRatesRecords.CurrenciesResponse;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class OpenExchangeProvider {
  private static final String API_KEY = System.getenv("OPEN_EXCHANGE_API_KEY");
  private static final String BASE_URL = "https://openexchangerates.org/api/latest.json";
  private static final String CURRENCIES_URL = "https://openexchangerates.org/api/currencies.json";

  private final Gson gson = new GsonBuilder()
          .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
          .setPrettyPrinting()
          .create();

  public final Map<String, Double> rates;
  public final Map<String, String> currencies;

  public OpenExchangeProvider() {
    this.rates = getLatestRates().rates();
    this.currencies = getCurrencies().currencies();
  }

  public OpenExchangeRatesResponse getLatestRates() {
    return gson.fromJson(
            getHttpResponse(BASE_URL).body(),
            OpenExchangeRatesResponse.class
    );
  }

  public CurrenciesResponse getCurrencies() {
    Map<String, String> map = gson.fromJson(
            getHttpResponse(CURRENCIES_URL).body(),
            new TypeToken<Map<String, String>>() {}.getType()
    );
    return new CurrenciesResponse(map);
  }

  public static HttpResponse<String> getHttpResponse(String url) {
    try (var httpClient = HttpClient.newHttpClient()) {
      var httpRequest = HttpRequest.newBuilder()
              .uri(URI.create(url))
              .header("Accept", "application/json")
              .header("Authorization", "Token " + API_KEY)
              .build();
      HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
      if (httpResponse.statusCode() != 200) {
        throw new RuntimeException("Error getting exchange rates: " + httpResponse.body());
      }
      return httpResponse;
    } catch (java.io.IOException | java.lang.InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

}
