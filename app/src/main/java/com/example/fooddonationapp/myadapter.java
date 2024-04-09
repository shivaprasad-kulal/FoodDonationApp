package com.example.fooddonationapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myadapter extends  RecyclerView.Adapter<myadapter.myviewholder> {

    ArrayList<model> datastore;

    public myadapter(ArrayList<model> datastore) {
        this.datastore = datastore;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.onerow_one,parent,false);
         return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.dname.setText(datastore.get(position).getName());
        holder.dfood.setText(datastore.get(position).getFood());
        holder.daddress.setText(datastore.get(position).getAddress());
        holder.dphone.setText(datastore.get(position).getPhone());
        holder.dpin.setText(datastore.get(position).getPin());
        holder.dquantity.setText(datastore.get(position).getQuantity());
        holder.demail.setText(datastore.get(position).getEmail());

    }

    @Override
    public int getItemCount() {
        return datastore.size();
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        TextView  dname,dfood,daddress,dphone,dpin,dquantity,demail;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            dname=(TextView)itemView.findViewById(R.id.oname);
            dfood=(TextView)itemView.findViewById(R.id.ofood);
            daddress=(TextView)itemView.findViewById(R.id.oaddress);
            dphone=(TextView)itemView.findViewById(R.id.ophone);
            dpin=(TextView)itemView.findViewById(R.id.opin);
            dquantity=(TextView)itemView.findViewById(R.id.oquant);
            demail=(TextView)itemView.findViewById(R.id.oemail);


        }
    }
}
