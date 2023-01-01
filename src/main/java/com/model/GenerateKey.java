package com.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

@Entity(name = "license_keys")
public class GenerateKey implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "lkey")
    private String lkey;

    @Column(name = "link")
    private String link;

    @Column(name = "days")
    private int days;

    @Column(name = "expiration_date")
    private Date expirationDate;

    //private Calendar expiration;


 /*   public GenerateKey(int id, String link, int days) {
        this.id = id;
        this.key = generateKey();
        this.link = link + "?key=" + this.key;
        this.expiration = Calendar.getInstance();
        this.expiration.add(Calendar.DAY_OF_YEAR, days);
    }*/

   /* public GenerateKey(String link, int days) {

        this.key = generateKey();
        this.link = link + "?key=" + this.key;
        this.expiration = Calendar.getInstance();
        this.expiration.add(Calendar.DAY_OF_YEAR, days);

    }*/

   /* private String generateKey() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int c = random.nextInt(36);
            if (c < 10) {
                sb.append((char) (c + '0'));
            } else {
                sb.append((char) (c - 10 + 'A'));
            }
        }
        return sb.toString();
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getLkey() {
        return lkey;
    }

    public void setLkey(String lkey) {
        this.lkey = lkey;
    }
}


//In this example, the License class has three private fields: key, link, and expiration. It has a constructor that takes a link and days as
// parameters and uses them to initialize the fields. The key field is initialized using the generateKey() method, which generates a random
// mixed numbers and letters string of length 10. The link field is initialized by appending the key to the provided link using string concatenation.
// The expiration field is initialized using the Calendar class and the provided days parameter. The class also has getter methods for each of the
// fields.