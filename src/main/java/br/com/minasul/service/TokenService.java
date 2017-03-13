package br.com.minasul.service;

/**
 * Todos os Direitos reservados  - Projeto AgendaIntegradaFluig
 * @brief Classe TokenService
 * @author Alisson de Pádua
 * @date   10/03/2017 - 17:35:16
 */
import br.com.minasul.model.TokenModel;
import com.fluig.oauth.HttpHelper;
import com.fluig.oauth.LoginResult;
import com.fluig.oauth.OAuthClient;
import java.io.IOException;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

public class TokenService {

    private OAuthClient oAuthClient;
    private TokenModel tokenModel;
    
    public TokenService(TokenModel tokenModel) {
        this.tokenModel = tokenModel;
    }

    public OAuthClient getoAuthClient() {
        return oAuthClient;
    }

    public void setoAuthClient(OAuthClient oAuthClient) {
        this.oAuthClient = oAuthClient;
    }

    public String connect() {

        try {
            oAuthClient = new OAuthClient(this.tokenModel.getLinkFluig(), this.tokenModel.getConsKey(), this.tokenModel.getConsSec());
            LoginResult result = oAuthClient.prepareResources(this.tokenModel.getUserApi(), this.tokenModel.getPassApi());
            HttpHelper.closeResource(result.getConnection());

            if (HttpHelper.returnSuccess(result.getConnection())) {
                this.setoAuthClient(oAuthClient);
                return "OK";
            } else {
                return "NOK";
            }
        } catch (OAuthException e) {
            return e.getMessage();
        } catch (IOException e) {
            return e.getMessage();
        }

    }

}
