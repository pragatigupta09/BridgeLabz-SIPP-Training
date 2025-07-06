class State {
    String text;
    State prev, next;

    public State(String text) {
        this.text = text;
        this.prev = null;
        this.next = null;
    }
}

class TextEditor {
    State current;
    int maxHistory = 10;
    int size = 0;

    void type(String newText) {
        State newState = new State(newText);
        if (current != null) {
            newState.prev = current;
            current.next = newState;
        }
        current = newState;
        size++;
        if (size > maxHistory) {
            State temp = current;
            while (temp.prev != null && size > maxHistory) {
                temp.prev.prev = null;
                temp.prev = temp.prev.next;
                size--;
            }
        }
    }

    void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        }
    }

    void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        }
    }

    void displayCurrent() {
        if (current != null)
            System.out.println("Current Text: " + current.text);
    }
}

public class UndoRedoEditor {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        editor.type("Hello");
        editor.type("Hello World");
        editor.type("Hello World!!!");
        editor.displayCurrent();
        editor.undo();
        editor.displayCurrent();
        editor.redo();
        editor.displayCurrent();
    }
}
