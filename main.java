package pancakes;

import java.util.Scanner;

public class main {
	
	//Variables globales
	public static String abecedario = "abcdefghijklmnopqrstuvwxyz";
	
	public static void main(String args []) {
		Scanner leer = new Scanner(System.in);
		System.out.println("Ingrese el numero de pancakes:");
		int stack [] = generarPancakes(leer.nextInt());
		System.out.println("");
		for (int i = 0; i < stack.length; i ++) {
			System.out.println(abecedario.charAt(i) + ".- " + stack[i]);
		}
		leer.nextLine();
		while(!arreglado(stack)) {
			mover(leer.nextLine(), stack);
			System.out.print("\033[H\033[2J");  
		    System.out.flush(); 
			for (int i = 0; i < stack.length; i ++) {
				System.out.println(abecedario.charAt(i) + ".- " + stack[i]);
			}
		}
	}
	
	//Se le pasa el numero de pancakes para el juego, los revuelve y regresa el array revuelto
	public static int [] generarPancakes(int numeroPancakes) {
		int stack [] = new int [numeroPancakes];
		for (int i = 0; i < stack.length; i ++) {
			stack[i] = i + 1;
		}
		for (int i = 0; i < stack.length; i ++) {
			int temp = stack[i];
			int rand = (int) (Math.random()*stack.length);
			stack[i] = stack[rand];
			stack[rand] = temp;
		}
		return stack;
	}
	
	//Método para mover los pancakes
	public static void mover(String pos, int stack[]) {
		int indexMov = abecedario.indexOf(pos);
		int arrayTemp[] = new int [indexMov+1];
		int e = 0;
		for(int i = indexMov; i >= 0; i --) {
			arrayTemp[e] = stack[i];
			e++;
		}
		System.out.println("");
		for(int i = 0; i <= indexMov; i ++) {
			stack[i] = arrayTemp[i];
		}
	}
	
	public static boolean arreglado(int stack[]) {
		for(int i = 0; i < stack.length-1; i ++) {
			if(stack[i] > stack[i+1]) {
				return false;
			}
		}
		return true;
	}
}
