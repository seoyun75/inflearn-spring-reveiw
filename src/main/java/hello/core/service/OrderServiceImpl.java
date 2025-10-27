package hello.core.service;

import hello.core.entity.Member;
import hello.core.entity.Order;
import hello.core.repository.MemberRepository;
import hello.core.repository.MemoryMemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderServiceImpl implements OrderService{

    private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member orderMember = memberRepository.findById(memberId);
        log.info(memberRepository.findById(memberId).toString());
        int discountPrice = discountPolicy.discount(itemPrice, orderMember.getGrade());

        return new Order(orderMember.getId(), itemName, itemPrice, discountPrice);
    }
}
