package dev.Zerphyis.pontoGps.Entitys;

import dev.Zerphyis.pontoGps.Entitys.Data.DataPoi;
import jakarta.persistence.*;

@Entity
@Table(name = "Pontos_interese")
public class POI {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer x;
    private Integer y;


    public POI(){

    }
    public POI(DataPoi data){
        this.name=data.name();
        this.x= data.x();
        this.y= data.y();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }
}
