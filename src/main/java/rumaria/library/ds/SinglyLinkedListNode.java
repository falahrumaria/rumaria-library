package rumaria.library.ds;

import edu.princeton.cs.algs4.StdOut;

public class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;

    public SinglyLinkedListNode(int data) {
        this.data = data;
    }

    public static void main(String[] args) {
        StdOut.println("opo yo");
    }

    public static SinglyLinkedListNode deleteOdd(SinglyLinkedListNode listHead) {
        SinglyLinkedListNode listHeadResult = null;
        SinglyLinkedListNode currentListHead = null;
        while (listHead != null) {
            if (listHead.data % 2 != 0) {
                listHead = listHead.next;
                continue;
            }
            if (listHeadResult == null) {
                listHeadResult = new SinglyLinkedListNode(listHead.data);
                currentListHead = listHeadResult;
            } else {
                currentListHead.next = new SinglyLinkedListNode(listHead.data);
                currentListHead = currentListHead.next;
            }
            listHead = listHead.next;
        }
        return listHeadResult;
    }

    public static SinglyLinkedListNode mergeInBetween(SinglyLinkedListNode list1, SinglyLinkedListNode list2, int a, int b) {
        SinglyLinkedListNode currentListNode = list1;
        SinglyLinkedListNode nodeA_Pior = null;
        SinglyLinkedListNode nodeB_After = null;
        for (int i = 1; i < a; i++) {
            nodeA_Pior = currentListNode;
            currentListNode = currentListNode.next;
        }
        for (int i = a + 1; i <= b + 1; i++) {
            nodeB_After = currentListNode;
            currentListNode = currentListNode.next;
        }
        doIt(list2, nodeB_After);
        if (nodeA_Pior != null) {
            nodeA_Pior.next = list2;
            return list1;
        }
        return list2;
    }

    private static void doIt(SinglyLinkedListNode currentListNode, SinglyLinkedListNode nodeB_After) {
        while (currentListNode.next != null) {
            currentListNode = currentListNode.next;
        }
        currentListNode.next = nodeB_After;
    }

    public void deleteDuplicates(SinglyLinkedListNode head) {
        int currentVal = head.data;
        SinglyLinkedListNode currentListNode = head;
        while (currentListNode.next != null) {
            if (currentListNode.next.data != currentVal) {
                currentVal = currentListNode.next.data;
                currentListNode = currentListNode.next;
                continue;
            }
            SinglyLinkedListNode nodeX = currentListNode;
            while (currentListNode.next != null && currentListNode.next.data == currentVal) {
                currentListNode = currentListNode.next;
            }
            nodeX.next = currentListNode.next;
        }
    }
}

