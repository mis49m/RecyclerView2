package tr.com.mis49m.recyclerview2;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView tName, tPhone, tMail;
    View view;
    LinearLayout back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //-- Read references from ui
        tName = (TextView) findViewById(R.id.name);
        tPhone = (TextView) findViewById(R.id.phone);
        tMail = (TextView) findViewById(R.id.email);
        view = (View) findViewById(R.id.circle);
        back = (LinearLayout) findViewById(R.id.back);

        //-- get intent
        Intent intent = getIntent();

        //-- get value from intent
        Contact contact = (Contact)intent.getSerializableExtra("contact");

        //-- set values to ui components
        tName.setText(contact.name);
        tPhone.setText(contact.phone);
        tMail.setText(contact.eMail);

        //-- change background color
        GradientDrawable bgShape = (GradientDrawable) view.getBackground();
        bgShape.setColor(Color.parseColor(contact.color));
        back.setBackgroundColor(Color.parseColor(contact.color));

    }

}
