package br.com.vanessa.starwars;

import java.util.List;

import com.google.common.collect.Lists;

public class Test {

	public static void main(String[] args) {

		List<String> lista1 = Lists.newArrayList("ZB20", "zb06");
		List<String> lista2 = Lists.newArrayList("ZB12", "ZB06", "ZB20");

		lista1.retainAll(lista2);

		lista1.forEach(z -> System.out.println(z));

	}
}
