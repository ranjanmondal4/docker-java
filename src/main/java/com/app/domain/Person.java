package com.app.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

import java.util.concurrent.TimeUnit;

@RedisHash("people")
@TypeAlias("pers")
@Getter
@Setter
public class Person {

    @Id
    String id;
    @Indexed
    String name;
    Address address;
    @TimeToLive(unit = TimeUnit.SECONDS)
    private Long expiration;

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", expiration=" + expiration +
                '}';
    }
}
