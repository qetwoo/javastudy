package com.test.exam03;

interface Sales {

    public void manager(){
    public void goal();
    public void product();
}

class A1Team implements Sales {

    @Override
    public void manager() {
    System.out.println("A팀장입니다. 열심히 하겠습니다.");
    }

    @Override
    public void goal() {
        System.out.println("A팀은 올해 70억을 달성해 보겠습니다.");


    @Override
    public void product() {
        System.out.p



class Bteam implements Sales {

    @Override
    public void manager() {
        System.out.println("B팀 팀장입니다.");
    }

    @Override
    public void goal() {
        System.out.println("B팀은 올해 100억 달성해보겠습니다.");
    }

    @Override
    public void product() {
        System.out.println("B팀은 냉장고 팔겠습니다.");
    }
}

public class InterfaceExam {

    public static void main(String[] args) {

        Ateam aSalesPlan = new Ateam();
        bSalesPlan.manager();
        bSalesPlan.goal();
        bSalesPlan.
