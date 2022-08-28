package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "MBR") //테이블명을 지정
public class Member_ex {

    @Id
    private Long id;

    @Column(name = "name",nullable = false) //디비 컬럼을 name으로 지정,nullable notnull 제약조건
    // updatable = false,  기본 true값이며 update시 변경안하겠다는 의미.
    //columnDefinition 컬럼정의를 직접할때 사용
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING)//EnumType.ORDINAL enum의 순서를 디비에 저장, EnumType.STRING은 enum이름을 디비에 저장.(default ordinal)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob//varchar를 넘어서는 큰 데이터
    private String description;

    @Transient//디비에는 연관없이 메모리에서만 사용하겠다는 어노테이션
    private int tmp;
    
    /*@Id
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }*/
}
