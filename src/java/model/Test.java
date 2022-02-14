/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.json.JSONObject;

/**
 *
 * @author ADMIN
 */
public class Test {

    private String APIKey;
    private String PUUID;
    private final String defaultLink = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-puuid/";

    public String getDefaultLink() {
        return defaultLink;
    }

    public String getAPIKey() {
        return APIKey;
    }

    public String getPUUID() {
        return PUUID;
    }

    public void setPUUID(String PUUID) {
        this.PUUID = PUUID;
    }

    public void setAPIKey(String APIKey) {
        this.APIKey = APIKey;
    }

    public String getLink() {
        return getDefaultLink() + getPUUID() + "?api_key=" + getAPIKey();
    }
    

    public JSONObject getDefaultJSON() {
        JSONObject obj = null;
        String urlString = getLink();
        disableSslVerification();
        try {
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            InputStream res = con.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(res));
            String data = reader.readLine();
            String jsondata = data.substring(0, data.length());
            obj = new JSONObject(jsondata);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    public String getEncryptedSummonerIDLink() {
        JSONObject obj = getDefaultJSON();
        String encryptedSummonerID = obj.get("id").toString();
        return "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/" + encryptedSummonerID + "?api_key=" + getAPIKey();
    }
    
    public JSONObject getDetailJSON(){
        JSONObject obj = null;
        String urlString = getEncryptedSummonerIDLink();
        disableSslVerification();
        try {
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            InputStream res = con.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(res));
            String data = reader.readLine();
            String jsondata = data.substring(1, data.length()-1);
            obj = new JSONObject(jsondata);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    private void disableSslVerification() {
        try {
            // Create a trust manager that does not validate certificate chains
            TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }

                    public void checkClientTrusted(X509Certificate[] certs,
                            String authType) {
                    }

                    public void checkServerTrusted(X509Certificate[] certs,
                            String authType) {
                    }
                }};

            // Install the all-trusting trust manager
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            // Create all-trusting host name verifier
            HostnameVerifier allHostsValid = new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            };

            // Install the all-trusting host verifier
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
    }
    
    public String getRank(){
        return getDetailJSON().getString("tier")+" "+getDetailJSON().getString("rank");
    }
    
    public String getWins(){
        return getDetailJSON().get("wins").toString();
    }
    
    public String getLosses(){
        return getDetailJSON().get("losses").toString();
    }
    
    public String getSummonerName(){
        return getDetailJSON().getString("summonerName");
    }
    
    public String getPoints(){
        return getDetailJSON().get("leaguePoints").toString();
    }
    
}
