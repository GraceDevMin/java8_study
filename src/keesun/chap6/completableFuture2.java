package keesun.chap6;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class completableFuture2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        });

//        CompletableFuture<String> future = hello.thenCompose(completableFuture2::getWorld);
//        System.out.println(future.get());
//    }
//
//    private static CompletableFuture<String> getWorld(String message) {
//        return CompletableFuture.supplyAsync(() -> {
//            System.out.println(message + Thread.currentThread().getName());
//            return message + "World";
//        });

        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> {
            System.out.println("World " + Thread.currentThread().getName());
            return "World";
        });

        CompletableFuture<String> future = hello.thenCombine(world, (h, w) -> h + " " + w);
        System.out.println(future.get());

    }
}
