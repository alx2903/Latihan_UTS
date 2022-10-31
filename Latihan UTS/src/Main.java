import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Main {

	public Main() {
		
		int menu;
		
		String name;
		String id;
		int price;
		String desc;
		String coun = "";
		String lib;
		
		String update;
		
		String Echlib = "EchLib";
		String JustGoLib = "JustGoLib";
		String XLib = "XLib";
		
		Vector<Book> Vec = new Vector<>();
		
		do {
			Scanner scan = new Scanner(System.in);
			
			System.out.println("Welcome to JuGlib");
			System.out.println("1. View Book");
			System.out.println("2. Add Book");
			System.out.println("3. Update Book");
			System.out.println("4. Exit");
			System.out.printf("Choose [1 - 4] >> ");
			menu = scan.nextInt();
			scan.nextLine();
			
			switch (menu) {
			case 1:
				if(Vec.isEmpty() == true) {
					System.out.println("There is no book.");
					Util.PressEnter();
				}
				else {
					System.out.println("List of book:");
					System.out.println("====================================================================================================================================");
					System.out.println("|| Library Name    || Book Id  || Book name                  || Book Price      || Book Description            || Library Country ||");
					System.out.println("====================================================================================================================================");
					for(int i=0 ; i < Vec.size() ; i++) {
						System.out.println("|| " + String.format("%-15s",Vec.get(i).getLib()) + " || " + String.format("%-8s", Vec.get(i).getId()) + " || " + String.format("%-26s", Vec.get(i).getName()) +" || " + String.format("%-15s", Vec.get(i).getPrice()) +" || " + String.format("%-27s", Vec.get(i).getDesc()) + " || " + String.format("%-15s", Vec.get(i).getCoun()) + " || ");
					}
					System.out.println("====================================================================================================================================");
				}
				break;
			case 2:
				System.out.printf("Input book name >> ");
				name = scan.nextLine();
				
				System.out.printf("Input book price [ more than 20000] >> ");
				price = scan.nextInt();
				scan.nextLine();
				while(price <= 20000) {
					System.out.println("Book price must be more than 20000!");
					System.out.printf("Input book price [ more than 20000] >> ");
					price = scan.nextInt();
					scan.nextLine();
				}
				
				System.out.printf("Input book description [ 5..20 ] >> ");
				desc = scan.nextLine();
				while(desc.length() < 5 || desc.length() > 20) {
					System.out.println("Description should be between 5 and 20 characters");
					System.out.printf("Input book description [ 5..20 ] >> ");
					desc = scan.nextLine();
				}
				
				for(;;) {
					System.out.printf("Input library name [ EchLib | JustGoLib | XLib ] >> ");
					lib = scan.next();
					if(lib.matches(Echlib) == true || lib.matches(JustGoLib) == true || lib.matches(XLib) == true) {
						break;
					}
				}
				
				if(lib.matches(Echlib) == true) {
					coun = "Singapore";
				} else if (lib.matches(JustGoLib) == true){
					coun = "Indonesia";
				}else if (lib.matches(XLib) == true){
					coun = "Malaysia";
				}
				
				Random rand = new Random();
				int rand1 = rand.nextInt(10000);
				
				String randnum;
				randnum = String.format("%04d", rand1);
			
				id = "BOOK" + randnum;
				
				Book book = new Book(lib, name, id, price, desc, coun);
				
				Vec.add(book);
				
				break;
			case 3:
				System.out.printf("Input Book Id [ e.g. BOOK1234] >> ");
				update = scan.next();
				
				int menu1;
				
				for(int i = 0 ; i < Vec.size() ; i++) {
					if(update.matches(Vec.get(i).getId()) == true) {
						System.out.println("Update :");
						System.out.println("1. Update book name");
						System.out.println("2. Update book price");
						System.out.println("3. Update book description");
						System.out.printf("Choose [ 1 - 3 ] >> ");
						menu1 = scan.nextInt();
						scan.nextLine();
						
						switch (menu1) {
						case 1:
							String name1;
							for(;;) {
								System.out.printf("Input book name >> ");
								name1 = scan.nextLine();
								if(name1.isBlank() == false) {
									Vec.get(i).setName(name1);
									System.out.println("Succesfully changed book name!");
									Util.PressEnter();
									break;
								}
							}
							break;
						
						case 2:
							int price1;
							for(;;) {
								System.out.printf("Input book price [ more than 20000 ] >> ");
								price1 = scan.nextInt();
								if(price1 > 20000) {
									Vec.get(i).setPrice(price1);
									System.out.println("Succesfully changed book price!");
									Util.PressEnter();
									break;
								}
							}
							break;
						
						case 3:
							String desc1;
							for(;;) {
								System.out.printf("Input book description [ 5..20 ] >> ");
								desc1 = scan.nextLine();
								if(desc1.length() >= 5 && desc1.length() <= 20) {
									Vec.get(i).setDesc(desc1);
									System.out.println("Succesfully changed book description!");
									Util.PressEnter();
									break;
								}
							}
							break;
							
						default:
							System.out.println("Requires valid input [ 1 - 3 ]");
							Util.PressEnter();
							break;
						}
						break;
					}
					else if (i != Vec.size()){
						continue;
					}
					else {
						System.out.println("Book Id not found!");
						Util.PressEnter();
						break;
					}
				}
				
				break;
			
			case 4:
				break;
			
			default:
				System.out.println("Error, please choose between 1-4");
				continue;
			}
		} while (menu !=4);
		
	}

	public static void main(String[] args) {
		new Main();
	}

}
