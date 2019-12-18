package com.vistek.controller;

import java.util.UUID;
import java.util.concurrent.Callable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import com.vistek.service.DeferredResultQueue;

@Controller
public class AsyncController {

	@ResponseBody
	@RequestMapping("/async")
	public Callable<String> async01() {
		System.out.println(Thread.currentThread() + "主线程开始->" + System.currentTimeMillis());
		Callable<String> callable = new Callable<String>() {
			@Override
			public String call() throws Exception {
				System.out.println(Thread.currentThread() + "子线程开始->" + System.currentTimeMillis());
				// TODO Auto-generated method stub
				Thread.sleep(3000);
				System.out.println(Thread.currentThread() + "子线程结束->" + System.currentTimeMillis());
				return "Callable<String> async01()";
			}
		};
		System.out.println(Thread.currentThread() + "主线程结束->" + System.currentTimeMillis());
		return callable;
	}

	@ResponseBody
	@RequestMapping("/createOrder")
	public DeferredResult<Object> createOrder() {
		DeferredResult<Object> deferredResult = new DeferredResult<Object>((long) 3000, "create failed");
		DeferredResultQueue.save(deferredResult);
		return deferredResult;
	}

	@ResponseBody
	@RequestMapping("/create")
	public String create() {
		String order = UUID.randomUUID().toString();
		DeferredResult<Object> deferredResult = DeferredResultQueue.get();
		deferredResult.setResult(order);
		return "success->" + order;
	}
}
