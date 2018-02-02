package com.antengine.armchair.test;

public class Jungle {

	public static class Animal {
		private String name;
		private int energy = 0;
		public Animal(String name) {
			this.name = name;
		}
		public Animal() {
			this.name = "Animal";
		}
		public void sound() {
			if (this.energy < 3) {
				System.out.printf("%s not enough evergy\n", this.name);
				return;
			}
			this.energy -= 3;
			System.out.printf("%s sound\n", this.name);
		}

		public void eat() {
			this.energy += 5;
			System.out.printf("%s eat\n", this.name);
		}

		public void sleep() {
			this.energy += 10;
			System.out.printf("%s sleep\n", this.name);
		}
	}

	public interface Sumable {
		int sum();
	}

	public interface Playable {
		void play();
	}

	public static class Tiger extends Animal implements Sumable {
		static private int sum = 0;
		public Tiger() {
			super("Tiger");
			sum++;
		}
		@Override
		public void sleep() {
			super.energy += 10;
			System.out.printf("%s sleep\n", super.name);
		}

		@Override
		public int sum() {
			return sum;
		}
	}

	public static class Monkey extends Animal implements Sumable, Playable {
		static private int sum = 0;
		public Monkey() {
			super("Monkey");
			sum++;
		}
		@Override
		public void sound() {
			if (super.energy < 4) {
				System.out.printf("%s not enough evergy\n", super.name);
				return;
			}
			super.energy -= 4;
			System.out.printf("%s sound\n", super.name);
		}
		@Override
		public void eat() {
			super.energy += 2;
			System.out.printf("%s eat\n", super.name);
		}
		@Override
		public int sum() {
			return sum;
		}

		@Override
		public void play() {
			System.out.printf("%s play Ooooo\n", super.name);
		}
	}
	public static class Snake extends Animal implements Sumable {
		static private int sum = 0;
		public Snake() {
			super("Snake");
			sum++;
		}
		@Override
		public int sum() {
			return sum;
		}
	}
}
