package hello.core;

import hello.core.entity.Grade;
import hello.core.entity.Member;
import hello.core.entity.Order;
import hello.core.service.MemberService;
import hello.core.service.MemberServiceImpl;
import hello.core.service.OrderService;
import hello.core.service.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "member1", Grade.VIP);
        memberService.join(member);
        Order book = orderService.createOrder(memberId, "책", 10000);

        System.out.println("구매상품: " + book);

    }


}
