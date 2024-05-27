package grpceffortservice.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import com.google.protobuf.ByteString;
import com.proto.audio.Video.DataChunkResponse;
import com.proto.audio.Video.DownloadVideoRequest;
import com.proto.audio.VideoServiceGrpc.VideoServiceImplBase;

import io.grpc.stub.StreamObserver;

public class ServerImpl extends VideoServiceImplBase {

    @Override
    public void downloadVideo(DownloadVideoRequest request, StreamObserver<DataChunkResponse> responseObserver) {
        String videoName = request.getName();
        System.out.println("\n\nSending Video: " + videoName);

        Path videoPath = Paths.get("app/src/main/resources/uploads/", videoName).toAbsolutePath();
        if (!Files.exists(videoPath)) {
            responseObserver.onError(new IOException("File not found: " + videoName));
            return;
        }

        try (InputStream fileStream = Files.newInputStream(videoPath)) {
            int bufferSize = 1024;
            byte[] buffer = new byte[bufferSize];
            int length;

            while ((length = fileStream.read(buffer, 0, bufferSize)) != -1) {
                DataChunkResponse response = DataChunkResponse.newBuilder()
                        .setData(ByteString.copyFrom(buffer, 0, length))
                        .build();
                responseObserver.onNext(response);
            }

            responseObserver.onCompleted();

        } catch (IOException e) {
            System.out.println("Could not get file " + videoName);
            responseObserver.onError(e);
        } catch (Exception e) {
            e.printStackTrace();
            responseObserver.onError(e);
        }
    }

    @Override
    public StreamObserver<DataChunkResponse> uploadVideo(StreamObserver<DownloadVideoRequest> responseObserver) {
        return new StreamObserver<DataChunkResponse>() {
            String videoName;
            OutputStream writer;

            @Override
            public void onNext(DataChunkResponse request) {
                try {
                    if (request.hasName()) {
                        videoName = request.getName();
                        System.out.println("\nReceiving the file: " + videoName);
                        var videoPath = Paths.get("app/src/main/resources/uploads/" + videoName).toAbsolutePath();
                        writer = Files.newOutputStream(videoPath, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                    } else if (request.hasData()) {
                        writer.write(request.getData().toByteArray());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    responseObserver.onError(e);
                }
            }

            @Override
            public void onError(Throwable t) {
                try {
                    if (writer != null) {
                        writer.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                responseObserver.onError(t);
            }

            @Override
            public void onCompleted() {
                try {
                    if (writer != null) {
                        writer.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    responseObserver.onError(e);
                }

                DownloadVideoRequest response = DownloadVideoRequest.newBuilder().setName(videoName).build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
                System.out.println("\nRecepción de datos terminada.");
            }
        };
    }
}
