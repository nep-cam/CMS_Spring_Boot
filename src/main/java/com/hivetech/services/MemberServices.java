package com.hivetech.services;

import com.hivetech.entities.Member;
import com.hivetech.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;


@Service
//@RequiredArgsConstructor
public class MemberServices {
    @Autowired
    private MemberRepository memberRepository;

    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member getMemberById(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    public Member getMembersByName(String name) {
        return memberRepository.findByUsername(name);
    }

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

    public void updateMember(Member member) {
        Member memberUpdate = getMembersByName(member.getUsername());
        Date updateTime = Date.valueOf(LocalDate.now());
        memberUpdate.setFirstName(member.getFirstName());
        memberUpdate.setLastName(member.getLastName());
        memberUpdate.setUsername(memberUpdate.getUsername());
        memberUpdate.setEmail(memberUpdate.getEmail());
        memberUpdate.setPhone(member.getPhone());
        memberUpdate.setDescription(member.getDescription());
        memberUpdate.setUpdateTime(updateTime);
        memberRepository.save(memberUpdate);
    }

    public boolean validate(String username, String password) {
        Member member = getMembersByName(username);
        if (member != null && member.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

}
