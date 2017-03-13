package com.fluig.api.client.demo;

import br.com.minasul.model.TokenModel;
import br.com.minasul.service.TokenService;

import com.fluig.api.client.env.FluigClient;
import javax.json.Json;

public class FluigClientExample {

    public static void main(String[] args) throws Exception {

        TokenModel tokenModel = new TokenModel("LINK-COM-PORTA", "USUARIO", "SENHA", "CONSUMER-KEY", "CONSUMER-SECRET");
        TokenService tokenService = new TokenService(tokenModel);

        FluigClient fluig = new FluigClient();

        if (tokenService.connect() == "OK") {
            
            fluig.setHost(tokenModel.getLinkFluig())
                    .setConsumerKey(tokenModel.getConsKey())
                    .setConsumerSecret(tokenModel.getConsSec())
                    .setTokenAccess(tokenService.getoAuthClient().getToken())
                    .setTokenSecret(tokenService.getoAuthClient().getTokenSecret())
                    .connect();
            
           String param = Json.createObjectBuilder()
                .add("name", "colleague")
                .addNull("fields")
                .addNull("constraints")
                .build().toString();
                    
                String result = fluig.post("/api/public/ecm/dataset/datasets", param);
                System.out.println(result);
                
        } else {
            System.err.println("Erro");
        }


    }
}
