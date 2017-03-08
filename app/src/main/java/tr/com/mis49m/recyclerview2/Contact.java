package tr.com.mis49m.recyclerview2;

import java.io.Serializable;

public class Contact implements Serializable {

    String name;
    String phone;
    String eMail;
    String color;
    boolean isChecked;

    public Contact(String name, String color,
                   String phone, String eMail,
                   boolean isChecked) {
        this.name = name;
        this.phone = phone;
        this.eMail = eMail;
        this.color = color;
        this.isChecked = isChecked;
    }

}
