package TD3;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		
		System.out.println("Entrez pays et codepos");
		Scanner sc = new Scanner(System.in);
		
		String pays = sc.nextLine();
		//int codepos = sc.nextInt();
		
		Pays p = new Pays(pays/*, codepos*/);

	}

}
