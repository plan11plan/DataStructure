package com.webp.p5.Winner;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WinnerController  {



   @Autowired
   private StarRepository starRep;

    @GetMapping("/star/1")
    public String my1(){
        return "start1";
    }

    @GetMapping("/star/2")
    public String my2(String choice1,HttpSession session) {
        session.setAttribute("choice1", choice1);
        return "start2";
    }

      @GetMapping("/star/3")
      public String my3(String choice2,String choice1, HttpSession session,Model mo) {
         mo.addAttribute("choice1",session.getAttribute("choice1"));
         mo.addAttribute("choice2",choice2);
         
         starRep.updateCount_SEMI(choice1);
         starRep.updateCount_SEMI(choice2);
          return "start3";
      }

    @GetMapping("/star/winner")
    public String my4(String winner, HttpSession session, Model mo) {
        session.setAttribute("winner",winner);
        mo.addAttribute("winner",session.getAttribute("winner"));
        
        starRep.updateCount_FINAL(winner);
        return "winner";
    }
    @GetMapping("/winner/list")
    public String finalResultList(Model mo){
       List<Star> list = starRep.findAll();
      mo.addAttribute("list", list);
      return "winnerList";
    }
    @GetMapping("/winner/reset")
   public String winnerReset() {
      starRep.resetCount();
      return "redirect:/winner/list";
   }
}