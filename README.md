utils
=====

Java Utils

### Num2Str ###

default

    Num2Str ns=new Num2Str();
    System.out.println("-27 = " + ns.toStr(-15));
    System.out.println("BXY = " + ns.toInt("BXY"))

output

    -27 = -AB
    BXY = 2000

Use the A,B,C, combination number, minus is D

    Num2Str ns=new Num2Str("ABC", 'D');
    System.out.println("-25 = " + ns.toStr(-15));
    for (int i = 0; i < 15; i++)
            System.out.println(i + "=" + ns.toStr(i));

output

    -25 = DBBB
    0=A
    1=B
    2=C
    3=AA
    4=AB
    5=AC
    6=BA
    7=BB
    8=BC
    9=CA
    10=CB
    11=CC
    12=AAA
    13=AAB
    14=AAC
