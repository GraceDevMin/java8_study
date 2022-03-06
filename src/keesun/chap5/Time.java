package keesun.chap5;

import java.time.*;

public class Time {

    public static void main(String[] args) {
        //기계용API (시간을 재거나, 메서드 실행 시간을 비교하거나 할 때.. 등)
        Instant instant = Instant.now();
        System.out.println(instant); //기준시 UTC, GMT

        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);
        ZonedDateTime zonedDateTime = instant.atZone(zoneId);
        System.out.println(zonedDateTime);

        //휴먼용API
        LocalDateTime now = LocalDateTime.now();    //내컴퓨터의 로컬타임 cf.서버에 배포시
        System.out.println(now);
        LocalDateTime birthDay = LocalDateTime.of(1982, Month.JULY, 15, 0, 0, 0);
        ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println(nowInKorea);

        Instant nowInstant = Instant.now();
        ZonedDateTime zonedDateTime1 = nowInstant.atZone(ZoneId.of("Asia/Seoul"));
        System.out.println(zonedDateTime1);
    }
}
