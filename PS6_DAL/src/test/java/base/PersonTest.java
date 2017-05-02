package base;

import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.UUID;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;

public class PersonTest {
	private static PersonDAL ptest;
	private static PersonDomainModel per1;
	private static PersonDomainModel per2;
	
	private static UUID person1UUID = UUID.randomUUID();			
	private static UUID person2UUID = UUID.randomUUID();
	
	
	static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		LocalDate per1BDay = null;dateFormat.parse("1982-09-22");
		LocalDate per2BDay = null;dateFormat.parse("1998-01-24");
		
		
		per1.setFirstName("Connor");
		per1.setLastName("Olaya");
		per1.setBirthday(per1BDay);
		per1.setCity("Wayne");
		per1.setStreet("111 Sugar Blvd");
		per1.setPostalCode(32321);
		
		per2.setFirstName("Yilong");
		per2.setLastName("Zhang");
		per2.setBirthday(per2BDay);
		per2.setCity("Hong Kong");
		per2.setStreet("111 Capitol Street");
		per2.setPostalCode(32452);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}


	@Test
	public void testPerson() {
		ptest.addPerson(per1);
		ptest.addPerson(per2);
		
		ptest.deletePerson(per1);
		
		per2.setStreet("123 Poop Lane");
		ptest.updatePerson(per2);
		
		ptest.getPersons();
	}

}
