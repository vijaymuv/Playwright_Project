package org.example;

public interface LamadaFunction {
    void abstractFun(int x);

    public static void main(String[] args) {
       LamadaFunction func= x ->
            System.out.println(3*x);
       func.abstractFun(3);

    }
}
