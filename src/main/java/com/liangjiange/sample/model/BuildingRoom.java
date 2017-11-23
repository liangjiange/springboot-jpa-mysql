package com.liangjiange.sample.model;

public class BuildingRoom {

    private Long roomId;

    private String roomCode;

    private String roomNumber;

    private String buildingCode;

    private String buildingName;

    public BuildingRoom(){
        super();
    }

    public BuildingRoom(Long roomId,String roomCode,String roomNumber,String buildingCode,String buildingName){
        this.roomId = roomId;
        this.roomCode = roomCode;
        this.roomNumber = roomNumber;
        this.buildingCode = buildingCode;
        this.buildingName = buildingName;
    }

}
