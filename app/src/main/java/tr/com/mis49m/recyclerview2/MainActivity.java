package tr.com.mis49m.recyclerview2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contact> contactList;

    Button btn;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //-- initialize data set
        initializeData();

        //-- Read references from ui
        btn = (Button) findViewById(R.id.btnRemove);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        //-- create layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //-- create adapter
        final MyAdapter myAdapter = new MyAdapter(contactList, this);
        //-- set adapter to recyclerview
        recyclerView.setAdapter(myAdapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //-- create iterator from arraylist
                Iterator<Contact> i = contactList.iterator();
                while (i.hasNext()) {
                    Contact contact = i.next();
                    if(contact.isChecked)
                        i.remove(); //-- remove if selected
                }
                //-- notify adapter about dataset chanced
                myAdapter.notifyDataSetChanged();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //-- Add menu on application bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle menu item selection
        switch (item.getItemId()) {
            case R.id.menu_list:
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                return true;
            case R.id.menu_grid:
                recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void initializeData() {
        contactList = new ArrayList<>();
        contactList.add(new Contact("Marc-Andre ter Stegen", "#33b5e5", "+34 987654321", "terstegen@fcb.com", false));
        contactList.add(new Contact("Luis Suares", "#ffbb33", "+34 987654321", "suares@fcb.com", false));
        contactList.add(new Contact("Jordi Alba", "#ff4444", "+34 123456789", "alba@fcb.com", false));
        contactList.add(new Contact("Lionel Messi", "#99cc00", "+34 123456789", "messi@fcb.com", false));
        contactList.add(new Contact("Neymar", "#33b5e5", "+34 987654321", "neymar@fcb.com", false));
        contactList.add(new Contact("Javier Mascherano", "#ffbb33", "+34 123456789", "mascherano@fcb.com", false));
        contactList.add(new Contact("Andres Iniesta", "#ff4444", "+34 11235813", "iniesta@fcb.lu", false));
        contactList.add(new Contact("Dani Alves", "#99cc00", "+34 987654321", "alves@fcb.com", false));

    }

}


