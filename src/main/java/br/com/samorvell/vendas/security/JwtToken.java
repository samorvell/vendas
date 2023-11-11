package br.com.samorvell.vendas.security;;

public class JwtToken {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public JwtToken(String token) {
        super();
        this.token = token;
    }

    public JwtToken() {
        super();
    }

    @Override
    public String toString() {
        return "JwtToken [token=" + token + "]";
    }
}
