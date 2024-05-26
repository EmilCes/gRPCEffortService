package com.proto.audio;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.62.2)",
    comments = "Source: video.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class VideoServiceGrpc {

  private VideoServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "VideoService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.proto.audio.Video.DownloadVideoRequest,
      com.proto.audio.Video.DataChunkResponse> getDownloadVideoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "downloadVideo",
      requestType = com.proto.audio.Video.DownloadVideoRequest.class,
      responseType = com.proto.audio.Video.DataChunkResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.proto.audio.Video.DownloadVideoRequest,
      com.proto.audio.Video.DataChunkResponse> getDownloadVideoMethod() {
    io.grpc.MethodDescriptor<com.proto.audio.Video.DownloadVideoRequest, com.proto.audio.Video.DataChunkResponse> getDownloadVideoMethod;
    if ((getDownloadVideoMethod = VideoServiceGrpc.getDownloadVideoMethod) == null) {
      synchronized (VideoServiceGrpc.class) {
        if ((getDownloadVideoMethod = VideoServiceGrpc.getDownloadVideoMethod) == null) {
          VideoServiceGrpc.getDownloadVideoMethod = getDownloadVideoMethod =
              io.grpc.MethodDescriptor.<com.proto.audio.Video.DownloadVideoRequest, com.proto.audio.Video.DataChunkResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "downloadVideo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.audio.Video.DownloadVideoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.audio.Video.DataChunkResponse.getDefaultInstance()))
              .setSchemaDescriptor(new VideoServiceMethodDescriptorSupplier("downloadVideo"))
              .build();
        }
      }
    }
    return getDownloadVideoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.proto.audio.Video.DataChunkResponse,
      com.proto.audio.Video.DownloadVideoRequest> getUploadVideoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "uploadVideo",
      requestType = com.proto.audio.Video.DataChunkResponse.class,
      responseType = com.proto.audio.Video.DownloadVideoRequest.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.proto.audio.Video.DataChunkResponse,
      com.proto.audio.Video.DownloadVideoRequest> getUploadVideoMethod() {
    io.grpc.MethodDescriptor<com.proto.audio.Video.DataChunkResponse, com.proto.audio.Video.DownloadVideoRequest> getUploadVideoMethod;
    if ((getUploadVideoMethod = VideoServiceGrpc.getUploadVideoMethod) == null) {
      synchronized (VideoServiceGrpc.class) {
        if ((getUploadVideoMethod = VideoServiceGrpc.getUploadVideoMethod) == null) {
          VideoServiceGrpc.getUploadVideoMethod = getUploadVideoMethod =
              io.grpc.MethodDescriptor.<com.proto.audio.Video.DataChunkResponse, com.proto.audio.Video.DownloadVideoRequest>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "uploadVideo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.audio.Video.DataChunkResponse.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.audio.Video.DownloadVideoRequest.getDefaultInstance()))
              .setSchemaDescriptor(new VideoServiceMethodDescriptorSupplier("uploadVideo"))
              .build();
        }
      }
    }
    return getUploadVideoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static VideoServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VideoServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<VideoServiceStub>() {
        @java.lang.Override
        public VideoServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new VideoServiceStub(channel, callOptions);
        }
      };
    return VideoServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static VideoServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VideoServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<VideoServiceBlockingStub>() {
        @java.lang.Override
        public VideoServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new VideoServiceBlockingStub(channel, callOptions);
        }
      };
    return VideoServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static VideoServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VideoServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<VideoServiceFutureStub>() {
        @java.lang.Override
        public VideoServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new VideoServiceFutureStub(channel, callOptions);
        }
      };
    return VideoServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void downloadVideo(com.proto.audio.Video.DownloadVideoRequest request,
        io.grpc.stub.StreamObserver<com.proto.audio.Video.DataChunkResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDownloadVideoMethod(), responseObserver);
    }

    /**
     */
    default io.grpc.stub.StreamObserver<com.proto.audio.Video.DataChunkResponse> uploadVideo(
        io.grpc.stub.StreamObserver<com.proto.audio.Video.DownloadVideoRequest> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getUploadVideoMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service VideoService.
   */
  public static abstract class VideoServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return VideoServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service VideoService.
   */
  public static final class VideoServiceStub
      extends io.grpc.stub.AbstractAsyncStub<VideoServiceStub> {
    private VideoServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VideoServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VideoServiceStub(channel, callOptions);
    }

    /**
     */
    public void downloadVideo(com.proto.audio.Video.DownloadVideoRequest request,
        io.grpc.stub.StreamObserver<com.proto.audio.Video.DataChunkResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getDownloadVideoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.proto.audio.Video.DataChunkResponse> uploadVideo(
        io.grpc.stub.StreamObserver<com.proto.audio.Video.DownloadVideoRequest> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getUploadVideoMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service VideoService.
   */
  public static final class VideoServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<VideoServiceBlockingStub> {
    private VideoServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VideoServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VideoServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.proto.audio.Video.DataChunkResponse> downloadVideo(
        com.proto.audio.Video.DownloadVideoRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getDownloadVideoMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service VideoService.
   */
  public static final class VideoServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<VideoServiceFutureStub> {
    private VideoServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VideoServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VideoServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_DOWNLOAD_VIDEO = 0;
  private static final int METHODID_UPLOAD_VIDEO = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_DOWNLOAD_VIDEO:
          serviceImpl.downloadVideo((com.proto.audio.Video.DownloadVideoRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.audio.Video.DataChunkResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_UPLOAD_VIDEO:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.uploadVideo(
              (io.grpc.stub.StreamObserver<com.proto.audio.Video.DownloadVideoRequest>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getDownloadVideoMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.proto.audio.Video.DownloadVideoRequest,
              com.proto.audio.Video.DataChunkResponse>(
                service, METHODID_DOWNLOAD_VIDEO)))
        .addMethod(
          getUploadVideoMethod(),
          io.grpc.stub.ServerCalls.asyncClientStreamingCall(
            new MethodHandlers<
              com.proto.audio.Video.DataChunkResponse,
              com.proto.audio.Video.DownloadVideoRequest>(
                service, METHODID_UPLOAD_VIDEO)))
        .build();
  }

  private static abstract class VideoServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    VideoServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.proto.audio.Video.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("VideoService");
    }
  }

  private static final class VideoServiceFileDescriptorSupplier
      extends VideoServiceBaseDescriptorSupplier {
    VideoServiceFileDescriptorSupplier() {}
  }

  private static final class VideoServiceMethodDescriptorSupplier
      extends VideoServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    VideoServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (VideoServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new VideoServiceFileDescriptorSupplier())
              .addMethod(getDownloadVideoMethod())
              .addMethod(getUploadVideoMethod())
              .build();
        }
      }
    }
    return result;
  }
}
