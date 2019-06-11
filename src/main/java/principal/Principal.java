/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import model.Coord;
import model.Example;
import model.Weather;
import model.Weathers;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import view.TelaPrincipal;

/**
 *
 * @author william.mauro
 */
public class Principal {

    public static void main(String[] args) {
        TelaPrincipal telaPrincipal = new TelaPrincipal();
        telaPrincipal.setVisible(true);
        
        
     
    }
    
    
    public static Double retornaTemperatura() {
           String link = "http://api.openweathermap.org/data/2.5/weather?q=palho%C3%A7a,br&appid=a229614ea2dc0d9e7e48d2384b4d0779";

        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();

        HttpGet requisicaoGet = new HttpGet(link);
//        requisicaoGet.addHeader("content-type", "application/json");
//        requisicaoGet.addHeader("Accept", "application/json");
        HttpResponse resposta;
//        Weathers weather;
         Example example;
        Gson gson = new Gson();

        try {
            resposta = closeableHttpClient.execute(requisicaoGet);
            HttpEntity entidade = resposta.getEntity();
            String conteudo = EntityUtils.toString(entidade);

          example =  gson.fromJson(conteudo, Example.class);
            System.out.println(example);
           Double temperaturaEmKelvin = example.getMain().getTemp();
           Double tempCelcius = temperaturaEmKelvin - 273.15;
            System.out.println("temp:" + tempCelcius);
            return tempCelcius;

        } catch (Exception e) {
            example = null;
            return null;
        }
    }

}
