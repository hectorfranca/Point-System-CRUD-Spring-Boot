package com.app.pointsystem.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.*;
import javax.transaction.Transactional;
import com.app.pointsystem.models.PointModel;
import com.app.pointsystem.repositories.PointRepository;
import org.springframework.stereotype.Service;

@Service
public class PointService {
    private PointRepository pointRepository;

    PointService(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }

    public List<PointModel> findAll() {
        return pointRepository.findAll();
    }

    public Optional<PointModel> findById(UUID pointId) {
        return pointRepository.findById(pointId);
    }

    @Transactional
    public void save(PointModel point) {
        pointRepository.save(point);
    }

    @Transactional
    public void deleteById(UUID pointId) {
        pointRepository.deleteById(pointId);
    }

    public boolean validationName(String name) {
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(name);

        return matcher.find() ? true : false;
    }
}
