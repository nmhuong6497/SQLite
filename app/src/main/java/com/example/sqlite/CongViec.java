package com.example.sqlite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CongViec {
    private int Id;
    private String Name;

    public CongViec(int id, String name) {
        Id = id;
        Name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public static final List<CongViec> getMock() {
        return new ArrayList<>(Arrays.asList(
                new CongViec(0, "Làm bài tập"),
                new CongViec(1, "Làm việc nhà"),
                new CongViec(2, "Nấu cơm"),
                new CongViec(3, "Giặt quần áo")
        ));
    }
}
