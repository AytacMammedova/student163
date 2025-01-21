package com.matrix.java163Spring;

import com.matrix.java163Spring.configuration.MyConfig;
import com.matrix.java163Spring.model.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Java163SpringApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Java163SpringApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		//xml
//		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
//		Student student=(Student) context.getBean("student");
//		System.out.println(student);
		//annotation
//		ApplicationContext context=new AnnotationConfigApplicationContext(MyConfig.class);
//		Student student=(Student) context.getBean("getStudentBeans");
//		System.out.println(student);

	}
}
