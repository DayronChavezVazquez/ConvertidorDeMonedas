import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultadorDeMoneda {
    public  Valor convertidorDeValor(String moneda, String monedaAConvertir, double cantidad){

        URI direccion= URI.create("https://v6.exchangerate-api.com/v6/3d62c562e240f7f93a2650da/pair/" +moneda+"/"+monedaAConvertir+"/"+cantidad);

        HttpClient client= HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();


        try {
            HttpResponse<String>  response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return  new Gson().fromJson(response.body(), Valor.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontre la pelicula");
        }


    }
}