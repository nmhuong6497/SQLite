package com.example.sqlite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Database database;
    RecyclerView recyclerView;
    CongViecAdapter congViecAdapter;
    List<CongViec> congViecList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        congViecList = CongViec.getMock();
        congViecAdapter = new CongViecAdapter(congViecList);
        recyclerView.setAdapter(congViecAdapter);
        recyclerView.setHasFixedSize(true);

        database = new Database(this, "ghichu.sqlite", null, 1);
        database.QueryData("CREATE TABLE IF NOT EXISTS CongViec(Id INTEGER PRIMARY KEY AUTOINCREMENT, TenCV VARCHAR)");
//        database.QueryData("INSERT INTO CongViec VALUES(null, 'Lam bai tap Android 4')");

        GetDataCongViec();
    }

    private void GetDataCongViec() {
        Cursor dataCongViec = database.GetData("SELECT * FROM CongViec");
        while (dataCongViec.moveToNext()) {
            String ten = dataCongViec.getString(1);
            int id = dataCongViec.getInt(0);
            congViecList.add(new CongViec(id, ten));
        }
        congViecAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_cong_viec, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_add) {
            Dialog();
        }
        return super.onOptionsItemSelected(item);
    }

    public void Dialog() {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_add);

        Window window = dialog.getWindow();
        if (window != null) {
            window.setGravity(Gravity.CENTER);
            window.setLayout(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
        }

        EditText edtAdd = findViewById(R.id.edt_add);
        Button btnAdd = findViewById(R.id.btn_add);
        Button btnCancel = findViewById(R.id.btn_cancel);

//        btnAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String tenCV = edtAdd.getText().toString();
//                if (tenCV.equals("")) {
//                    Toast.makeText(MainActivity.this, "Hãy nhập nội dung công việc", Toast.LENGTH_SHORT).show();
//                } else {
//                    database.QueryData("INSERT INTO CongViec VALUES(null, '"+ tenCV +"')");
//                    Toast.makeText(MainActivity.this, "Đã thêm", Toast.LENGTH_SHORT).show();
//                    dialog.dismiss();
//                    GetDataCongViec();
//                }
//            }
//        });

        dialog.show();
    }
}