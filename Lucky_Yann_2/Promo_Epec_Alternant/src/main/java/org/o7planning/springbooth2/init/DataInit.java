package org.o7planning.springbooth2.init;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
 
import org.o7planning.springbooth2.dao.PersonDAO;
import org.o7planning.springbooth2.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements ApplicationRunner{

	private PersonDAO personDAO;
	
	private static final DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

@Autowired
public DataInit(PersonDAO personDAO)
{
	this.personDAO = personDAO;
}


@Override
public void run(ApplicationArguments args) throws Exception{
	
	long count = personDAO.count();
	
	
//	if(count == 0)
//	{
//		Person p1 = new Person();
//		
//		p1.setFullName("Lucky");
//		
//		Date d1 = df.parse("1995-12-20");
//		p1.setBirthday(d1);
//		
//		//
//		
//Person p2 = new Person();
//		
//		p2.setFullName("Stanley");
//		
//		Date d2 = df.parse("1992-05-03");
//		p2.setBirthday(d2);
//	
//		
//		//
//		
//Person p3 = new Person();
//		
//		p3.setFullName("Aleksander");
//		
//		Date d3 = df.parse("1980-10-25");
//		p3.setBirthday(d3);
//		
//		
//		personDAO.save(p1);
//		personDAO.save(p2);
//		personDAO.save(p3);
	}
	
	
}




