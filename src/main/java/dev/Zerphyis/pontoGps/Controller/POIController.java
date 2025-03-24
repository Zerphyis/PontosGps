package dev.Zerphyis.pontoGps.Controller;

import dev.Zerphyis.pontoGps.Entitys.Data.DataPoi;
import dev.Zerphyis.pontoGps.Entitys.POI;
import dev.Zerphyis.pontoGps.Service.POIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gps")
public class POIController {
    @Autowired
    private POIService poiService;

    @PostMapping()
    public ResponseEntity<POI> createPOI(@RequestBody DataPoi dataPoi) {
        POI poi = poiService.createPOI(dataPoi);
        return ResponseEntity.ok(poi);
    }

    @GetMapping()
    public ResponseEntity<List<POI>> getAllPOIs() {
        List<POI> pois = poiService.getAllPOIs();
        return ResponseEntity.ok(pois);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<POI> getPOIById(@PathVariable("id") Long id) {
        Optional<POI> poi = poiService.getPOIById(id);
        return poi.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<POI> updatePOI(@PathVariable("id") Long id, @RequestBody DataPoi dataPoi) {
        POI updatedPOI = poiService.updatePOI(id, dataPoi);
        return ResponseEntity.ok(updatedPOI);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePOI(@PathVariable("id") Long id) {
        poiService.deletePOI(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/proximidade")
    public ResponseEntity<List<POI>> findNearbyPOIs(@RequestParam int x, @RequestParam int y, @RequestParam int dMax) {
        List<POI> pois = poiService.findNearbyPOIs(x, y, dMax);
        return ResponseEntity.ok(pois);
    }
}
