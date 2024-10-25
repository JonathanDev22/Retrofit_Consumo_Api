package com.luismi.retrofittelefonos;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class Data {
    @Nullable
    private String color;
    @Nullable
    private String capacity;
    @Nullable
    @SerializedName("price")
    private Float price;
    @Nullable
    private String generation;
    @Nullable
    private int year;
    @Nullable
    @SerializedName("CPU_model")
    private String cpuModel;
    @Nullable
    @SerializedName("Hard disk size")
    private String hardDiskSize;
    @Nullable
    @SerializedName("Strap Colour")
    private String strapColour;
    @Nullable
    @SerializedName("case size")
    private String caseSize;
    @Nullable
    private String description;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getGeneration() {
        return generation;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCpuModel() {
        return cpuModel;
    }

    public void setCpuModel(String cpuModel) {
        this.cpuModel = cpuModel;
    }

    public String getHardDiskSize() {
        return hardDiskSize;
    }

    public void setHardDiskSize(String hardDiskSize) {
        this.hardDiskSize = hardDiskSize;
    }

    public String getStrapColour() {
        return strapColour;
    }

    public void setStrapColour(String strapColour) {
        this.strapColour = strapColour;
    }

    public String getCaseSize() {
        return caseSize;
    }

    public void setCaseSize(String caseSize) {
        this.caseSize = caseSize;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
