 class AnimalListRunner {
	public static void main(String[] args) {
		AnimalList list = new AnimalList();
		/* Preliminary testing of basic empty list addition/ fake removals
		list.addAnimal("Bear");
		list.displayList();
		list.addAnimal("Alpaca");
		list.displayList();
		list.removeAnimal("Bear");
		list.displayList();
		list.addAnimal("Snake");
		list.displayList();
		list.removeAnimal("FAKE");
		list.displayList();
		list.removeAnimal("Snake");
		list.displayList();
		list.removeAnimal("Alpaca");
		list.displayList();
		*/
		int count; //takes the int from the called method
		/* Initiate Strings(NOT IN ALPHABETICAL ORDER) */
		String s1 = "African lion";
		String s2 = "Cheetah";
		String s3 = "Dingo";
		String s4 = "Fennec Fox";
		String s5 = "Moose";
		String s6 = "Polar Bear";
		String s7 = "Sea Otter";
		String s8 = "Blue Whale";
		String s9 = "Bottlenose Dolphin";
		String s10 = "Humpback Whale";
		String s11 = "Orca Killer Whale";
		String s12 = "Sperm Whale";
		String s13 = "Koala";
		String s14 = "Red kangaroo";
		String s15 = "Tasmanian Devil";
		String s16 = "Wallaby";
		String s17 = "Beaver";
		String s18 = "Meerkat";
		String s19 = "African Elephant";
		String s20 = "Asian Elephant";
		String s21 = "Giraffe";
		String s22 = "Hippopotamus";
		String s23 = "Horse";
		String s24 = "Black Bear";
		String s25 = "Grizzly Bear";
		/* Add animals to list-should be sorted */
		list.addAnimal(s1);
		list.addAnimal(s2);
		list.addAnimal(s3);
		list.addAnimal(s4);
		list.addAnimal(s5);
		list.addAnimal(s6);
		list.addAnimal(s7);
		list.addAnimal(s8);
		list.addAnimal(s9);
		list.addAnimal(s10);
		list.addAnimal(s11);
		list.addAnimal(s12);
		list.addAnimal(s13);
		list.addAnimal(s14);
		list.addAnimal(s15);
		list.addAnimal(s16);
		list.addAnimal(s17);
		list.addAnimal(s18);
		list.addAnimal(s19);
		list.addAnimal(s20);
		list.addAnimal(s21);
		list.addAnimal(s22);
		list.addAnimal(s23);
		list.addAnimal(s24);
		list.addAnimal(s25);
		list.displayList();
		count = list.getnumAddRemove();
		System.out.println(count); //25
		/* removes some animals in the list */
		boolean result;
		result = list.removeAnimal("African lion"); //beginning
		System.out.println(result);
		list.displayList();
		result = list.removeAnimal("Wallaby"); //end
		System.out.println(result);
		list.displayList();
		result = list.removeAnimal("Koala"); //middle
		System.out.println(result);
		list.displayList();
		result = list.removeAnimal("Totally a real animal!"); //animal not in list-should be no errors
		System.out.println(result);
		count = list.getnumAddRemove();
		System.out.println(count); //28 
		/* Empty list add/remove */
		list.addAnimal(s25);
		list.displayList();
		list.removeAnimal(s25);
		list.displayList();
		count = list.getnumAddRemove(); //30
		System.out.println(count);
		/* Remove everything */
		list.removeAnimal(s1);
		list.removeAnimal(s2);
		list.removeAnimal(s3);
		list.removeAnimal(s4);
		list.removeAnimal(s5);
		list.removeAnimal(s6);
		list.removeAnimal(s7);
		list.removeAnimal(s8);
		list.removeAnimal(s9);
		list.removeAnimal(s10);
		list.removeAnimal(s11);
		list.removeAnimal(s12);
		list.removeAnimal(s13);
		list.removeAnimal(s14);
		list.removeAnimal(s15);
		list.removeAnimal(s16);
		list.removeAnimal(s17);
		list.removeAnimal(s18);
		list.removeAnimal(s19);
		list.removeAnimal(s20);
		list.removeAnimal(s21);
		list.removeAnimal(s22);
		list.removeAnimal(s23);
		list.removeAnimal(s24);
		list.removeAnimal(s25);
		list.displayList();
		count = list.getnumAddRemove(); 
		System.out.println(count); //52
	}

}
