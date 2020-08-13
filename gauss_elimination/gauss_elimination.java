	/** -----------------------------------------------------------------------------------
	 *  Author:        Panayiotis Leontiou
	 *  Written:       17/10/2016
	 *  Last updated:  13/8/2020
	 * 
	 *  Compile:  $ javac gauss_elimination.java
	 *  Execute:  $ java gauss_elimination < fileName.txt
     *
	 *  This program calculates the solution of a system of equations with n variables 
	 *  using the Gauss elimination process. The number of supported equations are 1-10.
	 *  The program also calculates the error percentage for each equation and displays 
	 *  them on screen along with the solution. If the system has no solution the program
	 *  will print an error message and terminate.
	 *
	 *  Input file format:
	 *  Example with n = 3 equations
	 *  Equations:
	 *  2 * x - 1 * y - 4 * z = -1
	 *  1 * x + 5 * y + 1 * z = 0
	 *  1 * x + 3 * y + 2 * z = 4
	 *  
	 *  Input file (test1.txt):
	 *  3 
	 *  2 -1 -4 -1
	 *  1 5 1 0
	 *  1 3 2 4
	 *  
	 *  Execute with: java gauss_elimination < test1.txt
	 *  
	 *  Output:
	 *  GAUSSIAN ELIMINATION
     *
	 *	The Problem
     *
	 *	2.00 -1.00 -4.00	x 1	-1.00
	 *	1.00  5.00  1.00	x 2	 0.00
	 *	1.00  3.00  2.00	x 3	 4.00
     *
	 *	The Solution
     *
	 *	2.00 -1.00 -4.00	 3.00000	-1.00000
	 * 	1.00  5.00  1.00	-1.00000	 0.00000
	 *	1.00  3.00  2.00	 2.00000	 4.00000
     *
	 *	Accuracy of Solution
     *
	 *	for equation  1 the error is 	    0.00000%
	 *	for equation  2 the error is 	    0.00000%
	 *	for equation  3 the error is 	    0.00000%
	 *  
	 *  ----------------------------------------------------------------------------------- */

import java.util.Scanner;

public class gauss_elimination {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// System.out.print("Enter the number of equations (1-10): ");
		int n = scan.nextInt(); 	//  n = number of equations (array dimenstions)
		while ((n>10)||(n<1)){   	//  n must be between 1 and 10
			System.out.println("Wrong number! Please try again...");
			System.out.print("Enter the number of equations (1-10): ");
			n = scan.nextInt(); 
		}
		
		double sintelestes[][] = new double[n][n]; //  Disdiastatos pinakas me tous sintelestes ton agnoston.
		double times[] = new double[n];    //  Monodiastatos pinakas me tis pragmatikes times ton eksisoseon.
		for (int i=0; i<n; i++){           //  Diavazoume ta stoixeia ton eksisoseon (sintelestes kai times).
		
		//  System.out.println("Sintelestes " + (i+1) + "is eksisosis");
			for (int j=0; j<n; j++){
			//  System.out.print((j+1) + "os sintelestis: ");
				sintelestes[i][j] = scan.nextDouble();
			}
		//  System.out.print("Timi "+ (i+1) + "is eksisosis: ");
			times[i] = scan.nextDouble();
		}
		
		boolean isUnsolvable = false;  //  An opoiodipote stoixeio tis diagoniou tou pinaka einai miden tote
		for (int i=0; i<n; i++){       //  to sistima den exei lisi kai to programma termatizei.
			if (sintelestes[i][i] == 0) isUnsolvable=true;
		}
		if (!isUnsolvable){   		//  An to sistima mporei na lithei tote to programma vriskei tis liseis.
			double trigonikos[][] = new double[n][n];  //  Dimiourgoume disdiastato trigoniko pinaka.
			double timesTrigonikou[] = new double[n];  //  Dimiourgoume pinaka me tis times tou trigonikou.
			for (int i=0; i<n; i++){    //  Antigrafoume tis times tou pinaka sintelestes ston trigoniko.
				for(int j=0; j<n; j++){
					trigonikos[i][j] = sintelestes[i][j];
				}
				timesTrigonikou[i] = times[i];  	//  Antigrafoume tis pragmatikes times ton eksisoseon 
			}										//  stis antistixes times tou trigonikou pinaka.
						
			if (sintelestes[0][0]!=1){      //  An o protos sintelestis tis protis eksisosis den einai isos 
				for (int j=0; j<n; j++){    //  me ena(1) dieroume olous tous sintelestes tis protis siras 
					trigonikos[0][j] = sintelestes[0][j] / sintelestes[0][0];  //  kathos kai tin timi tis 
					timesTrigonikou[0] = times[0] / sintelestes[0][0];   //  seiras me ton sintelesti afto.
				}
			}
			
			//  Epeksergasia tou trigonikou pinaka kai tou pinaka me tis times tou trigonikou! 
			for (int i=1; i<n; i++){
				for (int j=0; j<i; j++){
						if (trigonikos[i][j] != 0){	      //  An to stixeio tou trigonikou den einai miden
							if (trigonikos[i][j]!=1){      //  oute ena, tote dierei ola ta stixeia tis 
								for (int m=j+1; m<n; m++){  //  siggekrimenis seiras me to stixeio afto.
									trigonikos[i][m] = trigonikos[i][m]/ trigonikos[i][j];
								}	  
								//  Kathos kai gia ta antistoixa stixeia ton timon tou trigonikou.
								timesTrigonikou[i] = timesTrigonikou[i] / trigonikos[i][j];
								trigonikos[i][j] = 1;  //  Antikathista to stixeio pou dierese ta ipolipa 
							}						   //  me ton arithmo ena (1).
						    //  Aferoume apo ta stoixeia tou trigonikou tin proigoumeni seira tou pou
							for (int w=j; w<n; w++){   //  exei ton arithmo 1 sti thesi pou theloume na 
								trigonikos[i][w] = trigonikos[i][w] - trigonikos[j][w]; //  midenisoume.
							}   
							//  Antistixa apo ton pinaka timon tou trigonikou aferoume tin proigoumeni
							timesTrigonikou[i] = timesTrigonikou[i] - timesTrigonikou[j];     //  timi.
						}
				}	
				//  An ena diagonio stixeio tou trigonikou exei tin timi miden (0) tote to sistima 
				if (trigonikos[i][i] == 0){   //  den mporei na lithei kai to programma termatizei.
					System.out.println("The system cannot be solved! Terminating program...");
					return;
				}
				//  An ena diagonio stixeio tou trigonikou den exei tin timi ena (1) tote to programma
				if (trigonikos[i][i] != 1){  //  metatrepei tin diagonio se ena (1) kanontas antistixa
					int k=i+1;        //  tis kataliles metatropes kai sta ipolipa stoixeia tis seiras.
					while (k<n){
						trigonikos[i][k] = trigonikos[i][k] / trigonikos[i][i];
						k++;
					}//  Ektos apo ta stixeia tis seiras metavallei kai ta stixeia tis antistixis timis
					timesTrigonikou[i] = timesTrigonikou[i] / trigonikos[i][i];		
					trigonikos[i][i] = 1;				
				}
			}
			
			//  Ipologismos liseon!
			double liseis[] = new double[n];  //  Dimiourgei ena pinaka gia tis liseis ton eksisoseon.
			liseis[n-1] = (timesTrigonikou[n-1]);  //  H teleftea timi tou pinaka timon tou trigonikou  
		                                           //  isoute me to tin lisi tou telefteou stixeiou. 
			for (int i=n-2; i>=0; i--){            
				double sum = timesTrigonikou[i];  //  Gia na vroume tis ipolipes liseis prepei na 
				//  vroume to athrisma antikathistontas tis liseis pou vrikame proigoumenos kai na
			    //  to aferesoume apo tin antistixi timi tou trigonikou.
				for (int j=n-1; j>i; j--){  
					sum = sum - trigonikos[i][j] * liseis[j];
				}
				liseis[i]=sum;      //  Kataxoroume ti lisi pou vrikame ston pinaka me tis liseis.
			}
			
			//  Ypologismos sfalmaton!
			final double E = 0.0001;           //  Stathera E (gia ton ipologismo ton sfalmaton)
			double error[] = new double[n];  //  Dimiourgoume pinaka sfalmaton
			for (int i=0; i<n; i++){
				double sum = 0.0;
				for (int j=0; j<n; j++){  //  Ypologizoume to athrisma me vasi tis liseis pou vrikame.
					sum += (sintelestes[i][j] * liseis[j]);
				}
				if (Math.abs(times[i] - sum) < E) error[i] = 0.0;   //  Kai to siggrinoume me tin 
				else if (times[i] == 0) error[i] = (100.0 * sum/E); //  pragmatiki timi tis eksisosis.
				else error[i] = 100.0 * (1.0 - sum/times[i]);
			}//  An i diafora tous einai mikroteri apo tin stathera E, theoroume to sfalma iso me miden.
			 //  An i pragmatiki timi isoute me miden tote to sfalma isoute me 100*(athrisma/stathera E)
			 //  Diaforetika to sfalma isoute me 100*(1 - (athrisma/tin pragmatiki timi tis eksisosis)
			
			//  Ektiposi apotelesmaton!
			System.out.println("  GAUSSIAN ELIMINATION");      //  Ektiposi epikefalidas.
			System.out.println("\n  The Problem");             //  Ektiposi provlimatos.
			System.out.println();
			for (int i=0; i<n; i++){
				for (int j=0; j<n; j++){
					if (sintelestes[i][j]<0) System.out.print(" ");
					else System.out.print("  ");
					System.out.printf("%.2f",sintelestes[i][j]);
				}
				System.out.print("\tx "+ (i+1));
				if (times[i]<0) System.out.print("\t");
				else System.out.print("\t ");
				System.out.printf("%.2f", times[i]);
				System.out.println();
			}
			
			System.out.println("\n  The Solution");            //  Ektiposi liseon provlimatos
			System.out.println();
			for (int i=0; i<n; i++){
				for (int j=0; j<n; j++){
					if (sintelestes[i][j]<0) System.out.print(" ");
					else System.out.print("  ");
					System.out.printf("%.2f",sintelestes[i][j]);
				}
				if (liseis[i]>=0) System.out.print("\t ");
				else System.out.print("\t");
				System.out.printf("%.5f",liseis[i]);
				
				if (times[i]>=0) System.out.print("\t ");
				else System.out.print("\t");
				System.out.printf("%.5f", times[i]);
				System.out.println();
			}
			
			System.out.println("\n  Accuracy of Solution");   //  Ektiposi sfalmaton provlimatos
			System.out.println();
			for (int i=0; i<n; i++){
				if (i != 9){
					System.out.print("  for equation  " + (i+1) + " the error is ");
				}
				else{
					System.out.print("  for equation " + (i+1) + " the error is ");
				}
				if (error[i]>=0) System.out.print("\t ");
				else System.out.print("\t");
				System.out.printf("%10.5f", error[i]);
				System.out.println("%");
			}
		}
		//  An to sistima den mporei na lithei ektiponete minima ston xristi.
		else System.out.println("The system cannot be solved! Terminating program...");
	}

}
