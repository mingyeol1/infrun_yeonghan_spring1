package infrun.core;

import infrun.core.discount.FixDiscountPolicy;
import infrun.core.member.MemberService;
import infrun.core.member.MemberServiceImpl;
import infrun.core.member.MemoryMemberRepository;
import infrun.core.order.OrderService;
import infrun.core.order.OrderServiceImpl;

//환경을 구성하는 클래스
public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
