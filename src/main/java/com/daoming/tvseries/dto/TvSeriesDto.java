package com.daoming.tvseries.dto;

import java.util.Date;

public class TvSeriesDto {
    private int id;
    private String name;
    private int seasonCount;
    //    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")//日期格式化：yyyy-MM-dd
    //    @JsonFormat(shape = JsonFormat.Shape.NUMBER)//日期格式化：时间戳timestamp
    private Date originRelease;

    public TvSeriesDto() {

    }

    public TvSeriesDto(int id, String name, int seasonCount, Date originRelease) {
        this.id = id;
        this.name = name;
        this.seasonCount = seasonCount;
        this.originRelease = originRelease;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeasonCount() {
        return seasonCount;
    }

    public void setSeasonCount(int seasonCount) {
        this.seasonCount = seasonCount;
    }

    public Date getOriginRelease() {
        return originRelease;
    }

    public void setOriginRelease(Date originRelease) {
        this.originRelease = originRelease;
    }

    @Override
    public String toString() {
        return "TvSeriesDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", seasonCount=" + seasonCount +
                ", originRelease=" + originRelease +
                '}';
    }
}
