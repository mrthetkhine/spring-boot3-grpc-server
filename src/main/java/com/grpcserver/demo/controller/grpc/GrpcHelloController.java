package com.grpcserver.demo.controller.grpc;

import java.util.logging.Logger;

import org.lognet.springboot.grpc.GRpcService;

import com.grpc.proto.HelloReply;
import com.grpc.proto.HelloRequest;

import com.grpc.proto.HelloServiceGrpc;

import io.grpc.stub.StreamObserver;
import java.util.Date;

@GRpcService
public class GrpcHelloController extends HelloServiceGrpc.HelloServiceImplBase{
	private static final Logger logger = Logger.getLogger(GrpcHelloController.class.getName());
	@Override
	public void hello(HelloRequest request,StreamObserver<com.grpc.proto.HelloReply> responseObserver) {
		 
		try
		{
			logger.info("Request" +request.getName());
			System.out.println("Request "+ request.getName());
		      //Thread.sleep(2000);
		      
			 HelloReply reply = HelloReply.newBuilder()
						.setMessage("Hello "+new Date())
						.build();
	    	  responseObserver.onNext(reply);
		      responseObserver.onCompleted();
		     
		}
		catch(Exception e)
		{
			responseObserver.onError(e);
			
			
		}
		
	}
}
