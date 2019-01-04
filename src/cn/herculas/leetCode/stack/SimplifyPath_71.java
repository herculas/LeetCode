package cn.herculas.leetCode.stack;

import java.util.Stack;

public class SimplifyPath_71 {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        Stack<String> pathStack = new Stack<>();

        for (String p : paths) {
            if (p.equals("") || p.equals(".")) {
            } else if (p.equals("..")) {
                if (!pathStack.empty()) pathStack.pop();
            } else {
                pathStack.push(p);
            }
        }

        StringBuilder res = new StringBuilder();
        while (!pathStack.empty()) {
            res.insert(0, "/" + pathStack.pop() );
        }
        if (res.length() == 0) return "/";
        else return res.toString();
    }

    public static void main(String[] args) {
        String test1 = "/a/./b/../../c/";
        String test2 = "/home/";
        String test3 = "/../";
        String test4 = "/home//foo/";

        SimplifyPath_71 simplifyPath_71 = new SimplifyPath_71();
        System.out.println(simplifyPath_71.simplifyPath(test1));
        System.out.println(simplifyPath_71.simplifyPath(test2));
        System.out.println(simplifyPath_71.simplifyPath(test3));
        System.out.println(simplifyPath_71.simplifyPath(test4));
    }
}
