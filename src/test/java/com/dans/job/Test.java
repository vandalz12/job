package com.dans.job;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class Test {

    public static void main(String[] args) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss 'UTC' yyyy");
        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss 'UTC' yyyy");
        System.out.println(dateTimeFormatter.format(offsetDateTime));
//        System.out.print(OffsetDateTime.parse("Wed Jul 12 14:23:22 UTC 2023", dateTimeFormatter));
        System.out.println(OffsetDateTime.ofInstant(dateFormat.parse("Wed Jul 12 14:23:22 UTC 2023").toInstant(), ZoneOffset.UTC));
    }

}
