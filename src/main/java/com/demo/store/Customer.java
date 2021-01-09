package com.demo.store;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Enumeration;
import java.util.Vector;

@NoArgsConstructor
@Getter
public class Customer {
    private String name;
    private Vector rentals = new Vector();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.addElement(arg);
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rental = rentals.elements();

        String result = getName() + " 고객님의 대여 기록 \n";
        while (rental.hasMoreElements()) {
            Rental each = (Rental) rental.nextElement();
            // 비디오 종류별 대여료 계산
            // 적립 포인트를 1 포인트 증가
            frequentRenterPoints ++;
            // 최신물을 이틀 이상 대여하면 보너스 포인트 지급
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
                each.getDaysRented() > 1) frequentRenterPoints ++;

            // 이번에 대여하는 비디오 정보와 대여료를 출력
            result = "\t" + each.getMovie().getTitle() + "\t" +
                    String.valueOf(each.getCharge()) + "\n";

            // 현재까지 누적된 초 대여료
            totalAmount += each.getCharge();
        }

        // 푸터 행 추가
        result += "누적 대여료: " + String.valueOf(totalAmount) + "\n";
        result += "적립 대여료: " + String.valueOf(frequentRenterPoints);

        return result;
    }


}
