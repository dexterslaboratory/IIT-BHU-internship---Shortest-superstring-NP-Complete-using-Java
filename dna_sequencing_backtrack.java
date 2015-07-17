package dna_sequencing;
import java.io.*;
import two_strings_super.two_string;


public class dna_sequencing_backtrack {
	
 	
	public static void main(String args[])throws IOException{
		
		Branch branch = new Branch();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String stringatthatlevel = new String();
		System.out.println("_________________________________________________");
		System.out.println();
		System.out.println ("      *********  D N A   SEQUENCING  *********  ");
		System.out.println("__________________________________________________");
		System.out.print("Enter the number of threads: \n>> ");
		int n = Integer.parseInt(br.readLine());
		int visited[]=new int[n];
		int position=0;		
		System.out.println("-- Enter DNA threads -- ");
		String strings[] = new String[n];
		for(int i=0;i<n;i++ ){
			System.out.print((i+1) +". >> ");
			strings[i]=br.readLine();
		}
		
		/*
		System.out.println("str before function call "+ s1);
		app.append(s1, s2);
		System.out.println("str after function call "+s1);
		*/
		
		branch.sequence(0, n, visited, position,strings,stringatthatlevel);
		System.out.println("Length of shortest superstring is: "+Branch.length);
		System.out.println("The string is: "+Branch.finalstring);
		
	}
}


class Branch{
	static StringBuffer finalstring = new StringBuffer();
	static int length;
	static boolean checkfirst = true;
	/*
	 * it is not necessary to declare the above variables as static .they just have to be global.
	 */
	two_string app = new two_string();
	public void sequence(int n,int numofstrings,int visited[],int position,String strings[],String stringatthatlevel){
		int i;
		position++;
		/*
		 * the value of position if different at different level and ranges from 1 to the number of strings
		 * is used to denote the level.
		 * when ever a function is called within itself recursively  it is like writing the function inside itself
		 * so the position variable in the inner function is in scope for the inner function 
		 * and for the outer or calling function the position inside the inner function is out of scope
		 * that is why position variable has fixed values representing level .
		 */
		for(i=0;i<numofstrings;i++){
			if(visited[i]==1) continue;
			else {
				visited[i]=1;
				//to below code in designed to pass the strings carefully..since strings 
				//are immutable therefore the last argument is of string time 
				//making it a stringbuffer class would not work as it would make changes in the string
				//at all levels..nd the aim was to have a minimum string of each level unique.
				StringBuffer forappending = new StringBuffer(stringatthatlevel);
				app.append(forappending, strings[i]);
				String temp=new String(forappending);
				//stringatthatlevel=temp;
	            //now to update the length and finalstring static variables the follwing code has been written
				//the so obtained length will also help us write the bounding condition
				//boolean recursivecall = true;
				if(checkfirst == true && position==numofstrings){
					length = forappending.length();
					finalstring.append(forappending);
					System.out.println("String: "+finalstring+" Length: "+length);
				}
				else if(checkfirst == false && forappending.length()>length){
					visited[i]=0;
					/*
					 * the continue statement is given because the length of the string has exceeded the length of a short string
					 * that has already been obtained..so its pointless to move further with such a branch.
					 * 
					 * also continue and not return is written as return would send the program to the previous level.
					 * but we want another string at the same level.
					 * example..
					 * lets say we have 4 strings and if we obtain a string of length say 7 in the first sequence.ie 1234.
					 * and then the sequence 21 gives a string of length 8 then its pointless to branch further and form 2134 or 2143
					 * instead as the same level we mould want to have 3 then 4 i.e 2314 2341 2413 2431 
					 */
					continue;
				}
				else if(position==numofstrings && forappending.length()<length ) {
					length=forappending.length();
					finalstring.delete(0, finalstring.length());
					finalstring.append(forappending);
					System.out.println("String: "+finalstring+" Length: "+length);
					
				}
	
				sequence(i,numofstrings,visited,position,strings,temp);}
		
			}//for
		checkfirst = false;
		/*
		 * before returning to the previous level we must mark the string sellected at the present level as unvisited.
		 */
		visited[n]=0;
		
		/*
		 * it is to note that the program reaches this point either when it reaches the end of a branch i.e all vertices have been
		 * visited or when the for loop completes.
		 */

		return;
			
		}
		
	}
	

