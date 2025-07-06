class Ticket {
    String ticketID, customerName, movieName, seatNo, bookingTime;
    Ticket next;

    public Ticket(String ticketID, String customerName, String movieName, String seatNo, String bookingTime) {
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNo = seatNo;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservation {
    Ticket head = null;

    void addTicket(String id, String name, String movie, String seat, String time) {
        Ticket newTicket = new Ticket(id, name, movie, seat, time);
        if (head == null) {
            head = newTicket;
            head.next = head;
        } else {
            Ticket temp = head;
            while (temp.next != head) temp = temp.next;
            temp.next = newTicket;
            newTicket.next = head;
        }
    }

    void removeTicket(String ticketID) {
        if (head == null) return;
        Ticket curr = head, prev = null;
        do {
            if (curr.ticketID.equals(ticketID)) {
                if (curr == head && curr.next == head) {
                    head = null;
                    return;
                }
                if (curr == head) {
                    Ticket temp = head;
                    while (temp.next != head) temp = temp.next;
                    head = head.next;
                    temp.next = head;
                } else {
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    void displayTickets() {
        if (head == null) return;
        Ticket temp = head;
        do {
            System.out.println(temp.ticketID + " | " + temp.customerName + " | " + temp.movieName + " | " + temp.seatNo + " | " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    void search(String keyword) {
        if (head == null) return;
        Ticket temp = head;
        do {
            if (temp.customerName.equalsIgnoreCase(keyword) || temp.movieName.equalsIgnoreCase(keyword)) {
                System.out.println("Found: " + temp.ticketID);
            }
            temp = temp.next;
        } while (temp != head);
    }

    int countTickets() {
        int count = 0;
        if (head == null) return count;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }
}

public class TicketSystem {
    public static void main(String[] args) {
        TicketReservation system = new TicketReservation();
        system.addTicket("T101", "Alice", "Inception", "A1", "10:00AM");
        system.addTicket("T102", "Bob", "Interstellar", "B2", "11:00AM");
        system.displayTickets();
        system.search("Alice");
        system.removeTicket("T101");
        system.displayTickets();
        System.out.println("Total Tickets: " + system.countTickets());
    }
}
