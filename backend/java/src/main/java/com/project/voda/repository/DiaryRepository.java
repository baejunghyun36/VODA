package com.project.voda.repository;

import com.project.voda.domain.Calendar;
import com.project.voda.domain.Diary;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryRepository extends JpaRepository<Diary, Long> {

  // 하루 일기 목록
  List<Diary> findByCalendar(Calendar calendar);

}
