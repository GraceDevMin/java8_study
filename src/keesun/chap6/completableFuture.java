package keesun.chap6;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class completableFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CompletableFuture<String> future = new CompletableFuture<>();
//        future.complete("keesun");
//
//        System.out.println(future.get());

        //리턴값이 없는 경우
//        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
//            System.out.println("Hello " + Thread.currentThread().getName());
//        });
//
//        future.get();

        //리턴값이 있는 경우
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }).thenApply((s) -> {
            System.out.println(Thread.currentThread().getName());
            return s.toUpperCase();
        }); //자바8 이전에는 get이전에 콜백을 정의하는 것이 불가능했었음

        System.out.println(future.get());
    }
}
