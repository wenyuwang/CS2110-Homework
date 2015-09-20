import java.util.Arrays;


/** NetIds: ww424, jnf27. Time spent: 04 hours, 18 minutes. */

/** An instance contains static methods for assignment A2 */
public class A2 {

    /* NOTE: You will have to rely on methods that are declared in class String.
     * Visit docs.oracle.com/javase/8/docs/api/index.html?java/lang/String.html,
     * scroll down to the Method Summary, and peruse the available methods.
     * Oft-used ones are charAt, length, trim, substring, indexOf, isEmpty,
     * lastIndexOf, startsWith, endsWith, split, toLowerCase, toUpperCase.
     *
     * In all these methods, assume that String parameters are not null.
     * Also assume that the preconditions of the methods are true you do not have
     * to deal with the cases that the input is malformed.
     * 
     * Of course, you can, if you want, use assert statement to test preconditions,
     * but you do not have to..
     * 
     * It is OK to have return statements within the body of a loop.
     * However, try to write loops that do NOT us break or continue;
     * these statements often lead to loop bodies that are hard to
     * understand. */

    /** if b, return the sum of s1 and s2.
     * if not b, return the difference of s1 and s2 */
    public static int sumDif(boolean b, int s1, int s2) {
        if (b) {
            return s1 + s2;
        }
        // b is false;
        return s1 - s2;
    }

    /** if b, return the sum of s1 and s2.
     * if not b, return the difference of s1 and s2 */
     
    public static int sumDif1(boolean b, int s1, int s2) {
        /* sumDif1 and sumDIf have the same specifications. We show two ways of
         * writing the body. In the then-part below, you see a declaration of local
         * variable s, an assignment to it, and then the use of s in the return
         * statement. The declaration and assignment could have been written in 
         * one statement:  int s= s1 + s2;*/
        if (b) {
            int s;
            s= s1 + s2;
            return s;
        }
        else {
            return s1 - s2;
        }
    }
    
    //Done//
    /** Return true iff s reads the same backwards and forwards.
     * Examples: For s = "", return true
     *           For s = "b", return true
     *           For s = "ab", return false
     *           For s = "aba", return true.
     *           For s = "abba", return true.
     *           For s = "Madam, I'm Adam", return false.
     *           For s = "MadamImAdam", return false.
     *           For s = "madamimadam", return true.  */
    public static boolean sameBackAndForth(String s) {
        /* Use one loop. Do not use recursion.
         * Do not use an array; just process the characters of s.
         * Visit each character of the string at most once. */
    	if (s.length()==0 || s.length() ==1 ) return true;
    	else{
    		//s.toLowerCase();
    		int middle = s.length()/2;
    		int size = s.length();
    		for(int i =0;i<middle;i++){
    			if (s.charAt(i) != s.charAt(size-1-i)){
    				return false;
    			}
    		}
    		return true;
    		}

    }
    //DONE
    /** Return the number of times query occurs as a substring of src
     * (different occurrences may overlap).
     * Precondition: query is not the empty string "".
     * Examples: For src = "ab", query = "b", return 1.
     *           For src = "Luke Skywalker", query = "ke", return 2.
     *           For src = "abababab", query = "aba", return 3.
     *           For src = "aaaa", query = "aa", return 3.*/
    public static int numOccurrences(String src, String query) {
        /* This should be done with one loop. If at all possible, don't have
         * each iteration of the loop process one character of src. Instead,
         * see whether some method of class String can be used to jump from one
         * occurrence of query to the next. */
    	int count =0;
    	if(query.length()!=0){
    		for (int i =0; i<src.length()-query.length()+1;i++){
    			if ((src.substring(i,i+query.length()).equals(query))==true){
    				count = count +1;
    			}
    		}
    		return count;
    	}
        return count;
    }
    //Done
    /** String s is written in a form that looks something like this:
     * "b3c1x2a013b2". For this s, return the decompressed string "bbbcxx111bb".
     *
     * More formally, we have:
     * Precondition: s is in "compressed form": it consists of a sequence of
     * pairs of characters, with the second character being a digit in 0..9.
     * Return the decompressed form of s, which is found by replacing each
     * pair "ci" by i occurrences of character c.
     */
    public static String decompress(String s) {
        /* You can use function Integer.parseInt(s1) to get the int that is in s1.
         * Remember that a character c is not a String, and to change c into a
         * String you can catenate it with the empty String "".
         * This function will probably need a loop within a loop
         */
    	String charArray ="";
    	int[] ints = new int[s.length()/2];
    	String ret = "";
    	for (int i=0, j=1; i<s.length();i+=2,j=i+1){
    		charArray = charArray + s.charAt(i);
    		ints[(j-1)/2] = Character.getNumericValue(s.charAt(j));
    		}

    	for (int i =0; i<charArray.length();i++){
    		for(int j=0;j<ints[i];j++){
    		ret = ret+charArray.charAt(i);
    		}}
        return ret;
    }

    //Done
    /** Precondition: String s consists of a last-name, a comma ',', a first-name,
     *      and an optional middle-name. There are one or more blank characters
     *      (spaces) before the first-name and before the optional middle-name.
     *      There are 0 or more blanks at the beginning and end of s. Any of the
     *      characters in the names may be in lower or upper case.
     * Return the correctly formatted name as
     * first-name middle-name (if present) last-name
     * The first character of each name must be in uppercase and the rest of the
     * characters in lowercase.
     * Exactly one blank must separate adjacent names. There should be no blank
     * before the first-name and after the last-name.
     *
     * Examples: For s = "   gRies,  DAVID     "   return "David Gries"
     *           For s = "foster,    nate"         return "Nate Foster"
     *           For s = "GOSLING, JAMES   ARTHUR" return "James Arthur Gosling"*/
    public static String fixName(String s) {
        /* As you know, String is a class. An object of class String is
         * immutable -- you cannot change the sequence of chars that it
         * contains. However, you can create new strings by catenating together
         * parts of the original string.
         *
         * Do not use a loop or recursion. Use only if-statements,
         * assignments, and return statements.
         *
         * Finally, this method can be written using an oft-used pattern:
         *   1. Break the string into its parts
         *   2. Modify the parts
         *        (How can you make the first letter of each part of the name
         *         uppercase? How can you extract the first name?)
         *   3. Build the result from the modified parts. */
    	String firstName = "";
    	String rawFirstName =s.split(",")[1];
    	String[] modiFirstName = rawFirstName.trim().replaceAll("\\s+", " ").toLowerCase().split(" ");
    	if (modiFirstName.length ==1){
    		firstName = modiFirstName[0];
    		firstName = firstName.substring(0,1).toUpperCase() + firstName.substring(1);
    	}
    	else if (modiFirstName.length ==2){
    		String tmp1 = modiFirstName[0].substring(0,1).toUpperCase() + 
    				modiFirstName[0].substring(1);
    		String tmp2 = modiFirstName[1].substring(0,1).toUpperCase() + 
    				modiFirstName[1].substring(1);
    		firstName = tmp1 +" "+ tmp2;
    	}
    	
    	String lastName = s.split(",")[0].replaceAll("\\s+","").toLowerCase();
    	lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);

        return firstName+" "+lastName;
    }
    //DONE
    /** Return a string that is s but with all upper-case consonants (letters of
     * the English alphabet other than the vowels a, e, i, o, u) replaced with
     * _, and all lower-case consonants replaced with their upper-case version.
     *
     * Examples: For s = "Minecraft" return "_iNeCRaFT".
     *           For s = "Alan Turing" return "ALaN _uRiNG".
     */
    public static String replaceConsonants(String s) {
        /* Writing a long list of 42 statements, one for each (upper-case or
         * lower-case) consonant is not a great idea. Instead, put the 21
         * lower-case consonants in a string and the upper-case consonants in
         * another string. Then write a loop that sequences the
         * chars in s in turn, replacing the upper and
         * lowercase versions of each letter in s. This should be the ONLY loop
         * you write! 
         *
         * A for-loop to loop through a range b..c-1 of integers can look like
         * this:
         *    for (int i = b; i < c ; i = i + 1) {
         *        ...
         *    }
         */

    	char[] upperConsonants = {'B','C','D','F','G','H','J','K','L','M','N','P','Q','R','S','T','V','W','X','Y','Z'};
    	char[] lowerConsonants = {'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','y','z'};
    
//    		for (int j=0;j<21;j++){s = s.replace(upperConsonants[j], '_');}
//    	
//    		for (int j=0;j<21;j++){s = s.replace(lowerConsonants[j],upperConsonants[j]);}
    	char[] sc = s.toCharArray();
    	for (int i=0 ; i< s.length();i++){
    			for (int j =0; j<21;j++){
    				if (sc[i] == upperConsonants[j]){
    						sc[i] = '_';
    				}
    				if (sc[i] == lowerConsonants[j]){
    						sc[i] = upperConsonants[j];
    				}
    			}
    		}
   
    	String ret = new String(sc);
    	return ret;
    }

    //Done//
    /** Return true iff s and t are anagrams of each other. An anagram of a string
     * is another string that has the same characters, but possibly in a
     * different order. Note that 'a' and 'A' are considered different characters
     * and that the space is a character.
     *
     * Examples: For s = "noon", t = "noon", return true.
     *           For s = "mary", t = "army", return true.
     *           For s = "tom marvolo riddle", t = "i am lordvoldemort", return true.
     *           For s = "tommarvoloriddle", t = "i am lordvoldemort", return false.
     *           For s = "hello", t = "world", return false.  */
    public static boolean areAnagrams(String s, String t) {
        /* Do not use a loop or recursion! This is tricky but can in fact
         * be done in a few lines. Hint: how can a sequence of characters be
         * uniquely ordered? You might need to first convert the string to an
         * array of characters and then use functions in class Arrays
         * (http://docs.oracle.com/javase/8/docs/api/java/util/Arrays.html). */
    	if (s.length() != t.length()){
    		return false;
    	}
    	else{
    		//char[] sc = s.replaceAll("\\s+","").toLowerCase().toCharArray();
    		//char[] tc = t.replaceAll("\\s+","").toLowerCase().toCharArray();
    		char[] tc = t.toLowerCase().toCharArray();
    		char[] sc = s.toLowerCase().toCharArray();
    		Arrays.sort(sc);
    		Arrays.sort(tc);
    		return Arrays.equals(sc,tc);
    	}
    }
}
