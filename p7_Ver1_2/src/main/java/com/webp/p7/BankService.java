package com.webp.p7;
import java.text.DecimalFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 로직 처리 : @Service (서비스 레이어, 내부에서 자바 로직을 처리함)
 * @service 어노테이션은 해당 클래스를 루트 컨테이너에 빈(Bean) 객체로 생성해주는 어노테이션입니다.
 * (@Repositroy, @Service 모두 Bean 객체를 생성해주고 딱히 다른 기능을 넣어주는게
 *  아니라서 뭘 써도 상관 없긴한데 명시적으로 구분해주기 위해 각자 분리해서 사용합니다.)
 *
 * @Transactional
 * 어떤 연산에 트랜잭션이 보장된다면, DB에서 의도치 않은 값이 저장되거나 조회되는 것을 막을 수 있다.
 * @Transactional은 클래스나 메서드에 붙여줄 경우, 해당 범위 내 메서드가 트랜잭션이 되도록 보장해준다.
 * 선언적 트랜잭션이라고도 하는데, 직접 객체를 만들 필요 없이 선언만으로도 관리를 용이하게 해주기 때문.
 * 특히나 SpringBoot에서는 선언적 트랜잭션에 필요한 여러 설정이 이미 되어있는 탓에, 더 쉽게 사용할 수 있다.
 *
 * 클래스,메서드에 해당 어노테이션을 선언시, 해당 클래스는 트랜잭션 기능이 추가된 프록시 객체가 생성된다.
 * PlatformTransactionManager를 사용하여 트랜잭션을 시작하고 정상 여부에 따라 commit 혹은 rollback한다.
 *
 */
@Service
public class BankService {
    @Autowired
    private BankRepository bankRep;
    @Autowired
    private MemberRepository memRep;
    /* 이 부분에 서비스 메소드가 추가됩니다 */
    public List<Bank> myhistory(String id) {
        return bankRep.findByIdOrderByTdateDesc(id);
    }
    public String findBalance(String id) {
        int balance = memRep.findBalance(id); /* 정수로 읽어와서 */
        DecimalFormat df = new DecimalFormat("###,###"); /* 쉼표 추가 */
        return df.format(balance);
    }

    @Transactional
    public void dewi(String id, int money, int choice) { /* 입출금 */
        Bank b = new Bank(); b.id = id;
        b.de = (choice==1? money: 0); b.wi = (choice==-1? money: 0);
        // 1이 입금 . -1이 출금
        b.tcode = 0; bankRep.save(b);
        memRep.updateBalance(id, choice*money);
    }
    // 이체 처리 Service 메소드
    @Transactional
    public boolean transfer(String id, int money, String tid) { /* 이체*/
        if( !memRep.existsById(tid) )
            return false;
        Bank b = new Bank();
        b.id = id; /* 보내는사람 */
        b.de = 0;
        b.wi = money;
        b.tcode = 1; /* 이체보냄 */
        b.tid = tid;
        bankRep.save(b);
        memRep.updateBalance(id, -money);
        b = new Bank(); /* new 안 하면 bank.no가 같아서 insert아니고 update됨 */
        b.id = tid; /* 받는 사람 */
        b.de = money;
        b.wi = 0;
        b.tcode = 2; /* 이체받음 */
        b.tid = id;
        bankRep.save(b);
        memRep.updateBalance(tid, money);
        return true;
    }
    public List<Bank> bankList() {
        return bankRep.findAllOrderByIdTdateDesc();
    }
    public int findCount() {
        return memRep.findCount();
    }
    public String findSum() {
        int sum = memRep.findSum();
        DecimalFormat df = new DecimalFormat("###,###");
        return df.format(sum);
    }

} // class
