package springapp.service;

import springapp.model.MastersHackersStatistics;

import java.util.List;

public interface MastersHackersStatisticsService {

    MastersHackersStatistics create(MastersHackersStatistics mastersHackersStatistics);
    List<MastersHackersStatistics> showAll();
    MastersHackersStatistics showById(int id);
    MastersHackersStatistics update(MastersHackersStatistics mastersHackersStatistics) throws ClassNotFoundException;
    void delete(int id) throws ClassNotFoundException;
    long getHackersCount(int id);

}
