package dev.Zerphyis.pontoGps.Service;

import dev.Zerphyis.pontoGps.Entitys.Data.DataPoi;
import dev.Zerphyis.pontoGps.Entitys.POI;
import dev.Zerphyis.pontoGps.Repository.RepositoryPOI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class POIService {
    @Autowired
    private RepositoryPOI repository;

    public POI createPOI(DataPoi dataPoi) {
        POI poi = new POI(dataPoi);
        return repository.save(poi);
    }

    public List<POI> getAllPOIs() {
        List<POI> pois = repository.findAll();
        saveToFile(pois);
        return pois;
    }

    public Optional<POI> getPOIById(Long id) {
        return repository.findById(id);
    }

    public POI updatePOI(Long id, DataPoi dataPoi) {
        return repository.findById(id).map(poi -> {
            poi.setName(dataPoi.name());
            poi.setX(dataPoi.x());
            poi.setY(dataPoi.y());
            return repository.save(poi);
        }).orElseThrow(() -> new RuntimeException("POI não encontrado"));
    }

    public List<POI> findNearbyPOIs(int x, int y, int dMax) {
        int xMin = x - dMax;
        int xMax = x + dMax;
        int yMin = y - dMax;
        int yMax = y + dMax;
        return repository.findNear(xMin, xMax, yMin, yMax);
    }

    public void deletePOI(Long id) {
        repository.deleteById(id);
    }

    private void saveToFile(List<POI> pois) {
        File file = new File("pois_list.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (POI poi : pois) {
                writer.write( ", Nome: " + poi.getName() + ", X: " + poi.getX() + ", Y: " + poi.getY());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
