package javabegin;

import javabegin.character.AbstractCharacter;
import javabegin.character.AbstractMage;
import javabegin.character.FireMage;
import javabegin.character.IceMage;
import javabegin.character.Warrior;
import javabegin.employee.AbstractEmployee;
import javabegin.employee.Administrator;
import javabegin.employee.Human;

public class Main {

	public static void main(String[] args) {

		Human admin1 = new Administrator();
		AbstractEmployee admin2 = new Administrator("Vlad", "Petrov", 24);
		Administrator admin3 = new Administrator("Artem", "Sidorov", 43);

		System.out.println(admin2.getName() + admin2.getSurname() + admin2.getAge());
		System.out.println(admin3.getName() + admin3.getSurname() + admin3.getAge());

		admin3.control();


		AbstractCharacter warrior = new Warrior("Wolf");
		AbstractMage fireMage = new FireMage("Aston");
		AbstractMage iceMage = new IceMage("Givi");

		fireMage.sayBaseSpell();
		iceMage.sayBaseSpell();

		System.out.println(warrior.getName());
		System.out.println(fireMage.getName());

	}
}
