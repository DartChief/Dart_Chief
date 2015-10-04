package springapp.service.impl;

import springapp.model.MastersHackersStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springapp.repository.MastersHackersStatisticsRepository;
import springapp.service.MastersHackersStatisticsService;

import java.util.List;

@Service
public class MastersHackersStatisticsServiceImpl implements MastersHackersStatisticsService {

    @Autowired
    MastersHackersStatisticsRepository mastersHackersStatisticsRepository;

    @Override
    public MastersHackersStatistics create(MastersHackersStatistics mastersHackersStatistics) {
        MastersHackersStatistics createdMastersHackersStatistics = mastersHackersStatistics;
        return mastersHackersStatisticsRepository.saveAndFlush(createdMastersHackersStatistics);
    }

    @Override
    public List<MastersHackersStatistics> showAll() {
        return mastersHackersStatisticsRepository.findAll();
    }

    @Override
    public MastersHackersStatistics showById(int id) {
        return mastersHackersStatisticsRepository.findOne(id);
    }

    @Override
    public MastersHackersStatistics update(MastersHackersStatistics mastersHackersStatistics) throws ClassNotFoundException {
        return mastersHackersStatisticsRepository.saveAndFlush(mastersHackersStatistics);
    }

    @Override
    public void delete(int id) throws ClassNotFoundException {
        mastersHackersStatisticsRepository.delete(id);
    }

    @Override
    public long getHackersCount(int id) {
        return mastersHackersStatisticsRepository.getCount(id);
    }
}
