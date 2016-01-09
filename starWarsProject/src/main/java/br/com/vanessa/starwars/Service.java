package br.com.vanessa.starwars;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

import br.com.vanessa.starwars.api.model.People;

public class Service {
	
	public List<People> orderByBirthDateAsc(Stream<People> people) {
		return people.sorted().collect(Collectors.toList());
	}
	
	public Map<Integer, List<People>> groupBySpeciec(List<People> people) {
		return people.stream().collect(Collectors.groupingBy(People::getSpecie));
	}
	
	public Stream<People> orderByMassDesc(Stream<People> people, String order) {
		return order.equalsIgnoreCase("desc") ? people
				.sorted((p1,p2) -> Long.compare(Integer.parseInt(p2.getMass()), Integer.parseInt(p1.getMass()))) :
			people
			.sorted((p1,p2) -> Long.compare(Integer.parseInt(p1.getMass()), Integer.parseInt(p2.getMass())));
	}
	
	public int calculateNumberOfTravels(Stream<People> people) {
		return (int) Math.round((double)getPeopleListTotalMass(people)/VEICLE_CAPACITY);
	}

	private long getPeopleListTotalMass(Stream<People> people) {
		int peopleTotalMass = people
				.filter(p -> StringUtils.isNumeric(p.getMass()))
				.map(p -> Integer.parseInt(p.mass))
				.reduce(0, (x,y) -> x+y);
		return peopleTotalMass + (numberOfPeopleUnknowMass(people)*DEFAULT_PEOPLE_SIZE);
	}

	private long numberOfPeopleUnknowMass(Stream<People> people) {
		return people
				.filter(p -> !StringUtils.isNumeric(p.getMass()))
				.count();
	}
	
	private static final int DEFAULT_PEOPLE_SIZE = 100;
	private static final int VEICLE_CAPACITY = 100;


}
