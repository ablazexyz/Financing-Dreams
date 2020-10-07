package com.lti.service;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

import com.lti.model.Application;

public class PDFService {
	
	 public static void create(Application appl) {
	        try {
	            PDDocument pDDocument = PDDocument.load(new File("D:\\Document Filling Test\\pdf-java.pdf"));
	            PDAcroForm pDAcroForm = pDDocument.getDocumentCatalog().getAcroForm();
	            
	            PDField field = pDAcroForm.getField("aid");
	            field.setValue(" "+appl.getApplicationId());
	            
	            field = pDAcroForm.getField("Name");
	            field.setValue(" "+appl.getCdetails2().getRegistration().getFirstName()+" "+appl.getCdetails2().getRegistration().getLastName());
	            
	            field = pDAcroForm.getField("Email");
	            field.setValue(" "+appl.getCdetails2().getRegistration().getEmailId());
	            
	            field = pDAcroForm.getField("Gender");
	            field.setValue(" "+appl.getCdetails2().getRegistration().getGender());
	            
	            field = pDAcroForm.getField("Nat");
	            field.setValue(" "+appl.getCdetails2().getRegistration().getNationality());
	            
	            field = pDAcroForm.getField("number");
	            field.setValue(" "+appl.getCdetails2().getRegistration().getPhoneNumber());
	            
	            field = pDAcroForm.getField("aadhar");
	            field.setValue(" "+appl.getCdetails2().getAadhar());
	            
	            field = pDAcroForm.getField("pan");
	            field.setValue(" "+appl.getCdetails2().getPan());
	            
	            field = pDAcroForm.getField("empname");
	            field.setValue(" "+appl.getCdetails2().getEmpname());
	            
	            field = pDAcroForm.getField("orgtype");
	            field.setValue(" "+appl.getCdetails2().getOrgtype());
	            
	            field = pDAcroForm.getField("emptype");
	            field.setValue(" "+appl.getCdetails2().getEmptype());
	            
	            field = pDAcroForm.getField("sal");
	            field.setValue(" "+(int)appl.getCdetails2().getSalary());
	            
	            field = pDAcroForm.getField("age");
	            field.setValue(" "+appl.getCdetails2().getRetireage());
	            
	            field = pDAcroForm.getField("ploc");
	            field.setValue(" "+appl.getPropertyLocation());
	            
	            field = pDAcroForm.getField("pname");
	            field.setValue(" "+appl.getPropertyName());
	            
	            field = pDAcroForm.getField("pamt");
	            field.setValue(" "+(int)appl.getPropertyAmt());
	            
	            field = pDAcroForm.getField("lamt");
	            field.setValue(" "+(int)appl.getLoanAmt());
	            
	            field = pDAcroForm.getField("ploc");
	            field.setValue(" "+appl.getPropertyLocation());
	            
	            field = pDAcroForm.getField("roi");
	            field.setValue(" "+appl.getRoi());
	            
	            field = pDAcroForm.getField("tenure");
	            field.setValue(" "+appl.getTenure());

	            pDDocument.save("D:\\Project_Gladiator\\Registration Form\\"+appl.getApplicationId()+"_Reg.pdf");
	            pDDocument.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
