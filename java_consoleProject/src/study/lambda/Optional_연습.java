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
		 * @param name
		 *            the name to set
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
		 * @param age
		 *            the age to set
		 */
		public void setAge(Integer age) {
			this.age = age;
		}
	}

	public static void main(String[] args) {

		Human human = new Human("신윤섭", 34);

		{ // map, filter orElexe 관련
			Integer age = Optional.ofNullable(human).map(Human::getAge) // Human 에서 age 를 가져온다
					.filter(a -> {
						return a > 40;
					}) // 조건에 부합한 애들만 걸러 낸다
					.orElseGet(() -> {
						return null;
					}); // else 일 경우의 값을 정한다

			System.out.println("이 사람은 40이 넘었나요? " + Optional.ofNullable(age).isPresent());
		}

		{ // isPresent 예제, 대상 객체가 null 인지를 확인 한다
			Human h2 = null;
			System.out.println("h2 는 null 이니? " + Optional.ofNullable(h2).isPresent());
		}

		{// ifPresent 예제, 대상 객체가 null 이 아닐경우 실행 되는 것
			Optional.ofNullable(human) //
					.ifPresent(h -> {
						System.out.println("human 은 null 이 아니다.");
					});
		}

		{// orEleseThrow 예제, 대상 객체가 null 일 경우 Exception을 발생 시킨다
			try {
				Human nullHuman = null;
				Optional.ofNullable(nullHuman).orElseThrow(() -> {
					return new IllegalArgumentException("이 Human 은 null 입니다.");
				});
			} catch (NullPointerException | IllegalArgumentException ex) {
				System.out.println(ex.getMessage());
			}
		}

		{
			// map 과 flatMap 의 차이, map 은 return 되는 값의 optional 값으로 받을 수 있다면...
			// flatMap 은 return 되는 optional 값을 생성 해서 보낼 수 있다. 즉, flatMap 은 연속되는 작업이 가능 하다
			String hName = Optional.ofNullable(human).map(h -> {
				return h.getName();
			}).orElse("No named");
			System.out.println("map 을 사용한 이 사용자의 이름은 " + hName);

			hName = Optional.ofNullable(human).flatMap(h -> {
				return Optional.ofNullable(h.getName());
			}).orElse("No named");

			System.out.println("flatMap 을 사용한 이 사용자의 이름은 " + hName);
		}

	}

}
