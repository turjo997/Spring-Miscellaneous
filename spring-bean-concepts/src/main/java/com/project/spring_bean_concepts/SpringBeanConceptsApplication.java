package com.project.spring_bean_concepts;

import com.project.spring_bean_concepts.lifeCycle_annotation.MessageService;
import com.project.spring_bean_concepts.primary_annotation.EmployeeService;
import com.project.spring_bean_concepts.qualifier_annotation.PaymentController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBeanConceptsApplication implements CommandLineRunner {


	@Autowired
	private LazyBean lazyBean;

	@Autowired
	private GreetingService greetingService;

	@Autowired
	private PrototypeBean prototypeBean1;

	@Autowired
	private PrototypeBean prototypeBean2;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private PaymentController paymentController;

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(SpringBeanConceptsApplication.class, args);

		MessageService messageService  = context.getBean(MessageService.class);

		messageService.sendMessage("Hello, Spring Lifecycle!");



	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println("Application is running...");
//
//		// Trigger Lazy Bean
//		System.out.println("Calling lazy bean...");
//
//		lazyBean.show();
//
//
//		// Primary Bean Example
//		greetingService.greet();
//
//
//		employeeService.getEmployee().work();
//
//
//		paymentController.getPayment();
//
//
//		// Prototype Scope Example
//		System.out.println(prototypeBean1 == prototypeBean2); // Should print false, different instances
//

	}
}
