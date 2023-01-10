package com.baeldung.shallowdeep;

public class Employee {

	private String name;
	private Address address;
	private int age;

	public Employee(String name, Address address, int age) {
		this.name = name;
		this.address = address;
		this.age = age;
	}

	public static class Address {
		private int houseNumber;
		private String cityName;
		private String country;

		public Address(int houseNumber, String cityName, String country) {
			this.houseNumber = houseNumber;
			this.cityName = cityName;
			this.country = country;
		}

		public static Address deepCopy(Address address) {
			return new Address(address.getHouseNumber(), address.getCityName(), address.getCountry());
		}

		public int getHouseNumber() {
			return houseNumber;
		}

		public String getCityName() {
			return cityName;
		}

		public String getCountry() {
			return country;
		}

	}

	public static Employee shallowCopy(Employee employee) {
		Employee shallowCopy = new Employee(employee.getName(), employee.getAddress(), employee.getAge());

		return shallowCopy;
	}

	public static Employee deepCopy(Employee employee) {
		Employee shallowCopy = new Employee(employee.getName(), Address.deepCopy(employee.getAddress()),
				employee.getAge());

		return shallowCopy;
	}

	public String getName() {
		return name;
	}

	public Address getAddress() {
		return address;
	}

	public int getAge() {
		return age;
	}

}
