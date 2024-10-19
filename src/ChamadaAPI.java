import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ChamadaAPI {
    public static String Chamada(String de, String para, Double valor) throws IOException, InterruptedException {

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(taxaJson.class, (JsonDeserializer<taxaJson>) (json, typeOfT, context) -> {
                    JsonObject jsonObject = json.getAsJsonObject();
                    double conversionResult = jsonObject.get("conversion_result").getAsDouble();
                    return new taxaJson(conversionResult);
                })
                .setPrettyPrinting()
                .create();

        String url = "https://v6.exchangerate-api.com/v6/db576e56462ea2a77fced629/pair/"+de+"/"+ para +"/" + valor;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        taxaJson minhaTaxa = gson.fromJson(json, taxaJson.class);

        // Criando uma instância da classe Taxa
        Taxa taxa = new Taxa(minhaTaxa);
        return taxa.toString();

    }
}
