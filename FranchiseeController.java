package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.dao.AdminReop;
import com.boot.dao.FranchiseeRepo;
import com.boot.dao.TeachersRepo;
import com.boot.entity.Admin;
import com.boot.entity.EmailDetails;
import com.boot.entity.Franchisee;
import com.boot.entity.Teacher;

@RestController
@RequestMapping("/franchisee")
@CrossOrigin("http://localhost:4200")
public class FranchiseeController {

	@Autowired
	FranchiseeRepo  repo;
	
	@Autowired
	AdminReop admRepo;
	
	@Autowired 
	private JavaMailSender javaMailSender;
	 
	@Autowired
	TeachersRepo teacherRepo;

	@PostMapping("/add-franchisee/{adminId}")
	public void savedata(@RequestBody Franchisee franchies, @PathVariable String adminId) {
		
		repo.save(franchies);
		
		Admin adm = admRepo.findById(adminId).get();
		franchies.setAdminId(adm);
		
		repo.save(franchies);
	}
	
	/*
	@PostMapping("/send-email-franchies/{franchEmail}")
	public void sendMail(@RequestBody Franchisee franchies,  @PathVariable String franchEmail) {
		
		System.out.println("franchies Email: "+franchEmail);
		String adminEmail = "seedproject24@gmail.com";
		
	    // SMTP server details
	    String smtpServer = "smtp.gmail.com";
	    int port = 587;
	    final String username = "rangnegaurav06@gmail.com";
	    final String password = "thlm svdf sjha vfwd";

	    // Message content
	    String subject = "From Gaurav! Testing Purpose!";
	    String body = "Registration Successfully";

	    try {
	        // Create a new session
	        Properties props = new Properties();
	        props.put("mail.smtp.host", smtpServer);
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.port", port);
	        props.put("mail.smtp.auth", "true");
	        Session session1 = Session.getInstance(props,
	        		new Authenticator() {
	                    protected PasswordAuthentication getPasswordAuthentication() {
	                        return new PasswordAuthentication(username, password);
	                    }
	                });

	        // Create a new message
	        MimeMessage message = new MimeMessage(session1);
	        message.setFrom(new InternetAddress(username)); // sender email
	        InternetAddress[] recipents=new InternetAddress[2];
	        recipents[0]=new InternetAddress(adminEmail);
	        recipents[1]=new InternetAddress(franchEmail);
	        
	        message.addRecipients(Message.RecipientType.TO, recipents);
	        
	      //  message.addRecipient(Message.RecipientType.TO, new InternetAddress(clientEmail));	// for one client
	        
	        message.setSubject(subject);
	        message.setContent(body, "text/plain");

	        // Send the message
	        Transport.send(message);
	        
	    } catch (Exception e) {
	        System.out.println("Error sending email: " + e.getMessage());
	        // Handle the exception appropriately
	    }
	}
	*/
	
	
	@PostMapping("/send-email-franchies/{franchEmail}")
	public String sendSimpleMail(@RequestBody EmailDetails details, @PathVariable String franchEmail)
    {
//		Admin adm = new Admin();
//		String adminEmail = adm.getEmailId();
//		
//		String franchiesName = repo.findFranchiesNameByEmailId(franchEmail);
//		long password = repo.findPhoneNoByEmailId(franchEmail);

		details.setRecipient(franchEmail);
		details.setSubject("Registration Successful");
		details.setMsgBody("Hi, Your Register Successfully. \\n Your, \\n Your User Name: \\n You Password: ");
		
        // Try block to check for exceptions
        try {
 
            // Creating a simple mail message
            SimpleMailMessage mailMessage = new SimpleMailMessage();
 
            // Setting up necessary details           
            mailMessage.setFrom("rangnegaurav06@gmail.com");
            
//            mailMessage.setTo(details.getRecipient(), franchEmail, adminEmail);
            
            mailMessage.setTo(details.getRecipient());
            mailMessage.setText(details.getMsgBody());
            mailMessage.setSubject(details.getSubject());
 
            // Sending the mail
            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        }
 
        // Catch block to handle the exceptions
        catch (Exception e) {
            return "Error while Sending Mail";
        }
    }
	
	@PostMapping("/set-teacher-franchisee/{teacherId}")
	public void savedata1(@RequestBody Franchisee franchies, @PathVariable String teacherId) {
		repo.save(franchies);
		
		Teacher teach = teacherRepo.findById(teacherId).get();
		franchies.setTeacherId(teach);
		
		repo.save(franchies);
	}

	@GetMapping("/show-franchisee")
	public List<Franchisee> showAllData(){
		return repo.findAll();
	}

	@DeleteMapping("/delete-franchisee/{id}")
	public void deletedata(@PathVariable(name="id")String id) {
		repo.deleteById(id);
	}

	@PutMapping("/update-franchisee/{id}")
	public Franchisee updateFranchies(@PathVariable String id, @RequestBody Franchisee newfranchies) {

			return repo.findById(id).map( 
					franchisee ->{
						franchisee.setFranchiesName(newfranchies.getFranchiesName());
						franchisee.setLocation(newfranchies.getLocation());	
						return repo.save(franchisee);
					}
					).orElseGet(
							()->repo.save(newfranchies)
					);
	}
	
	@PutMapping("/update-franchisee-password/{id}")
	public Franchisee updateFranchiesPassword(@PathVariable String  id, @RequestBody Franchisee newfranchisee) {
		return repo.findById(id).map( 
				franchisee ->{			
					franchisee.setPhoneNo(newfranchisee.getPhoneNo());
					return repo.save(franchisee);
				}	
		).orElseGet(
				()->repo.save(newfranchisee)
		);				
	}	
}