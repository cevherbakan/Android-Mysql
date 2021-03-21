package com.example.mysql_data_connection;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobilhanem.retrofitgetandpost.R;
import com.mobilhanem.retrofitgetandpost.model.UserResponse;

import java.util.List;

/**
 * Created by alper on 19/02/17.
 */

public class CustomAdaptor extends RecyclerView.Adapter<CustomAdapter.PersonViewHolder> {

    private List<UserResponse> userResponses;
    private CustomAdapter.PersonViewHolder holder;
    private int position;

    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        TextView personName;
        TextView personEmail;
        TextView personPhone;
        TextView companyName;
        TextView ehliyetSinifi;
        TextView experienceYear;

        PersonViewHolder(View itemView) {
            super(itemView);
            personName = (TextView)itemView.findViewById(R.id.customer_name);
            personEmail = (TextView)itemView.findViewById(R.id.customer_email);
            personPhone = (TextView)itemView.findViewById(R.id.customer_phone);
            companyName = (TextView)itemView.findViewById(R.id.company_name);
            ehliyetSinifi = (TextView)itemView.findViewById(R.id.ehliyetSinifi);
            experienceYear = (TextView)itemView.findViewById(R.id.experince_year);
        }
    }

    public CustomAdapter(List<UserResponse> userResponses){
        this.userResponses = userResponses;
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item, parent, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.PersonViewHolder holder, int position) {

        this.holder = holder;
        this.position = position;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {
        holder.personName.setText("Kullanıcı Adı:"+"  "+userResponses.get(position).getBilgiler().getMusteriKullaniciAdi());
        holder.personPhone.setText("Telefon Numarası:"+"  "+userResponses.get(position).getBilgiler().getTelefon());
        holder.personEmail.setText("E-posta:"+"  "+userResponses.get(position).getBilgiler().getMusteriEposta());
        holder.companyName.setText("Firma Ünvan:"+"  "+userResponses.get(position).getBilgiler().getFirmaUnvan());
        holder.ehliyetSinifi.setText("Ehliyet Sınıfı:"+"  "+userResponses.get(position).getBilgiler().getEhliyetSinifi());
        holder.experienceYear.setText("Tecrübe Yılı:"+"  "+userResponses.get(position).getBilgiler().getTecrubeYil());
    }

    @Override
    public int getItemCount() {
        return userResponses.size();
    }
}