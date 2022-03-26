package com.app.pointsystem.repositories;

import java.util.UUID;
import com.app.pointsystem.models.PointModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointRepository extends JpaRepository<PointModel, UUID> {

}
