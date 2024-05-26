package grpceffortservice.server;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class Servidor {
    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 8080;

        Server server = ServerBuilder
                .forPort(port)
                .addService(new ServerImpl())
                .intercept(new JwtServerInterceptor())
                .build();
        
        server.start();

        System.out.println("Server starting...");
        System.out.println("Listening on port: " + port);

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.out.println("Receiving shutdown request...");
                server.shutdown();
                System.out.println("Server stopped");
            }
        });

        server.awaitTermination();
    }
}
