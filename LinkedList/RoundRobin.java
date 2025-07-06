class Process {
    int pid, burstTime, priority;
    Process next;

    public Process(int pid, int burstTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    Process head = null;

    void addProcess(int pid, int burstTime, int priority) {
        Process newProcess = new Process(pid, burstTime, priority);
        if (head == null) {
            head = newProcess;
            head.next = head;
        } else {
            Process temp = head;
            while (temp.next != head)
                temp = temp.next;
            temp.next = newProcess;
            newProcess.next = head;
        }
    }

    void removeProcess(int pid) {
        if (head == null) return;
        Process curr = head, prev = null;
        do {
            if (curr.pid == pid) {
                if (curr == head && curr.next == head) {
                    head = null;
                    return;
                }
                if (curr == head) {
                    Process temp = head;
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

    void simulate(int timeQuantum) {
        if (head == null) return;
        Process current = head;
        while (true) {
            boolean done = true;
            Process temp = head;
            do {
                if (temp.burstTime > 0) {
                    done = false;
                    if (temp.burstTime > timeQuantum) {
                        System.out.println("Process " + temp.pid + " executed for " + timeQuantum);
                        temp.burstTime -= timeQuantum;
                    } else {
                        System.out.println("Process " + temp.pid + " executed for " + temp.burstTime);
                        temp.burstTime = 0;
                    }
                }
                temp = temp.next;
            } while (temp != head);
            if (done) break;
        }
    }
}

public class RoundRobin {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();
        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 4, 2);
        scheduler.addProcess(3, 6, 1);
        scheduler.simulate(3);
    }
}
