package com.webp.p7;
import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import javax.servlet.http.HttpSession;

@Controller
public class VanController1 {
@Autowired
private MemberRepository memRep; // Service없이 바로 Repository 연결
/* 이 부분에 컨트롤러 메소드가 추가됩니다 */

@GetMapping("/login")
public String login() {
return "login";
}

@GetMapping("/member/register")
public String memberRegister() { 
return "memberRegister";
}

@GetMapping("/member/insert")
public String memberInsert(String id, String pw, String name, String phone, Model mo) {
Member m = new Member();
m.id = id; m.pw = pw; m.name = name; m.phone = phone;
m.balance = 0;
if( memRep.existsById(id) ) { // 이미 존재하는 아이디
mo.addAttribute("msg", id+"는 이미 사용되고 있는 아이디입니다.");
mo.addAttribute("url", "back");
}
else {
memRep.save(m);
mo.addAttribute("msg", id+"님, 반갑습니다!! (로그인 화면으로 이동)");
mo.addAttribute("url", "/login");
}
return "popups";
}



@GetMapping("/login/check")
public String loginCheck(HttpSession session, String id, Model mo) {
if(memRep.existsById(id)) { /* 정상 로그인 */
session.setAttribute("id", id);
return "redirect:/menu"; 
}
else {
mo.addAttribute("msg", id+"는 미등록 아이디입니다. 확인 후 로그인 부탁드립니다.");
mo.addAttribute("url", "/login");
return "popups";
}
}





@GetMapping("/menu")
public String menu(HttpSession session, Model mo) {
mo.addAttribute("id", session.getAttribute("id"));
return "menu";
}


@GetMapping("/myinfo")
public String myinfo(HttpSession session, Model mo) {
String id = (String)session.getAttribute("id");
Member m = memRep.findById(id).get(); 
mo.addAttribute("m",m);
DecimalFormat df = new DecimalFormat("###,###");
mo.addAttribute("won", df.format(m.balance)+" 원");
return "myinfo";
}

@GetMapping("/myinfo/update")
public String myinfoUpdate(HttpSession session, String pw, String 
name, String phone, Model mo) 
{
String id = (String)session.getAttribute("id");
if(memRep.updateMyinfo(id, pw, name, phone)==0) 
mo.addAttribute("msg", "정보 변경 실패. 고객센터로 문의하세요.");
else
mo.addAttribute("msg", id+"님의 정보가 변경되었습니다.");
mo.addAttribute("url", "back");
return "popups";
}

@GetMapping("/member/list")
public String memberList(HttpSession session, Model model) {
List<Member> list = memRep.findAll(); 
model.addAttribute("list",list);
return "memberList";
}

@GetMapping("/logout")
public String logout(HttpSession session, Model mo) {
mo.addAttribute("id", session.getAttribute("id"));
session.invalidate();
return "logout";
}



} // class
