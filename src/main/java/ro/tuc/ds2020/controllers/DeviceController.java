package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.DeviceDTO;
import ro.tuc.ds2020.dtos.DeviceDetailsDTO;
import ro.tuc.ds2020.services.DeviceService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping(value = "/device")
public class DeviceController {

    private final DeviceService deviceService;

    @Autowired
    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping()
    public ResponseEntity<List<DeviceDTO>> getDevices() {
        List<DeviceDTO> dtos = deviceService.findDevices();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<DeviceDTO>> getDevices2() {
        List<DeviceDTO> dtos = deviceService.findDevicesWithUsers();
        return new ResponseEntity<>(dtos, HttpStatus.OK);}

    @GetMapping("/alll")
    public ResponseEntity<List<DeviceDTO>> getDevices3() {
        List<DeviceDTO> dtos = deviceService.findAllDevicesWithUsers();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<UUID> insertDevice(@Valid @RequestBody DeviceDetailsDTO deviceDTO) {
        UUID deviceID = deviceService.insert(deviceDTO);
        return new ResponseEntity<>(deviceID, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DeviceDetailsDTO> getDevice(@PathVariable("id") UUID deviceId) {
        DeviceDetailsDTO dto = deviceService.findDeviceById(deviceId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<DeviceDetailsDTO> updateDevice(
            @PathVariable("id") UUID deviceId,
            @Valid @RequestBody DeviceDetailsDTO deviceDetailsDTO
    ) {
        DeviceDetailsDTO updatedDevice = deviceService.update(deviceId, deviceDetailsDTO);
        return new ResponseEntity<>(updatedDevice, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteDevice(@PathVariable("id") UUID deviceId) {
        deviceService.delete(deviceId);
        String responseMessage = "Device with ID " + deviceId + " has been successfully deleted.";
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }
}
