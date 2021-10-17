package com.example.mascotas.pojo;

import android.app.usage.UsageEvents;

public class Pet {



    private String nombre;
    private  int likes;
    private int img;


    public Pet(String nombre,int likes,int img){
        this.nombre=nombre;
        this.likes=likes;
        this.img=img;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {

        this.likes = likes;
    }

    public int getImg() {
        return img;
    }
    public void like(){
        this.likes++;
    }
    public void setImg(int img) {
        this.img = img;
    }







}
