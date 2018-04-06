public class ListInteger{
    // Stored integer
    int val;

    // Next element
    ListInteger next = null;

    // Constructor
    public ListInteger(int val) {
        this.val = val;
    }

    // Create a new element for the given variable and returns it
    public ListInteger setNext(int newVal) {
        return this.setNext(new ListInteger(newVal));
    }

    // Create a new element for the given variable and returns it
    public ListInteger setNext(ListInteger spawn) {
        this.next = spawn;
        return spawn;
    }

    // Add an element directly before this element and returns it
    public ListInteger setPrevious(int newVal) {
        return this.setPrevious(new ListInteger(newVal));
    }

    // Create a new element for the given variable and returns it
    public ListInteger setPrevious(ListInteger spawn) {
        spawn.next = this;
        return spawn;
    }

    // Remove the element from the given position
    // "FusionListe"
    public ListInteger append(ListInteger element) {
        // Get to the end of the current list
        ListInteger lastElement = this;
        while (lastElement.next != null) {
            lastElement = lastElement.next;
        }

        // Append the element
        return lastElement.setNext(element);
    }

    // "AjouterFin"
    public ListInteger append(int newVal) {
        return this.append(new ListInteger(newVal));
    }

    // "AjouterDebut"
    public ListInteger prepend(int newVal) {
        return this.setPrevious(newVal);
    }

    // Returns the length of the list
    public int length() {
        ListInteger cur = this;
        int counter = 0;
        while (cur != null) {
            cur = cur.next;
            counter++;
        }
        return counter;
    }

    // Returns the list as string
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        ListInteger cur = this;
        while (cur != null) {
            builder.append(" ").append(cur.val).append(" ");
            cur = cur.next;
        }
        builder.append("]");
        return builder.toString();
    }

    // Prints the list
    public void print() {
        System.out.println(this.toString());
    }

    // Returns the n'th element or null if no such element exists
    public ListInteger query(int index) {
        ListInteger cur = this;
        for (int i = 0; i < index && cur != null; i++) {
            cur = cur.next;
        }
        return cur;
    }

    // Returns the n element's value or null if no such element exists
    public int queryValue(int index) throws Exception {
        ListInteger target = this.query(index);
        if (target == null) {
            throw new Exception("Target doesn't exist");
        }
        return target.val;
    }

    // Insert the element to the given position and returns it
    public ListInteger insert(int index, int val) {
        // Find the element or the last if the index is too high
        ListInteger previous = this;
        for (int i = 0; i < index - 1 && previous.next != null; i++) {
            previous = previous.next;
        }

        // Extract the next one in order to re-attach
        ListInteger next = previous.next;

        // Set new next for target
        ListInteger spawn = previous.setNext(val);

        // Set new next for new element
        spawn.setNext(next);

        // Return the spawn
        return spawn;
    }

    // Removes the element from the given position
    public void remove(int index) {
        // Find the previous element
        ListInteger previousElement = this.query(index-1);

        // Check for sanity/end of list
        if (previousElement == null || previousElement.next == null || previousElement.next.next == null) {
            return;
        }

        // Find the next element
        ListInteger nextElement = previousElement.next.next;

        // Connect directly the previous & next element
        previousElement.setNext(nextElement);
    }

    // Finds the maximum value in the list and returns the n'th element
    public ListInteger max() {
        ListInteger cur = this;
        ListInteger highest = cur;
        while (cur != null) {
            if (cur.val > highest.val) {
                highest = cur;
            }
            cur = cur.next;
        }
        return highest;
    }

    // Finds the maximum value in the list and returns it
    public int maxValue() {
        return this.max().val;
    }

    // Permute
    public void permute(int indexA, int indexB) throws Exception {
        // Before And After A
        ListInteger beforeA = this.query(indexA-1);
        if (beforeA == null || beforeA.next == null) {
            throw new Exception("Element A or parent is not in list");
        }
        ListInteger A = beforeA.next;
        ListInteger afterA = beforeA.next.next;

        // Before And After B
        ListInteger beforeB = this.query(indexB-1);
        if (beforeB == null || beforeB.next == null) {
            throw new Exception("Element B or parent is not in list");
        }
        ListInteger B = beforeB.next;
        ListInteger afterB = B.next;

        // Permute
        beforeA.setNext(B);
        B.setNext(afterA);
        beforeB.setNext(A);
        A.setNext(afterB);
    }

    // Invert the list
    public ListInteger invert() {

        ListInteger cur = this;
        ListInteger previous = null;
        ListInteger next;

        // Go through all the list and connect each one's next to the previous one
        while (cur != null) {
            next = cur.next;
            cur.setNext(previous);
            previous = cur;
            cur = next;
        }

        // Finish it
        return previous;
    }
}