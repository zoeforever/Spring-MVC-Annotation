package com.vistek.servlet;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/async", asyncSupported = true)
public class HelloAsyncServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(Thread.currentThread()+"主线程开始->"+System.currentTimeMillis());
		AsyncContext startAsync = req.startAsync();
		startAsync.start(new Runnable() {			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					System.out.println(Thread.currentThread()+"子线程开始->"+System.currentTimeMillis());
					sayHello();
					startAsync.complete();
					AsyncContext asyncContext = req.getAsyncContext();
					ServletResponse response = asyncContext.getResponse();
					response.getWriter().write("hello async");
					System.out.println(Thread.currentThread()+"子线程结束->"+System.currentTimeMillis());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		System.out.println(Thread.currentThread()+"主线程结束->"+System.currentTimeMillis());
		
	}

	public void sayHello() throws Exception {
		System.out.println(Thread.currentThread() + " processing...");
		Thread.sleep(3000);
	}
}
