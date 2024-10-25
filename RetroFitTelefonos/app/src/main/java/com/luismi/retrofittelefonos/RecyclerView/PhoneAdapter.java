package com.luismi.retrofittelefonos.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.luismi.retrofittelefonos.Phone;
import com.luismi.retrofittelefonos.R;

import java.util.List;

public class PhoneAdapter extends RecyclerView.Adapter<PhoneViewHolder> {
    private Context context;
    private List<Phone> listPhones;
    private View.OnClickListener listener;

    public PhoneAdapter(Context context, List<Phone> listPhones) {
        this.context = context;
        this.listPhones = listPhones;
    }

    @NonNull
    @Override
    public PhoneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_row_item, parent, false);
        return new PhoneViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhoneViewHolder holder, int position) {
        Phone phone = listPhones.get(position);
        holder.setTxtName(phone.getName());
        if (phone.getData() != null){
            holder.setTxtColor(phone.getData().getColor() != null ? phone.getData().getColor() : "Vacio");
            holder.setTxtCapacidad(phone.getData().getCapacity() != null ? phone.getData().getCapacity() : "Vacio");
            holder.setTxtPrecio(phone.getData().getPrice() != null ? phone.getData().getPrice() : 0.0f);
            holder.setTxtGeneracion(phone.getData().getGeneration() != null ? phone.getData().getGeneration() : "Vacio");
            holder.setTxtAnio(phone.getData().getYear() < 0 ? phone.getData().getYear() : 0);
            holder.setTxtModeloCPU(phone.getData().getCpuModel() != null ? phone.getData().getCpuModel() : "Vacio");
            holder.setTxtDiscoDuro(phone.getData().getHardDiskSize() != null ? phone.getData().getHardDiskSize() : "Vacio");
            holder.setTxtDisenioColor(phone.getData().getStrapColour() != null ? phone.getData().getStrapColour() : "Vacio");
            holder.setTxtTamanio(phone.getData().getCaseSize() != null ? phone.getData().getCaseSize() : "Vacio");
            holder.setTxtDescripcion(phone.getData().getDescription() != null ? phone.getData().getDescription() : "Vacio");
        }else{
            holder.setTxtColor("No hay datos ");
            holder.setTxtAnio(0);
            holder.setTxtPrecio(0.0f);
            holder.setTxtModeloCPU("No hay datos");
            holder.setTxtCapacidad("No hay datos");
            holder.setTxtDescripcion("No hay datos");
            holder.setTxtGeneracion("No hay datos ");
            holder.setTxtDiscoDuro("No hay datos ");
            holder.setTxtDisenioColor("No hay datos ");
            holder.setTxtTamanio("No hay datos");
            holder.setTxtColor("No hay datos");

        }
    }

    @Override
    public int getItemCount() {
        return listPhones == null ? 0 : listPhones.size();
    }

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }
}
