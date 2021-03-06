package API;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appvidac.Servicio2;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Adapters.ServiciosAdapter;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class EnfermerosAPI extends AsyncTask<Void, Integer, List<Servicio2>> {
    RecyclerView recyclerView;
    Context context;

    public List<Servicio2> listaEnfermeros = new ArrayList<>();

    public EnfermerosAPI(RecyclerView recyclerView, Context context){
        this.recyclerView = recyclerView;
        this.context = context;
    }

    @Override
    protected List<Servicio2> doInBackground(Void... voids) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://192.168.1.95/Vidac/Datos_Enfermeros.php")
                .build();
        try (Response response = client.newCall(request).execute()) {
            String result = response.body().string();
            JSONObject enfermerosData = new JSONObject(result);
            JSONArray array = enfermerosData.getJSONArray("data");
            if (array != null) {
                JSONParser parser = new JSONParser();
                for (int i = 0; i < array.length(); i++){
                    JSONObject data = array.getJSONObject(i);
                    listaEnfermeros.add(new Servicio2().createFromJSONObject(data));
                }
                Log.i("SIZE", String.valueOf(listaEnfermeros.size()));
            }


        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return listaEnfermeros;
    }
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        Log.i("UPDATES", values.toString());
    }

    @Override
    protected void onPostExecute(List<Servicio2> data) {
        super.onPostExecute(data);
        Log.i("onPostExecute", data.toString());
        Log.i("SIZE", String.valueOf(this.listaEnfermeros.size()));
        ServiciosAdapter adapter = new ServiciosAdapter(this.listaEnfermeros);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.context));
    }
}
