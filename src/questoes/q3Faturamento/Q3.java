package questoes.q3Faturamento;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Q3 {

    public static void main(String[] args) {
        String jsonData = readJsonFile("C:\\Users\\Ludmila\\OneDrive\\Área de Trabalho\\DEV\\fase-tecnica-estagio\\src\\questoes\\q3Faturamento\\faturamento.json");
        JSONArray faturamentoArray;

        try {
            faturamentoArray = new JSONArray(jsonData);
        } catch (Exception e) {
            System.err.println("Erro ao processar o JSON: " + e.getMessage());
            return;
        }

        List<Double> valores = new ArrayList<>();
        double minFaturamento = Double.MAX_VALUE;
        double maxFaturamento = Double.MIN_VALUE;
        double totalFaturamento = 0.0;
        int diasComFaturamento = 0;

        for (int i = 0; i < faturamentoArray.length(); i++) {
            JSONObject objeto = faturamentoArray.getJSONObject(i);
            double valor = objeto.getDouble("valor");

            if (valor > 0) {
                valores.add(valor);
                totalFaturamento += valor;
                diasComFaturamento++;

                if (valor < minFaturamento) {
                    minFaturamento = valor;
                }

                if (valor > maxFaturamento) {
                    maxFaturamento = valor;
                }
            }
        }

        double mediaMensal = (diasComFaturamento > 0) ? totalFaturamento / diasComFaturamento : 0;
        int diasAcimaDaMedia = 0;

        for (double valor : valores) {
            if (valor > mediaMensal) {
                diasAcimaDaMedia++;
            }
        }

        System.out.println("Menor valor de faturamento: " + minFaturamento);
        System.out.println("Maior valor de faturamento: " + maxFaturamento);
        System.out.println("Número de dias com faturamento superior à média mensal: " + diasAcimaDaMedia);
    }

    private static String readJsonFile(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();
        try {
            Files.lines(Paths.get(filePath)).forEach(contentBuilder::append);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }
}
