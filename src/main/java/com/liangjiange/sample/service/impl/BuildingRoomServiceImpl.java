package com.liangjiange.sample.service.impl;

import com.liangjiange.sample.domain.Room;
import com.liangjiange.sample.model.BuildingRoom;
import com.liangjiange.sample.repository.BuildingRepository;
import com.liangjiange.sample.repository.RoomRepository;
import com.liangjiange.sample.repository.custom.BuildingRoomRepository;
import com.liangjiange.sample.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingRoomServiceImpl implements RoomService{

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private BuildingRoomRepository buildingRoomRepository;

    @Override
    public List<Room> getRoomList() {
        return roomRepository.findAll();
    }

    @Override
    public List<BuildingRoom> getBuildingRoomListByBuildingId(Long buildingId) {
        return buildingRoomRepository.getBuildingRoomListByBuildingId(buildingId);
    }
}
