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
      "o22\n\020HelloGrpcService\022\036\n\007request\022\010.Reque" +
      "st\032\t.ResponseB5\n\027org.mytest.test.service" +
      "B\026HelloGrpcServiceDefineH\001P\000b\006proto3"
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
