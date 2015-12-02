/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cievents;

/**
 *
 * @author brian.ortiz540
 */
public class LoginManager {
    Member current;
    
    public LoginManager() {
        this.current = null;
    }
    
    public Member getUser() {
        return this.current;
    }
    
    public void setUser(Member member) {
        this.current = member;
    }
    
    public String toString() {
        return this.current.toString();
    }
}
