package com.Web.Socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SocketApplication implements CommandLineRunner {
	@Autowired
	public PdfService pdf;

	public static void main(String[] args) {
		SpringApplication.run(SocketApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Creating pdf...");
		pdf.CreatePDF();
		System.out.println("done");
		
	}

}
