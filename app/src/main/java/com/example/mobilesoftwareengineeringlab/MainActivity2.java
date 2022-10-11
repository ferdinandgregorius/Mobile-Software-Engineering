package com.example.mobilesoftwareengineeringlab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mobilesoftwareengineeringlab.Models.DataModel;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity{

    ArrayList<DataModel> dataModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        dataModels = new ArrayList<DataModel>();
        dataModels.add(new DataModel("Hello", "World"));
        dataModels.add(new DataModel("Gading", "Serpong"));
        dataModels.add(new DataModel("Alam", "Sutera"));
        dataModels.add(new DataModel("SGU", "Best university"));

        prepareListView();
    }

    private void prepareListView() {
        RecyclerView rv = findViewById(R.id.list_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        DataModelAdapter dataModelAdapter = new DataModelAdapter(dataModels);

        rv.setLayoutManager(layoutManager);
        rv.setAdapter(dataModelAdapter);
    }
}

class DataModelAdapter extends RecyclerView.Adapter<DataModelViewHolder> {

    ArrayList<DataModel> dataModels;

    public DataModelAdapter(ArrayList<DataModel> dataModels) {
        this.dataModels = dataModels;
    }

    @NonNull
    @Override
    public DataModelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.list_item_card_value, parent, false);

        return new DataModelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataModelViewHolder holder, int position) {
        DataModel model = dataModels.get(position);

        holder.titleText.setText(model.getTitle());
        holder.descriptionText.setText(model.getDescription());
    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }
}

class DataModelViewHolder extends RecyclerView.ViewHolder {
    View parent;
    TextView titleText;
    TextView descriptionText;

    public DataModelViewHolder(@NonNull View itemView) {
        super(itemView);
        parent = itemView;
        titleText = itemView.findViewById(R.id.title_text);
        descriptionText = itemView.findViewById(R.id.description_text);
    }
}