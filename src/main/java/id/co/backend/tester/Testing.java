package id.co.backend.tester;

import com.google.common.collect.Lists;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Testing {

    public static void main(String[] args){
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy", new java.util.Locale("id"));

        String date = localDateTime.format(dateTimeFormatter);

        System.out.println(date);
    }
}
