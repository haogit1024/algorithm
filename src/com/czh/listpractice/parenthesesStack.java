package com.czh.listpractice;

/**
 * Created by czh on 17-8-7.
 */
public class parenthesesStack<Item> {

    private Node first;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public static void main(String[] args) {
        String input = "{())}";
        boolean flag = isParentheses(input);
        System.out.println(flag);

    }

    private static boolean isParentheses(String input){
        char[] chars = input.toCharArray();
        char[] leftP = new char[]{'{','('};
        char[] rightP = new char[]{'}',')'};
        parenthesesStack<Character> ps = new parenthesesStack<>();
        for (char c : chars) {
            if (isInChars(leftP, c)){
                ps.push(c);
            } else {
                if (ps.isEmpty()) {
                    System.out.println("1");
                    return false;
                } else {
                    char stackC = ps.pop();
                    if (!isPairing(stackC, c)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean isInChars(char[] chars, char target) {
        for (char c : chars) {
            if (c == target) {
                return true;
            }
        }
        return false;
    }

    private static boolean isPairing(char left, char right) {
        char[] leftP = new char[]{'{','('};
        char[] rightP = new char[]{'}',')'};
        for (int i = 0; i < leftP.length; i++) {
            if (leftP[i] == left) {
                if (rightP[i] == right) {
                    return true;
                }
            }
        }
        return false;
    }
}
