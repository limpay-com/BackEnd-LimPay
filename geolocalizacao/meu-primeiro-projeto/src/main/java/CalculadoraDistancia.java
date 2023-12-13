import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class CalculadoraDistancia {

    public static void main(String[] args) {
        String enderecoUsuario1 = "Rua Nunes Balboa, São Paulo, Brazil"; // Endereço do primeiro usuário
        String enderecoUsuario2 = "Avenida Paulista, São Paulo, Brazil"; // Endereço do segundo usuário

        try {
            // Obtendo coordenadas do prsuário
            Coordenadas coordenadasUsuario1 = obterCoordenadas(enderecoUsuario1);
            Coordenadas coordenadasUsuario2 = obterCoordenadas(enderecoUsuario2);

            // Calculando a distância entre as coordenadas
            double distancia = calcularDistancia(
                    coordenadasUsuario1.getLatitude(), coordenadasUsuario1.getLongitude(),
                    coordenadasUsuario2.getLatitude(), coordenadasUsuario2.getLongitude()
            );

            System.out.println("A distância entre os usuários é: " + distancia + " km");

        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao calcular a distância: " + e.getMessage());
        }
    }

    // Classe para armazenar coordenadas
    static class Coordenadas {
        private final double latitude;
        private final double longitude;

        Coordenadas(double latitude, double longitude) {
            this.latitude = latitude;
            this.longitude = longitude;
        }

        double getLatitude() {
            return latitude;
        }

        double getLongitude() {
            return longitude;
        }
    }

    // Método para obter as coordenadas geográficas (latitude e longitude) a partir do endereço usando a API do OpenStreetMap Nominatim
    private static Coordenadas obterCoordenadas(String endereco) throws IOException {
        String enderecoCodificado = URLEncoder.encode(endereco, "UTF-8");
        String url = "https://nominatim.openstreetmap.org/search?q=" + enderecoCodificado + "&format=json";

        HttpURLConnection conexao = (HttpURLConnection) new URL(url).openConnection();
        conexao.setRequestMethod("GET");

        BufferedReader leitor = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
        StringBuilder resposta = new StringBuilder();
        String linha;

        while ((linha = leitor.readLine()) != null) {
            resposta.append(linha);
        }

        leitor.close();

        // Extrair latitude e longitude do JSON
        JsonArray jsonArray = new Gson().fromJson(resposta.toString(), JsonArray.class);
        if (jsonArray.size() > 0) {
            JsonObject jsonObject = jsonArray.get(0).getAsJsonObject();
            double latitude = jsonObject.get("lat").getAsDouble();
            double longitude = jsonObject.get("lon").getAsDouble();
            return new Coordenadas(latitude, longitude);
        } else {
            throw new IOException("Nenhuma coordenada encontrada para o endereço fornecido.");
        }
    }

    // Método para calcular a distância entre duas coordenadas geográficas usando a fórmula de Haversine
    private static double calcularDistancia(double lat1, double lon1, double lat2, double lon2) {
        final int RAIO_TERRA = 6371; // Raio médio da Terra em quilômetros

        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        double a = Math.pow(Math.sin(dLat / 2), 2) +
                Math.pow(Math.sin(dLon / 2), 2) * Math.cos(lat1) * Math.cos(lat2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return RAIO_TERRA * c; // Distância em quilômetros
    }
}
