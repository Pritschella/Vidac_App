package Adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appvidac.R;
import com.example.appvidac.Servicio2;
import com.squareup.picasso.Picasso;

import java.util.List;

import ViewHolders.ItemViewHolder;

public class ServiciosAdapter extends RecyclerView.Adapter<ItemViewHolder> {
    List<Servicio2> items;

    public ServiciosAdapter(List<Servicio2> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Servicio2 data = this.items.get(position);
        holder.nombre.setText(data.getNombre() + " " + data.getApellidos());
        holder.telefono.setText(String.valueOf(data.getTelefono()));
        holder.direccion.setText(data.getDireccion());
        holder.descripcion.setText(data.getDescripcion());
        //String url = "http://192.168.0.31/Vidac/fotos_clientes/" + data.getFoto();

        if(data.getFoto() != null) {
            String url = data.getFoto().replace("192.168.0.31", "192.168.1.95");
            Log.i("IMAGE", url);
            Picasso.get()
                    .load(url)
                    .resize(124, 124)
                    //.fit()
                    .centerInside()
                    .into(holder.imagen);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
