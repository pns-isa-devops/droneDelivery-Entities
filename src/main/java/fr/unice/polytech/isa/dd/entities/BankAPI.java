package fr.unice.polytech.isa.dd.entities;


import org.apache.cxf.jaxrs.client.WebClient;
import org.json.JSONArray;
import org.json.JSONObject;

public class BankAPI {

    private String url;


    public BankAPI(String host, String port) {
        this.url = "http://" + host + ":" + port;
    }

    public BankAPI() { this("localhost", "9090"); }
    public JSONObject getPayment(int id) throws ExternalPartnerException {
        JSONObject payment=null;
        try {
            String response = WebClient.create(url).path("/payments/" + id).get(String.class);

            //if (response != null) {
                payment = new JSONObject(response);
                //return true;
            //}
        } catch (Exception e) {
            throw new ExternalPartnerException(url + "/payments/" + id, e);
        }
        // Assessing the payment status
        //return (payment.getInt("Status") == 0);
        return payment;
    }

    public JSONArray getPayements() throws ExternalPartnerException {
        JSONArray res=null;
        try {
            String response = WebClient.create(url).path("/payments").get(String.class);
            res = new JSONArray(response);

        } catch (Exception e) {
            throw new ExternalPartnerException(url + "/payments", e);
        }
        // Assessing the payment status
        //return (payment.getInt("Status") == 0);
        return res;
    }

}
