package org.yyym.cloudback.general;

public class CheckEmailForm {
    public static boolean check(String email) {
        if (email.indexOf('@') == -1)
            return false;
        return (email.endsWith(".com") || email.endsWith(".cn"));
    }
}
