package com.liangjiange.sample.service;

import com.liangjiange.sample.domain.Room;
import com.liangjiange.sample.model.BuildingRoom;

import java.util.List;

public interface RoomService {

    List<Room> getRoomList();

    List<BuildingRoom> getBuildingRoomListByBuildingId(Long buildingId);

}
