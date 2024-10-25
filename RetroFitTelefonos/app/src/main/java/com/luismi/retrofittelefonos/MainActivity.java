package com.luismi.retrofittelefonos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.luismi.retrofittelefonos.RecyclerView.PhoneAdapter;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Crear app para realizar operaciones CRUD contra una API Rest.
 * 1. Listar todos los objetos con un RecyclerView
 * 2. Mostrar objeto por Id
 * 3. Subir un objeto usando un formulario
 * 4. Actualizar un objeto
 * 5. Borrar un objeto
 */
public class MainActivity extends AppCompatActivity {
    private String TAG = "Main_Activity";
    Button btnListObjetos;
    Button btnGetObjeto;
    Button btnIngresarPhone;
    EditText edTxtId;
    TextView txtResultado;
    PhoneAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnListObjetos = findViewById(R.id.btnListObjetos);
        btnGetObjeto = findViewById(R.id.btnGetObjeto);
        btnIngresarPhone = findViewById(R.id.btnInsertarObjeto);
        edTxtId = findViewById(R.id.edTxt);
        txtResultado = findViewById(R.id.txtEncontrados);
        recyclerView = findViewById(R.id.recyclerView);


        JsonRestFulApi jsonRestFulApi = buildConsumoApi("https://api.restful-api.dev/");
        btnListObjetos.setOnClickListener(v -> pulsarBotonListaObjetos(jsonRestFulApi));
        btnGetObjeto.setOnClickListener(v -> pulsarBotonTraerObjeto(jsonRestFulApi, edTxtId.getText().toString()));
        btnIngresarPhone.setOnClickListener(v -> {Intent intent = new Intent(getApplicationContext(), AddPhoneActivity.class);
            startActivity(intent);
        });

    }

    /**
     * @param direccionApi La URL de la api que queremos Cosumir
     * @return el objeto de la llamda a la api
     */
    private JsonRestFulApi buildConsumoApi(String direccionApi) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(direccionApi)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(JsonRestFulApi.class);

    }

    /**
     * Pulsamos sobre el botón para realizar la llamada a la APi
     *
     * @param jsonRestFulApi Le pasamos el objeto que retorna al consumir la api
     */
    private void pulsarBotonListaObjetos(JsonRestFulApi jsonRestFulApi) {
        Call<List<Phone>> listTelefonos = jsonRestFulApi.getAllPhone();
        listTelefonos.enqueue(new Callback<List<Phone>>() {
            @Override
            public void onResponse(Call<List<Phone>> call, Response<List<Phone>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "El Resultado llego vacio", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, "El resultado no trajo objetos");
                    return;
                }
                List<Phone> listPhones = response.body();
                Log.i(TAG, " Id : " + response.body().get(9).getId());
                Log.i(TAG, " Name : " + response.body().get(9).getName());
                Log.i(TAG, " data : " + response.body().get(9).getData());
                Log.i(TAG, " color : " + response.body().get(9).getData().getColor());
                Log.i(TAG, " capacity: " + response.body().get(9).getData().getCapacity());
                Log.i(TAG, " caseSize : " + response.body().get(9).getData().getCaseSize());
                Log.i(TAG, " description : " + response.body().get(9).getData().getDescription());
                Log.i(TAG, " generation : " + response.body().get(9).getData().getGeneration());
                Log.i(TAG, " CpuModel : " + response.body().get(9).getData().getCpuModel());
                Log.i(TAG, " year : " + response.body().get(9).getData().getYear());
                Log.i(TAG, " colourStrap : " + response.body().get(9).getData().getStrapColour());
                Log.i(TAG, " Price : " + response.body().get(9).getData().getPrice());
                Log.i(TAG, " hardDisk : " + response.body().get(9).getData().getHardDiskSize());
                String size = String.valueOf(listPhones.size());
                txtResultado.setText(size);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                adapter = new PhoneAdapter(getApplicationContext(), listPhones);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Phone>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "El consumo de la Api no se pudo establecer", Toast.LENGTH_SHORT);
                Log.e(TAG, "Fallo al realizar la llamada: " + t.getMessage());
            }
        });
    }

    private void pulsarBotonTraerObjeto(JsonRestFulApi jsonRestFulApi, String id) {
        if (!id.isEmpty()) {
            Call<Phone> telefono = jsonRestFulApi.getIdPhone(id);
            telefono.enqueue(new Callback<Phone>() {
                @Override
                public void onResponse(Call<Phone> call, Response<Phone> response) {
                    if (!response.isSuccessful()) {
                        Toast.makeText(getApplicationContext(), "El Resultado llego vacio", Toast.LENGTH_SHORT).show();
                        Log.e(TAG, "El resultado no trajo objetos " + response.code());
                        return;
                    }
                    // List<Phone> phoneListPruebaId = response.body();
                    Phone telefono = response.body();
                    List<Phone> listPhonesId = Collections.singletonList(telefono);

                    txtResultado.setText("1");
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    adapter = new PhoneAdapter(MainActivity.this, listPhonesId);
                    Log.i(TAG, "He pasado");
                    recyclerView.setAdapter(adapter);


                }

                @Override
                public void onFailure(Call<Phone> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "El consumo de la Api no se pudo establecer", Toast.LENGTH_SHORT);
                    Log.e(TAG, "Fallo al realizar la llamada: " + t.getMessage());
                }
            });
        } else {
            Toast.makeText(getApplicationContext(), "Introduce un Id válido", Toast.LENGTH_LONG).show();
        }
    }
}