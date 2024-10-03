package javaCurso2024;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ExercicioApi {
    public static void main(String[] args) {
    	Scanner entrada = new Scanner(System.in);
    	System.out.println("Digite o cep desejado");
        String cep = entrada.next(); // Exemplo de CEP
        String urlString = "https://viacep.com.br/ws/" + cep + "/json/";

        try {
            // Criar a URL
            URL url = new URL(urlString);
            // Abrir a conexão
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            // Verificar o código de resposta
            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Ler a resposta
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Exibir a resposta
                System.out.println("Resposta da API: " + response.toString());
            } else {
                System.out.println("Erro na consulta: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}