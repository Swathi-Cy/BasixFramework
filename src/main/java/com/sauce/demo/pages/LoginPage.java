package com.sauce.demo.pages;

import org.openqa.selenium.By;

public class LoginPage extends  BasePage{
    private By usernameField=By.id("username");
    private By passwordField=By.id("password");
    private By loginBtn=By.id("login-button");
    private By errormessage=By.xpath("#login_button_container h3");

    public void setUsername(String username){
        set(usernameField,username);
    }
    public void setPassword(String password){
        set(passwordField,password);
    }
    public ProductPage setLoginBtn(){
        click(loginBtn);
        return new ProductPage();// This is a transition method because when you click the button, you are led to another page
    }
    public ProductPage LogintoApplication(String username, String password){
        setUsername(username);
        setPassword(password);
        return setLoginBtn();
    }
    public String getErrorMessage(){
        return  find(errormessage).getText();

    }


}
