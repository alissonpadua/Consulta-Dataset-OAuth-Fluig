package br.com.minasul.model;

import com.fluig.oauth.OAuthClient;

/**
 * Todos os Direitos reservados  - Projeto api-client-demo
 * @brief Classe TokenModel
 * @author Alisson de Pádua
 * @date   13/03/2017 - 16:18:26
 */
public class TokenModel {
    
    private String linkFluig;
    private String userApi;
    private String passApi;
    private String consKey;
    private String consSec;
    
    public TokenModel(String domain, String user, String password, String consumerKer, String ConsumerSecret) {
        this.setLinkFluig(domain);
        this.setUserApi(user);
        this.setPassApi(password);
        this.setConsKey(consumerKer);
        this.setConsSec(ConsumerSecret);
    }


    public String getLinkFluig() {
        return linkFluig;
    }

    public void setLinkFluig(String linkFluig) {
        this.linkFluig = linkFluig;
    }

    public String getUserApi() {
        return userApi;
    }

    public void setUserApi(String userApi) {
        this.userApi = userApi;
    }

    public String getPassApi() {
        return passApi;
    }

    public void setPassApi(String passApi) {
        this.passApi = passApi;
    }

    public String getConsKey() {
        return consKey;
    }

    public void setConsKey(String consKey) {
        this.consKey = consKey;
    }

    public String getConsSec() {
        return consSec;
    }

    public void setConsSec(String consSec) {
        this.consSec = consSec;
    }
}
