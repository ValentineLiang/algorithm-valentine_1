package opel_demo.asm;

import opel_demo.SecurityChecker;

public class AccountASM {
 public void operation() {
        SecurityChecker.checkSecurity();
        System.out.println("operation...");

    }
 }