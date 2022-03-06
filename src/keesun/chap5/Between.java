package keesun.chap5;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Between {

    public static void main(String[] args) {
        //휴먼용
        LocalDate today = LocalDate.now();
        LocalDate thisYearBirthday = LocalDate.of(2022, Month.OCTOBER, 6);

        java.time.Period period = java.time.Period.between(today, thisYearBirthday);
        System.out.println(period.getDays());

        java.time.Period until = today.until(thisYearBirthday);
        System.out.println(until.get(ChronoUnit.DAYS));
        
        //머신용
        Instant now = Instant.now();
        Instant plus = now.plus(10, ChronoUnit.SECONDS);
        Duration between = Duration.between(now, plus);
        System.out.println(between.getSeconds());
    }
}
