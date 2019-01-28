import java.util.Scanner;
import java.util.*;

public class coinFlip {

	
	static int headbias = 50;

	public static void biasSetter(int bias){
		headbias = bias;
	}

	public static int coinTosser(){
		int ranber = ((int)(Math.random()*(562431)))%100;
		if(ranber <= headbias){
			return 1;
		}
		else{
			return 2;
		}
	}

	public static void main(String[] args){
		while(true){
			System.out.println("Enter:");
			System.out.println("1 For a single coin toss. ");
			System.out.println("2 For a set number of coin tosses. ");
			System.out.println("3 Change biases. ");
			System.out.println("-1 to exit. ");
			Scanner userInput = new Scanner(System.in);
			String input = userInput.nextLine();
			if(input.equals("1")){
				int result = coinTosser();
				if(result == 1){
					System.out.println("The result is heads!");
				}
				else{
					System.out.println("The result is tails!");					
				}
			}
			else if(input.equals("2")){
				int heads = 0;
				int tails = 0;
				System.out.println("How many tests do you want to run: ");
				userInput = new Scanner(System.in);
				input = userInput.nextLine();
				for(int i=0; i<Integer.parseInt(input); i++){
					if(coinTosser() == 1){
						heads++;
					}
					else{
						tails++;
					}
				}
				String hstring = "Number of heads: " + Integer.toString(heads);
				String tstring = "Number of tails: " + Integer.toString(tails);
				System.out.println(hstring);
				System.out.println(tstring);
			}
			else if(input.equals("3")){
				System.out.println("The sum of both biases should be 100. ");
				System.out.println("Enter the bias for head (50 for unbiased): ");
				userInput = new Scanner(System.in);
				int bias = Integer.parseInt(userInput.nextLine());
				if(bias <= 100 && bias>=0){
					biasSetter(bias);
					System.out.println("Bias changed!");
				}
				else {
					System.out.println("Out of bounds!");
				}
			}
			else if(input.equals("-1")){
				break;
			}
			else{
				System.out.println("Wrong input.");
			}
			System.out.print("\n \n \n");
		}
	}
}
