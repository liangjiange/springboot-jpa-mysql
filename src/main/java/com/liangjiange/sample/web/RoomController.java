package com.liangjiange.sample.web;

import com.alibaba.fastjson.JSONArray;
import com.liangjiange.sample.domain.Room;
import com.liangjiange.sample.model.BuildingRoom;
import com.liangjiange.sample.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @RequestMapping("all")
    public String getAllRooms(){
        List<Room> roomList = roomService.getRoomList();
        return JSONArray.toJSONString(roomList);
    }

    @RequestMapping("building/room/list")
    public String getAllRooms(@RequestParam("buildingId") Long buildingId){
        List<BuildingRoom> buildingRoomList = roomService.getBuildingRoomListByBuildingId(buildingId);
        return JSONArray.toJSONString(buildingRoomList);
    }



}
