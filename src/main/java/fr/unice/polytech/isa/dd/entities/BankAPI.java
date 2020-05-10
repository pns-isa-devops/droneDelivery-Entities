package fr.unice.polytech.isa.dd.entities;


import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.cxf.jaxrs.client.WebClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLOutput;

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

//    public JSONArray getPayements() throws ExternalPartnerException {
//
//        JSONArray res = null;
//        try {
//            System.out.println("-------------------------- Ping  external Service /  Payment ------------------------------------");
//            System.out.println();
//            String response = WebClient.create("http://192.168.99.100:9090").path("/payments").get(String.class);
//            res = new JSONArray(response);
//            System.out.println("Fuck ");
//        } catch (Exception e) {
//            // ### ou soit essayer de pinguer le serveur jenkins
//            System.out.println("-------------------------- Ping jenkins external Service /  Payment ------------------------------------");
//            try {
//                String response = WebClient.create("http://jenkins-teamd.francecentral.cloudapp.azure.com:9090/").path("/payments").get(String.class);
//                res = new JSONArray(response);
//            } catch (Exception de) {
//                throw new ExternalPartnerException(url + "/payments", de);
//            }
//            return res;
//        }
//        //return (payment.getInt("Status") == 0);
//        return res;
//
//        try {
////            URL url = new URL("http://192.168.99.100:9090/payments");
//            //            URL url = new URL("http://localhost:9090/payments");
//
//            URL url = new URL("http://jenkins-teamd.francecentral.cloudapp.azure.com:9090/payments");
//
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("GET");
//            connection.connect();
//            int respCode = connection.getResponseCode();
//            System.out.println("=====> Jenkins Server Extern UP");
//            System.out.println(respCode);
//            System.out.println("Resp " + connection.getContent());
//            System.out.println();
//
//            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//            StringBuilder sb = new StringBuilder();
//            String line;
//            while ((line = br.readLine()) != null) {
//                sb.append(line+"\n");
//            }
//            br.close();
//            System.out.println("Resp "+sb.toString());
//        } catch (IOException e) {
//            System.out.println("=====> Jenkins Server Extern DOWN");
//            System.out.println();
//
//        }


    public JSONArray getPayements() throws ExternalPartnerException {

        JSONArray res = null;
//        try {
//            System.out.println("-------------------------- Ping  external Service /  Payment ------------------------------------");
//            System.out.println();
//            String response = WebClient.create("http://192.168.99.100:9090").path("/payments").get(String.class);
//            res = new JSONArray(response);
//            System.out.println("Fuck ");
//        } catch (Exception e) {
//            // ### ou soit essayer de pinguer le serveur jenkins
//            System.out.println("-------------------------- Ping jenkins external Service /  Payment ------------------------------------");
//            try {
//                String response = WebClient.create("http://jenkins-teamd.francecentral.cloudapp.azure.com:9090/").path("/payments").get(String.class);
//                res = new JSONArray(response);
//            } catch (Exception de) {
//                throw new ExternalPartnerException(url + "/payments", de);
//            }
//            return res;
//        }
        //return (payment.getInt("Status") == 0);

        try {
            URL url = new URL("http://jenkins-teamd.francecentral.cloudapp.azure.com:9090/payments");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int respCode = connection.getResponseCode();
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            br.close();
            res = new JSONArray(sb.toString());
        } catch (IOException e) {
            try {
                System.out.println("Second option");
//                URL url = new URL("http://192.168.99.100:9090/payments");
                URL url = new URL("http://localhost:9090/payments");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.connect();
                int respCode = connection.getResponseCode();
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                br.close();
                res = new JSONArray(sb.toString());
            } catch (IOException de) {
                throw new ExternalPartnerException(url + "/payments", de);
            }

        }
        return res;

    }

}
