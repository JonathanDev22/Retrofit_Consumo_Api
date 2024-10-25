package com.luismi.retrofittelefonos.RecyclerView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.luismi.retrofittelefonos.R;

public class PhoneViewHolder extends RecyclerView.ViewHolder {
    private TextView txtName;
    private TextView txtColor;
    private TextView txtCapacidad;
    private TextView txtPrecio;
    private TextView txtGeneracion;
    private TextView txtAnio;
    private TextView txtModeloCPU; // Ver nombre que se le puso
    private TextView txtDiscoDuro; // Ver nombre que se le puso
    private TextView txtDisenioColor; // Ver nombre que se le puso
    private TextView txtTamanio; // Ver nombre que se le puso
    private TextView txtDescripcion;


    public PhoneViewHolder(@NonNull View itemView) {
        super(itemView);
        txtName = itemView.findViewById(R.id.txtName);
        txtColor = itemView.findViewById(R.id.txtColor);
        txtCapacidad = itemView.findViewById(R.id.txtCapacidad);
        txtPrecio = itemView.findViewById(R.id.txtPrecio);
        txtGeneracion = itemView.findViewById(R.id.txtGeneracion);
        txtAnio = itemView.findViewById(R.id.txtAnio);
        txtModeloCPU = itemView.findViewById(R.id.txtModeloCPU);
        txtDiscoDuro = itemView.findViewById(R.id.txtDiscoDuro);
        txtDisenioColor = itemView.findViewById(R.id.txtDisenioColor);
        txtTamanio = itemView.findViewById(R.id.txtTamanio);
        txtDescripcion = itemView.findViewById(R.id.txtDescripcion);
    }

    public void setTxtName(String name) {
        this.txtName.setText(name);
    }

    public void setTxtColor(String color) {
        this.txtColor.setText(color);
    }

    public void setTxtCapacidad(String capacity) {
        this.txtCapacidad.setText(capacity);
    }

    public void setTxtPrecio(Float precio) {
        this.txtPrecio.setText(precio.toString());
    }

    public void setTxtGeneracion(String generacion) {
        this.txtGeneracion.setText(generacion);
    }

    public void setTxtAnio(int anio) {
        this.txtAnio.setText(String.valueOf(anio));
    }

    public void setTxtModeloCPU(String CPUModel) {
        this.txtModeloCPU.setText(CPUModel);
    }

    public void setTxtDiscoDuro(String discoDuro) {
        this.txtDiscoDuro.setText(discoDuro);
    }

    public void setTxtDisenioColor(String colorDisenio) {
        this.txtDisenioColor.setText(colorDisenio);
    }

    public void setTxtTamanio(String tamanio) {
        this.txtTamanio.setText(tamanio);
    }

    public void setTxtDescripcion(String descripcion) {
        this.txtDescripcion.setText(descripcion);
    }


}
