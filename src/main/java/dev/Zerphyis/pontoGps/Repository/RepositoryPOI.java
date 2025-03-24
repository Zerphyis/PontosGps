package dev.Zerphyis.pontoGps.Repository;

import dev.Zerphyis.pontoGps.Entitys.POI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryPOI extends JpaRepository<POI,Long> {

    @Query("""
            SELECT p FROM POI p
            WHERE (p.x >= :xMin AND p.x <= :xMax AND p.y >= :yMin AND p.y <= :yMax)
            """)
    List<POI> findNear(@Param("xMin") long xMin,
                       @Param("xMax") long xMax,
                       @Param("yMin") long yMin,
                       @Param("yMax") long yMax);
}
