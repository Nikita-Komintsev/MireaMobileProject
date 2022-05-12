package com.mirea.komintsev.mireaproject.ui.stories;

public class Stories {
    private String text;
    private String photo;

    public Stories(String text, String photo) {
        this.text = text;
        this.photo = photo;
    }
    public Stories(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
