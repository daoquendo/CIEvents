/**
 * Roberto Cervantes
 * Daniela Miles
 * Brian Ortiz
 * Brian Radomski
 */
package cievents;

/**
 *
 * @author brian.ortiz540
 */
public class Member {
    private String email;
    private String password;
    
    public Member(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean equals(Member other) {
        return this.email.equals(other.email) && this.password.equals(other.password);
    }
    
    public String toString() {
        return "User: " + this.email + "\n" + "Password: " + this.password;
    }
}
