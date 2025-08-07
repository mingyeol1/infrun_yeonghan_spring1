package infrun.core;

import infrun.core.discount.DiscountPolicy;
import infrun.core.discount.RateDiscountPolicy;
import infrun.core.member.MemberRepository;
import infrun.core.member.MemberService;
import infrun.core.member.MemberServiceImpl;
import infrun.core.member.MemoryMemberRepository;
import infrun.core.order.OrderService;
import infrun.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//환경을 구성하는 클래스
@Configuration  //설정정보를 구성하는 configuration
public class AppConfig {



    @Bean
    public MemberService memberService(){
        System.out.println("CALL AppConfig.memberService");

        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        System.out.println("CALL AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        System.out.println("CALL AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
