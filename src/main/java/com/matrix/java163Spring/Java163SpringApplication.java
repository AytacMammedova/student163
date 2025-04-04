package com.matrix.java163Spring;

import com.matrix.java163Spring.jwt.JwtService;
import com.matrix.java163Spring.model.entity.security.Authority;
import com.matrix.java163Spring.model.entity.security.User;
import com.matrix.java163Spring.repository.CourseRepository;
import com.matrix.java163Spring.repository.StudentRepository;
import com.matrix.java163Spring.repository.UniversityRepository;
import com.matrix.java163Spring.repository.UserRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.io.File;
import java.util.List;
import java.util.Set;


@RequiredArgsConstructor
@SpringBootApplication
@Slf4j
@EnableFeignClients(basePackages = "com.matrix.java163Spring")
public class Java163SpringApplication implements CommandLineRunner {
	private final StudentRepository studentRepository;
	private final CourseRepository courseRepository;
	private final UniversityRepository universityRepository;
	private final JavaMailSender javaMailSender;
	private final SpringTemplateEngine templateEngine;
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;


	public static void main(String[] args) {
		SpringApplication.run(Java163SpringApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
//		User user=new User();
//		user.setId(2);
//		user.setUsername("ali");
//		user.setPassword(passwordEncoder.encode("00000"));
//		user.setAccountNonExpired(true);
//		user.setEnabled(true);
//		user.setAccountNonLocked(true);
//		user.setCredentialsNonExpired(true);
//
//		Authority authority1=new Authority();
//		authority1.setAuthority("USER");
//		authority1.setId(3);
//
//		authority1.setUser(user);
//
//		user.setAuthorities(List.of(authority1));
//		userRepository.save(user);


//	User user=userRepository.findByUsername("ali").orElseThrow(IllegalStateException::new);
//	String token=jwtService.issueToken(user);
//	user.setIssueToken(token);
//	userRepository.save(user);
//	System.out.println("JWT"+token);
	//System.out.println(jwtService.verifyToken(token));










		//Transaction
//		Student student=studentRepository.findById(2).get();
//		student.setSurname("Alizade");
//		if(true){
//			throw new Exception();
//		}
//		Student student1=new Student();
//		student1.setName("Ali");
//		student1.setSurname("Aliyev");
//		student1.setAge(18);
//		student1.setUniversity_id(2);
//		studentRepository.save(student1);


		//Course course=courseRepository.findById(1).get();
//		student.getCourses().add(course);
//		course.getStudents().add(student);
//		studentRepository.save(student);
//		courseRepository.save(course);


		//xml
//		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
//		Student student=(Student) context.getBean("student");
//		System.out.println(student);
		//annotation
//		ApplicationContext context=new AnnotationConfigApplicationContext(MyConfig.class);
//		Student student=(Student) context.getBean("getStudentBeans");
//		System.out.println(student);

	}

		private void sendEmail(){
			SimpleMailMessage msg =new SimpleMailMessage();
			msg.setTo("aytajmammedova25@gmail.com");
			msg.setFrom("aytacmammedova25@gmail.com");
			msg.setSubject("Spring mail");
			msg.setText("Hello");
			javaMailSender.send(msg);
			log.info("Email successfully send");

	    }
		private void sendEmailWithAttachment() throws MessagingException {
			MimeMessage message=javaMailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(message,true);
			helper.setTo("aytajmammedova25@gmail.com");
			helper.setFrom("aytacmammedova25@gmail.com");
			helper.setSubject("Mail with attachment");
			helper.setText("Hello");
			helper.addAttachment("for Aytaj",new File("src\\main\\java\\com\\matrix\\java163Spring\\file"));
			javaMailSender.send(message);
			log.info("Email with attachment successfully send");
		}
		private void sendEmailWithHtmlTemplate(){
			Context context=new Context();
			context.setVariable("message","It is message for Aytaj");
			MimeMessage mimeMessage=javaMailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,"UTF-8");
			try{
				helper.setTo("aytajmammedova25@gmail.com");
				helper.setFrom("aytacmammedova25@gmail.com");
				helper.setSubject("Mail with HTML Template");
				String htmlContent=templateEngine.process("email-template",context);
				helper.setText(htmlContent,true);
				javaMailSender.send(mimeMessage);
				log.info("Email with template successfully send");
			}catch (Exception e){
				e.printStackTrace();

			}
		}

}
