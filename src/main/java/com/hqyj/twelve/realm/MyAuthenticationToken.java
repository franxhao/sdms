package com.hqyj.twelve.realm;

/**
 * @description:
 * @author: GP
 * @date: 2021/8/15-10:43
 */
import org.apache.shiro.authc.AuthenticationToken;

public class MyAuthenticationToken implements AuthenticationToken {


    private String flag;//新增的校验因子
    private String username;
    private char[] password;

    public void setFlag(String flag){
        this.flag = flag;
    }
    public String getFlag(){
        return flag;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public Object getPrincipal() {
        return getUsername();
    }

    public Object getCredentials() {
        return getPassword();
    }

    public char[] getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public MyAuthenticationToken() {
    }
    public MyAuthenticationToken(final String username, final char[] password,
                                 final String flag) {

        this.username = username;
        this.password = password;
        this.flag = flag;
    }

}


