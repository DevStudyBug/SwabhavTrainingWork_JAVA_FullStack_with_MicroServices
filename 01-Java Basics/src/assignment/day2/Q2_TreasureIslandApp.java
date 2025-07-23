package assignment.day2;

import java.util.Scanner;

public class Q2_TreasureIslandApp {
	public static void main (String [] agrs) {
		Scanner scanner = new Scanner (System.in);
		System.out.println("Welcome to Treasure Island.\r\n"
				+ "Your mission is to find the treasure.\r\n"
				+ "");
		System.out.println("choose the direction (left/right)?");
		
		String direction = scanner.nextLine();
		
		if (!direction.equalsIgnoreCase("left")){
			System.out.println("Fall into a hole.\r\n"
					+ "Game Over.");
		} else {
			System.out.println("Swim or wait?");
			String action = scanner.nextLine();
			
			if (!action.equalsIgnoreCase("wait")) {
				System.out.println("Attacked by trout.\r\n"
						+ "Game Over.");
			}
			else {
				
				System.out.println("Which door(Red, Yellow , Blue )?");
				String door = scanner.nextLine();
				
				 if (door.equalsIgnoreCase("red")) {
	                    System.out.println("Burned by fire. Game Over.");
	                } 
				 else if (door.equalsIgnoreCase("blue")) {
	                    System.out.println("Eaten by beasts. Game Over.");
	                } 
				 else if (door.equalsIgnoreCase("yellow")) {
	                    System.out.println(" You Win!");
	                } 
				 else {
	                    System.out.println("Game Over.");
	                }
	            }
	        }

	        scanner.close();
	    }
}


//				switch (door) {
//				case "red": {
//					System.out.println("Burned by fire.\r\n"
//							+ "Game Over.");
//				} 
//				break;
//				
//				case "Blue": {
//					System.out.println("Eaten by beasts.\r\n"
//							+ "Game Over");
//				} 
//				break;
//				
//				case "Yellow": {
//					System.out.println("You Win !");
//				} 
//				break;
//				
//				default : System.out.println("Game Over.\r\n"
//						+ "");
//				
//				}
//				
//			}
//		}
//		
//	}
//}
