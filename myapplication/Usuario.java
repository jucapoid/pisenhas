package com.ruben.myapplication;

/**
 * Servirá para o registo do aluno
 */

public class Usuario {

    String Name, Nickname, Email, Password;

    public Usuario(String nome, String apelido, String email, String password){
        this.Name = nome;
        this.Nickname = apelido;
        this.Email = email;
        this.Password = password;
    }

    public Usuario(String email, String password){
        this.Name = "";
        this.Nickname = "";
        this.Email = email;
        this.Password = password;
    }
}
