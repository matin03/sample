package study.lambda;

import java.util.Optional;

public class Optional_연습 {

	public static class Human {
		private String name;
		private Integer age;

		public Human() {
			this.age = -1;
		}

		public Human(String name, int age) {
			this.name = name;
			this.age = age;
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * @return the age
		 */
		public Integer getAge() {
			return age;
		}

		/**
		 * @param age the age to set
		 */
		public void setAge(Integer age) {
			this.age = age;
		}
	}

	public static void main(String[] args) {


		Human h = new Human("신윤섭", 34);

		Integer age = Optional.ofNullable(h)
				.map(Human::getAge) // Human 에서 age 를 가져온다
				.filter(a -> { return a > 40; }) // 조건에 부합한 애들만 걸러 낸다
				.orElseGet(()->{ return null; }); // else 일 경우의 값을 정한다

		System.out.println("이 사람은 40이 넘었나요? " + (age != null) );
	}

}
