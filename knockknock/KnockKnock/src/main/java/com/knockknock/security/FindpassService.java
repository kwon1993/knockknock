package com.knockknock.security;

import java.util.Random;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.knockknock.dto.member.MemberDTO;
import com.knockknock.mapper.MemberMapper;

@Service
public class FindpassService {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	public static String toss;
	
    public MemberDTO execute(SqlSession sqlsession, MemberDTO memberDTO) throws Exception {
           	System.out.println("FindpassService의 execute");
            
           	MemberMapper memberMapper = sqlsession.getMapper(MemberMapper.class);
//            memberMapper.changePassword(memberDTO);

        	System.out.println("랜덤번호:");
    		int randomInt;
    		String randomStr="";
    		String tempPassword="";
    		Random rnd = new Random();
    		
    		for(int i=0; i<3; i++) {
    			randomInt = (int)(Math.random()*9)+1;
    			randomStr = String.valueOf((char) ((int) (rnd.nextInt(26)) + 97));
    			tempPassword+=randomInt+randomStr;
    		}
    		
    		System.out.println("임시비번은:"+tempPassword);
    		toss = tempPassword;
    		System.out.println("임비:"+toss);
    		
    		memberDTO.setPassword(new BCryptPasswordEncoder().encode(tempPassword));
    		
    		memberMapper.changePassword(memberDTO);
           	
            MemberDTO resultdto = memberMapper.findByEmail(memberDTO);
            System.out.println(resultdto);
            if(resultdto == null) {
            	System.out.println("예외발생");
                throw new Exception();
            }//사용자가 입력한 아이디가 존재하지 않으면 예외 던짐.
            return resultdto;
    }
}

/*
 * 이 서비스 객체에서는 mybatis를 활용해서 데이터를 꺼내오고 꺼내온 결과를 resultDto 커맨드 객체에 담으며 그 커맨드 객체가
 * 없을경우 (이메일로 인한 쿼리문 실패) (select * from userinfo where bEmail = 사용자가입력한이메일) 예외를
 * 발생시키고 정상적일 경우 꺼내온 값을 리턴시키고있습니다.
 */