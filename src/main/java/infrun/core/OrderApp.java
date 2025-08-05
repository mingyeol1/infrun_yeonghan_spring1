package infrun.core;


import infrun.core.discount.FixDiscountPolicy;
import infrun.core.member.Grade;
import infrun.core.member.Member;
import infrun.core.member.MemberService;
import infrun.core.member.MemberServiceImpl;
import infrun.core.order.Order;
import infrun.core.order.OrderService;
import infrun.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
//        MemberService memberService = new MemberServiceImpl();
//        OrderService orderService = new OrderServiceImpl();
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "ItemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order = " + order.calculatePrice());

    }
}
