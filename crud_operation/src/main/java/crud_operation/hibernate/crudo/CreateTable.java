package crud_operation.hibernate.crudo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Data;

@Entity
@Data
public class CreateTable {

    @javax.persistence.Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int Id;
    private  String Name;
    private  String Email;
    private  String Dob;
    private long Phone_No;

}
