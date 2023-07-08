package org.mytest.test.service;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.42.2)",
    comments = "Source: HelloGrpcService.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class HelloGrpcServiceGrpc {

  private HelloGrpcServiceGrpc() {}

  public static final String SERVICE_NAME = "HelloGrpcService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.mytest.test.entity.HelloGrpc.Request,
      org.mytest.test.entity.HelloGrpc.Response> getRequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "request",
      requestType = org.mytest.test.entity.HelloGrpc.Request.class,
      responseType = org.mytest.test.entity.HelloGrpc.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.mytest.test.entity.HelloGrpc.Request,
      org.mytest.test.entity.HelloGrpc.Response> getRequestMethod() {
    io.grpc.MethodDescriptor<org.mytest.test.entity.HelloGrpc.Request, org.mytest.test.entity.HelloGrpc.Response> getRequestMethod;
    if ((getRequestMethod = HelloGrpcServiceGrpc.getRequestMethod) == null) {
      synchronized (HelloGrpcServiceGrpc.class) {
        if ((getRequestMethod = HelloGrpcServiceGrpc.getRequestMethod) == null) {
          HelloGrpcServiceGrpc.getRequestMethod = getRequestMethod =
              io.grpc.MethodDescriptor.<org.mytest.test.entity.HelloGrpc.Request, org.mytest.test.entity.HelloGrpc.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "request"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.mytest.test.entity.HelloGrpc.Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.mytest.test.entity.HelloGrpc.Response.getDefaultInstance()))
              .setSchemaDescriptor(new HelloGrpcServiceMethodDescriptorSupplier("request"))
              .build();
        }
      }
    }
    return getRequestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.mytest.test.entity.HelloGrpc.Request,
      org.mytest.test.entity.HelloGrpc.Response> getServerStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "serverStream",
      requestType = org.mytest.test.entity.HelloGrpc.Request.class,
      responseType = org.mytest.test.entity.HelloGrpc.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<org.mytest.test.entity.HelloGrpc.Request,
      org.mytest.test.entity.HelloGrpc.Response> getServerStreamMethod() {
    io.grpc.MethodDescriptor<org.mytest.test.entity.HelloGrpc.Request, org.mytest.test.entity.HelloGrpc.Response> getServerStreamMethod;
    if ((getServerStreamMethod = HelloGrpcServiceGrpc.getServerStreamMethod) == null) {
      synchronized (HelloGrpcServiceGrpc.class) {
        if ((getServerStreamMethod = HelloGrpcServiceGrpc.getServerStreamMethod) == null) {
          HelloGrpcServiceGrpc.getServerStreamMethod = getServerStreamMethod =
              io.grpc.MethodDescriptor.<org.mytest.test.entity.HelloGrpc.Request, org.mytest.test.entity.HelloGrpc.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "serverStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.mytest.test.entity.HelloGrpc.Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.mytest.test.entity.HelloGrpc.Response.getDefaultInstance()))
              .setSchemaDescriptor(new HelloGrpcServiceMethodDescriptorSupplier("serverStream"))
              .build();
        }
      }
    }
    return getServerStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.mytest.test.entity.HelloGrpc.Request,
      org.mytest.test.entity.HelloGrpc.Response> getClientStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "clientStream",
      requestType = org.mytest.test.entity.HelloGrpc.Request.class,
      responseType = org.mytest.test.entity.HelloGrpc.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<org.mytest.test.entity.HelloGrpc.Request,
      org.mytest.test.entity.HelloGrpc.Response> getClientStreamMethod() {
    io.grpc.MethodDescriptor<org.mytest.test.entity.HelloGrpc.Request, org.mytest.test.entity.HelloGrpc.Response> getClientStreamMethod;
    if ((getClientStreamMethod = HelloGrpcServiceGrpc.getClientStreamMethod) == null) {
      synchronized (HelloGrpcServiceGrpc.class) {
        if ((getClientStreamMethod = HelloGrpcServiceGrpc.getClientStreamMethod) == null) {
          HelloGrpcServiceGrpc.getClientStreamMethod = getClientStreamMethod =
              io.grpc.MethodDescriptor.<org.mytest.test.entity.HelloGrpc.Request, org.mytest.test.entity.HelloGrpc.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "clientStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.mytest.test.entity.HelloGrpc.Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.mytest.test.entity.HelloGrpc.Response.getDefaultInstance()))
              .setSchemaDescriptor(new HelloGrpcServiceMethodDescriptorSupplier("clientStream"))
              .build();
        }
      }
    }
    return getClientStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.mytest.test.entity.HelloGrpc.Request,
      org.mytest.test.entity.HelloGrpc.Response> getBidirectionalStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "bidirectionalStream",
      requestType = org.mytest.test.entity.HelloGrpc.Request.class,
      responseType = org.mytest.test.entity.HelloGrpc.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<org.mytest.test.entity.HelloGrpc.Request,
      org.mytest.test.entity.HelloGrpc.Response> getBidirectionalStreamMethod() {
    io.grpc.MethodDescriptor<org.mytest.test.entity.HelloGrpc.Request, org.mytest.test.entity.HelloGrpc.Response> getBidirectionalStreamMethod;
    if ((getBidirectionalStreamMethod = HelloGrpcServiceGrpc.getBidirectionalStreamMethod) == null) {
      synchronized (HelloGrpcServiceGrpc.class) {
        if ((getBidirectionalStreamMethod = HelloGrpcServiceGrpc.getBidirectionalStreamMethod) == null) {
          HelloGrpcServiceGrpc.getBidirectionalStreamMethod = getBidirectionalStreamMethod =
              io.grpc.MethodDescriptor.<org.mytest.test.entity.HelloGrpc.Request, org.mytest.test.entity.HelloGrpc.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "bidirectionalStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.mytest.test.entity.HelloGrpc.Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.mytest.test.entity.HelloGrpc.Response.getDefaultInstance()))
              .setSchemaDescriptor(new HelloGrpcServiceMethodDescriptorSupplier("bidirectionalStream"))
              .build();
        }
      }
    }
    return getBidirectionalStreamMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HelloGrpcServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HelloGrpcServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HelloGrpcServiceStub>() {
        @java.lang.Override
        public HelloGrpcServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HelloGrpcServiceStub(channel, callOptions);
        }
      };
    return HelloGrpcServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HelloGrpcServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HelloGrpcServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HelloGrpcServiceBlockingStub>() {
        @java.lang.Override
        public HelloGrpcServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HelloGrpcServiceBlockingStub(channel, callOptions);
        }
      };
    return HelloGrpcServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HelloGrpcServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HelloGrpcServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HelloGrpcServiceFutureStub>() {
        @java.lang.Override
        public HelloGrpcServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HelloGrpcServiceFutureStub(channel, callOptions);
        }
      };
    return HelloGrpcServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class HelloGrpcServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * 简单RPC/一元RPC
     * </pre>
     */
    public void request(org.mytest.test.entity.HelloGrpc.Request request,
        io.grpc.stub.StreamObserver<org.mytest.test.entity.HelloGrpc.Response> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRequestMethod(), responseObserver);
    }

    /**
     * <pre>
     * 服务端流式RPC
     * </pre>
     */
    public void serverStream(org.mytest.test.entity.HelloGrpc.Request request,
        io.grpc.stub.StreamObserver<org.mytest.test.entity.HelloGrpc.Response> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getServerStreamMethod(), responseObserver);
    }

    /**
     * <pre>
     * 客户端流式RPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<org.mytest.test.entity.HelloGrpc.Request> clientStream(
        io.grpc.stub.StreamObserver<org.mytest.test.entity.HelloGrpc.Response> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getClientStreamMethod(), responseObserver);
    }

    /**
     * <pre>
     * 双向流RPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<org.mytest.test.entity.HelloGrpc.Request> bidirectionalStream(
        io.grpc.stub.StreamObserver<org.mytest.test.entity.HelloGrpc.Response> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getBidirectionalStreamMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRequestMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.mytest.test.entity.HelloGrpc.Request,
                org.mytest.test.entity.HelloGrpc.Response>(
                  this, METHODID_REQUEST)))
          .addMethod(
            getServerStreamMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                org.mytest.test.entity.HelloGrpc.Request,
                org.mytest.test.entity.HelloGrpc.Response>(
                  this, METHODID_SERVER_STREAM)))
          .addMethod(
            getClientStreamMethod(),
            io.grpc.stub.ServerCalls.asyncClientStreamingCall(
              new MethodHandlers<
                org.mytest.test.entity.HelloGrpc.Request,
                org.mytest.test.entity.HelloGrpc.Response>(
                  this, METHODID_CLIENT_STREAM)))
          .addMethod(
            getBidirectionalStreamMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                org.mytest.test.entity.HelloGrpc.Request,
                org.mytest.test.entity.HelloGrpc.Response>(
                  this, METHODID_BIDIRECTIONAL_STREAM)))
          .build();
    }
  }

  /**
   */
  public static final class HelloGrpcServiceStub extends io.grpc.stub.AbstractAsyncStub<HelloGrpcServiceStub> {
    private HelloGrpcServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HelloGrpcServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HelloGrpcServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * 简单RPC/一元RPC
     * </pre>
     */
    public void request(org.mytest.test.entity.HelloGrpc.Request request,
        io.grpc.stub.StreamObserver<org.mytest.test.entity.HelloGrpc.Response> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRequestMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 服务端流式RPC
     * </pre>
     */
    public void serverStream(org.mytest.test.entity.HelloGrpc.Request request,
        io.grpc.stub.StreamObserver<org.mytest.test.entity.HelloGrpc.Response> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getServerStreamMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 客户端流式RPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<org.mytest.test.entity.HelloGrpc.Request> clientStream(
        io.grpc.stub.StreamObserver<org.mytest.test.entity.HelloGrpc.Response> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getClientStreamMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * 双向流RPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<org.mytest.test.entity.HelloGrpc.Request> bidirectionalStream(
        io.grpc.stub.StreamObserver<org.mytest.test.entity.HelloGrpc.Response> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getBidirectionalStreamMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class HelloGrpcServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<HelloGrpcServiceBlockingStub> {
    private HelloGrpcServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HelloGrpcServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HelloGrpcServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 简单RPC/一元RPC
     * </pre>
     */
    public org.mytest.test.entity.HelloGrpc.Response request(org.mytest.test.entity.HelloGrpc.Request request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRequestMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 服务端流式RPC
     * </pre>
     */
    public java.util.Iterator<org.mytest.test.entity.HelloGrpc.Response> serverStream(
        org.mytest.test.entity.HelloGrpc.Request request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getServerStreamMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class HelloGrpcServiceFutureStub extends io.grpc.stub.AbstractFutureStub<HelloGrpcServiceFutureStub> {
    private HelloGrpcServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HelloGrpcServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HelloGrpcServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * 简单RPC/一元RPC
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.mytest.test.entity.HelloGrpc.Response> request(
        org.mytest.test.entity.HelloGrpc.Request request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRequestMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REQUEST = 0;
  private static final int METHODID_SERVER_STREAM = 1;
  private static final int METHODID_CLIENT_STREAM = 2;
  private static final int METHODID_BIDIRECTIONAL_STREAM = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final HelloGrpcServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(HelloGrpcServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REQUEST:
          serviceImpl.request((org.mytest.test.entity.HelloGrpc.Request) request,
              (io.grpc.stub.StreamObserver<org.mytest.test.entity.HelloGrpc.Response>) responseObserver);
          break;
        case METHODID_SERVER_STREAM:
          serviceImpl.serverStream((org.mytest.test.entity.HelloGrpc.Request) request,
              (io.grpc.stub.StreamObserver<org.mytest.test.entity.HelloGrpc.Response>) responseObserver);
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
        case METHODID_CLIENT_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.clientStream(
              (io.grpc.stub.StreamObserver<org.mytest.test.entity.HelloGrpc.Response>) responseObserver);
        case METHODID_BIDIRECTIONAL_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.bidirectionalStream(
              (io.grpc.stub.StreamObserver<org.mytest.test.entity.HelloGrpc.Response>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class HelloGrpcServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HelloGrpcServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.mytest.test.service.HelloGrpcServiceDefine.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("HelloGrpcService");
    }
  }

  private static final class HelloGrpcServiceFileDescriptorSupplier
      extends HelloGrpcServiceBaseDescriptorSupplier {
    HelloGrpcServiceFileDescriptorSupplier() {}
  }

  private static final class HelloGrpcServiceMethodDescriptorSupplier
      extends HelloGrpcServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    HelloGrpcServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (HelloGrpcServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HelloGrpcServiceFileDescriptorSupplier())
              .addMethod(getRequestMethod())
              .addMethod(getServerStreamMethod())
              .addMethod(getClientStreamMethod())
              .addMethod(getBidirectionalStreamMethod())
              .build();
        }
      }
    }
    return result;
  }
}
