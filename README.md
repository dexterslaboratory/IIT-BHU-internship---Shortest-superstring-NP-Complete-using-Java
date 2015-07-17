# IIT-BHU-internship---Shortest-superstring-NP-Complete-using-Java
Given 'n' strings (or sequences) the program returns the shortest string that contains all the 'n' strings.
<br>
Note:<br>
Number of characters in each sequence should be greater than one.<br>
Before returning the shortest string the program also returns some other longer superstrings.<br>
<br>
Sample Input/Output:<br>
      *********  D N A   SEQUENCING  *********  <br>
__________________________________________________<br>
Enter the number of threads: <br>
 10<br>
-- Enter DNA threads -- <br>
1. >> ACGTCT<br>
2. >> ACGTAG<br>
3. >> ACGTGACTGG<br>
4. >> ACGTAGCT<br>
5. >> ACGTAGCT<br>
6. >> TGACTG<br>
7. >> ACGTAGC<br>
8. >> GTCAGTCAGT<br>
9. >> GTCAGT<br>
10. >> GTCA<br>
String: ACGTCTACGTAGACGTGACTGGACGTAGCTGTCAGTCAGT Length: 40<br>
String: ACGTCTACGTAGACGTGACTGGTCAGTCAGTACGTAGCT Length: 39<br>
String: ACGTCTACGTAGCTACGTGACTGGTCAGTCAGT Length: 33<br>
Length of shortest superstring is: 33<br>
The string is: ACGTCTACGTAGCTACGTGACTGGTCAGTCAGT<br>
<br>
