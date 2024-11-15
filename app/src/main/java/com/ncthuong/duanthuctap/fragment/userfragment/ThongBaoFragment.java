package com.ncthuong.duanthuctap.fragment.userfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ncthuong.duanthuctap.MyApplication;
import com.ncthuong.duanthuctap.R;
import com.ncthuong.duanthuctap.activity.user.UserMainActivity;
import com.ncthuong.duanthuctap.adapter.user.NotificationAdapterUser;
import com.ncthuong.duanthuctap.database.MyDatabase;
import com.ncthuong.duanthuctap.model.MyNotification;

import java.util.List;


public class ThongBaoFragment extends Fragment {

    List<MyNotification> notifications;
    RecyclerView recyclerView;
    NotificationAdapterUser adapterUser;
    TextView tv;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        notifications = MyDatabase.getInstance(getContext()).notificationDAO().getNotifiWithCusId(UserMainActivity.customer.getId(), MyApplication.HOATDONG_STATUS);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_thong_bao, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recy_notifi_user);
        tv = view.findViewById(R.id.tv_count_notification_user);
        tv.setText(notifications.size()+"");

        adapterUser = new NotificationAdapterUser(getContext(),notifications);
        recyclerView.setAdapter(adapterUser);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
    }
}