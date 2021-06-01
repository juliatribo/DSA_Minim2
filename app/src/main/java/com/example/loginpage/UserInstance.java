package com.example.loginpage;

import com.example.loginpage.models.Usuario;

public class UserInstance {
    private static UserInstance instance;
    private Usuario user;

    private UserInstance() {
        this.user = null;
    }

    public static UserInstance getInstance() {
        if (instance == null)
            instance = new UserInstance();
        return instance;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
}
