package tr.com.mis49m.recyclerview2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    ArrayList<Contact> contactList;
    Context context;

    public MyAdapter(ArrayList<Contact> contactList, Context context) {
        this.contactList = contactList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Contact contact = contactList.get(position);

        holder.tName.setText(contact.name);
        holder.tPhone.setText(contact.phone);
        holder.tInitials.setText(contact.name.substring(0,1));

        GradientDrawable circleBachground = (GradientDrawable) holder.circle.getBackground();
        circleBachground.setColor(Color.parseColor(contact.color));

        holder.checkBox.setChecked(contact.isChecked);
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean value) {
                contact.isChecked = value;
            }
        });

        holder.lClickHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                intent.putExtra("name", contact.name);
                intent.putExtra("contact", contact);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tName, tPhone, tInitials;
        View circle;
        CheckBox checkBox;
        LinearLayout lClickHolder;
        public MyViewHolder(View itemView) {
            super(itemView);
             tName = (TextView) itemView.findViewById(R.id.name);
             tPhone = (TextView) itemView.findViewById(R.id.phone);
             tInitials = (TextView) itemView.findViewById(R.id.initials);
             checkBox = (CheckBox) itemView.findViewById(R.id.check);
             circle = (View) itemView.findViewById(R.id.circle);
             lClickHolder = (LinearLayout) itemView.findViewById(R.id.clickHolder);
        }
    }

}
