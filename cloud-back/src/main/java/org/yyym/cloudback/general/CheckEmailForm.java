package org.yyym.cloudback.general;

public class CheckEmailForm {
    public static boolean check(String email) {
        String target="[a-zA-Z0-9_]+@\\w+(\\.com|\\.cn){1}";
        return email.matches(target);
    }
}
