# 요구사항

- 회원
  - 회원을 가입하고 조회할 수 있다.
  - 회원은 일반과 VIP 두가지 등급이 있다.
  - 회원 데이터는 자체 DB를 구축할 수 있고, 외부 시스템과 연동할 수 있다.(미확정)
- 주문과 할인 정책
  - 회원은 상품을 주문할 수 있다.
  - 회원 등급에 따라 할일 정책을 적용할 수 있다.
  - 할일 정책은 모든 VIP는 1000원을 할인해주는 고정할인 정책을 적용한다.(추후 변경가능)
  - 할일 정책은 변경가능성이 높으며, 정책 확정은 오픈시점까지 미뤄질 예정이다.
  

# 회원 도메인

```mermaid

graph LR
A[클라이언트]-->B[회원서비스
    -회원가입
    -회원조회
]
B-->C[회원저장소]

subgraph -
%%    diraction TD
    C1[메모리회원저장소]-->C
    C2[DB회원저장소]-->C
    C3[외부시스템연동저장소]-->C

end
```

# 회원 클래스 다이어그램
```mermaid
classDiagram
direction LR

    %% 1. 컴포넌트 정의
    class MemberService
    class MemberRepository {
        +회원가입()
        +회원조회()
    }
    class MemberServiceImpl
    class MemoryMemberRepository
    class DBMemberRepository
    
    
    %% 2. 의존 관계 정의 (실선 화살표)
    
    %% MemberService -> MemberRepository (일반적인 의존/호출)
    MemberService<|.. MemberServiceImpl
    MemberServiceImpl --> MemberRepository
    
    %% 회원 서비스 -> 회원 저장소 (의존성: 인터페이스에 의존)
    MemberRepository<|.. MemoryMemberRepository
    MemberRepository<|.. DBMemberRepository
    
    
    
    %% 4. 레이아웃 힌트 추가 (배치 제어)
    %% 상속 관계의 노드들을 수직 방향(top-down)으로 그룹화하여 깔끔하게 배치되도록 힌트를 줍니다.
%%    linkStyle 7 direction TD  
```