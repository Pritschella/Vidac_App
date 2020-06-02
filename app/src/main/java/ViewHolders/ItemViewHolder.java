package ViewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appvidac.R;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    public ImageView imagen;
    public TextView nombre;
    public TextView direccion;
    public TextView telefono;
    public TextView descripcion;

    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);
        imagen = (ImageView) itemView.findViewById(R.id.imageView);
        nombre = (TextView) itemView.findViewById(R.id.nombre);
        direccion = (TextView)itemView.findViewById(R.id.direccion);
        telefono = (TextView)itemView.findViewById(R.id.tel);
        descripcion = (TextView)itemView.findViewById(R.id.descripcion);
    }
}
