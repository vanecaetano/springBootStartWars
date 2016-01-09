package starWarsProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

import br.com.vanessa.starwars.Service;
import br.com.vanessa.starwars.api.model.People;


public class ServiceTest {
	
	Service service = new Service();
	
	@Test
	public void testGroupingBySpecie() {
		Map<Integer, List<People>> people = service.groupBySpeciec(mockPeople());
		Assert.assertEquals("Ana", people.get(1).get(0).getName());
		Assert.assertEquals("Maria", people.get(1).get(1).getName());
		Assert.assertEquals("Lucas", people.get(1).get(2).getName());
		Assert.assertEquals("Cassia", people.get(1).get(3).getName());
		Assert.assertEquals("Julia", people.get(1).get(4).getName());
		Assert.assertEquals("João", people.get(2).get(0).getName());
		Assert.assertEquals("Bruno", people.get(2).get(1).getName());
		Assert.assertEquals("Juca", people.get(3).get(0).getName());
		Assert.assertEquals("Bernardo", people.get(3).get(1).getName());
		Assert.assertEquals("Jessica", people.get(3).get(2).getName());


	}
	
	@Test
	public void testBirthOrder() {
		List<People> people = service.orderByBirthDateAsc(mockPeople().stream());
		Assert.assertEquals("Lucas", people.get(0).getName());
		Assert.assertEquals("Bernardo", people.get(1).getName());
		Assert.assertEquals("Ana", people.get(2).getName());
		Assert.assertEquals("Julia", people.get(3).getName());
		Assert.assertEquals("Maria", people.get(4).getName());
		Assert.assertEquals("João", people.get(5).getName());
		Assert.assertEquals("Bruno", people.get(6).getName());
		Assert.assertEquals("Cassia", people.get(7).getName());
		Assert.assertEquals("Juca", people.get(8).getName());
		Assert.assertEquals("Jessica", people.get(9).getName());
	}
	
	@Test
	public void testOrderByMassDesc() {
		List<People> people = service.orderByMassDesc(mockPeople().stream(),"desc").collect(Collectors.toList());
		Assert.assertEquals("João", people.get(0).getName());
		Assert.assertEquals("Maria", people.get(1).getName());
		Assert.assertEquals("Ana", people.get(2).getName());
		Assert.assertEquals("Juca", people.get(3).getName());
		Assert.assertEquals("Bruno", people.get(4).getName());
		Assert.assertEquals("Cassia", people.get(5).getName());
		Assert.assertEquals("Jessica", people.get(6).getName());
		Assert.assertEquals("Julia", people.get(7).getName());
		Assert.assertEquals("Bernardo", people.get(8).getName());
		Assert.assertEquals("Lucas", people.get(9).getName());
	}
	
	@Test
	public void testOrderByMassAsc() {
		List<People> people = service.orderByMassDesc(mockPeople().stream(), "asc").collect(Collectors.toList());
		Assert.assertEquals("João", people.get(9).getName());
		Assert.assertEquals("Maria", people.get(8).getName());
		Assert.assertEquals("Juca", people.get(7).getName());
		Assert.assertEquals("Ana", people.get(6).getName());
		Assert.assertEquals("Jessica", people.get(5).getName());
		Assert.assertEquals("Cassia", people.get(4).getName());
		Assert.assertEquals("Bruno", people.get(3).getName());
		Assert.assertEquals("Julia", people.get(2).getName());
		Assert.assertEquals("Bernardo", people.get(1).getName());
		Assert.assertEquals("Lucas", people.get(0).getName());
	}
	
	@Test
	public void numberOfTravels() {
		 int numberOfTravels = service.calculateNumberOfTravels(mockPeople().stream());
		 Assert.assertEquals(3, numberOfTravels);
	}
	
	private List<People> mockPeople() {
		List<People> people = new ArrayList<People>();
		people.add(new People("Ana", "19BBY", "unknown", "180", "29",1));
		people.add(new People("João", "11ABY", "Male", "180", "89",2));
		people.add(new People("Maria", "10BBY", "unknown", "180", "84",1));
		people.add(new People("Juca", "40ABY", "Male", "180", "29",3));
		people.add(new People("Lucas", "90BBY", "unknown", "180", "7",1));
		people.add(new People("Bernardo", "34BBY", "Male", "180", "8",3));
		people.add(new People("Bruno", "15ABY", "Male", "180", "12",2));
		people.add(new People("Cassia", "29ABY", "Female", "180", "12",1));
		people.add(new People("Jessica", "99ABY", "Female", "180", "12",3));
		people.add(new People("Julia", "13BBY", "Female", "180", "10",1));
		return people;
		
	}

}
