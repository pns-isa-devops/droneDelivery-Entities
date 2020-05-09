package fr.unice.polytech.isa.dd.entities;


import org.apache.cxf.jaxrs.client.WebClient;
import org.json.JSONArray;
import org.json.JSONObject;

public class BankAPI {

    private String url;

    public BankAPI(String host, String port) {
        this.url = "http://" + host + ":" + port;
    }

    public BankAPI() {
        this("localhost", "9090");
    }


    public JSONObject getPayment(int id) throws ExternalPartnerException {
        JSONObject payment = null;
        try {
            String response = WebClient.create(url).path("/payments/" + id).get(String.class);
            payment = new JSONObject(response);
        } catch (Exception e) {
            // ### ou soit essayer de pinguer le serveur jenkins
            System.out.println("-------------------------- Ping jenkins external Service /  PaymentById ------------------------------------");
            try {
                String response = WebClient.create("http://jenkins-teamd.francecentral.cloudapp.azure.com:9090/").path("/payments/" + id).get(String.class);
                payment = new JSONObject(response);
            } catch (Exception de) {
                throw new ExternalPartnerException(url + "/payments/" + id, de);
            }
            return payment;
        }
        return payment;
    }

    public JSONArray getPayements() throws ExternalPartnerException {

        JSONArray res = null;
        try {
            String response = WebClient.create(url).path("/payments").get(String.class);
            res = new JSONArray(response);
        } catch (Exception e) {
            // ### ou soit essayer de pinguer le serveur jenkins
            System.out.println("-------------------------- Ping jenkins external Service /  Payment ------------------------------------");
            try {
                String response = WebClient.create("http://jenkins-teamd.francecentral.cloudapp.azure.com:9090/").path("/payments").get(String.class);
                res = new JSONArray(response);
            } catch (Exception de) {
                throw new ExternalPartnerException(url + "/payments", de);
            }
            return res;
        }
        //return (payment.getInt("Status") == 0);
        return res;
    }

}
