package com.want.want.domain;

import com.want.want.common.MemberInfo;
import com.want.want.constant.Role;
import com.want.want.dto.member.join.MemberJoinReqDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity
@ToString
@Table(name = "member")
//@Builder
@Getter
@Setter
@DynamicInsert
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memberId;

    @Column(unique = true, nullable = false)
    private String webId;

    @Column(nullable = false)
    private String webPw;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false, unique = true)
    private String nickName;

    @Column(nullable = false)
    private String birth;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Role role;

    @ColumnDefault("'H'")
    private String joinGbn;

/*    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Post> posts = new ArrayList<>();*/

    public Member() {

    }

    public Member(MemberJoinReqDto reqDto) {
        this.webId = reqDto.getWebId();
        this.webPw = reqDto.getWebPw();
        this.name = reqDto.getName();
        this.gender = reqDto.getGender();
        this.nickName = reqDto.getNickName();
        this.birth = reqDto.getBirth();
        this.email = reqDto.getEmail();
        this.phoneNumber = reqDto.getPhoneNumber();
        this.role = Role.USER;
    }

    @Builder
    public Member(MemberInfo memberInfo) {
        this.memberId = memberInfo.getMemberId();
        this.nickName = memberInfo.getNickName();
    }

}
