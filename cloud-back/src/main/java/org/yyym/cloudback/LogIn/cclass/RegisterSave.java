package org.yyym.cloudback.LogIn.cclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterSave {
    private String userName;
    private String email;
    private String password;
    private String code;
}
