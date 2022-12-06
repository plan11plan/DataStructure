package com.webp.p5.memo;//package com.webp.p5.memo;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//@Controller
//public class memoController {
//	
//@Autowired
//private memoRepository meRep;
//
//@GetMapping("/star/1")
//public String star() {
//	return "startt1";
//}
//
//@PostMapping("/star/0")
//public String memoInsert(String title, String memo,Model mo) {
//memo m = new memo();
//m.title = title;
//m.memo = memo; 
//meRep.save(m);
//mo.addAttribute("msg","잘 저장되었습니다.!!");
//return "popupss";
//}
//
//@GetMapping("/memo/list")
//public String memoList(Model mo) {
//	
//	List<memo> list = meRep.findAll(); 
//	mo.addAttribute("list",list);
//	return "memoList";
//}
//} // class
