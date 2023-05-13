package com.example.montestore;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Admin extends AppCompatActivity {
    private ListView userList;
    private ArrayAdapter<String> adapter;
    private List<String> userIdList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        userList = findViewById(R.id.userList);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        userIdList = new ArrayList<>();

        displayUserList();
        userList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Show confirmation dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(Admin.this);
                builder.setMessage("Are you sure you want to delete this user?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Remove user from database
                        String userId = userIdList.get(position);
                        // Remove user from list
                        userIdList.remove(position);
                        adapter.notifyDataSetChanged();
                        removeUser(userId);

                    }
                });
                builder.setNegativeButton("No", null);
                builder.show();
            }
        });


    }

    private void displayUserList() {
        DataBase dataBase = DataBase.getDataBase(getApplicationContext());
        final DAO dao = dataBase.userDao();

        new Thread(new Runnable() {
            @Override
            public void run() {
                List<UEntity> users = dao.getAllUsers();
                for (UEntity user : users) {
                    String item = user.getUserId() + " - " + user.getName();
                    userIdList.add(user.getUserId());
                    adapter.add(item);
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        userList.setAdapter(adapter);
                    }
                });
            }
        }).start();
    }



    private void removeUser(final String userId) {
        DataBase dataBase = DataBase.getDataBase(getApplicationContext());
        final DAO dao = dataBase.userDao();

        new Thread(new Runnable() {
            @Override
            public void run() {
                dao.deleteUserById(userId);
            }
        }).start();
    }
}
