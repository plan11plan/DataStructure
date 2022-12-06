package com.webp.p7;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;

/**
 * 로직 처리 : @Service (서비스 레이어, 내부에서 자바 로직을 처리함)
 * @service 어노테이션은 해당 클래스를 루트 컨테이너에 빈(Bean) 객체로 생성해주는 어노테이션입니다.
 * (@Repositroy, @Service 모두 Bean 객체를 생성해주고 딱히 다른 기능을 넣어주는게
 *  아니라서 뭘 써도 상관 없긴한데 명시적으로 구분해주기 위해 각자 분리해서 사용합니다.)
 *
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
 *
 * Optional<T> 클래스를 사용해 NPE를 방지할 수 있도록 도와준다.
 * Optional<T>는 null이 올 수 있는 값을 감싸는 Wrapper 클래스로, 참조하더라도 NPE가 발생하지 않도록 도와준다.
 * Optional 클래스는  값이 null이더라도 바로 NPE가 발생하지 않으며,
 * 클래스이기 때문에 각종 메소드를 제공해준다.
 */
@Service
public class MemberService {
    @Autowired
    private MemberRepository memRep;

    /* 이 부분에 서비스 메소드가 추가됩니다 */
    public Boolean memberInsert(String id, String pw, String name, String phone) {
        if( memRep.existsById(id) )
            return false;
        else {
            Member m = new Member();
            m.id = id; m.pw = pw;
            m.name = name; m.phone = phone;
            m.balance = 0;
            memRep.save(m);
            return true;
        }
    }
    public Optional<Member> findOne(String id){ /* select one */
        return memRep.findById(id); // findById()는 제공되는 메소드
    }
    public int updateMyinfo(String id, String pw, String name, String phone) {
        return memRep.updateMyinfo(id,pw,name,phone);
    }
    public List<Member> memberList() { /* select all */
        return memRep.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }


} // class
