package org.yyym.cloudback.LogIn.cclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogReturn {
    private String JWT;
    private Integer userID;
}
