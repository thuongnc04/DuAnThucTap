package com.ncthuong.duanthuctap.activity.user;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ncthuong.duanthuctap.R;
import com.ncthuong.duanthuctap.adapter.user.HistoryBuyAdapter;
import com.ncthuong.duanthuctap.database.MyDatabase;
import com.ncthuong.duanthuctap.model.HistoryBuy;

import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TextView tvCount;
    private List<HistoryBuy> list;
    HistoryBuyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        list = MyDatabase.getInstance(this).historyBuyDAO().getALlWithId(UserMainActivity.customer.getId());
        tvCount = findViewById(R.id.tv_count_history_buy);
        tvCount.setText(list.size()+"");

        recyclerView = findViewById(R.id.recy_history_buy);
        adapter = new HistoryBuyAdapter(this,list);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL,false));
    }
}