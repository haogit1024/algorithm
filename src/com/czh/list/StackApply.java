package com.czh.list;

import java.util.Stack;

/**
 * Created by czh on 17-7-25.
 */
public class StackApply {
    public static void main(String[] args) {
        char[] opts = new char[]{'(',')','+','-','*','/'};

    }

    public static boolean isInChars(char[] chars, char target) {
        for (char c : chars) {
            if (c == target) {
                return true;
            }
        }
        return false;
    }
}
