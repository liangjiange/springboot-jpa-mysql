package com.liangjiange.sample.repository.custom;

import com.liangjiange.sample.model.BuildingRoom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class BuildingRoomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<BuildingRoom> getBuildingRoomListByBuildingId(Long buildingId){
        StringBuilder sb = new StringBuilder();
        sb.append("select new com.liangjiange.sample.model.BuildingRoom(r.id as roomId,r.code as roomCode,r.number as roomNumber,b.code as buildingCode,b.name as buildingName) from Room r,Building b where r.building.id = b.id");
        if (buildingId != null) {
            sb.append(" and b.id = ");
            sb.append(buildingId);
        }
        String qlString = sb.toString();
        Query query = this.entityManager.createQuery(qlString);
        List<BuildingRoom> buildingRooms = query.getResultList();
        return buildingRooms;
    }

}
