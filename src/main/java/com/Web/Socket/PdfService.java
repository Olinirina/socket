package com.Web.Socket;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.layout.SharedContext;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.DocumentException;


@Service
public class PdfService {
	@Autowired
	private TemplateEngine template;
	
	public void CreatePDF() throws DocumentException, IOException  {
		Context context= new Context();
		context.setVariable("name", "Oly");
		String processHtml= template.process("helloword", context);
		OutputStream outputStream= new FileOutputStream("doc.pdf");
		ITextRenderer render=new ITextRenderer();
		SharedContext sharedContext = render.getSharedContext();
		sharedContext.setBaseURL("file:///static"); // Remplacez par le chemin absolu de votre projet
		render.setDocumentFromString(processHtml);
		render.layout();
		render.createPDF(outputStream,false);
		render.finishPDF();
		outputStream.close();
	}

}
