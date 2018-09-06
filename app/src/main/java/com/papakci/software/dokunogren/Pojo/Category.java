package com.papakci.software.dokunogren.Pojo;


/**
 * Created by EREN on 23/12/2017.
 */

public class Category {

    int ID;
    String picture_n,text_n,sound_n;

    public Category(String picture_n, String text_n, String sound_n) {
        this.picture_n = picture_n;
        this.text_n = text_n;
        this.sound_n = sound_n;
    }

    public String getPicture_n() {
        return picture_n;
    }

    public void setPicture_n(String picture_n) {
        this.picture_n = picture_n;
    }

    public String getText_n() {
        return text_n;
    }

    public void setText_n(String text_n) {
        this.text_n = text_n;
    }

    public String getSound_n() {
        return sound_n;
    }

    public void setSound_n(String sound_n) {
        this.sound_n = sound_n;
    }


}
