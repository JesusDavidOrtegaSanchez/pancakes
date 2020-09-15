package pancakes;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
	
	public static ArrayList<String> yaProducidos = new ArrayList<>();
	public static String ordenada;
	public static int numeroEntradas;
	
	public static void main(String args []) {
		Scanner leer = new Scanner(System.in);
		System.out.println("Ingrese el numero de pancakes:");
		int cantidad = leer.nextInt();
		leer.close();
		pancake stack [] = generarPancakes(cantidad);
		yaProducidos.ensureCapacity(factorial(cantidad));
		yaProducidos.add(toString(stack));
		System.out.println("Cadena Inicial:");
		for(int e = 0; e < stack.length; e ++) {
			System.out.println(stack[e].getValor());
		}
		trabajoPorNodo(stack, 0, 1);
		System.out.println("Numero de Entradas: " + numeroEntradas);
		for(int e = 0; e < stack.length; e ++) {
			System.out.println(stack[e].getValor());
		}
	}
	
	public static int factorial(int cantidad) {
		if(cantidad == 0) {
			return 1;
		}else {
			return cantidad * factorial(cantidad-1);
		}
	}
	
	public static String toString(pancake stack[]) {
		String cadena = "";
		for(int i = 0; i < stack.length; i ++) {
			cadena += stack[i].getValor();
		}
		return cadena;
	}
	
	//Se le pasa el numero de pancakes para el juego, los revuelve y regresa el array revuelto
	public static pancake [] generarPancakes(int numeroPancakes) {
		pancake stack [] = new pancake [numeroPancakes];
		for (int i = 0; i < stack.length; i ++) {
			pancake nodo = new pancake(i+1, false);
			stack[i] = nodo;
		}
		ordenada = toString(stack);
		for (int i = 0; i < stack.length; i ++) {
			pancake temp = stack[i];
			int rand = (int) (Math.random()*stack.length);
			stack[i] = stack[rand];
			stack[rand] = temp;
		}
		return stack;
	}
	
	//Método para mover los pancakes
	public static pancake[] mover(int pos, pancake stack[]) {
		pancake arrayTemp[] = new pancake [pos+1];
		int e = 0;
		for(int i = pos-1; i >= 0; i --) {
			arrayTemp[e] = stack[i];
			e++;
		}
		for(int i = 0; i < pos; i ++) {
			stack[i] = arrayTemp[i];
		}
		return stack;
	}
	
	public static void trabajoPorNodo(pancake stack[], int posicionReciente, int numEntradas) {
		if(!toString(stack).equals(ordenada)) {
			numeroEntradas = numEntradas;
			int posicion;
			for(int i = 0; i < stack.length; i ++) {
				if(!stack[i].getRevisado() && !toString(stack).equals(ordenada)){
					stack[i].setRevisado(true);
					pancake stackHijo[];
					do {
						posicion = (int) (Math.random()*stack.length+1);
						stackHijo  = mover(posicion, stack);
					}while(yaProducidos.contains(toString(stackHijo)));
					yaProducidos.add(toString(stackHijo));
					for(int e = 0; e < stackHijo.length; e ++) {
						if(e != posicion) {
							stackHijo[e].setRevisado(false);
						}
					}
					trabajoPorNodo(stackHijo, posicion, numEntradas+=1);
				}
			}
		}
	}
	
}
