package com.project.voda.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.project.voda.dto.UserSignUpRequestDto;
import com.project.voda.util.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "user")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_seq")
  private Long userSeq;

  @Column(name = "email", nullable = false, unique = true)
  private String email;

  @Column(name = "nickname")
  private String nickname;

  @Column(name = "model_id")
  private String modelId;

  @Column(name = "delete_yn")
  @ColumnDefault("0")
  private boolean deleteYn;

  @JsonIgnore
  @OneToMany(mappedBy = "user")
  private List<Calendar> calendars = new ArrayList<>();
}
