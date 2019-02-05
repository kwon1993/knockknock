package com.knockknock.security;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.knockknock.dto.member.MemberDTO;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;
	@Autowired
	SqlSession sqlsession;

	@RequestMapping("/register")
	public String registerStart() {
		return "member/Register";
	}

	//1.회원등록
	@RequestMapping("/create")
	public String member(Model model, MemberDTO memberDTO) {
		//2.memberService의 register호출
		memberService.register(memberDTO);
		
		return "member/RegisterComplete";
	}
	
	//기본적으로 '로그인'누르면 연결. 그외에 인증처리 안된상태에서 방찾기 등 누르면 로그인으로
	@RequestMapping("/login")
	public String login() {
		return "member/Login";
	}
	
	@PostMapping("/loginComplete")
	public String loginComplete(MemberDTO memberDTO) {
		return "etc/fragments/Main_layout";
	}
	
	@RequestMapping(value="/findPass", method = RequestMethod.POST)
    public String find_pass(MemberDTO memberDTO,RedirectAttributes redirectattr,Errors errors) {
		System.out.println("findPass매핑");
        new FindPassValidator().validate(memberDTO, errors);
        if(errors.hasErrors()) {
        	System.out.println("error가 있다");
            return "member/Login";
        }
        
        FindpassService service = new FindpassService();
        
        try {
        	System.out.println("try시작");
        	MemberDTO resultDto = service.execute(sqlsession, memberDTO);
            redirectattr.addFlashAttribute("resultDto",resultDto); 
            System.out.println("try끝");
            return "redirect:sendpass";
        }catch(Exception e)
        {
        	System.out.println("예외가 있다");
            errors.reject("EmailNotExist");
            return "member/Login"; 
        }
    }
}
