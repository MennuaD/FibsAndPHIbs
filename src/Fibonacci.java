public class Fibonacci
{
    // instance variable
    private int[] sequence;
    private int n;
    private int r;
    private int len;

    /** Constructor: sets sequence instance variable to an array containing the
     first sequenceLen numbers in a Fibonacci sequence (a Fibonacci sequence is formed
     by summing the previous two numbers to generate the next number,
     e.g. 0, 1, 1, 2, 3, 5, 8, 13, 21...)

     PRECONDITION: sequenceLen >= 2
     */
    public Fibonacci(int sequenceLen)
    {
        len = sequenceLen;
        n = 0;
        r = 1;
        sequence = new int[sequenceLen];
        sequence[0] = 0;
        sequence[1] = 1;
        if (sequenceLen > 2) {
            for (int i = 2; i < sequenceLen; i++) {
                int temp = r;
                r = r + n;
                n = temp;
                sequence[i] = r;

            }
        }
    }


    /** Getter method: returns a reference to the sequence array

     @return  reference to sequence instance variable
     */
    public int[] getSequence()
    {
        return sequence;
    }

    /** Returns the index in the array where a particular value, searchVal, is
     located in sequence; if not found, returns -1.  If searchVal == 1, return
     first index where 1 is found (since this value appears twice in Fibonacci
     sequences longer than 2 numbers)

     @param searchVal  the number to search for in sequence
     @return  the index where searchVal is located in sequence, -1 if not found
     */
    public int getIndexOf(int searchVal)
    {
        int ind = -1;
        for (int i = 0; i <= sequence.length - 1; i++){
            if(sequence[i] == searchVal){
                ind = i;
                return ind;
            }
        }
        return ind;
    }


    /** Creates a temp array that contains the original sequence array with
     howManyMore numbers Fibonacci values added on to the end,
     then assigns sequence to that new array.

     For example, if sequence == {0, 1, 1, 2, 3, 5} and this method is called
     with howManyMore == 3, sequence would be assigned to a new array with
     the next 2 Fibonacci numbers: {0, 1, 1, 2, 3, 5, 8, 13, 21}
     */
    public void extendBy(int howManyMore)
    {   int tempLen = len;
        len += howManyMore;
        int[] temp = new int[len];
        for (int i = 0; i <= sequence.length - 1; i++) {
            temp[i] = sequence[i];
        }
        for (int i = tempLen; i < len; i++) {
            int tempr = r;
            r = r + n;
            n = tempr;
            temp[i] = r;
        }
        sequence = temp;

        }
    }

