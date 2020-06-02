package API;

import android.util.Log;

import com.android.volley.toolbox.HttpResponse;

/*import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;*/
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by qps07 on 10/12/2015.
 */
public class JSONParser {
    JSONObject json = null;
    String jsonString = "";
    ArrayList<String> userData = new ArrayList<>();

    public JSONParser() {
    }

    public void parse(JSONArray array) {
        /*Log.e("Builder: ", jsonString);
        this.jsonString = jsonString;*/

        try{
            //JSONArray array = new JSONArray(getJsonString());
            for (int i = 0; i < array.length(); i++){
                JSONObject data = array.getJSONObject(i);
                /*userData.add(data.getString("Nombre") + " " +
                        data.get("ApellidoPaterno") + " " +
                        data.getString("ApellidoMaterno"));
                userData.add(data.getString("Correo"));*/
                Log.i("DATA ARRAY", data.toString());
            }

        }catch (JSONException e){
            Log.e("log_tag", "Error converting result ");
        }

        /*try{
            json = new JSONObject(jsonString);
        }catch (JSONException e){
            Log.e("ERROR: ", "ERROR ANALIZANDO DATOS");
        }*/
        //return json;
    }

    public String getJsonString() {
        return jsonString;
    }

    /*public JSONObject requestHTTP(String file, List<NameValuePair> params) {
        String URI = "http://192.168.0.13/Aminver/app/"+file;
        InputStream input = null;
        Boolean success = false;
        try {
            DefaultHttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost(URI);
            post.setEntity(new UrlEncodedFormEntity(params));

            HttpResponse response = client.execute(post);
            HttpEntity entity = response.getEntity();
            input = entity.getContent();
            if(input != null)
                success = true;
        } catch (UnsupportedEncodingException e) {
            Log.e("log_tag", "Error in http connection "+e.toString());
        } catch (ClientProtocolException e) {
            Log.e("log_tag", "Error in http connection "+e.toString());
        } catch (IOException e) {
            Log.e("log_tag", "Error in http connection "+e.toString());
        }

        if(success){
            try{
                BufferedReader reader = new BufferedReader(new InputStreamReader(
                        input, "ISO-8859-1"), 8);
                StringBuilder builder = new StringBuilder();
                String line = null;

                while((line = reader.readLine()) != null){
                    builder.append(line + "\n");
                }

                input.close();
                jsonString = builder.toString();
                //Log.e("Builder: ", builder.toString());

                try{
                    JSONArray array = new JSONArray(getJsonString());
                    for (int i = 0; i < array.length(); i++){
                        JSONObject data = array.getJSONObject(i);
                        userData.add(data.getString("Nombre") + " " +
                                data.get("ApellidoPaterno") + " " +
                                data.getString("ApellidoMaterno"));
                        userData.add(data.getString("Correo"));
                    }
                    Log.i("userDAta", userData.get(0) + "," +userData.get(1));
                }catch (JSONException e){
                    Log.e("log_tag", "Error converting result ");
                }

            } catch (UnsupportedEncodingException e) {
                Log.e("log_tag", "Error converting result ");
            } catch (IOException e) {
                Log.e("log_tag", "Error converting result ");
            }

            try{
                json = new JSONObject(jsonString);
            }catch (JSONException e){
                Log.e("ERROR: ", "ERROR ANALIZANDO DATOS");
            }
            return json;
        }else{
            return null;
        }
    }

    public JSONObject requestHTTP(List<NameValuePair> params, String value) {
        String URI = "http://192.168.0.13/Aminver/app/executeQuery.php";
        InputStream input = null;
        Boolean success = false;
        try {
            DefaultHttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost(URI);
            post.setEntity(new UrlEncodedFormEntity(params));

            HttpResponse response = client.execute(post);
            HttpEntity entity = response.getEntity();
            input = entity.getContent();
            if(input != null)
                success = true;
        } catch (UnsupportedEncodingException e) {
            Log.e("log_tag", "Error in http connection ");
        } catch (ClientProtocolException e) {
            Log.e("log_tag", "Error in http connection ");
        } catch (IOException e) {
            Log.e("log_tag", "Error in http connection ");
        }

        if(success){
            Log.i("TASK", "SUCCESS");
            try{
                BufferedReader reader = new BufferedReader(new InputStreamReader(
                        input, "ISO-8859-1"), 8);
                StringBuilder builder = new StringBuilder();
                String line = null;

                while((line = reader.readLine()) != null){
                    builder.append(line + "\n");
                }

                input.close();
                jsonString = builder.toString();
                //Log.e("Builder: ", builder.toString());

                // CALL TO METHOD CHECKING FILE
                executeQuery(value);

            } catch (UnsupportedEncodingException e) {
                Log.e("log_tag", "Error converting result 1 "+ e.toString());
            } catch (IOException e) {
                Log.e("log_tag", "Error converting result 2 "+e.toString());
            }

            try{
                json = new JSONObject(jsonString);
            }catch (JSONException e){
                //Log.e("ERROR: ", "ERROR ANALIZANDO DATOS");
            }
            return json;
        }else{
            return null;
        }
    }

    public void insertData(List<NameValuePair> params){
        String URI = "http://192.168.0.13/Aminver/app/insertData.php";
        InputStream input = null;
        Boolean success = false;
        try {
            DefaultHttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost(URI);
            post.setEntity(new UrlEncodedFormEntity(params));

            HttpResponse response = client.execute(post);
            HttpEntity entity = response.getEntity();
            input = entity.getContent();
            if(input != null)
                success = true;
        } catch (UnsupportedEncodingException e) {
            Log.e("log_tag", "Error in http connection "+e.toString());
        } catch (ClientProtocolException e) {
            Log.e("log_tag", "Error in http connection "+e.toString());
        } catch (IOException e) {
            Log.e("log_tag", "Error in http connection "+e.toString());
        }

        if(success){
            try{
                BufferedReader reader = new BufferedReader(new InputStreamReader(
                        input, "ISO-8859-1"), 8);
                StringBuilder builder = new StringBuilder();
                String line = null;

                while((line = reader.readLine()) != null){
                    builder.append(line + "\n");
                }

                input.close();
                jsonString = builder.toString();

                try{
                    JSONArray array = new JSONArray(getJsonString());
                    for (int i = 0; i < array.length(); i++){
                        JSONObject data = array.getJSONObject(i);
                        Log.w("DATA", data.toString());
                    }
                }catch (JSONException e){
                    Log.e("DATA_INSERT", "Error converting result ");
                }

            } catch (UnsupportedEncodingException e) {
                Log.e("log_tag", "Error DATA_INSERT ");
            } catch (IOException e) {
                Log.e("log_tag", "Error DATA_INSERT ");
            }
        }
    }

    public void executeQuery(String value){
        switch (value){
            case "YEAR": queryYear(); break;
            case "MONTH": queryMonth(); break;
            case "DAY": queryDay(); break;
            case "LIST": listYear(); break;
        }
    }*/

}
