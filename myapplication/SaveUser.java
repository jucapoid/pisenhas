package com.ruben.myapplication;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Vai guardar as informações do usuário
 */

public class SaveUser {

    public static final String Details = "User_Details";
    SharedPreferences userDatabase;

    // Construtor
    public SaveUser(Context context){
        userDatabase = context.getSharedPreferences(Details, 0);
    }

    // Guarda a inscrição de novos alunos
    public void storeUserData(Usuario user){
        SharedPreferences.Editor Editor = userDatabase.edit();
        Editor.putString("name", user.Name );
        Editor.putString("nickname", user.Nickname);
        Editor.putString("email", user.Email);
        Editor.putString("password", user.Password);
        Editor.commit();
    }

    // Devolve o conteudo do aluno
    public Usuario getLoggedUsuario(){
        String name = userDatabase.getString("name", "");
        String nickname = userDatabase.getString("nickname", "");
        String email = userDatabase.getString("email", "");
        String password = userDatabase.getString("password", "");

        Usuario usuario = new Usuario(name,nickname,email,password);
        return usuario;
    }

    // Coloca o Usuario fazer logIn, colocando a true este método
    public void setUserLoggedIn(boolean loggedIn){
        SharedPreferences.Editor Editor = userDatabase.edit();
        Editor.putBoolean("loggedIn", loggedIn);
        Editor.commit();
    }

     // Devolve se o aluno esta autenticado
    public boolean getIfUserLoggedIn(){
        if(userDatabase.getBoolean("LoggedIn", false)== true){
            return true;
        }else {
            return false;
        }
    }

    // Apaga os Dados do Aluno
    public void clearUserData(){
        SharedPreferences.Editor Editor = userDatabase.edit();
        Editor.clear();
        Editor.commit();
    }
}
