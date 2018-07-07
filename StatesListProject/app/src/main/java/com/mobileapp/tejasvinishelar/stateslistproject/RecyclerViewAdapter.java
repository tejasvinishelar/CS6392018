package com.mobileapp.tejasvinishelar.stateslistproject;

import android.content.Context;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private ArrayList<String> statesList;
    private Context contex;

    public RecyclerViewAdapter(ArrayList<String> statesList, Context contex) {
        this.statesList = statesList;
        this.contex = contex;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_layout,parent,false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder,final int position) {
        Log.d("TAG","called");
        holder.stateName.setText(statesList.get(position));

            holder.stateName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(holder.stateName.getText()=="Tennessee") {
                        String uri = "https://www.google.com/maps/place/Nashville,+TN/@36.1865585,-86.9256726,11z/data=!3m1!4b1!4m5!3m4!1s0x8864ec3213eb903d:0x7d3fb9d0a1e9daa0!8m2!3d36.1626638!4d-86.7816016" ;
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                        intent.setPackage("com.google.android.apps.maps");
                        contex.startActivity(intent);

                    }


                    Toast.makeText(contex, holder.stateName.getText(), Toast.LENGTH_LONG).show();

                }
            });
    }

    @Override
    public int getItemCount() {
        return statesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView stateName;
        LinearLayout parentlayout;

        public ViewHolder(View itemView) {
            super(itemView);
            stateName = itemView.findViewById(R.id.textView);
            parentlayout = itemView.findViewById(R.id.parent_layout);

        }
    }
}
