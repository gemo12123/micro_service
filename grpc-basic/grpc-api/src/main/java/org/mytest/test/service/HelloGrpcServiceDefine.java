// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: HelloGrpcService.proto

package org.mytest.test.service;

public final class HelloGrpcServiceDefine {
  private HelloGrpcServiceDefine() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\026HelloGrpcService.proto\032\017HelloGrpc.prot" +
      "o2\200\001\n\020HelloGrpcService\022\036\n\007request\022\010.Requ" +
      "est\032\t.Response\022%\n\014serverStream\022\010.Request" +
      "\032\t.Response0\001\022%\n\014clientStream\022\010.Request\032" +
      "\t.Response(\001B5\n\027org.mytest.test.serviceB" +
      "\026HelloGrpcServiceDefineH\001P\000b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          org.mytest.test.entity.HelloGrpc.getDescriptor(),
        });
    org.mytest.test.entity.HelloGrpc.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
