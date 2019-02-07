package com.knockknock.security;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.knockknock.dto.member.MemberDTO;
import com.knockknock.mapper.MemberMapper;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	SqlSession sqlsession;
	
	//회원가입으로 이동
	@RequestMapping("/register")
	public String registerStart() {
		return "member/Register";
	}

	//회원가입폼
	//1.회원등록
	@RequestMapping("/create")
	public String member(Model model, MemberDTO memberDTO) {
		//2.memberService의 register호출
		memberService.register(memberDTO);
		
		return "member/RegisterComplete";
	}
	
	@RequestMapping("/checkEmail")
	@ResponseBody
	public MemberDTO checkEmail(Model model, @RequestBody MemberDTO memberDTO) {
		return memberMapper.checkEmail(memberDTO);
	
	}
	
	
	//기본적으로 '로그인'누르면 연결. 그외에 인증처리 안된상태에서 방찾기 등 누르면 로그인으로
	@RequestMapping("/login")
	public String login() {
		return "member/Login";
	}
	
	//로그인완료
	@PostMapping("/loginComplete")
	public String loginComplete(MemberDTO memberDTO){
		return "etc/fragments/Main_layout";
	}
	
	//아이디찾기
	@RequestMapping("/findId")
	@ResponseBody //ajax로 받을때 쓰는 어노테이션
	public MemberDTO findId(Model model, @RequestBody MemberDTO memberDTO){ //@RequestBody 쓰면 객체로 받을 수 있음(뷰단에서 "name":name 이렇게 쓴게 알아서 name변수에 들어감)
		
		return memberMapper.findByName(memberDTO);
	}
	
	//패스워드찾기
	@RequestMapping(value="/findPass", method = RequestMethod.POST)
    public String findPass(MemberDTO memberDTO,RedirectAttributes redirectattr,Errors errors) {
		System.out.println("findPass매핑");
		//1.이메일형식검사
        new FindPassValidator().validate(memberDTO, errors);
        //2.이메일형식 안 맞으면 로그인 페이지로 돌아감
        if(errors.hasErrors()) {
        	System.out.println("error가 있다");
            return "member/Login";
        }
        //3.이메일형식이 맞으면 서비스 인스턴스 생성
        FindpassService service = new FindpassService();
        
        try {
        	System.out.println("try시작");
        	//비번찾기를 위한 excute메서드 실행
        	MemberDTO resultDto = service.execute(sqlsession, memberDTO);
            System.out.println("resultDto"+resultDto);
        	redirectattr.addFlashAttribute("resultDto",resultDto); 
            System.out.println("try끝");
            return "redirect:/sendpass";
        }catch(Exception e)
        {
        	System.out.println("예외가 있다");
            errors.reject("EmailNotExist");
            return "member/Login"; 
        }
    }
}
