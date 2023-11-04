package ro.tuc.ds2020.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.tuc.ds2020.entities.User;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeviceDTO  {
    private UUID id;
    private String name;
    private String address;
private User user;
private String description ;
private int maximumEnergyConsumption;
    public DeviceDTO(UUID id, String name, String address, User user) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.user = user;
    }

    public DeviceDTO(UUID id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}