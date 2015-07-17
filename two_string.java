package two_strings_super;

public class two_string {
	public int append(StringBuffer string1,String string2){
		String str1=new String(string1);
		String str2=new String(string2);
		//System.out.println("inside function string1="+str+" and length ="+string1.length);
		/* the function is divided into three cases
		 * 1st. when the first srting is empty..which it will be at the first level.
		 * 2nd string wount be empty but yet it has been coded in case user wants an empty second string
		 */
		if (str1.isEmpty() || str2.isEmpty() ){
			string1.append(string2);
			return string1.length();
		}
		
		/*second case is in order to avoid unnecessary comparisions i.e if the second string is alreaady
		 * there in first we may simply skip that string.
		 */
		else if (str1.contains(str2)){
			//string1.append(string2);
			return str1.length();	
		}
		/*not needed..according to my observation if the below code is enabled we might fail to obtain
		 * the shortest super string..can be seen with the help of few examples
		 * 
		 * else if(str2.contains(str1)){
			string1.delete(0, string1.length());
			string1.append(string2);
			System.out.println("string2 contained string1 so string1 is now same as string2: "+string1);
		}*/
		
		/*
		 * the last case in the most import part wich performs the important task of forming a short string 
		 * taken string1 first followed by string2..that contains both string1 and string2 as subsets
		 */
		else
		{   
			int a=1;
			//the start from is the index in string1 from where the comparisions start
			int startfrom = (string1.length()>string2.length())? string1.length()-string2.length()+1 : 1; 
			for(int j=startfrom;j<string1.length();j++){
				int samecount=0;
				for(int i=j;i<string1.length();i++){
					//System.out.println("inside function string1="+string1+" and length ="+string1.length);
					//the below if statement is satisfied when the last comparision is reached nd it is also 
					//not same..so we simply append them normally
					if(j==string1.length()-1 && string1.charAt(j)!= string2.charAt(0)){
						 
						 string1.append(string2);
						 return str1.length();}
					try{
					if(i==j && string1.length()>string2.length()){
						a=i;
					                                         }	
					if (string1.charAt(i)!=string2.charAt(i-a))  {
						break;
						}
					else samecount++;       
					}
					catch(ArrayIndexOutOfBoundsException e){}
					int ls=(string1.length())-j;
					if (samecount==ls){
					string1.delete(j, string1.length());
					string1.append(string2);
					return string1.length();
					}
					
					
					
				}//for in i
			a++;
			}//for in j
			
		}//else
		return string1.length();
	}
}
