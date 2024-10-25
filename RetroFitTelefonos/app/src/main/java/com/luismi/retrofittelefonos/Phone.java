package com.luismi.retrofittelefonos;
/*
  *  {
    "id": "1",
    "name": "Google Pixel 6 Pro",
    "data": {
       "color": "Cloudy White",
       "capacity": "128 GB"
    }
 }
 */
public class Phone {
  private String id;
  private String name;
  private Data data;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
