package hello.core;

import hello.core.entity.Grade;
import hello.core.entity.Member;
import hello.core.service.MemberService;
import hello.core.service.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();

        Member member = new Member(1L, "ann", Grade.VIP);
        memberService.join(member);
        System.out.println(memberService.findMember(member.getId()));
    }
}
