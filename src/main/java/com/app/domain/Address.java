package com.app.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.core.index.GeoIndexed;

@Getter
@Setter
public class Address {
    String street;
    String city;

    @GeoIndexed
    Point location;

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
