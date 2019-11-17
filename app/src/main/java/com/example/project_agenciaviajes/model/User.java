package com.example.project_agenciaviajes.model;


public class User {
    private int idUser;
    private String nameUser, emailUser, passwUser,url_imagen;
    private int dniUser,telefUser;
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getPasswUser() {
        return passwUser;
    }

    public void setPasswUser(String passwUser) {
        this.passwUser = passwUser;
    }

    public int getDniUser() {
        return dniUser;
    }

    public void setDniUser(int dniUser) {
        this.dniUser = dniUser;
    }

    public int getTelefUser() {
        return telefUser;
    }

    public void setTelefUser(int telefUser) {
        this.telefUser = telefUser;
    }

    public String getUrl_imagen() {
        return url_imagen;
    }

    public void setUrl_imagen(String url_imagen) {
        this.url_imagen = url_imagen;
    }
}