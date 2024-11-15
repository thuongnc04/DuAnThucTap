package com.ncthuong.duanthuctap.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.ncthuong.duanthuctap.dao.CustomerDAO;
import com.ncthuong.duanthuctap.dao.HistoryBuyDAO;
import com.ncthuong.duanthuctap.dao.ManagerCategoryDAO;
import com.ncthuong.duanthuctap.dao.ManagerDAO;
import com.ncthuong.duanthuctap.dao.NotificationDAO;
import com.ncthuong.duanthuctap.dao.NotificationDetailsDAO;
import com.ncthuong.duanthuctap.dao.OrderDAO;
import com.ncthuong.duanthuctap.dao.OrderDetailsDAO;
import com.ncthuong.duanthuctap.dao.PitchCategoryDAO;
import com.ncthuong.duanthuctap.dao.PitchDAO;
import com.ncthuong.duanthuctap.dao.ServiceDAO;
import com.ncthuong.duanthuctap.dao.TimeDAO;
import com.ncthuong.duanthuctap.dao.TimeOrderDetailsDAO;
import com.ncthuong.duanthuctap.model.Customer;
import com.ncthuong.duanthuctap.model.HistoryBuy;
import com.ncthuong.duanthuctap.model.Manager;
import com.ncthuong.duanthuctap.model.ManagerCategory;
import com.ncthuong.duanthuctap.model.MyNotification;
import com.ncthuong.duanthuctap.model.MyTime;
import com.ncthuong.duanthuctap.model.NotificationDetails;
import com.ncthuong.duanthuctap.model.Order;
import com.ncthuong.duanthuctap.model.OrderDetails;
import com.ncthuong.duanthuctap.model.Pitch;
import com.ncthuong.duanthuctap.model.PithCategory;
import com.ncthuong.duanthuctap.model.ServiceBall;
import com.ncthuong.duanthuctap.model.TimeOrderDetails;

@Database(entities = {Customer.class,Manager.class, Order.class
        , OrderDetails.class, Pitch.class, PithCategory.class
        , ServiceBall.class, ManagerCategory.class, MyNotification.class
        , MyTime.class, TimeOrderDetails.class, HistoryBuy.class
        , NotificationDetails.class}, version = 1)
public abstract class MyDatabase extends RoomDatabase {

    private static String DB_NAME = "PITCH_MANAGER22";
    private static MyDatabase instance;

    public static synchronized MyDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),MyDatabase.class,DB_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    public abstract CustomerDAO customerDAO();
    public abstract ManagerDAO managerDAO();
    public abstract OrderDAO orderDAO();
    public abstract OrderDetailsDAO orderDetailsDAO();
    public abstract PitchCategoryDAO pitchCategoryDAO();
    public abstract PitchDAO pitchDao();
    public abstract ServiceDAO serviceDAO();
    public abstract ManagerCategoryDAO managerCategoryDAO();
    public abstract TimeOrderDetailsDAO timeOrderDetailsDAO();
    public abstract TimeDAO timeDAO();
    public abstract HistoryBuyDAO historyBuyDAO();
    public abstract NotificationDetailsDAO notificationDetailsDAO();
    public abstract NotificationDAO notificationDAO();
}
