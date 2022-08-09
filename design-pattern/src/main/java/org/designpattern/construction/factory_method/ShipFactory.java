package org.designpattern.construction.factory_method;

public interface ShipFactory {

	default Ship orderShip(String name, String email) {
		validate(name, email);
		prepareFor(name);
		Ship ship = createShip();
		sendEmailTo(email, ship);
		return ship;
	}

	private void sendEmailTo(String email, Ship ship) {
		System.out.printf("hey %s, %s produced%n", email, ship.getName());
	}

	Ship createShip();

	private void validate(String name, String email) {
		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException("Name is required");
		}

		if (email == null || email.isBlank()) {
			throw new IllegalArgumentException("Email is required");
		}
	}

	private void prepareFor(String name) {
		System.out.printf("Preparing for %s", name);
	}

}
