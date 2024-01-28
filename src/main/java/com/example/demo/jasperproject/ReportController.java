package com.example.demo.jasperproject;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

@RestController
public class ReportController {
	
	@Autowired
	StudentService studentService;

	@GetMapping("/pdf")
	public void getPdfreport(HttpServletResponse response) throws JRException, IOException {
		//String filePath = "G:\\jobPrep5yearExp\\demo.jasperproject\\src\\main\\resources\\templates\\Students_report.jrxml";
		String filePath = "G:\\jobPrep5yearExp\\demo.jasperproject\\src\\main\\resources\\templates\\StudentListReport.jasper";
		Map<String,Object> parameters = new HashMap<>();
		List<Student> student = studentService.getStudentDetails();
		//JRBeanCollectionDataSource courses = new JRBeanCollectionDataSource(student.getCourses());
		//JRBeanCollectionDataSource gadgets = new JRBeanCollectionDataSource(student.getGadgetsList());
	
		
		//parameters.put("firstName", student.getName());
		//parameters.put("age", student.getAge());
		//parameters.put("courses", courses);
		/*
		 * parameters.put("gadgetSubreport", getSubReport());
		 * parameters.put("gadgetsDataSource", gadgets);
		 */
		//JRBeanCollectionDataSource studentCollectionDataSourceList1 = new JRBeanCollectionDataSource(student);
		JRBeanCollectionDataSource studentCollectionDataSourceList2 = new JRBeanCollectionDataSource(student, false);
		//parameters.put("studentListDataSet", studentCollectionDataSourceList1);
		parameters.put("coursesSubreport", "G:\\jobPrep5yearExp\\demo.jasperproject\\src\\main\\resources\\templates\\courses_subreport.jasper");
		//JasperReport jasperReport = JasperCompileManager.compileReport(filePath);
		
		InputStream inputStream = this.getClass().getResourceAsStream("/templates/StudentListReport.jasper");
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(inputStream);
		JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, studentCollectionDataSourceList2);
		byte[] result = JasperExportManager.exportReportToPdf(print);
		response.setContentType("application/pdf");
		response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "inline; filename= report.pdf");
		
		response.getOutputStream().write(result);
		//JasperExportManager.exportReportToPdfStream(print, outStream);
		
		
	}
	
	public static JasperReport getSubReport() {
		String filePath = "G:\\jobPrep5yearExp\\demo.jasperproject\\src\\main\\resources\\templates\\gadgets.jrxml";
		try {
			return JasperCompileManager.compileReport(filePath);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
