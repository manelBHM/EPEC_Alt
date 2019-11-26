package com.Ecommerce;

import com.Ecommerce.service.FlickrImplService;
import com.Ecommerce.service.IFlickrService;
import com.Ecommerce.service.SendingMailService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;

public class test {

	@Autowired
	public IFlickrService iFlickrService;

	private static Logger logger = Logger.getLogger(test.class);

	public static void main(String[] args) {
		SendingMailService SendingMailService = new SendingMailService();
		IFlickrService iFlickrService = new FlickrImplService();
		try {
			InputStream stream= new FileInputStream(new File("/home/fadeil/Images/404.png"));
			String url = iFlickrService.savePhoto(stream, "photo1");
			System.out.println(url);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			logger.error("msg d'erreur");
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("msg d'erreur");
		} catch (NullPointerException e) {
			e.printStackTrace();
			logger.error("msg d'erreur NullPointerException ");

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("msg d'erreur Exception ");
		}

		SendingMailService.sendingMail("abdalfadeil@gmail.com", "test mail");
	}

}
