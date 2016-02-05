package springapp.repository;

import springapp.model.MastersHackersStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MastersHackersStatisticsRepository extends JpaRepository<MastersHackersStatistics, Integer> {

    // А что, если... создатель БД ужасный нормализатор? Делаем кастомные запросы
    // Можно было сделать View, но все нужно попробовать

    @Query("select COUNT(*) from MastersHackersStatistics m where m.id = :id")
    long getCount(@Param("id") Integer integer);

}
