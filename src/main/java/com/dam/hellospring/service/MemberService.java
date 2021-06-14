package com.dam.hellospring.service;

import com.dam.hellospring.repository.MemberRepository;
import domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// cmd + shift + T -> test 생성 가능
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     */
    public Long join(Member member) {
        // 같은 이름이 있는 중복 회원은 가입할 수 없도록 비즈니스 로직을 정함
        // 커맨드 옵션 V
//        Optional<Member> result = memberRepository.findByName(member.getName());
//        result.ifPresent(mem -> {  // 만약 존재하면
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });
        ValidateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    // ctrl + T -> extract Method
    private void ValidateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원이므로 가입할 수 없습니다.");
        });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
