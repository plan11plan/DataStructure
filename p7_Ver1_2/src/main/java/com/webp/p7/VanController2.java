package com.webp.p7;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class VanController2 {
    private BankService bankSvc; /* 생성자코딩 대신 필드 위에 @Autowired 해도 됨 */
    public VanController2(BankService bankSvc) {
        this.bankSvc = bankSvc;
    }
    /* 이 부분에 컨트롤러 메소드가 추가됩니다 */
    @GetMapping("/myhistory")
    public String myhistory(HttpSession session, Model mo){
        String id = (String)session.getAttribute("id");
        List<Bank> list = bankSvc.myhistory(id);
        String balance = bankSvc.findBalance(id);
        mo.addAttribute("id",id);
        mo.addAttribute("balance",balance);
        mo.addAttribute("list",list);
        return "myhistory";
    }
    @GetMapping("/deposit")
    public String deposit(HttpSession session, Model mo){
        mo.addAttribute("id", session.getAttribute("id"));
        mo.addAttribute("word", "입");
        mo.addAttribute("color","rgb(255, 255, 128)");
        mo.addAttribute("url", "/dewi?choice=1");
        return "dewi";
    }

    @GetMapping("/withdrawal")
    public String withdrawal(HttpSession session, Model mo){
        mo.addAttribute("id", session.getAttribute("id"));
        mo.addAttribute("word", "출");
        mo.addAttribute("color","#E0F8F7");
        mo.addAttribute("url", "/dewi?choice=-1");
        return "dewi";
    }

    //입출금 Controller 메소드
    @PostMapping("/dewi")
    public String depositPost(HttpSession session, int choice, int money, Model mo){
        String id = (String)session.getAttribute("id");
        bankSvc.dewi(id, money, choice);
        mo.addAttribute("msg", money + "원이 " + (choice==1?"입금":"출금")
                +" 완료 되었습니다. (거래 내역 화면으로 이동)");
        mo.addAttribute("url", "/myhistory");
        return "popups";
    }
    @GetMapping("/transfer")
    public String transfer(HttpSession session, Model mo){
        mo.addAttribute("id", session.getAttribute("id"));
        return "transfer";
    }
    //이체 처리 Controller 메소드
    @PostMapping("/transfer")
    public String transferNew(HttpSession session, int money, String tid,
                              Model mo){
        String id = (String)session.getAttribute("id");
        if(id.equals(tid)) {
            mo.addAttribute("msg", "고객님 본인한테는 이체 불가합니다.");
            mo.addAttribute("url", "back");
        }
        else if( bankSvc.transfer(id, money, tid) ) {
            mo.addAttribute("msg", tid+"님께 "+money
                    +"원이 이체 완료 되었습니다. (거래 내역 화면으로 이동)");
            mo.addAttribute("url", "/myhistory");
        }
        else {
            mo.addAttribute("msg",
                    "미등록 수신인 아이디입니다. 수신인 아이디를 확인해 주세요.");
            mo.addAttribute("url", "back");
        }
        return "popups";
    }
    @GetMapping("/bank/list")
    public String bankList(HttpSession session, Model mo) {
        List<Bank> list = bankSvc.bankList();
        int count = bankSvc.findCount();
        String sum = bankSvc.findSum();
        mo.addAttribute("count",count); mo.addAttribute("sum",sum);
        mo.addAttribute("list",list);
        return "bankList";
    }

} // class
