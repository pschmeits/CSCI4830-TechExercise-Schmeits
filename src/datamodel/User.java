package datamodel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @since J2SE-1.8
 CREATE TABLE users (
  id INT NOT NULL AUTO_INCREMENT,    
  userName VARCHAR(30) NOT NULL,   
  password VARCHAR(30) NOT NULL, 
  PRIMARY KEY (id));
 */
@Entity
@Table(name = "user")
public class User {

   @Id  // primary key
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id") // specify the column name. Without it, it will use method name
   private Integer id;

   @Column(name = "userName")
   private String userName;
   
   @Column(name = "password")
   private String password;

   public User() {
	  super();
   }

   public User(Integer id, String userName, String password) {
      this.id = id;
      this.userName = userName;
      this.password = password;
   }

   public User(String userName, String password) {
      this.userName = userName;
      this.password = password;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getUserName() {
      return userName;
   }

   public void setUserName(String username) {
      this.userName = username;
   }
   
   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   @Override
   public String toString() {
      return "User: " + this.id + ", " + this.userName + ", " + this.password;
   }
}